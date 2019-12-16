package com.example.jiyin.home.Activity.sonview.base;

import android.widget.Checkable;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class VideoindexBean extends Callcode {


    /**
     * msg : success
     * data : {"ification":[{"ification_id":3,"ification_title":"22"},{"ification_id":1,"ification_title":"111"}],"video":[{"video_id":4,"video_title":"111","video_label":"222","video_time":"2019-11-01","video_num":0,"heat_num":0,"video_path":"/upload/admin/20191029/620d1c80c0a8998c5e544dbb1997f00a.mp4"},{"video_id":3,"video_title":"测试","video_label":"555","video_time":"2019-10-30","video_num":0,"heat_num":0,"video_path":"/upload/admin/20191030/ef347740aad35aed4078e4a4bedcb134.mp4"}]}
     * time : 1574059379
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
        private List<IficationBean> ification;
        private List<VideoBean> video;

        public List<IficationBean> getIfication() {
            return ification;
        }

        public void setIfication(List<IficationBean> ification) {
            this.ification = ification;
        }

        public List<VideoBean> getVideo() {
            return video;
        }

        public void setVideo(List<VideoBean> video) {
            this.video = video;
        }

        public static class IficationBean implements Checkable {
            /**
             * ification_id : 3
             * ification_title : 22
             */

            private int ification_id;
            private String ification_title;

            public IficationBean(int ification_id, String ification_title) {
                this.ification_id = ification_id;
                this.ification_title = ification_title;
            }

            public int getIfication_id() {
                return ification_id;
            }

            public void setIfication_id(int ification_id) {
                this.ification_id = ification_id;
            }

            public String getIfication_title() {
                return ification_title;
            }

            public void setIfication_title(String ification_title) {
                this.ification_title = ification_title;
            }

            private boolean mChecked = false;

            public void setChecked(boolean checked) {
                mChecked = checked;
            }

            public boolean isChecked() {
                return mChecked;
            }

            public void toggle() {
                setChecked(!mChecked);
            }
        }

        public static class VideoBean {
            /**
             * video_id : 4
             * video_title : 111
             * video_label : 222
             * video_time : 2019-11-01
             * video_num : 0
             * heat_num : 0
             * video_path : /upload/admin/20191029/620d1c80c0a8998c5e544dbb1997f00a.mp4
             */

            private int video_id;
            private String video_title;
            private String video_label;
            private String video_time;
            private int video_num;
            private int heat_num;
            private String video_path;

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

            public String getVideo_time() {
                return video_time;
            }

            public void setVideo_time(String video_time) {
                this.video_time = video_time;
            }

            public int getVideo_num() {
                return video_num;
            }

            public void setVideo_num(int video_num) {
                this.video_num = video_num;
            }

            public int getHeat_num() {
                return heat_num;
            }

            public void setHeat_num(int heat_num) {
                this.heat_num = heat_num;
            }

            public String getVideo_path() {
                return video_path;
            }

            public void setVideo_path(String video_path) {
                this.video_path = video_path;
            }
        }
    }
}
