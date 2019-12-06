package com.example.jiyin.home.Activity.sonview.base;

import android.widget.Checkable;

import com.example.jiyin.common.net.netunti.Callcode;

import java.util.List;

/**
 * <p> 工作坊 基类 </p>
 */
public class WorkshopLabelBase extends Callcode {


    /**
     * code : 1
     * msg : success
     * data : [{"ification_id":3,"ification_title":"去去去去去去去去","ification_time":"2019-11-19 16:54:04"},{"ification_id":1,"ification_title":"是否是放松放松8555665165去去去去","ification_time":"2019-11-19 15:37:11"}]
     * time : 1574217088
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

    public static class DataBean implements Checkable  {
        /**
         * ification_id : 3
         * ification_title : 去去去去去去去去
         * ification_time : 2019-11-19 16:54:04
         */

        private int ification_id;
        private String ification_title;
        private String ification_time;

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

        public String getIfication_time() {
            return ification_time;
        }

        public void setIfication_time(String ification_time) {
            this.ification_time = ification_time;
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
}
