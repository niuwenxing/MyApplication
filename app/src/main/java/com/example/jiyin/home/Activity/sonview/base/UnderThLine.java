package com.example.jiyin.home.Activity.sonview.base;

import java.util.List;

//自定义 线下培训
public class UnderThLine {


    private List<List<?>> study;

    public List<List<?>> getStudy() {
        return study;
    }

    public void setStudy(List<List<?>> study) {
        this.study = study;
    }

    public static class StudyBean {
        /**
         * type : 1
         * list : {"under_id":1,"under_title":"测试去去去去","under_path":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg","under_time":"2019-11-19","under_type":1}
         */

        private int type;
        private List<OfflineTrainingBean.DataBean> list;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<OfflineTrainingBean.DataBean> getList() {
            return list;
        }

        public void setList(List<OfflineTrainingBean.DataBean> list) {
            this.list = list;
        }


    }
}
