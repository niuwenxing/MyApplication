package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class MessagefollowDosBean extends Callcode {


    /**
     * msg : success
     * data : [{"follow_id":6,"uid":7,"follow_uid":7,"follow_time":"2019-12-23 15:17:54","follow_status":1,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"follow_id":7,"uid":7,"follow_uid":7,"follow_time":"2019-12-23 15:18:11","follow_status":1,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"follow_id":8,"uid":7,"follow_uid":7,"follow_time":"2019-12-23 15:18:12","follow_status":1,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"follow_id":9,"uid":7,"follow_uid":7,"follow_time":"2019-12-23 15:50:52","follow_status":1,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"follow_id":10,"uid":7,"follow_uid":7,"follow_time":"2019-12-23 16:34:56","follow_status":1,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"follow_id":11,"uid":7,"follow_uid":7,"follow_time":"2019-12-24 17:43:47","follow_status":1,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"follow_id":12,"uid":7,"follow_uid":7,"follow_time":"2019-12-25 10:30:56","follow_status":1,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"follow_id":13,"uid":7,"follow_uid":7,"follow_time":"2019-12-25 10:32:24","follow_status":1,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"follow_id":14,"uid":7,"follow_uid":7,"follow_time":"2019-12-25 10:34:07","follow_status":1,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"follow_id":15,"uid":7,"follow_uid":7,"follow_time":"2019-12-25 10:34:53","follow_status":1,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"follow_id":16,"uid":7,"follow_uid":7,"follow_time":"2019-12-25 10:34:54","follow_status":1,"username":"1111","avatar":"/upload/admin/timg.jpg"},{"follow_id":17,"uid":7,"follow_uid":7,"follow_time":"2019-12-25 10:34:55","follow_status":1,"username":"1111","avatar":"/upload/admin/timg.jpg"}]
     * time : 1577253174
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
         * follow_id : 6
         * uid : 7
         * follow_uid : 7
         * follow_time : 2019-12-23 15:17:54
         * follow_status : 1
         * username : 1111
         * avatar : /upload/admin/timg.jpg
         */

        private int follow_id;
        private int uid;
        private int follow_uid;
        private String follow_time;
        private int follow_status;
        private String username;
        private String avatar;

        public int getFollow_id() {
            return follow_id;
        }

        public void setFollow_id(int follow_id) {
            this.follow_id = follow_id;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getFollow_uid() {
            return follow_uid;
        }

        public void setFollow_uid(int follow_uid) {
            this.follow_uid = follow_uid;
        }

        public String getFollow_time() {
            return follow_time;
        }

        public void setFollow_time(String follow_time) {
            this.follow_time = follow_time;
        }

        public int getFollow_status() {
            return follow_status;
        }

        public void setFollow_status(int follow_status) {
            this.follow_status = follow_status;
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
