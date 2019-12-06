package com.example.jiyin.home.Activity.homeview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

/**
 * 多图上传
 */

public class ImageArr extends Callcode {
    /**
     * msg : success
     * data : ["/upload/app/20191202/b78bab199a1d9f0ee348d6adcc06986f198421.png","/upload/app/20191202/b78bab199a1d9f0ee348d6adcc06986f41046.png","/upload/app/20191202/b78bab199a1d9f0ee348d6adcc06986f265382.png"]
     * time : 1575268527
     */

    private String msg;
    private int time;
    private List<String> data;

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

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

//    /**
//     * code : 1
//     * msg : success
//     * data : /upload/app/20191107/427fd8d7b2c58eae9201b6ef4042f91d.jpg
//     * time : 1573093539
//     */
//
//
}

