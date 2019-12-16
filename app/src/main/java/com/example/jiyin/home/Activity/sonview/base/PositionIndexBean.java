package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class PositionIndexBean extends Callcode {


    /**
     * msg : success
     * data : {"maintain":{"maintain_id":1,"maintain_path":"/upload/admin/20191119/56c5ec30468cbe1f3c425f16ff826fee.jpg","maintain_text":"<p>11啊大大大<\/p>"},"position":[{"position_id":2,"position_name":"程序员","cname":"科技大","position_site":"天津-河北","education":"大专","position_money":"8-13"}]}
     * time : 1574403453
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
         * maintain : {"maintain_id":1,"maintain_path":"/upload/admin/20191119/56c5ec30468cbe1f3c425f16ff826fee.jpg","maintain_text":"<p>11啊大大大<\/p>"}
         * position : [{"position_id":2,"position_name":"程序员","cname":"科技大","position_site":"天津-河北","education":"大专","position_money":"8-13"}]
         */

        private MaintainBean maintain;
        private List<PositionBean> position;

        public MaintainBean getMaintain() {
            return maintain;
        }

        public void setMaintain(MaintainBean maintain) {
            this.maintain = maintain;
        }

        public List<PositionBean> getPosition() {
            return position;
        }

        public void setPosition(List<PositionBean> position) {
            this.position = position;
        }

        public static class MaintainBean {
            /**
             * maintain_id : 1
             * maintain_path : /upload/admin/20191119/56c5ec30468cbe1f3c425f16ff826fee.jpg
             * maintain_text : <p>11啊大大大</p>
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

        public static class PositionBean {
            /**
             * position_id : 2
             * position_name : 程序员
             * cname : 科技大
             * position_site : 天津-河北
             * education : 大专
             * position_money : 8-13
             */

            private int position_id;
            private String position_name;
            private String cname;
            private String position_site;
            private String education;
            private String position_money;

            public int getPosition_id() {
                return position_id;
            }

            public void setPosition_id(int position_id) {
                this.position_id = position_id;
            }

            public String getPosition_name() {
                return position_name;
            }

            public void setPosition_name(String position_name) {
                this.position_name = position_name;
            }

            public String getCname() {
                return cname;
            }

            public void setCname(String cname) {
                this.cname = cname;
            }

            public String getPosition_site() {
                return position_site;
            }

            public void setPosition_site(String position_site) {
                this.position_site = position_site;
            }

            public String getEducation() {
                return education;
            }

            public void setEducation(String education) {
                this.education = education;
            }

            public String getPosition_money() {
                return position_money;
            }

            public void setPosition_money(String position_money) {
                this.position_money = position_money;
            }
        }
    }
}
