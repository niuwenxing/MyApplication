package com.example.jiyin.common.net.netunti;

import android.util.Log;

import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.net.beas.BaseResponseModel;
import com.example.jiyin.common.net.callback.BeanCallBack;
import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.rootlib.mvp.presenter.biz.IBaseAPIBiz;
import com.example.rootlib.utils.LogUtils;
import com.example.rootlib.utils.StringUtil;
import retrofit2.Call;
import retrofit2.Response;

/**
 * 基础网络访问单元
 *
 * @param <T> 网络响应成功bean类型
 */
public class BeanNetUnit<T> implements IBaseAPIBiz<NetBeanListener> {
    protected Call<BaseResponseModel<T>> call;


    @Override
    public BeanNetUnit request(final NetBeanListener listener) {

        // 没有设置访问句柄，报错返回
        if (call == null) {
            LogUtils.e("请通过setCall方法设置请求句柄");
            return this;
        }

        listener.onLoadStart();
        call.enqueue(new BeanCallBack<BaseResponseModel<T>>(listener) {
            @Override
            public void onSuc(Response<BaseResponseModel<T>> response) {
                listener.onSuc(response.body().data);
            }

            @Override
            public void onFail(String status, String message) {
                // 判断是否登录超时
                Log.e("state", "status = " + status + "  " + message);
                if (!StringUtil.isEmpty(status) && (status.equals(BaseConfig.SERVER_ERR_TOKEN_INVALIDATE)
                        || status.equals(BaseConfig.SERVER_ERR_LOGIN_EXCEPTION))) {
                    // 发送通知关闭页面
//                    EventBusUtil.post(new EventNoticeBean(EventBusUtil.EVENT_TOKEN_INVALIDATE, message));
                } else {
                    listener.onFail(status, message);
                }
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
    @Override
    public BeanNetUnit setCall(Call call) {
        this.call = call;
        return this;
    }

    @Override
    public void cancelRequest() {
        if (call != null && !call.isCanceled()) call.cancel();
    }
}
