package com.example.jiyin.common.net.netunti;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class Callcode implements Serializable {
    /**
     * data : []
     * msg : token无效或已过期
     * time : 1576726108
     * code : 20003
     */

    @JSONField(name = "code")
    int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
