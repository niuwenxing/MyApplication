package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class MessagecommentDosBean extends Callcode {

    /**
     * msg : success
     * data : [{"comment_id":2,"circle_id":1,"comment":"11","comment_uid":4,"comment_time":null,"to_uid":7,"fid":1,"username":"22","avatar":"/upload/admin/timg.jpg"}]
     * time : 1577262184
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
         * comment_id : 2
         * circle_id : 1
         * comment : 11
         * comment_uid : 4
         * comment_time : null
         * to_uid : 7
         * fid : 1
         * username : 22
         * avatar : /upload/admin/timg.jpg
         */

        private int comment_id;
        private int circle_id;
        private String comment;
        private int comment_uid;
        private Object comment_time;
        private int to_uid;
        private int fid;
        private String username;
        private String avatar;

        public int getComment_id() {
            return comment_id;
        }

        public void setComment_id(int comment_id) {
            this.comment_id = comment_id;
        }

        public int getCircle_id() {
            return circle_id;
        }

        public void setCircle_id(int circle_id) {
            this.circle_id = circle_id;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public int getComment_uid() {
            return comment_uid;
        }

        public void setComment_uid(int comment_uid) {
            this.comment_uid = comment_uid;
        }

        public Object getComment_time() {
            return comment_time;
        }

        public void setComment_time(Object comment_time) {
            this.comment_time = comment_time;
        }

        public int getTo_uid() {
            return to_uid;
        }

        public void setTo_uid(int to_uid) {
            this.to_uid = to_uid;
        }

        public int getFid() {
            return fid;
        }

        public void setFid(int fid) {
            this.fid = fid;
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
