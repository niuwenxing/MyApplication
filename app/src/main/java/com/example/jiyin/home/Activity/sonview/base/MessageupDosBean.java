package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class MessageupDosBean extends Callcode {

    /**
     * msg : success
     * data : [{"up_id":57,"circle_id":92,"uid":7,"up_time":"2019-12-24 18:03:06","circle_uid":7,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"up_id":58,"circle_id":92,"uid":7,"up_time":"2019-12-24 18:04:35","circle_uid":7,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"up_id":59,"circle_id":92,"uid":7,"up_time":"2019-12-24 18:04:53","circle_uid":7,"username":"1111","avatar":"/upload/admin/timg.jpg"}]
     * time : 1577260953
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
         * up_id : 57
         * circle_id : 92
         * uid : 7
         * up_time : 2019-12-24 18:03:06
         * circle_uid : 7
         * username : 1111
         * avatar : /upload/admin/timg.jpg
         */

        private int up_id;
        private int circle_id;
        private int uid;
        private String up_time;
        private int circle_uid;
        private String username;
        private String avatar;

        public int getUp_id() {
            return up_id;
        }

        public void setUp_id(int up_id) {
            this.up_id = up_id;
        }

        public int getCircle_id() {
            return circle_id;
        }

        public void setCircle_id(int circle_id) {
            this.circle_id = circle_id;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUp_time() {
            return up_time;
        }

        public void setUp_time(String up_time) {
            this.up_time = up_time;
        }

        public int getCircle_uid() {
            return circle_uid;
        }

        public void setCircle_uid(int circle_uid) {
            this.circle_uid = circle_uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
