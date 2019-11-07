package com.example.jiyin.home.Activity.homeview.base;

import com.example.jiyin.common.bean.BaseModel;

/**
 * 注册
 */

public class RegisterBase extends BaseModel {


    /**
     * code : 1
     * msg : 注册 成功
     * data : 5ea76fffc3a01b4d00e326ced1d4b422
     * time : 1573091668
     */

    private int code;
    private String msg;
    private String data;
    private int time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
