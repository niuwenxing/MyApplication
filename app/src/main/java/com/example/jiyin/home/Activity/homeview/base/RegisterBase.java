package com.example.jiyin.home.Activity.homeview.base;

import com.example.jiyin.common.net.netunti.callcode;

import java.util.List;

/**
 * 注册
 */

public class RegisterBase extends callcode {


    /**
     * msg : 账号已存在,请登录
     * data : []
     * time : 1573528818
     */

    private String msg;
    private int time;
    private List<?> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
