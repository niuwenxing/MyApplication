package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IndexindexBean extends Callcode {


    /**
     * msg : success
     * data : {"new":{"new_id":4,"new_title":"测试"},"project":[{"new_id":5,"new_title":"测试","path":"/upload/default/20191028/9a88a60cc598683752a6fb1adfd593b5.jpg","new_hot":0}],"video":[{"video_id":5,"video_label":"555","video_path":"/upload/default/20191029/8a775dd326818db755cc1b7285b34dab.mp4","video_title":"1111","video_num":0},{"video_id":3,"video_label":"555","video_path":"/upload/admin/20191030/ef347740aad35aed4078e4a4bedcb134.mp4","video_title":"测试","video_num":0}],"advert":{"advert_id":1,"advert_title":"测试","advert_text":"测试","advert_path":""},"box":[{"box_id":1,"box_title":"研习社","box_text":"视频讲解","box_path":null,"box_num":0}]}
     * time : 1573699871
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
         * new : {"new_id":4,"new_title":"测试"}
         * project : [{"new_id":5,"new_title":"测试","path":"/upload/default/20191028/9a88a60cc598683752a6fb1adfd593b5.jpg","new_hot":0}]
         * video : [{"video_id":5,"video_label":"555","video_path":"/upload/default/20191029/8a775dd326818db755cc1b7285b34dab.mp4","video_title":"1111","video_num":0},{"video_id":3,"video_label":"555","video_path":"/upload/admin/20191030/ef347740aad35aed4078e4a4bedcb134.mp4","video_title":"测试","video_num":0}]
         * advert : {"advert_id":1,"advert_title":"测试","advert_text":"测试","advert_path":""}
         * box : [{"box_id":1,"box_title":"研习社","box_text":"视频讲解","box_path":null,"box_num":0}]
         */

        @SerializedName("new")
        private NewBean newX;
        private AdvertBean advert;
        private List<ProjectBean> project;
        private List<VideoBean> video;
        private List<BoxBean> box;

        public NewBean getNewX() {
            return newX;
        }

        public void setNewX(NewBean newX) {
            this.newX = newX;
        }

        public AdvertBean getAdvert() {
            return advert;
        }

        public void setAdvert(AdvertBean advert) {
            this.advert = advert;
        }

        public List<ProjectBean> getProject() {
            return project;
        }

        public void setProject(List<ProjectBean> project) {
            this.project = project;
        }

        public List<VideoBean> getVideo() {
            return video;
        }

        public void setVideo(List<VideoBean> video) {
            this.video = video;
        }

        public List<BoxBean> getBox() {
            return box;
        }

        public void setBox(List<BoxBean> box) {
            this.box = box;
        }

        public static class NewBean {
            /**
             * new_id : 4
             * new_title : 测试
             */

            private int new_id;
            private String new_title;

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
        }

        public static class AdvertBean {
            /**
             * advert_id : 1
             * advert_title : 测试
             * advert_text : 测试
             * advert_path :
             */

            private int advert_id;
            private String advert_title;
            private String advert_text;
            private String advert_path;

            public int getAdvert_id() {
                return advert_id;
            }

            public void setAdvert_id(int advert_id) {
                this.advert_id = advert_id;
            }

            public String getAdvert_title() {
                return advert_title;
            }

            public void setAdvert_title(String advert_title) {
                this.advert_title = advert_title;
            }

            public String getAdvert_text() {
                return advert_text;
            }

            public void setAdvert_text(String advert_text) {
                this.advert_text = advert_text;
            }

            public String getAdvert_path() {
                return advert_path;
            }

            public void setAdvert_path(String advert_path) {
                this.advert_path = advert_path;
            }
        }

        public static class ProjectBean {
            /**
             * new_id : 5
             * new_title : 测试
             * path : /upload/default/20191028/9a88a60cc598683752a6fb1adfd593b5.jpg
             * new_hot : 0
             */

            private int new_id;
            private String new_title;
            private String path;
            private int new_hot;

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

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public int getNew_hot() {
                return new_hot;
            }

            public void setNew_hot(int new_hot) {
                this.new_hot = new_hot;
            }
        }

        public static class VideoBean {
            /**
             * video_id : 5
             * video_label : 555
             * video_path : /upload/default/20191029/8a775dd326818db755cc1b7285b34dab.mp4
             * video_title : 1111
             * video_num : 0
             */

            private int video_id;
            private String video_label;
            private String video_path;
            private String video_title;
            private int video_num;

            public int getVideo_id() {
                return video_id;
            }

            public void setVideo_id(int video_id) {
                this.video_id = video_id;
            }

            public String getVideo_label() {
                return video_label;
            }

            public void setVideo_label(String video_label) {
                this.video_label = video_label;
            }

            public String getVideo_path() {
                return video_path;
            }

            public void setVideo_path(String video_path) {
                this.video_path = video_path;
            }

            public String getVideo_title() {
                return video_title;
            }

            public void setVideo_title(String video_title) {
                this.video_title = video_title;
            }

            public int getVideo_num() {
                return video_num;
            }

            public void setVideo_num(int video_num) {
                this.video_num = video_num;
            }
        }

        public static class BoxBean {
            /**
             * box_id : 1
             * box_title : 研习社
             * box_text : 视频讲解
             * box_path : null
             * box_num : 0
             */

            private int box_id;
            private String box_title;
            private String box_text;
            private Object box_path;
            private int box_num;

            public int getBox_id() {
                return box_id;
            }

            public void setBox_id(int box_id) {
                this.box_id = box_id;
            }

            public String getBox_title() {
                return box_title;
            }

            public void setBox_title(String box_title) {
                this.box_title = box_title;
            }

            public String getBox_text() {
                return box_text;
            }

            public void setBox_text(String box_text) {
                this.box_text = box_text;
            }

            public Object getBox_path() {
                return box_path;
            }

            public void setBox_path(Object box_path) {
                this.box_path = box_path;
            }

            public int getBox_num() {
                return box_num;
            }

            public void setBox_num(int box_num) {
                this.box_num = box_num;
            }
        }
    }
}
