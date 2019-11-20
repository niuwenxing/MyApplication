package com.example.jiyin.common.bean;

//import com.example.jiyin.common.net.beas.BaseJsonRequestModel;
import com.example.rootlib.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class RequestModelBean  {
//extends BaseJsonRequestModel
    private HashMap<String, String> map;
    /**
     * 构建公参
     */
    public RequestModelBean(){
        map = new HashMap<>();

    }
    public void putMap(String key, String value) {
        if (!StringUtil.isEmpty(key)) {
            map.put(key, StringUtil.getNotNullStr(value));

        }
    }


//    @Override
//    public Map<String, String> getFinalRequestMap() {
//        return map;
//    }
}
