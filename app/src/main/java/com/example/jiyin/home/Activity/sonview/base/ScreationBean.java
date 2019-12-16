package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

//造物集 详情
public class ScreationBean extends Callcode {


    /**
     * msg : success
     * data : {"creation_id":1,"creation_title":"ce","creation_vtitle":"cccccc","creation_ctime":"2019-11-11 10:20:13","creation_text":"<p><img id=\"loading_k3f8fz64\"   src=\"http://www.jyxm.com/static/js/ueditor/themes/default/images/spacer.gif\" title=\"正在上传...\"/><\/p>","creation_stime":"2019-11-30","enroll":1,"status":0}
     * time : 1574748626
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
         * creation_id : 1
         * creation_title : ce
         * creation_vtitle : cccccc
         * creation_ctime : 2019-11-11 10:20:13
         * creation_text : <p><img id="loading_k3f8fz64"   src="http://www.jyxm.com/static/js/ueditor/themes/default/images/spacer.gif" title="正在上传..."/></p>
         * creation_stime : 2019-11-30
         * enroll : 1
         * status : 0
         */

        private int creation_id;
        private String creation_title;
        private String creation_vtitle;
        private String creation_ctime;
        private String creation_text;
        private String creation_stime;
        private int enroll;
        private int status;

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

        public String getCreation_vtitle() {
            return creation_vtitle;
        }

        public void setCreation_vtitle(String creation_vtitle) {
            this.creation_vtitle = creation_vtitle;
        }

        public String getCreation_ctime() {
            return creation_ctime;
        }

        public void setCreation_ctime(String creation_ctime) {
            this.creation_ctime = creation_ctime;
        }

        public String getCreation_text() {
            return creation_text;
        }

        public void setCreation_text(String creation_text) {
            this.creation_text = creation_text;
        }

        public String getCreation_stime() {
            return creation_stime;
        }

        public void setCreation_stime(String creation_stime) {
            this.creation_stime = creation_stime;
        }

        public int getEnroll() {
            return enroll;
        }

        public void setEnroll(int enroll) {
            this.enroll = enroll;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
