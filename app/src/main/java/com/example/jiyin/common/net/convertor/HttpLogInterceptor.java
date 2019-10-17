package com.example.jiyin.common.net.convertor;

import com.example.jiyin.common.net.file.UploadFileRequestBody;
import com.example.rootlib.utils.LogUtils;

import java.io.EOFException;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Created by zhao on 2016/7/5.
 */
public class HttpLogInterceptor implements Interceptor {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        long startNs = System.nanoTime();
        Response response;
        try {
            response = chain.proceed(request);
        } catch (Exception e) {
            LogUtils.e("<-- HTTP FAILED: " + e);
            throw e;
        }
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);

        String url = response.request().url().toString();

        // 请求体
        RequestBody requestBody = request.body();

        if (requestBody != null) {
            // 请求体中参数信息，如果是上传文件请求体，不解析，防止writeTo多次调用，因为此时response流已经关闭
            Buffer buffer = new Buffer();
            if (!(requestBody instanceof UploadFileRequestBody)) {
                requestBody.writeTo(buffer);
            }

            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }

            if (isPlaintext(buffer)) {
                url = url + "?" + buffer.readString(charset);
            } else {
                LogUtils.e("<-- code:" + response.code()
                        + " message:" + response.message()
                        + " 请求方式:" + request.method()
                        + " 请求大小:" + requestBody.contentLength() + "-byte body omitted"
                        + " (响应时间:" + tookMs + "ms" + ')');
            }
        }

        try {
            url = URLDecoder.decode(url, "UTF-8");
        } catch (Exception e) {
            LogUtils.e("URL转码错误，可能是文件接口");
        }
        LogUtils.e(url);

        return response;
    }

    /**
     * Returns true if the body in question probably contains human readable text. Uses a small sample
     * of code points to detect unicode control characters commonly used in binary file signatures.
     */
    static boolean isPlaintext(Buffer buffer) throws EOFException {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }

}
