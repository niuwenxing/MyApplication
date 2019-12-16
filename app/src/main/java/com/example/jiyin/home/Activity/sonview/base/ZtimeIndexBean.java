package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class ZtimeIndexBean extends Callcode {


    /**
     * msg : success
     * data : {"maintain":{"maintain_id":1,"maintain_path":"/upload/admin/20191119/56c5ec30468cbe1f3c425f16ff826fee.jpg","maintain_text":"<p>我；了提个拼命<\/p>"},"screation":[{"zid":1,"z_title":"ce","z_path":"","z_stime":"2019-11-16","z_etime":"2019-11-30","z_status":0}],"tscreation":[]}
     * time : 1575863692
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
         * maintain : {"maintain_id":1,"maintain_path":"/upload/admin/20191119/56c5ec30468cbe1f3c425f16ff826fee.jpg","maintain_text":"<p>我；了提个拼命<\/p>"}
         * screation : [{"zid":1,"z_title":"ce","z_path":"","z_stime":"2019-11-16","z_etime":"2019-11-30","z_status":0}]
         * tscreation : []
         */

        private MaintainBean maintain;
        private List<ScreationBean> screation;
        private List<ScreationBean> tscreation;

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

        public List<ScreationBean> getTscreation() {
            return tscreation;
        }

        public void setTscreation(List<ScreationBean> tscreation) {
            this.tscreation = tscreation;
        }

        public static class MaintainBean {
            /**
             * maintain_id : 1
             * maintain_path : /upload/admin/20191119/56c5ec30468cbe1f3c425f16ff826fee.jpg
             * maintain_text : <p>我；了提个拼命</p>
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
             * zid : 1
             * z_title : ce
             * z_path :
             * z_stime : 2019-11-16
             * z_etime : 2019-11-30
             * z_status : 0
             */

            private int zid;
            private String z_title;
            private String z_path;
            private String z_stime;
            private String z_etime;
            private int z_status;

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

            public String getZ_path() {
                return z_path;
            }

            public void setZ_path(String z_path) {
                this.z_path = z_path;
            }

            public String getZ_stime() {
                return z_stime;
            }

            public void setZ_stime(String z_stime) {
                this.z_stime = z_stime;
            }

            public String getZ_etime() {
                return z_etime;
            }

            public void setZ_etime(String z_etime) {
                this.z_etime = z_etime;
            }

            public int getZ_status() {
                return z_status;
            }

            public void setZ_status(int z_status) {
                this.z_status = z_status;
            }
        }
    }
}
