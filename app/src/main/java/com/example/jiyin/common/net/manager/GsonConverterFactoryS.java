package com.example.jiyin.common.net.manager;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;


public class GsonConverterFactoryS extends Converter.Factory {


    public static GsonConverterFactoryS create() {
        return create(new Gson());
    }

    public static GsonConverterFactoryS create(Gson gson) {
        return new GsonConverterFactoryS(gson);
    }

    private final Gson gson;
    private GsonConverterFactoryS(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new GsonResponseBodyConverter<>(gson, adapter,type);
    }




}
