package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

public class ZtimedetailBean extends Callcode {


    /**
     * msg : success
     * data : {"zid":2,"z_title":"ce","z_vtitle":"cccccc","z_ctime":"2019-11-26 10:21:32","z_text":"<p><img id=\"loading_k3f8fz64\" src=\"http://www.jyxm.com/static/js/ueditor/themes/default/images/spacer.gif\" title=\"正在上传...\"/><\/p>","enroll":1,"status":0}
     * time : 1574736047
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
         * zid : 2
         * z_title : ce
         * z_vtitle : cccccc
         * z_ctime : 2019-11-26 10:21:32
         * z_text : <p><img id="loading_k3f8fz64" src="http://www.jyxm.com/static/js/ueditor/themes/default/images/spacer.gif" title="正在上传..."/></p>
         * enroll : 1
         * status : 0
         */

        private int zid;
        private String z_title;
        private String z_vtitle;
        private String z_ctime;
        private String z_text;
        private int enroll;
        private int status;

        public int getZid() {
            return zid;
        }

        public void setZid(int zid) {
            this.zid = zid;
        }

        public String getZ_title() {
            return z_title;
        }

        public void setZ_title(String z_title) {
            this.z_title = z_title;
        }

        public String getZ_vtitle() {
            return z_vtitle;
        }

        public void setZ_vtitle(String z_vtitle) {
            this.z_vtitle = z_vtitle;
        }

        public String getZ_ctime() {
            return z_ctime;
        }

        public void setZ_ctime(String z_ctime) {
            this.z_ctime = z_ctime;
        }

        public String getZ_text() {
            return z_text;
        }

        public void setZ_text(String z_text) {
            this.z_text = z_text;
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
