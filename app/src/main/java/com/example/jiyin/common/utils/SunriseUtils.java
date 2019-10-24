package com.example.jiyin.common.utils;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class SunriseUtils {
    /**
     * 转化文本类型参数Wierequestbody
     *
     * @param param
     * @return
     */
    public static RequestBody convertToRequestBody(String param) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"), param);
        return requestBody;
    }

}
