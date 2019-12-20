package com.example.jiyin.common.net.manager;

import com.alibaba.fastjson.JSON;
import com.example.rootlib.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private Type type;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter,Type type) {
        this.gson = gson;
        this.adapter = adapter;
        this.type = type;
    }


    @Override public T convert(ResponseBody value) throws IOException {
        Reader reader = value.charStream();
        JsonReader jsonReader = gson.newJsonReader(reader);

        try {
            T read = adapter.read(jsonReader);
            Gson gson = new Gson();
            T jaisj=read;
            LogUtils.d("9527"+gson.toJson(jaisj));
            return read ;
        } finally {
            value.close();
        }
    }


}
