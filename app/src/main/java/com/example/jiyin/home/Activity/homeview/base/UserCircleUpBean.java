package com.example.jiyin.home.Activity.homeview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class UserCircleUpBean extends Callcode {


    /**
     * msg : 点赞成功
     * data : []
     * time : 1573460253
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
