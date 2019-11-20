package com.example.jiyin.common.net.presenter;

public interface IBaseListener {
    /**
     * 加载结束
     */
    void onLoadStart();

    /**
     * 加载结束
     */
    void onLoadFinished();

    /**
     * 网络异常
     */
    void onNetErr();

    /**
     * 系统异常
     */
    void onSysErr(int httpCode, String msg);

}
