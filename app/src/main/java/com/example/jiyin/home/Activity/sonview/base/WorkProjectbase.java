package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

public class WorkProjectbase extends Callcode {


    /**
     * msg : success
     * data : {"work_id":1,"work_title":"测试区去去去去"}
     * time : 1574231341
     */

    private String msg;
    private DataBean data;
    private int time;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static class DataBean {
        /**
         * work_id : 1
         * work_title : 测试区去去去去
         */

        private int work_id;
        private String work_title;

        public int getWork_id() {
            return work_id;
        }

        public void setWork_id(int work_id) {
            this.work_id = work_id;
        }

        public String getWork_title() {
            return work_title;
        }

        public void setWork_title(String work_title) {
            this.work_title = work_title;
        }
    }
}
