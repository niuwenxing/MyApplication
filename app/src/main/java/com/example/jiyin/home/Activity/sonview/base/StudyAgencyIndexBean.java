package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class StudyAgencyIndexBean extends Callcode {


    /**
     * msg : success
     * data : {"maintain":{"maintain_id":1,"maintain_path":"/upload/admin/20191119/56c5ec30468cbe1f3c425f16ff826fee.jpg","maintain_text":"<p>测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试<\/p>"},"online":[{"online_id":1,"online_title":"测试111","online_label":"111","online_num":0,"online_hot":0,"online_time":"2019-11-19","online_path":"/upload/admin/20191030/ef347740aad35aed4078e4a4bedcb134.mp4"}]}
     * time : 1574143720
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
         * maintain : {"maintain_id":1,"maintain_path":"/upload/admin/20191119/56c5ec30468cbe1f3c425f16ff826fee.jpg","maintain_text":"<p>测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试<\/p>"}
         * online : [{"online_id":1,"online_title":"测试111","online_label":"111","online_num":0,"online_hot":0,"online_time":"2019-11-19","online_path":"/upload/admin/20191030/ef347740aad35aed4078e4a4bedcb134.mp4"}]
         */

        private MaintainBean maintain;
        private List<OnlineBean> online;

        public MaintainBean getMaintain() {
            return maintain;
        }

        public void setMaintain(MaintainBean maintain) {
            this.maintain = maintain;
        }

        public List<OnlineBean> getOnline() {
            return online;
        }

        public void setOnline(List<OnlineBean> online) {
            this.online = online;
        }

        public static class MaintainBean {
            /**
             * maintain_id : 1
             * maintain_path : /upload/admin/20191119/56c5ec30468cbe1f3c425f16ff826fee.jpg
             * maintain_text : <p>测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试</p>
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

        public static class OnlineBean {
            /**
             * online_id : 1
             * online_title : 测试111
             * online_label : 111
             * online_num : 0
             * online_hot : 0
             * online_time : 2019-11-19
             * online_path : /upload/admin/20191030/ef347740aad35aed4078e4a4bedcb134.mp4
             */

            private int online_id;
            private String online_title;
            private String online_label;
            private int online_num;
            private int online_hot;
            private String online_time;
            private String online_path;

            public int getOnline_id() {
                return online_id;
            }

            public void setOnline_id(int online_id) {
                this.online_id = online_id;
            }

            public String getOnline_title() {
                return online_title;
            }

            public void setOnline_title(String online_title) {
                this.online_title = online_title;
            }

            public String getOnline_label() {
                return online_label;
            }

            public void setOnline_label(String online_label) {
                this.online_label = online_label;
            }

            public int getOnline_num() {
                return online_num;
            }

            public void setOnline_num(int online_num) {
                this.online_num = online_num;
            }

            public int getOnline_hot() {
                return online_hot;
            }

            public void setOnline_hot(int online_hot) {
                this.online_hot = online_hot;
            }

            public String getOnline_time() {
                return online_time;
            }

            public void setOnline_time(String online_time) {
                this.online_time = online_time;
            }

            public String getOnline_path() {
                return online_path;
            }

            public void setOnline_path(String online_path) {
                this.online_path = online_path;
            }
        }
    }
}
