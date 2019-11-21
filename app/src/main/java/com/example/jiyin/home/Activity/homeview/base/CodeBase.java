package com.example.jiyin.home.Activity.homeview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class CodeBase extends Callcode {

    /**
     * code : 1
     * msg : 发送成功
     * data : []
     * time : 1573090651
     */

//    private int code;
    private String msg;
    private int time;
    private List<?> data;

//    public int getCode() {
//        return code;
//    }

//    public void setCode(int code) {
//        this.code = code;
//    }

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
