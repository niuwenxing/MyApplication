package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class PositionDetailBean extends Callcode {


    /**
     * msg : success
     * data : {"position_id":2,"position_name":"程序员","cname":"科技大","position_site":"天津-河北","education":"大专","position_money":"8-13","position_text":"<p>11111<\/p>","c_text":"<p>111111<\/p>","position_label":"7,6,","label":["java","php"],"enroll":0}
     * time : 1574408549
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
         * position_id : 2
         * position_name : 程序员
         * cname : 科技大
         * position_site : 天津-河北
         * education : 大专
         * position_money : 8-13
         * position_text : <p>11111</p>
         * c_text : <p>111111</p>
         * position_label : 7,6,
         * label : ["java","php"]
         * enroll : 0
         */

        private int position_id;
        private String position_name;
        private String cname;
        private String position_site;
        private String education;
        private String position_money;
        private String position_text;
        private String c_text;
        private String position_label;
        private int enroll;
        private List<String> label;

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

        public String getPosition_text() {
            return position_text;
        }

        public void setPosition_text(String position_text) {
            this.position_text = position_text;
        }

        public String getC_text() {
            return c_text;
        }

        public void setC_text(String c_text) {
            this.c_text = c_text;
        }

        public String getPosition_label() {
            return position_label;
        }

        public void setPosition_label(String position_label) {
            this.position_label = position_label;
        }

        public int getEnroll() {
            return enroll;
        }

        public void setEnroll(int enroll) {
            this.enroll = enroll;
        }

        public List<String> getLabel() {
            return label;
        }

        public void setLabel(List<String> label) {
            this.label = label;
        }
    }
}
