package com.example.jiyin.home.Activity.homeview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

//圈子列表

public class CircleListBean extends Callcode {


    /**
     * msg : success
     * data : [{"circle_id":18,"circle_up":0,"circle_share":0,"circle_hot":0,"path":"/upload/admin/timg.jpg","ification_id":1,"circle_type":1,"circle_time":"2019-11-08 16:55:49","ification_title":"王者荣耀","uid":7,"avatar":"/upload/admin/timg.jpg","username":"111","comment":1,"files":[],"follow":1,"up":1,"time":"2天前"},{"circle_id":1,"circle_up":1,"circle_share":2,"circle_hot":0,"path":null,"ification_id":1,"circle_type":0,"circle_time":"2019-11-11 16:13:12","ification_title":"王者荣耀","uid":3,"avatar":"/upload/admin/timg.jpg","username":"11","comment":2,"files":[{"file_id":1,"circle_id":1,"file":"/upload/admin/timg.jpg"}],"follow":1,"up":1,"time":"5小时前"}]
     * time : 1573440532
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
         * circle_id : 18
         * circle_up : 0
         * circle_share : 0
         * circle_hot : 0
         * path : /upload/admin/timg.jpg
         * ification_id : 1
         * circle_type : 1
         * circle_time : 2019-11-08 16:55:49
         * ification_title : 王者荣耀
         * uid : 7
         * avatar : /upload/admin/timg.jpg
         * username : 111
         * comment : 1
         * files : []
         * follow : 1
         * up : 1
         * time : 2天前
         */

        private int circle_id;
        private int circle_up;
        private int circle_share;
        private int circle_hot;
        private String path;
        private int ification_id;
        private int circle_type;
        private String circle_time;
        private String ification_title;
        private int uid;
        private String avatar;
        private String username;
        private int comment;
        private int follow;
        private int up;
        private String time;
        private List<?> files;

        public int getCircle_id() {
            return circle_id;
        }

        public void setCircle_id(int circle_id) {
            this.circle_id = circle_id;
        }

        public int getCircle_up() {
            return circle_up;
        }

        public void setCircle_up(int circle_up) {
            this.circle_up = circle_up;
        }

        public int getCircle_share() {
            return circle_share;
        }

        public void setCircle_share(int circle_share) {
            this.circle_share = circle_share;
        }

        public int getCircle_hot() {
            return circle_hot;
        }

        public void setCircle_hot(int circle_hot) {
            this.circle_hot = circle_hot;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getIfication_id() {
            return ification_id;
        }

        public void setIfication_id(int ification_id) {
            this.ification_id = ification_id;
        }

        public int getCircle_type() {
            return circle_type;
        }

        public void setCircle_type(int circle_type) {
            this.circle_type = circle_type;
        }

        public String getCircle_time() {
            return circle_time;
        }

        public void setCircle_time(String circle_time) {
            this.circle_time = circle_time;
        }

        public String getIfication_title() {
            return ification_title;
        }

        public void setIfication_title(String ification_title) {
            this.ification_title = ification_title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public int getFollow() {
            return follow;
        }

        public void setFollow(int follow) {
            this.follow = follow;
        }

        public int getUp() {
            return up;
        }

        public void setUp(int up) {
            this.up = up;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public List<?> getFiles() {
            return files;
        }

        public void setFiles(List<?> files) {
            this.files = files;
        }
    }
}
