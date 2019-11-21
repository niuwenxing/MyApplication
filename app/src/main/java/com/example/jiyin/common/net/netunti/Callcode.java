package com.example.jiyin.common.net.netunti;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class Callcode implements Serializable {
    @JSONField(name = "code")
    int code;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

}
