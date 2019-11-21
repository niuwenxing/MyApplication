package com.example.jiyin.common.net.netlisenter;

import com.example.rootlib.mvp.presenter.IBaseListener;

/**
 * Created by guolei on 2017/5/10.
 */

public interface NetBeanListener<T> extends IBaseListener {
    /**
     * 成功回调
     * @param bean
     */
    void onSuc(T bean);
    /**
     * 失败回调
     * @param status
//     * @param canceled
     * @param message
     */
//    void onFail(String status, boolean canceled, String message);

    void onFail(int status, String message);
}
