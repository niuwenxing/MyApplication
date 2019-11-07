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


}
