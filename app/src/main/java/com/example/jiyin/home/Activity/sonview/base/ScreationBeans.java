package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class ScreationBeans extends Callcode {


    /**
     * msg : success
     * data : {"maintain":{"maintain_id":1,"maintain_path":"/upload/admin/20191119/56c5ec30468cbe1f3c425f16ff826fee.jpg","maintain_text":"<p>我；了提个拼命11111111111啊<\/p>"},"screation":[{"creation_id":1,"creation_title":"跑跑","creation_stime":"2019-11-30","creation_hnum":2,"creation_status":0,"creation_path":""}],"tscreation":[{"creation_id":3,"creation_title":"测试","creation_stime":"2019-11-09","creation_hnum":0,"creation_status":2,"creation_path":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg"}]}
     * time : 1575863598
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
         * maintain : {"maintain_id":1,"maintain_path":"/upload/admin/20191119/56c5ec30468cbe1f3c425f16ff826fee.jpg","maintain_text":"<p>我；了提个拼命11111111111啊<\/p>"}
         * screation : [{"creation_id":1,"creation_title":"跑跑","creation_stime":"2019-11-30","creation_hnum":2,"creation_status":0,"creation_path":""}]
         * tscreation : [{"creation_id":3,"creation_title":"测试","creation_stime":"2019-11-09","creation_hnum":0,"creation_status":2,"creation_path":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg"}]
         */

        private MaintainBean maintain;
        private List<ScreationBean> screation;
        private List<TscreationBean> tscreation;

        public MaintainBean getMaintain() {
            return maintain;
        }

        public void setMaintain(MaintainBean maintain) {
            this.maintain = maintain;
        }

        public List<ScreationBean> getScreation() {
            return screation;
        }

        public void setScreation(List<ScreationBean> screation) {
            this.screation = screation;
        }

        public List<TscreationBean> getTscreation() {
            return tscreation;
        }

        public void setTscreation(List<TscreationBean> tscreation) {
            this.tscreation = tscreation;
        }

        public static class MaintainBean {
            /**
             * maintain_id : 1
             * maintain_path : /upload/admin/20191119/56c5ec30468cbe1f3c425f16ff826fee.jpg
             * maintain_text : <p>我；了提个拼命11111111111啊</p>
             */

            private int maintain_id;
            private String maintain_path;
            private String maintain_text;

            public int getMaintain_id() {
                return maintain_id;
            }

            public void setMaintain_id(int maintain_id) {
                this.maintain_id = maintain_id;
            }

            public String getMaintain_path() {
                return maintain_path;
            }

            public void setMaintain_path(String maintain_path) {
                this.maintain_path = maintain_path;
            }

            public String getMaintain_text() {
                return maintain_text;
            }

            public void setMaintain_text(String maintain_text) {
                this.maintain_text = maintain_text;
            }
        }

        public static class ScreationBean {
            /**
             * creation_id : 1
             * creation_title : 跑跑
             * creation_stime : 2019-11-30
             * creation_hnum : 2
             * creation_status : 0
             * creation_path :
             */

            private int creation_id;
            private String creation_title;
            private String creation_stime;
            private int creation_hnum;
            private int creation_status;
            private String creation_path;

            public int getCreation_id() {
                return creation_id;
            }

            public void setCreation_id(int creation_id) {
                this.creation_id = creation_id;
            }

            public String getCreation_title() {
                return creation_title;
            }

            public void setCreation_title(String creation_title) {
                this.creation_title = creation_title;
            }

            public String getCreation_stime() {
                return creation_stime;
            }

            public void setCreation_stime(String creation_stime) {
                this.creation_stime = creation_stime;
            }

            public int getCreation_hnum() {
                return creation_hnum;
            }

            public void setCreation_hnum(int creation_hnum) {
                this.creation_hnum = creation_hnum;
            }

            public int getCreation_status() {
                return creation_status;
            }

            public void setCreation_status(int creation_status) {
                this.creation_status = creation_status;
            }

            public String getCreation_path() {
                return creation_path;
            }

            public void setCreation_path(String creation_path) {
                this.creation_path = creation_path;
            }
        }

        public static class TscreationBean {
            /**
             * creation_id : 3
             * creation_title : 测试
             * creation_stime : 2019-11-09
             * creation_hnum : 0
             * creation_status : 2
             * creation_path : /upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg
             */

            private int creation_id;
            private String creation_title;
            private String creation_stime;
            private int creation_hnum;
            private int creation_status;
            private String creation_path;

            public int getCreation_id() {
                return creation_id;
            }

            public void setCreation_id(int creation_id) {
                this.creation_id = creation_id;
            }

            public String getCreation_title() {
                return creation_title;
            }

            public void setCreation_title(String creation_title) {
                this.creation_title = creation_title;
            }

            public String getCreation_stime() {
                return creation_stime;
            }

            public void setCreation_stime(String creation_stime) {
                this.creation_stime = creation_stime;
            }

            public int getCreation_hnum() {
                return creation_hnum;
            }

            public void setCreation_hnum(int creation_hnum) {
                this.creation_hnum = creation_hnum;
            }

            public int getCreation_status() {
                return creation_status;
            }

            public void setCreation_status(int creation_status) {
                this.creation_status = creation_status;
            }

            public String getCreation_path() {
                return creation_path;
            }

            public void setCreation_path(String creation_path) {
                this.creation_path = creation_path;
            }
        }
    }
}
