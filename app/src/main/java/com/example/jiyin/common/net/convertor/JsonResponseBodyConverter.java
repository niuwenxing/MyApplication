package com.example.jiyin.common.net.convertor;


import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by gray on 2016/7/18.
 */


final class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private Type type;

    JsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        T t = null;
        String result = value.string();
//        LogUtils.e(result);
        if (result != null && !"".equals(result)) {
            //如果已经是字符串，直接返回
            if (type == String.class) {
                t = (T)result;
            }
            else {
                t = JSON.parseObject(result , type);
            }
        }
        return t;
    }
}