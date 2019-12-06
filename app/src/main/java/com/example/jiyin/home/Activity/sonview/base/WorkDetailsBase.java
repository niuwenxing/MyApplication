package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

/**
 * 工作坊 详情
 */

public class WorkDetailsBase extends Callcode {


    /**
     * msg : success
     * data : {
     * "work_id":1,
     * "work_title":"测试区去去去去","
     * work_vtitle":"QQ群",
     * "work_time":"2019-11-19 16:53:24",
     * "work_text":"<p>士大夫士大夫士大夫所发生的<\/p>",
     * "enroll":0 } 0是未报名 1是报过
     * time : 1574217880
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
         * work_vtitle : QQ群
         * work_time : 2019-11-19 16:53:24
         * work_text : <p>士大夫士大夫士大夫所发生的</p>
         * enroll : 0
         */

        private int work_id;
        private String work_title;
        private String work_vtitle;
        private String work_time;
        private String work_text;
        private int enroll;

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

        public String getWork_vtitle() {
            return work_vtitle;
        }

        public void setWork_vtitle(String work_vtitle) {
            this.work_vtitle = work_vtitle;
        }

        public String getWork_time() {
            return work_time;
        }

        public void setWork_time(String work_time) {
            this.work_time = work_time;
        }

        public String getWork_text() {
            return work_text;
        }

        public void setWork_text(String work_text) {
            this.work_text = work_text;
        }

        public int getEnroll() {
            return enroll;
        }

        public void setEnroll(int enroll) {
            this.enroll = enroll;
        }
    }
}
