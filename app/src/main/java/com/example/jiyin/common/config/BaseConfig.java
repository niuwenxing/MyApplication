package com.example.jiyin.common.config;

/**
 * 接口
 */
public interface BaseConfig {

    String ROOT_SERVER_API="http://a.gensbox.cn/api/";
//    String ROOT_SERVER_API="http://d.lepinxiao.com/api/";
//    String ROOT_SERVER_API="http://192.168.2.83";


    /**
     * 原因多种
     */
    String SERVER_ERR_LOGIN_EXCEPTION = "-1";
    //过期
    final int SERVER_ERR_LOGIN_OBSOLETE = 20003;

}
