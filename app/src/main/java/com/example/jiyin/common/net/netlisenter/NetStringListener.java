package com.example.jiyin.common.net.netlisenter;


import com.example.rootlib.mvp.presenter.IBaseListener;

/**
 * Created by guolei on 2017/5/10.
 */

public interface NetStringListener extends IBaseListener {
    /**
     * 服务器响应回调
     * @param result
     */
    void onResponse(String result);
}
