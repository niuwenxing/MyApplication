package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class ProduceIndexBean extends Callcode {


    /**
     * msg : success
     * data : [{"produce_id":1,"produce_title":"测试","produce_brief":"1111","produce_path":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg","produce_stime":"2019-11-14","produce_etime":"2019-11-30"}]
     * time : 1574064905
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
         * produce_id : 1
         * produce_title : 测试
         * produce_brief : 1111
         * produce_path : /upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg
         * produce_stime : 2019-11-14
         * produce_etime : 2019-11-30
         */

        private int produce_id;
        private String produce_title;
        private String produce_brief;
        private String produce_path;
        private String produce_stime;
        private String produce_etime;

        public int getProduce_id() {
            return produce_id;
        }

        public void setProduce_id(int produce_id) {
            this.produce_id = produce_id;
        }

        public String getProduce_title() {
            return produce_title;
        }

        public void setProduce_title(String produce_title) {
            this.produce_title = produce_title;
        }

        public String getProduce_brief() {
            return produce_brief;
        }

        public void setProduce_brief(String produce_brief) {
            this.produce_brief = produce_brief;
        }

        public String getProduce_path() {
            return produce_path;
        }

        public void setProduce_path(String produce_path) {
            this.produce_path = produce_path;
        }

        public String getProduce_stime() {
            return produce_stime;
        }

        public void setProduce_stime(String produce_stime) {
            this.produce_stime = produce_stime;
        }

        public String getProduce_etime() {
            return produce_etime;
        }

        public void setProduce_etime(String produce_etime) {
            this.produce_etime = produce_etime;
        }
    }
}
