package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

public class ClassifyDetailBean extends Callcode {


    /**
     * msg : success
     * data : {"new_id":1,"new_title":"测试","new_text":"<p><img src=\"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg\" title=\")JWAWO]VIUREIP(5]HXC_ZT.jpg\" alt=\")JWAWO]VIUREIP(5]HXC_ZT.jpg\"/><\/p>"}
     * time : 1574040516
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
         * new_id : 1
         * new_title : 测试
         * new_text : <p><img src="/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg" title=")JWAWO]VIUREIP(5]HXC_ZT.jpg" alt=")JWAWO]VIUREIP(5]HXC_ZT.jpg"/></p>
         */

        private int new_id;
        private String new_title;
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

        public String getNew_text() {
            return new_text;
        }

        public void setNew_text(String new_text) {
            this.new_text = new_text;
        }
    }
}
