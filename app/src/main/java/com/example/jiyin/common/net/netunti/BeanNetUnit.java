package com.example.jiyin.common.net.netunti;


import com.example.jiyin.common.bean.EventNoticeBean;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.net.beas.RootResponseModel;
import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.utils.EventBusUtil;
import com.example.rootlib.mvp.presenter.biz.IBaseAPIBiz;
import com.example.rootlib.utils.LogUtils;
import com.example.rootlib.utils.StringUtil;
import com.google.gson.Gson;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeanNetUnit<T extends Callcode> extends RootResponseModel implements IBaseAPIBiz<NetBeanListener>, BaseConfig {
    protected Call<T> call;

    @Override
    public BeanNetUnit request(final NetBeanListener listener) {
        // 没有设置访问句柄，报错返回
        if (call == null) {
            LogUtils.e("请通过setCall方法设置请求句柄");
            return this;
        }
        listener.onLoadStart();//实现加载

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                LogUtils.d("网络请求成功"+response.body()+"***"+response+"json"+new Gson().toJson(response.body()));
                callBackFinished(listener);
                if(response.raw().code()==200){
                    if (response.body().code== BaseConfig.SERVER_ERR_LOGIN_OBSOLETE) {
                        EventBusUtil.post(new EventNoticeBean(EventBusUtil.EVENT_TOKEN_INVALIDATE, " token过期"));
                    }
                    if (response.body() == null) {
                        listener.onSysErr(response.raw().code(), response.raw().message());
                        return;
                    }
                    if (!StringUtil.isEmpty(response.body().toString())) {
                        listener.onSuc(response.body());
                        LogUtils.w("json"+new Gson().toJson(response.body()));
                    }else{
                        listener.onFail(response.code(), response.message());
                    }
                }else{
                    listener.onSysErr(response.raw().code(), response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                LogUtils.d("网络请求失败");
                callBackFinished(listener);
                if (t instanceof SocketTimeoutException ||  //套接字超时异常
                        t instanceof ConnectException ||    //连接异常
                        t instanceof SocketException ||     //套接字异常
                        t instanceof UnknownHostException) { //未知主机异常
                    listener.onNetErr();//网络错误
                    LogUtils.e("网络错误");
                }else{
                    LogUtils.e("错误"+t.getMessage());
                    listener.onSysErr(999, t.getMessage()+"未知错误");//未知错误
                }
//                listener.onFail(call.toString(),call.isCanceled(),t.getMessage().toString());
            }
        });

        return this;
    }

    private void callBackFinished(NetBeanListener listener) {
        if (listener!=null) {
            listener.onLoadFinished();
        }
    }


    @Override
    public void cancelRequest() {
        if (call != null && !call.isCanceled()) call.cancel();
    }

    /**
     * 请求句柄
     * @param call
     * @return
     */
    @Override
    public BeanNetUnit setCall(Call call) {
        this.call = call;
        return this;
    }

}
