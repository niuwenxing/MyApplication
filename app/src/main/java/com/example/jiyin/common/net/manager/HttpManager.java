package com.example.jiyin.common.net.manager;

import androidx.annotation.NonNull;

import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.net.convertor.HttpLogInterceptor;
import com.example.rootlib.utils.CollectionUtil;
import com.example.rootlib.utils.StringUtil;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {

    private static HttpManager httpManager;
    private static Retrofit retrofit;
    private static OkHttpClient instance;
    private String pathfile;


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
                .addConverterFactory(GsonConverterFactoryS.create()) //设置数据解析器
//                .addConverterFactory(JsonConverterFactory.create())
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


    //多图上传
    public MultipartBody  getOkhttpImage(List<LocalMedia> listimg){
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        if (!CollectionUtil.isEmpty(listimg)) {
            for (int i = 0; i < listimg.size(); i++) {
                builder.addPart(
                        Headers.of("Content-Disposition", "form-data; name=\"image[]\"; filename=\"" + i + ".png\""),
                        RequestBody.create(MediaType.parse("image/png"), new File(listimg.get(i).getPath())));
            }
            return builder.build();
        }
        return null;
    }
    public MultipartBody  getOkhttpVoide(List<LocalMedia> listimg){
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        if (!CollectionUtil.isEmpty(listimg)) {
            for (int i = 0; i < listimg.size(); i++) {
                builder.addPart(
                        Headers.of("Content-Disposition", "form-data; name=\"image[]\"; filename=\"" + i + ".mp4\""),
                        RequestBody.create(MediaType.parse("image/png"), new File(listimg.get(i).getPath())));
            }
            return builder.build();
        }
        return null;
    }
    //上传文件
    public MultipartBody getOkhttpFile(@NonNull String filepath){
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (!StringUtil.isEmpty(filepath)) {
            if(filepath.contains(".doc")){
                pathfile = "form-data; name=\"image\"; filename=\"" + 8 + ".doc\"";
            }
            if(filepath.contains(".docx")){
                pathfile = "form-data; name=\"image\"; filename=\"" + 8 + ".docx\"";
            }
            if(filepath.contains(".ppt")){
                pathfile = "form-data; name=\"image\"; filename=\"" + 8 + ".ppt\"";
            }
            if(filepath.contains(".doc")){
                pathfile = "form-data; name=\"image\"; filename=\"" + 8 + ".pptx\"";
            }
                builder.addPart(
                        Headers.of("Content-Disposition",pathfile),
                        RequestBody.create(MediaType.parse("image/png"), new File(filepath)));
            return builder.build();
        }
        return null;
    }





}
