package com.example.jiyin.common.net.manager;

import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.net.convertor.HttpLogInterceptor;
import com.example.jiyin.common.net.convertor.JsonConverterFactory;
import com.example.rootlib.utils.StringUtil;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by gray on 2018/7/18.
 */
public class HttpManager {

    private static OkHttpClient instance;
    private static Retrofit retrofit;
    private static HttpManager httpManager;
    /**
     * 上次构建时的usertoken
     */
    private String currUserToken;

    /**
     * 服务器地址
     * @return
     */
    public static HttpManager getInstance() {
        if (httpManager == null) {
            synchronized (HttpManager.class) {
                if (httpManager == null) {
                    if (StringUtil.isEmpty(BaseConfig.ROOT_SERVER_API)) {
                        throw new RuntimeException("请在Application中初始化RootLib的ApplicationConfig.ROOT_PATH_API");
                    }
                    // 初始化Retrofit句柄
                    initRetrofitHandler();
                    // 创建单例
                    httpManager = new HttpManager();
                }
            }
        }
        return httpManager;
    }
    /**
     * 确保单例
     */
    private HttpManager() {}

    public <T> T req(final Class<T> service) {
        return retrofit.create(service);
    }

    /**
     * 初始化Retrofit句柄
     */
    private static void initRetrofitHandler() {
        // 初始化OKHttp句柄
        initCertificates();

        retrofit = new Retrofit.Builder()
                .baseUrl(BaseConfig.ROOT_SERVER_API)
                .addConverterFactory(JsonConverterFactory.create())
                .client(instance)
                .build();
    }

    /**
     * 初始话OKHttp句柄
     * -加密信息
     * -超时信息
     * -解析器
     * -拦截器
     */
    private static void initCertificates() {

        //https证书忽略
        TrustManager[] trustManager = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) throws
                            CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) throws
                            CertificateException {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        X509Certificate[] x509Certificates = new X509Certificate[0];
                        return x509Certificates;
                    }
                },
        };

        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustManager, new SecureRandom());
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            instance = new OkHttpClient.Builder()
                    .sslSocketFactory(sslSocketFactory)
                    .addInterceptor(new HttpLogInterceptor())
                    .addNetworkInterceptor(new StethoInterceptor())
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }
}
