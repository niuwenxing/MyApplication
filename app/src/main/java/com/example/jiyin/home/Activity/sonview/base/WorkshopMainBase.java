package com.example.jiyin.home.Activity.sonview.base;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

/**
 * 工作坊 首页数据
 */
public class WorkshopMainBase extends Callcode {


    /**
     * msg : success
     * data : {"maintain":{"maintain_id":1,"maintain_path":"/upload/admin/20191025/75f0ffe93f2780905261acbd7635b964.jpg","maintain_text":"<p>我；了提个拼命地；了买个；的了买个买个；\u2018的明天攻破而叫突破文件改破的口；阿无所谓是冯绍峰的帅哥的丰田光荣与回馈哦哦的改天我我师傅的有缘人回复的快感破耳机压迫是冻结；绿毛龟；立刻烦恼hi偶尔进去【、的<\/p>"},"workshop":[{"work_id":2,"work_title":"我我我人","work_time":"2019-11-19 16:54:25","work_content":"是否是放松放松QQ群"}]}
     * time : 1574154676
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
         * maintain : {"maintain_id":1,"maintain_path":"/upload/admin/20191025/75f0ffe93f2780905261acbd7635b964.jpg","maintain_text":"<p>我；了提个拼命地；了买个；的了买个买个；\u2018的明天攻破而叫突破文件改破的口；阿无所谓是冯绍峰的帅哥的丰田光荣与回馈哦哦的改天我我师傅的有缘人回复的快感破耳机压迫是冻结；绿毛龟；立刻烦恼hi偶尔进去【、的<\/p>"}
         * workshop : [{"work_id":2,"work_title":"我我我人","work_time":"2019-11-19 16:54:25","work_content":"是否是放松放松QQ群"}]
         */

        private MaintainBean maintain;
        private List<WorkshopBean> workshop;

        public MaintainBean getMaintain() {
            return maintain;
        }

        public void setMaintain(MaintainBean maintain) {
            this.maintain = maintain;
        }

        public List<WorkshopBean> getWorkshop() {
            return workshop;
        }

        public void setWorkshop(List<WorkshopBean> workshop) {
            this.workshop = workshop;
        }

        public static class MaintainBean {
            /**
             * maintain_id : 1
             * maintain_path : /upload/admin/20191025/75f0ffe93f2780905261acbd7635b964.jpg
             * maintain_text : <p>我；了提个拼命地；了买个；的了买个买个；‘的明天攻破而叫突破文件改破的口；阿无所谓是冯绍峰的帅哥的丰田光荣与回馈哦哦的改天我我师傅的有缘人回复的快感破耳机压迫是冻结；绿毛龟；立刻烦恼hi偶尔进去【、的</p>
             */

            private int maintain_id;
            private String maintain_path;
            private String maintain_text;

            public int getMaintain_id() {
                return maintain_id;
            }

            public void setMaintain_id(int maintain_id) {
                this.maintain_id = maintain_id;
            }

            public String getMaintain_path() {
                return maintain_path;
            }

            public void setMaintain_path(String maintain_path) {
                this.maintain_path = maintain_path;
            }

            public String getMaintain_text() {
                return maintain_text;
            }

            public void setMaintain_text(String maintain_text) {
                this.maintain_text = maintain_text;
            }
        }

        public static class WorkshopBean  {
            /**
             * work_id : 2
             * work_title : 我我我人
             * work_time : 2019-11-19 16:54:25
             * work_content : 是否是放松放松QQ群
             */

            private int work_id;
            private String work_title;
            private String work_time;
            private String work_content;

            public int getWork_id() {
                return work_id;
            }

            public void setWork_id(int work_id) {
                this.work_id = work_id;
            }

            public String getWork_title() {
                return work_title;
            }

            public void setWork_title(String work_title) {
                this.work_title = work_title;
            }

            public String getWork_time() {
                return work_time;
            }

            public void setWork_time(String work_time) {
                this.work_time = work_time;
            }

            public String getWork_content() {
                return work_content;
            }

            public void setWork_content(String work_content) {
                this.work_content = work_content;
            }


        }
    }
}
