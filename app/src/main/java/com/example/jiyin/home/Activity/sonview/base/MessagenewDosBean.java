package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class MessagenewDosBean extends Callcode {

    /**
     * msg : success
     * data : [{"new_id":6,"new_title":"11","new_time":"2019-11-04","new_text":"<p>1111<\/p>"},{"new_id":3,"new_title":"2","new_time":"2019-10-25","new_text":"<p>21<\/p>"},{"new_id":1,"new_title":"测试","new_time":"2019-10-25","new_text":"<p><img src=\"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg\" title=\")JWAWO]VIUREIP(5]HXC_ZT.jpg\" alt=\")JWAWO]VIUREIP(5]HXC_ZT.jpg\"/><\/p>"}]
     * time : 1577261352
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
         * new_id : 6
         * new_title : 11
         * new_time : 2019-11-04
         * new_text : <p>1111</p>
         */

        private int new_id;
        private String new_title;
        private String new_time;
        private String new_text;

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

        public String getNew_text() {
            return new_text;
        }

        public void setNew_text(String new_text) {
            this.new_text = new_text;
        }
    }
}
