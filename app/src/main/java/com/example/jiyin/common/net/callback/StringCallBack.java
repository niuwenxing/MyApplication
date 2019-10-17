package com.example.jiyin.common.net.callback;

import com.example.jiyin.common.net.NetConfig;
import com.example.rootlib.mvp.presenter.IBaseListener;
import com.example.rootlib.utils.LogUtils;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by gray on 2016/7/18.
 * 纯String解析回调解析器
 */
public abstract class StringCallBack implements Callback<String>, NetConfig {

    /**
     * 基础响应回调，不处理业务，仅通知
     */
    IBaseListener baseListener;

    public StringCallBack(IBaseListener baseListener) {
        this.baseListener = baseListener;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {//貌似是只要网络正常就会走这个回调,比如not found也是在这个回调里面,而非onFailure
        //通知上级类加载结束
        callBackFinished();

        if (200 == response.raw().code()) {//200是服务器有合理响应
            onResponse(response);
        } else {
            onSysError(response.raw().code(),response.raw().message());
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {//网络问题会走该回调
        LogUtils.e("request failer.\ndetail: " + t.toString());

        //通知上级类加载结束
        callBackFinished();

        if (t instanceof SocketTimeoutException ||
                t instanceof ConnectException ||
                t instanceof SocketException ||
                t instanceof UnknownHostException) {
            onNetError();
        } else {
            onSysError(HTTP_ERR_COMMON,t.getMessage());
        }
    }

    /**
     * 回调上级类加载结束
     */
    private void callBackFinished(){
        if (baseListener != null) {
            baseListener.onLoadFinished();
        }
    }

    /**
     * 请求成功
     * @param response
     */
    public abstract void onResponse(Response<String> response);

    /**
     * 网络异常
     */
    public abstract void onNetError();

    /**
     * 服务器异常
     * @param httpCode
     * @param msg
     */
    public abstract void onSysError(int httpCode, String msg);


}

