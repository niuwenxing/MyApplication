package com.example.jiyin.common.bean;

/**
 * Created by guolei on 2017/11/24.
 * event通知bean，简单类型
 */
public class EventNoticeBean extends BaseModel {
    /**
     * 消息类型
     */
    private int typeId;
    /**
     * 附加信息
     */
    private String msg;


    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public EventNoticeBean() {

    }

    public EventNoticeBean(int typeId) {
        this.typeId = typeId;
    }

    public EventNoticeBean(String msg) {
        this.msg = msg;
    }

    public EventNoticeBean(int typeId, String msg) {
        this.typeId = typeId;
        this.msg = msg;
    }
}