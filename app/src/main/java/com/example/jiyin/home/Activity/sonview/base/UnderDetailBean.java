package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

public class UnderDetailBean extends Callcode {
    /**
     * msg : success
     * data : {"under_id":1,"under_title":"测试去去去去","under_time":"2019-11-19","under_type":1,"under_vtitle":"QQ群","under_text":"<p>冯绍峰是放松放松是的山东省<\/p>","under_money":15,"enroll":1}
     * time : 1574146358
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
         * under_id : 1
         * under_title : 测试去去去去
         * under_time : 2019-11-19
         * under_type : 1
         * under_vtitle : QQ群
         * under_text : <p>冯绍峰是放松放松是的山东省</p>
         * under_money : 15
         * enroll : 1
         */

        private int under_id;
        private String under_title;
        private String under_time;
        private int under_type;
        private String under_vtitle;
        private String under_text;
        private int under_money;
        private int enroll;

        public int getUnder_id() {
            return under_id;
        }

        public void setUnder_id(int under_id) {
            this.under_id = under_id;
        }

        public String getUnder_title() {
            return under_title;
        }

        public void setUnder_title(String under_title) {
            this.under_title = under_title;
        }

        public String getUnder_time() {
            return under_time;
        }

        public void setUnder_time(String under_time) {
            this.under_time = under_time;
        }

        public int getUnder_type() {
            return under_type;
        }

        public void setUnder_type(int under_type) {
            this.under_type = under_type;
        }

        public String getUnder_vtitle() {
            return under_vtitle;
        }

        public void setUnder_vtitle(String under_vtitle) {
            this.under_vtitle = under_vtitle;
        }

        public String getUnder_text() {
            return under_text;
        }

        public void setUnder_text(String under_text) {
            this.under_text = under_text;
        }

        public int getUnder_money() {
            return under_money;
        }

        public void setUnder_money(int under_money) {
            this.under_money = under_money;
        }

        public int getEnroll() {
            return enroll;
        }

        public void setEnroll(int enroll) {
            this.enroll = enroll;
        }
    }


    /**
     * msg : success
     * data : {"under_id":1,"under_title":"测试去去去去","under_time":"2019-11-19","under_type":1,"under_vtitle":"QQ群","under_text":"<p>冯绍峰是放松放松是的山东省<\/p>","under_money":15,"enroll":1}
     * time : 1574146358
     */


//    private String msg;
//    private DataBean data;
//    private int time;
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
//    public int getTime() {
//        return time;
//    }
//
//    public void setTime(int time) {
//        this.time = time;
//    }
//
//    public static class DataBean {
//        /**
//         * under_id : 1
//         * under_title : 测试去去去去
//         * under_time : 2019-11-19
//         * under_type : 1
//         * under_vtitle : QQ群
//         * under_text : <p>冯绍峰是放松放松是的山东省</p>
//         * under_money : 15
//         * enroll : 1
//         */
//
//        private int under_id;
//        private String under_title;
//        private String under_time;
//        private int under_type;
//        private String under_vtitle;
//        private String under_text;
//        private int under_money;
//        private int enroll;
//
//        public int getUnder_id() {
//            return under_id;
//        }
//
//        public void setUnder_id(int under_id) {
//            this.under_id = under_id;
//        }
//
//        public String getUnder_title() {
//            return under_title;
//        }
//
//        public void setUnder_title(String under_title) {
//            this.under_title = under_title;
//        }
//
//        public String getUnder_time() {
//            return under_time;
//        }
//
//        public void setUnder_time(String under_time) {
//            this.under_time = under_time;
//        }
//
//        public int getUnder_type() {
//            return under_type;
//        }
//
//        public void setUnder_type(int under_type) {
//            this.under_type = under_type;
//        }
//
//        public String getUnder_vtitle() {
//            return under_vtitle;
//        }
//
//        public void setUnder_vtitle(String under_vtitle) {
//            this.under_vtitle = under_vtitle;
//        }
//
//        public String getUnder_text() {
//            return under_text;
//        }
//
//        public void setUnder_text(String under_text) {
//            this.under_text = under_text;
//        }
//
//        public int getUnder_money() {
//            return under_money;
//        }
//
//        public void setUnder_money(int under_money) {
//            this.under_money = under_money;
//        }
//
//        public int getEnroll() {
//            return enroll;
//        }
//
//        public void setEnroll(int enroll) {
//            this.enroll = enroll;
//        }
//    }
}
