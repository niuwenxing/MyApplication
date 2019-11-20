package com.example.jiyin.common.net.manager;

import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.net.convertor.HttpLogInterceptor;
import com.example.rootlib.utils.StringUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {

    private static HttpManager httpManager;
    private static Retrofit retrofit;
    private static OkHttpClient instance;


    public HttpManager(){}
    public static HttpManager getInstance() {

        if (httpManager == null) {
            synchronized (HttpManager.class) {
                if(httpManager == null){
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

    //创建网络
    public <T> T rep( final Class<T> service){

        return retrofit.create(service);
    }


    private static void initRetrofitHandler() {

        initCertificates();
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseConfig.ROOT_SERVER_API) //设置网络请求的Url地址
//                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(instance)
                .build();


    }


    private static void initCertificates() {
//             try {
             instance = new OkHttpClient().newBuilder()
                     .addInterceptor(new HttpLogInterceptor())
                     .connectTimeout(30, TimeUnit.SECONDS)
                     .readTimeout(30, TimeUnit.SECONDS)
                     .writeTimeout(60, TimeUnit.SECONDS)
                     .build();
//             } catch (Exception e) {
//                 throw new RuntimeException("initCertificates 异常");
//             }
    }
}
