package com.example.jiyin.common.net.beas;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by gray on 2018/7/18.
 */
public class RootResponseModel  {
    /**
     * 状态码
     */
    @JSONField(name = "code")
    public String status = "";
    /**
     * 服务器响应消息
     */
    public String message = "";
    /**
     * 当前响应时间
     */
    public String current_datetime;

    public Integer userId;//用户id

    public String realname;//真是姓名

    public String phoneNumber;//手机号

    public String memberCard;//会员卡号

    public Integer clubId;//球会id

    public String approveStatus;//认证状态 0 未 1 成功 2认证中 3 拒绝

    public String approveImgUp;

    public String approveImgDown;//替换为身份证号

    public Date createTime;

    public Date modifyTime;

    public String reason;//原因

    public String overTime;//有效期

    public Date approveTime;//审批时间

    public String lifelong;//'0:终身1：不是终身',

    public String clubName;//球会名

    /**
     * 调试编号
     */
    public String id = "";

    public int state; // 0 不更新 1 推荐更新 2 强制更新

    public String url;

    public boolean flag;
}
