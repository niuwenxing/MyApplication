package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class ClassifyIndexBean extends Callcode {

    /**
     * msg : success
     * data : [{"new_id":5,"new_title":"测试","new_time":"2019-11-01","path":"/upload/default/20191028/9a88a60cc598683752a6fb1adfd593b5.jpg"}]
     * time : 1574040176
     */

    private String msg;
    private int time;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * new_id : 5
         * new_title : 测试
         * new_time : 2019-11-01
         * path : /upload/default/20191028/9a88a60cc598683752a6fb1adfd593b5.jpg
         */

        private int new_id;
        private String new_title;
        private String new_time;
        private String path;

        public int getNew_id() {
            return new_id;
        }

        public void setNew_id(int new_id) {
            this.new_id = new_id;
        }

        public String getNew_title() {
            return new_title;
        }

        public void setNew_title(String new_title) {
            this.new_title = new_title;
        }

        public String getNew_time() {
            return new_time;
        }

        public void setNew_time(String new_time) {
            this.new_time = new_time;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
