package com.example.jiyin.home.Activity.homeview.base;

import android.widget.Checkable;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

public class CirclelabelBean extends Callcode {


    /**
     * msg : success
     * data : [{"ification_title":"王者荣耀","ification_id":1}]
     * time : 1573204290
     */

    private String msg;
    private int time;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean  implements Checkable {
        /**
         * ification_title : 王者荣耀
         * ification_id : 1
         */


        private String ification_title;
        private int ification_id;

        public DataBean(String ification_title,int ification_id){
            this.ification_id=ification_id;
            this.ification_title=ification_title;
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
        /********/
        public String getIfication_title() {
            return ification_title;
        }

        public void setIfication_title(String ification_title) {
            this.ification_title = ification_title;
        }

        public int getIfication_id() {
            return ification_id;
        }

        public void setIfication_id(int ification_id) {
            this.ification_id = ification_id;
        }
    }
}
