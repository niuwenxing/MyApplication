package com.example.jiyin.common.net.netunti;


import com.example.jiyin.common.net.callback.StringCallBack;
import com.example.jiyin.common.net.netlisenter.NetStringListener;
import com.example.rootlib.mvp.presenter.biz.IBaseAPIBiz;
import com.example.rootlib.utils.LogUtils;

import retrofit2.Call;
import retrofit2.Response;

/**
 * 基础网络访问单元
 *
 */
public class StringNetUnit implements IBaseAPIBiz<NetStringListener> {
    protected Call<String> call;

    public StringNetUnit request(final NetStringListener listener) {

        // 没有设置访问句柄，报错返回
        if (call == null) {
            LogUtils.e("请通过setCall方法设置请求句柄");
            return this;
        }

        listener.onLoadStart();
        call.enqueue(new StringCallBack(listener) {

            @Override
            public void onResponse(Response<String> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onNetError() {
                listener.onNetErr();
            }

            @Override
            public void onSysError(int httpCode, String msg) {
                listener.onSysErr(httpCode, msg);
            }
        });

        return this;
    }

    /**
     * 设置请求句柄
     */
    public StringNetUnit setCall(Call call){
        this.call = call;
        return this;
    }

    @Override
    public void cancelRequest() {
        if (call != null && !call.isCanceled()) call.cancel();
    }
}
