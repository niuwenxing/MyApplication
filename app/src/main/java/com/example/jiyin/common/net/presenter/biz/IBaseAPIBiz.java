package com.example.jiyin.common.net.presenter.biz;

import com.example.rootlib.mvp.presenter.IBaseListener;
import com.example.rootlib.mvp.presenter.biz.IBaseBiz;

import retrofit2.Call;

public interface IBaseAPIBiz<L extends IBaseListener> extends IBaseBiz {

    /**
     * 设置请求目标
     */
    <T extends IBaseAPIBiz> T setCall(Call call);

    /**
     * 开始访问
     */
    <T extends IBaseAPIBiz> T request(final L listener);

}
