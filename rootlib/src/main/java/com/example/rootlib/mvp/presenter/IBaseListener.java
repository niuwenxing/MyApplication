package com.example.rootlib.mvp.presenter;


/**
 * Created by gray on 2016/7/18.
 */
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
