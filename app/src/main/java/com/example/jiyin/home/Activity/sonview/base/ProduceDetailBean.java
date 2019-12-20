package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

/**
 * 玑瑛出品详情
 */
public class ProduceDetailBean extends Callcode {


    /**
     * msg : success
     * data : {"produce_id":1,"produce_title":"测试","produce_time":"2019-11-04 10:47:26","produce_content":"<p>11<\/p>"}
     * time : 1574065413
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
         * produce_id : 1
         * produce_title : 测试
         * produce_time : 2019-11-04 10:47:26
         * produce_content : <p>11</p>
         */

        private int produce_id;
        private String produce_title;
        private String produce_time;
        private String produce_content;

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

        public String getProduce_time() {
            return produce_time;
        }

        public void setProduce_time(String produce_time) {
            this.produce_time = produce_time;
        }

        public String getProduce_content() {
            return produce_content;
        }

        public void setProduce_content(String produce_content) {
            this.produce_content = produce_content;
        }
    }
}
