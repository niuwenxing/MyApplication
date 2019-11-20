package com.example.jiyin.common.net.beas;


public class BaseResponseModel<T> extends RootResponseModel {
//
    /**
     * 数据对象
     */
    public T data;

    @Override
    public String toString() {
        return "BaseResponseModel{" +
                "data=" + data.toString() +
                '}';
    }
}
