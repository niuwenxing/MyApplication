package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class NewdetailBean extends Callcode {


    /**
     * msg : success
     * data : {"new_id":4,"new_title":"测试","new_text":"<p>无所谓是是是是<\/p>","stories":[{"stories_id":1,"username":"1111","stories_text":"4444","stories_time":"2019-11-06","stories_up":0,"avatar":"1111","up":1}]}
     * time : 1574041819
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
         * new_id : 4
         * new_title : 测试
         * new_text : <p>无所谓是是是是</p>
         * stories : [{"stories_id":1,"username":"1111","stories_text":"4444","stories_time":"2019-11-06","stories_up":0,"avatar":"1111","up":1}]
         */

        private int new_id;
        private String new_title;
        private String new_text;
        private List<StoriesBean> stories;

        public int getNew_id() {
            return new_id;
        }

        public void setNew_id(int new_id) {
            this.new_id = new_id;
        }

        public String getNew_title() {
            return new_title;
        }

        public void setNew_title(String new_title) {
            this.new_title = new_title;
        }

        public String getNew_text() {
            return new_text;
        }

        public void setNew_text(String new_text) {
            this.new_text = new_text;
        }

        public List<StoriesBean> getStories() {
            return stories;
        }

        public void setStories(List<StoriesBean> stories) {
            this.stories = stories;
        }

        public static class StoriesBean {
            /**
             * stories_id : 1
             * username : 1111
             * stories_text : 4444
             * stories_time : 2019-11-06
             * stories_up : 0
             * avatar : 1111
             * up : 1
             */

            private int stories_id;
            private String username;
            private String stories_text;
            private String stories_time;
            private int stories_up;
            private String avatar;
            private int up;

            public int getStories_id() {
                return stories_id;
            }

            public void setStories_id(int stories_id) {
                this.stories_id = stories_id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getStories_text() {
                return stories_text;
            }

            public void setStories_text(String stories_text) {
                this.stories_text = stories_text;
            }

            public String getStories_time() {
                return stories_time;
            }

            public void setStories_time(String stories_time) {
                this.stories_time = stories_time;
            }

            public int getStories_up() {
                return stories_up;
            }

            public void setStories_up(int stories_up) {
                this.stories_up = stories_up;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getUp() {
                return up;
            }

            public void setUp(int up) {
                this.up = up;
            }
        }
    }
}
