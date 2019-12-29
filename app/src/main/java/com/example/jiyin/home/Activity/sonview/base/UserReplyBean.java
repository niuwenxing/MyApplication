package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

/**
 * 圈子详情评论
 * PLPLPL
 */

public class UserReplyBean extends Callcode {

    /**
     * msg : 评论成功
     * data : []
     * time : 1573459102
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

