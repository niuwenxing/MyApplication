package com.example.jiyin.common.widget.detail;

import java.util.List;

/**
 * Created by moos on 2018/4/20.
 */

public class CommentDetailBean {
    private int cid;
    private String username;
    private String avatar;
    private String content;
    private String zan;
    private String ifzan;
    private int replyTotal;
    private String createDate;
    private String time;
    private List<ReplyDetailBean> sublist;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIfzan() {
        return ifzan;
    }

    public void setIfzan(String ifzan) {
        this.ifzan = ifzan;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getZan() {
        return zan;
    }

    public void setZan(String zan) {
        this.zan = zan;
    }

    public List<ReplyDetailBean> getSublist() {
        return sublist;
    }

    public void setSublist(List<ReplyDetailBean> sublist) {
        this.sublist = sublist;
    }

    public void setReplyTotal(int replyTotal) {
        this.replyTotal = replyTotal;
    }
    public int getReplyTotal() {
        return replyTotal;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getCreateDate() {
        return createDate;
    }

    public void setReplyList(List<ReplyDetailBean> replyList) {
        this.sublist = replyList;
    }
    public List<ReplyDetailBean> getReplyList() {
        return sublist;
    }
}
