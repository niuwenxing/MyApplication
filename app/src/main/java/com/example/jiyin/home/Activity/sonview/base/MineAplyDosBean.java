package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class MineAplyDosBean extends Callcode {

    /**
     * msg : success
     * data : {"under":[{"under_time":"2019-11-19 15:00:00","under_id":1,"under_title":"测试去去去去","under_path":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg"}],"workShop":[{"work_id":2,"work_title":"我我我人","work_time":"2019-11-19 16:54:25","work_content":"是否是放松放松QQ群"}],"position":[{"position_id":3,"position_name":"2222","cname":"测试","position_site":"天津-河北","education":"大专","position_money":"8-79"},{"position_id":2,"position_name":"程序员","cname":"科技大","position_site":"天津-河北","education":"大专","position_money":"8-13"}],"time":[{"zid":2,"z_title":"ce","z_stime":"2019-11-16","z_etime":"2019-11-30","z_path":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg"}]}
     * time : 1577267258
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
        private List<UnderBean> under;
        private List<WorkShopBean> workShop;
        private List<PositionBean> position;
        private List<TimeBean> time;

        public List<UnderBean> getUnder() {
            return under;
        }

        public void setUnder(List<UnderBean> under) {
            this.under = under;
        }

        public List<WorkShopBean> getWorkShop() {
            return workShop;
        }

        public void setWorkShop(List<WorkShopBean> workShop) {
            this.workShop = workShop;
        }

        public List<PositionBean> getPosition() {
            return position;
        }

        public void setPosition(List<PositionBean> position) {
            this.position = position;
        }

        public List<TimeBean> getTime() {
            return time;
        }

        public void setTime(List<TimeBean> time) {
            this.time = time;
        }

        public static class UnderBean {
            /**
             * under_time : 2019-11-19 15:00:00
             * under_id : 1
             * under_title : 测试去去去去
             * under_path : /upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg
             */

            private String under_time;
            private int under_id;
            private String under_title;
            private String under_path;

            public String getUnder_time() {
                return under_time;
            }

            public void setUnder_time(String under_time) {
                this.under_time = under_time;
            }

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
        }

        public static class WorkShopBean {
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

        public static class PositionBean {
            /**
             * position_id : 3
             * position_name : 2222
             * cname : 测试
             * position_site : 天津-河北
             * education : 大专
             * position_money : 8-79
             */

            private int position_id;
            private String position_name;
            private String cname;
            private String position_site;
            private String education;
            private String position_money;

            public int getPosition_id() {
                return position_id;
            }

            public void setPosition_id(int position_id) {
                this.position_id = position_id;
            }

            public String getPosition_name() {
                return position_name;
            }

            public void setPosition_name(String position_name) {
                this.position_name = position_name;
            }

            public String getCname() {
                return cname;
            }

            public void setCname(String cname) {
                this.cname = cname;
            }

            public String getPosition_site() {
                return position_site;
            }

            public void setPosition_site(String position_site) {
                this.position_site = position_site;
            }

            public String getEducation() {
                return education;
            }

            public void setEducation(String education) {
                this.education = education;
            }

            public String getPosition_money() {
                return position_money;
            }

            public void setPosition_money(String position_money) {
                this.position_money = position_money;
            }
        }

        public static class TimeBean {
            /**
             * zid : 2
             * z_title : ce
             * z_stime : 2019-11-16
             * z_etime : 2019-11-30
             * z_path : /upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg
             */

            private int zid;
            private String z_title;
            private String z_stime;
            private String z_etime;
            private String z_path;

            public int getZid() {
                return zid;
            }

            public void setZid(int zid) {
                this.zid = zid;
            }

            public String getZ_title() {
                return z_title;
            }

            public void setZ_title(String z_title) {
                this.z_title = z_title;
            }

            public String getZ_stime() {
                return z_stime;
            }

            public void setZ_stime(String z_stime) {
                this.z_stime = z_stime;
            }

            public String getZ_etime() {
                return z_etime;
            }

            public void setZ_etime(String z_etime) {
                this.z_etime = z_etime;
            }

            public String getZ_path() {
                return z_path;
            }

            public void setZ_path(String z_path) {
                this.z_path = z_path;
            }
        }
    }
}
