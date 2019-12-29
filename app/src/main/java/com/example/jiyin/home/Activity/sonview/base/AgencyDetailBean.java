package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class AgencyDetailBean extends Callcode {

    /**
     * msg : success
     * data : {"online_id":1,"online_title":"测试111","online_label":"111","online_hot":0,"online_text":"<p>11111111111111111111111111111111111111111111111<\/p>","online_path":"/upload/admin/20191030/ef347740aad35aed4078e4a4bedcb134.mp4","online_num":0,"stories":[{"stories_id":1,"username":"1111","stories_text":"qqqqqq","stories_time":"2019-11-19","stories_up":1,"avatar":"1111","up":1}]}
     * time : 1574145712
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
         * online_id : 1
         * online_title : 测试111
         * online_label : 111
         * online_hot : 0
         * online_text : <p>11111111111111111111111111111111111111111111111</p>
         * online_path : /upload/admin/20191030/ef347740aad35aed4078e4a4bedcb134.mp4
         * online_num : 0
         * stories : [{"stories_id":1,"username":"1111","stories_text":"qqqqqq","stories_time":"2019-11-19","stories_up":1,"avatar":"1111","up":1}]
         */

        private int online_id;
        private String online_title;
        private String online_label;
        private int online_hot;
        private String online_text;
        private String online_path;
        private int online_num;
        private List<StoriesBean> stories;

        public int getOnline_id() {
            return online_id;
        }

        public void setOnline_id(int online_id) {
            this.online_id = online_id;
        }

        public String getOnline_title() {
            return online_title;
        }

        public void setOnline_title(String online_title) {
            this.online_title = online_title;
        }

        public String getOnline_label() {
            return online_label;
        }

        public void setOnline_label(String online_label) {
            this.online_label = online_label;
        }

        public int getOnline_hot() {
            return online_hot;
        }

        public void setOnline_hot(int online_hot) {
            this.online_hot = online_hot;
        }

        public String getOnline_text() {
            return online_text;
        }

        public void setOnline_text(String online_text) {
            this.online_text = online_text;
        }

        public String getOnline_path() {
            return online_path;
        }

        public void setOnline_path(String online_path) {
            this.online_path = online_path;
        }

        public int getOnline_num() {
            return online_num;
        }

        public void setOnline_num(int online_num) {
            this.online_num = online_num;
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
             * stories_text : qqqqqq
             * stories_time : 2019-11-19
             * stories_up : 1
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
