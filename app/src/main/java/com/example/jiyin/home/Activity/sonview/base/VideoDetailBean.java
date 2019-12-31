package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class VideoDetailBean extends Callcode {


    /**
     * msg : success
     * data : {"video_id":3,"video_title":"测试","video_label":"555","video_content":"","heat_num":1,"video_num":1,"stories":[{"stories_id":1,"username":"1111","stories_text":"1111","stories_time":"2019-11-18","stories_up":0,"avatar":"1111","up":0}]}
     * time : 1574063528
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
         * video_id : 3
         * video_title : 测试
         * video_label : 555
         * video_content :
         * heat_num : 1
         * video_num : 1
         * stories : [{"stories_id":1,"username":"1111","stories_text":"1111","stories_time":"2019-11-18","stories_up":0,"avatar":"1111","up":0}]
         */

        private int video_id;
        private String video_title;
        private String video_label;
        private String video_content;
        private int heat_num;
        private int video_num;
        private int up;
        private List<StoriesBean> stories;

        public int getUp() {
            return up;
        }

        public void setUp(int up) {
            this.up = up;
        }

        public int getVideo_id() {
            return video_id;
        }

        public void setVideo_id(int video_id) {
            this.video_id = video_id;
        }

        public String getVideo_title() {
            return video_title;
        }

        public void setVideo_title(String video_title) {
            this.video_title = video_title;
        }

        public String getVideo_label() {
            return video_label;
        }

        public void setVideo_label(String video_label) {
            this.video_label = video_label;
        }

        public String getVideo_content() {
            return video_content;
        }

        public void setVideo_content(String video_content) {
            this.video_content = video_content;
        }

        public int getHeat_num() {
            return heat_num;
        }

        public void setHeat_num(int heat_num) {
            this.heat_num = heat_num;
        }

        public int getVideo_num() {
            return video_num;
        }

        public void setVideo_num(int video_num) {
            this.video_num = video_num;
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
             * stories_text : 1111
             * stories_time : 2019-11-18
             * stories_up : 0
             * avatar : 1111
             * up : 0
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
