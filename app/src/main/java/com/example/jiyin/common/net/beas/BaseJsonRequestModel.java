package com.example.jiyin.common.net.beas;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by gray on 2017/4/24.
 * retrofit请求参数的封装基类，结构是json类型，具体项目做具体实现
 */
public abstract class BaseJsonRequestModel extends JSONObject{

    /**
     * 此处的公共参数不仅在app中有用到，在请求h5的地址的时候也会将公共参数传递给他们，so如果公共参数有修改的话，需要在webview里面也修改
     */
    public BaseJsonRequestModel() {
    }


    public BaseJsonRequestModel addArray(String name, JSONArray value) {
        try {
            if ("".equals(name)) {
                return this;
            }
            if (value == null) {
                this.remove(name);
                return this;
            }
            this.put(name, value);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BaseJsonRequestModel addObject(String name, JSONObject value) {
        try {
            if ("".equals(name)) {
                return this;
            }
            if (value == null) {
                this.remove(name);
                return this;
            }
            this.put(name, value);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }


    public BaseJsonRequestModel add(String name, String value) {
        try {
            if ("".equals(name)) {
                return this;
            }
            if (value == null) {
                this.remove(name);
                return this;
            }
            this.put(name, value);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public abstract Map<String, String> getFinalRequestMap();

}
