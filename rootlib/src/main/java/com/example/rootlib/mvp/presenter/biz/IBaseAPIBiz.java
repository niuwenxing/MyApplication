package com.example.rootlib.mvp.presenter.biz;

import com.example.rootlib.mvp.presenter.IBaseListener;

import retrofit2.Call;

/**
 * Created by gray on 2016/7/18.
 * 接口类业务抽象
 */

public interface IBaseAPIBiz<L extends IBaseListener> extends IBaseBiz{
    /**
     * 设置请求目标
     */
    <T extends IBaseAPIBiz> T setCall(Call call);

    /**
     * 开始访问
     */
    <T extends IBaseAPIBiz> T request(final L listener);
}
