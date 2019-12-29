package com.example.jiyin.common.net;


import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;

/**
 * Created by zhl on 2019/12/27.
 */

public class ExMultipartBody extends RequestBody {


    private MultipartBody mMultipartBody;
    private UploadProgressListener mProgressListener;

    private long mCurrentLength;

    public ExMultipartBody(MultipartBody multipartBody) {
        this.mMultipartBody = multipartBody;
    }

    public ExMultipartBody(MultipartBody multipartBody, UploadProgressListener progressListener) {
        this.mMultipartBody = multipartBody;
        this.mProgressListener = progressListener;
    }

    @Override
    public MediaType contentType() {
        return mMultipartBody.contentType();
    }

    @Override
    public long contentLength() throws IOException {
        return mMultipartBody.contentLength();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {


        //这里需要另一个代理类来获取写入的长度
        ForwardingSink forwardingSink = new ForwardingSink(sink) {

            final long totalLength = contentLength();

            @Override
            public void write(Buffer source, long byteCount) throws IOException {

                //这里可以获取到写入的长度
                mCurrentLength += byteCount;
                //回调进度
                if (mProgressListener != null) {
                    mProgressListener.onProgress(totalLength, mCurrentLength);
                }


                super.write(source, byteCount);
            }
        };

        //转一下
        BufferedSink bufferedSink = Okio.buffer(forwardingSink);
        //写数据
        mMultipartBody.writeTo(bufferedSink);
        //刷新一下数据
        bufferedSink.flush();
    }
}