package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

public class FilePathbean extends Callcode {


    @Override
    public String toString() {
        return "FilePathbean{" +
                "msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                ", time=" + time +
                '}';
    }

    /**
     * msg : success
     * data : /upload/app/20191107/427fd8d7b2c58eae9201b6ef4042f91d.jpg
     * time : 1573093539
     */

    private String msg;
    private String data;
    private int time;

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
