package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

public class UserInfoBean extends Callcode {

    /**
     * msg : success
     * data : {"username":"11","avatar":"/upload/admin/timg.jpg","status":0,}
     * time : 1573092939
     */

    private String msg;
    private DataBean data;
    private int time;
    private int tel;

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

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
         * username : 11
         * avatar : /upload/admin/timg.jpg
         * status : 0
         */

        private String username;
        private String avatar;
        private String tel;
        private int status;


        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
