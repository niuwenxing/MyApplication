package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class FounderfounderBean extends Callcode {


    /**
     * msg : success
     * data : {"banner":[{"banner_id":4,"banner_url":"","banner_path":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg"},{"banner_id":3,"banner_url":"111","banner_path":"/upload/default/20191028/9a88a60cc598683752a6fb1adfd593b5.jpg"},{"banner_id":2,"banner_url":"www.aaaa.com1","banner_path":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg"}],"recommend":[{"founder_name":"我就是有钱！","founder_head":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg","founder_job":"ceo","founder_brief":"就是有钱  不服打我！！！！","founder_id":1}],"founder":[{"founder_name":"测试","founder_head":"","founder_job":"1","founder_brief":"就是有钱  不服打我！！！！","founder_id":1},{"founder_name":"测试","founder_head":"/upload/default/20191028/9a88a60cc598683752a6fb1adfd593b5.jpg","founder_job":"11","founder_brief":"就是有钱  不服打我！！！！","founder_id":1},{"founder_name":"钻石王老五","founder_head":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg","founder_job":"CEO白富美","founder_brief":"就是有钱  不服打我！！！！","founder_id":1}]}
     * time : 1573712619
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
        private List<BannerBean> banner;
        private List<RecommendBean> recommend;
        private List<FounderBean> founder;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

        public List<FounderBean> getFounder() {
            return founder;
        }

        public void setFounder(List<FounderBean> founder) {
            this.founder = founder;
        }

        public static class BannerBean {
            /**
             * banner_id : 4
             * banner_url :
             * banner_path : /upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg
             */

            private int banner_id;
            private String banner_url;
            private String banner_path;

            public int getBanner_id() {
                return banner_id;
            }

            public void setBanner_id(int banner_id) {
                this.banner_id = banner_id;
            }

            public String getBanner_url() {
                return banner_url;
            }

            public void setBanner_url(String banner_url) {
                this.banner_url = banner_url;
            }

            public String getBanner_path() {
                return banner_path;
            }

            public void setBanner_path(String banner_path) {
                this.banner_path = banner_path;
            }
        }

        public static class RecommendBean {
            /**
             * founder_name : 我就是有钱！
             * founder_head : /upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg
             * founder_job : ceo
             * founder_brief : 就是有钱  不服打我！！！！
             * founder_id : 1
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

        public static class FounderBean {
            /**
             * founder_name : 测试
             * founder_head :
             * founder_job : 1
             * founder_brief : 就是有钱  不服打我！！！！
             * founder_id : 1
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
}
