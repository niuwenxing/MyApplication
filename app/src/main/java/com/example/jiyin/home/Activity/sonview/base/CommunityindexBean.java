package com.example.jiyin.home.Activity.sonview.base;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class CommunityindexBean extends Callcode {

    /**
     * msg : success
     * data : {"banner":[{"banner_id":5,"banner_url":"11111","banner_time":"2019-11-01 17:03:01","banner_path":"/upload/admin/20191025/75f0ffe93f2780905261acbd7635b964.jpg","banner_type":3}],"list":[{"community_title":"测试","community_path":"/upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg","community_paths":"/upload/default/20191028/9a88a60cc598683752a6fb1adfd593b5.jpg","community_id":3,"community_vtitle":"111"}]}
     * time : 1577264214
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
        private List<BannerBean> banner;
        private List<ListBean> list;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class BannerBean {
            /**
             * banner_id : 5
             * banner_url : 11111
             * banner_time : 2019-11-01 17:03:01
             * banner_path : /upload/admin/20191025/75f0ffe93f2780905261acbd7635b964.jpg
             * banner_type : 3
             */

            private int banner_id;
            private String banner_url;
            private String banner_time;
            private String banner_path;
            private int banner_type;

            public int getBanner_id() {
                return banner_id;
            }

            public void setBanner_id(int banner_id) {
                this.banner_id = banner_id;
            }

            public String getBanner_url() {
                return banner_url;
            }

            public void setBanner_url(String banner_url) {
                this.banner_url = banner_url;
            }

            public String getBanner_time() {
                return banner_time;
            }

            public void setBanner_time(String banner_time) {
                this.banner_time = banner_time;
            }

            public String getBanner_path() {
                return banner_path;
            }

            public void setBanner_path(String banner_path) {
                this.banner_path = banner_path;
            }

            public int getBanner_type() {
                return banner_type;
            }

            public void setBanner_type(int banner_type) {
                this.banner_type = banner_type;
            }
        }

        public static class ListBean {
            /**
             * community_title : 测试
             * community_path : /upload/default/20191025/b911e7e8c41b20ab6a014e34c1ee91be.jpg
             * community_paths : /upload/default/20191028/9a88a60cc598683752a6fb1adfd593b5.jpg
             * community_id : 3
             * community_vtitle : 111
             */

            private String community_title;
            private String community_path;
            private String community_paths;
            private int community_id;
            private String community_vtitle;

            public String getCommunity_title() {
                return community_title;
            }

            public void setCommunity_title(String community_title) {
                this.community_title = community_title;
            }

            public String getCommunity_path() {
                return community_path;
            }

            public void setCommunity_path(String community_path) {
                this.community_path = community_path;
            }

            public String getCommunity_paths() {
                return community_paths;
            }

            public void setCommunity_paths(String community_paths) {
                this.community_paths = community_paths;
            }

            public int getCommunity_id() {
                return community_id;
            }

            public void setCommunity_id(int community_id) {
                this.community_id = community_id;
            }

            public String getCommunity_vtitle() {
                return community_vtitle;
            }

            public void setCommunity_vtitle(String community_vtitle) {
                this.community_vtitle = community_vtitle;
            }
        }
    }
}
