package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class OfflineTrainingBean extends Callcode {


    /**
     * msg : success
     * data : {"oclass":[{"under_id":1,"under_title":"测试去去去去","under_path":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg","under_time":"2019-11-19","under_type":1}],"tcamp":[]}
     * time : 1575535276
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
        private List<OclassBean> oclass;
        private List<OclassBean> tcamp;

        public List<OclassBean> getOclass() {
            return oclass;
        }

        public void setOclass(List<OclassBean> oclass) {
            this.oclass = oclass;
        }

        public List<OclassBean> getTcamp() {
            return tcamp;
        }

        public void setTcamp(List<OclassBean> tcamp) {
            this.tcamp = tcamp;
        }

        public static class OclassBean {
            /**
             * under_id : 1
             * under_title : 测试去去去去
             * under_path : /upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg
             * under_time : 2019-11-19
             * under_type : 1
             */

            private int under_id;
            private String under_title;
            private String under_path;
            private String under_time;
            private int under_type;

            public int getUnder_id() {
                return under_id;
            }

            public void setUnder_id(int under_id) {
                this.under_id = under_id;
            }

            public String getUnder_title() {
                return under_title;
            }

            public void setUnder_title(String under_title) {
                this.under_title = under_title;
            }

            public String getUnder_path() {
                return under_path;
            }

            public void setUnder_path(String under_path) {
                this.under_path = under_path;
            }

            public String getUnder_time() {
                return under_time;
            }

            public void setUnder_time(String under_time) {
                this.under_time = under_time;
            }

            public int getUnder_type() {
                return under_type;
            }

            public void setUnder_type(int under_type) {
                this.under_type = under_type;
            }
        }
    }
}
