package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class FounderListBean extends Callcode {

    /**
     * msg : success
     * data : [{"founder_name":"测试","founder_head":"","founder_job":"1","founder_brief":"111","founder_id":5},{"founder_name":"我就是有钱！","founder_head":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg","founder_job":"ceo","founder_brief":"就是有钱  不服打我！！！！","founder_id":4},{"founder_name":"测试","founder_head":"/upload/default/20191028/9a88a60cc598683752a6fb1adfd593b5.jpg","founder_job":"11","founder_brief":"111","founder_id":2},{"founder_name":"钻石王老五","founder_head":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg","founder_job":"CEO白富美","founder_brief":"就是有钱","founder_id":1}]
     * time : 1573713872
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
         * founder_name : 测试
         * founder_head :
         * founder_job : 1
         * founder_brief : 111
         * founder_id : 5
         */

        private String founder_name;
        private String founder_head;
        private String founder_job;
        private String founder_brief;
        private int founder_id;

        public String getFounder_name() {
            return founder_name;
        }

        public void setFounder_name(String founder_name) {
            this.founder_name = founder_name;
        }

        public String getFounder_head() {
            return founder_head;
        }

        public void setFounder_head(String founder_head) {
            this.founder_head = founder_head;
        }

        public String getFounder_job() {
            return founder_job;
        }

        public void setFounder_job(String founder_job) {
            this.founder_job = founder_job;
        }

        public String getFounder_brief() {
            return founder_brief;
        }

        public void setFounder_brief(String founder_brief) {
            this.founder_brief = founder_brief;
        }

        public int getFounder_id() {
            return founder_id;
        }

        public void setFounder_id(int founder_id) {
            this.founder_id = founder_id;
        }
    }
}
