package com.example.jiyin.common.net.callback;

import android.text.TextUtils;

import com.example.jiyin.common.net.beas.BaseResponseModel;
import com.example.jiyin.common.net.NetConfig;
import com.example.rootlib.mvp.presenter.IBaseListener;
import com.example.rootlib.utils.LogUtils;
import com.example.rootlib.utils.StringUtil;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by gray on 2018/7/18.
 * 带json解析回调解析器
 */
public abstract class BeanCallBack<T extends BaseResponseModel> implements Callback<T>, NetConfig {

    /**
     * 基础响应回调，不处理业务，仅通知
     */
    IBaseListener baseListener;

    public BeanCallBack(IBaseListener baseListener) {
        this.baseListener = baseListener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {//貌似是只要网络正常就会走这个回调,比如not found也是在这个回调里面,而非onFailure
        //通知上级类加载结束
        callBackFinished();

        if (200 == response.raw().code()) {//200是服务器有合理响应
            if (response.body() == null) {
                onSysError(response.raw().code(), response.raw().message());
                return;
            }
            if (!StringUtil.isEmpty(response.body().status) && TextUtils.equals(response.body().status, "0") || TextUtils.equals(response.body().status, "200")) {
                onSuc(response);
            } else {
                onFail(response.body().status, response.body().message);
            }
        } else {
            onSysError(response.raw().code(), response.raw().message());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {//网络问题会走该回调
        LogUtils.e("request failer.\ndetail: " + t.toString());

        //通知上级类加载结束
        callBackFinished();

        if (t instanceof SocketTimeoutException ||
                t instanceof ConnectException ||
                t instanceof SocketException ||
                t instanceof UnknownHostException) {
            onNetError();
        } else {
            onSysError(HTTP_ERR_COMMON, t.getMessage());
        }
    }

    /**
     * 回调上级类加载结束
     */
    private void callBackFinished() {
        if (baseListener != null) {
            baseListener.onLoadFinished();
        }
    }

    /**
     * 请求成功
     *
     * @param response
     */
    public abstract void onSuc(Response<T> response);

    /**
     * 服务器业务处理失败
     *
     * @param status
     * @param message
     */
    public abstract void onFail(String status, String message);

    /**
     * 网络异常
     */
    public abstract void onNetError();

    /**
     * 服务器异常
     *
     * @param httpCode
     * @param msg
     */
    public abstract void onSysError(int httpCode, String msg);


}

