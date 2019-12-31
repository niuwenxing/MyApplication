package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class AuthregCodeBean extends Callcode {
    /**
     * msg : 账号已存在,请登录
     * data : []
     * time : 1577758357
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


//    /**
//     * msg : 注册 成功
//     * data : 5ea76fffc3a01b4d00e326ced1d4b422
//     * time : 1573091668
//     */
//
//    private String msg;
//    private String data;
//    private int time;
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public String getData() {
//        return data;
//    }
//
//    public void setData(String data) {
//        this.data = data;
//    }
//
//    public int getTime() {
//        return time;
//    }
//
//    public void setTime(int time) {
//        this.time = time;
//    }
}
