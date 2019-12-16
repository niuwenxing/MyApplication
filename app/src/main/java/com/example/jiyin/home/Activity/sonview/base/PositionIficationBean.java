package com.example.jiyin.home.Activity.sonview.base;

import android.widget.Checkable;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class PositionIficationBean extends Callcode {

    /**
     * msg : success
     * data : {"gdoc":[{"ification_id":1,"ification_title":"是否是放松放松8555665165去去去去","ification_type":1}],"xdoc":[{"ification_id":5,"ification_title":"1111","ification_type":2}],"zdoc":[{"ification_id":6,"ification_title":"222","ification_type":3}]}
     * time : 1575535420
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
        private List<GdocBean> gdoc;
        private List<XdocBean> xdoc;
        private List<ZdocBean> zdoc;

        public List<GdocBean> getGdoc() {
            return gdoc;
        }

        public void setGdoc(List<GdocBean> gdoc) {
            this.gdoc = gdoc;
        }

        public List<XdocBean> getXdoc() {
            return xdoc;
        }

        public void setXdoc(List<XdocBean> xdoc) {
            this.xdoc = xdoc;
        }

        public List<ZdocBean> getZdoc() {
            return zdoc;
        }

        public void setZdoc(List<ZdocBean> zdoc) {
            this.zdoc = zdoc;
        }

        public static class GdocBean implements Checkable {
            /**
             * ification_id : 1
             * ification_title : 是否是放松放松8555665165去去去去
             * ification_type : 1
             */

            private int ification_id;
            private String ification_title;
            private int ification_type;

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

            public int getIfication_type() {
                return ification_type;
            }

            public void setIfication_type(int ification_type) {
                this.ification_type = ification_type;
            }
        }

        public static class XdocBean implements Checkable{
            /**
             * ification_id : 5
             * ification_title : 1111
             * ification_type : 2
             */

            private int ification_id;
            private String ification_title;
            private int ification_type;
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

            public int getIfication_type() {
                return ification_type;
            }

            public void setIfication_type(int ification_type) {
                this.ification_type = ification_type;
            }
        }

        public static class ZdocBean implements Checkable{
            /**
             * ification_id : 6
             * ification_title : 222
             * ification_type : 3
             */

            private int ification_id;
            private String ification_title;
            private int ification_type;
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

            public int getIfication_type() {
                return ification_type;
            }

            public void setIfication_type(int ification_type) {
                this.ification_type = ification_type;
            }
        }
    }
}
