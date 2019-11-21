package com.example.jiyin.home.Activity.homeview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

/**
 * 发布圈子 实体类
 */

public class ReleaseBean extends Callcode {


    /**
     * msg : 发布成功
     * data : []
     * time : 1573203965
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
