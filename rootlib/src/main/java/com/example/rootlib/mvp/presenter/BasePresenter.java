package com.example.rootlib.mvp.presenter;

import android.content.Context;

import com.example.rootlib.mvp.presenter.biz.IBaseBiz;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class BasePresenter<V extends IBaseView> implements IPresenter<V>  {

    public Context context;
    public V v;

    /**
     * 批量取消业务中的网络请求
     * @param bizs 业务bean集合
     */
    public void cancelRequest(IBaseBiz... bizs){
        if (bizs != null && bizs.length > 0) {
            for (IBaseBiz biz:bizs) {
                if (biz != null) {
                    biz.cancelRequest();
                }
            }
        }
    }


    @Override
    public void attachView(V v, Context context) {
        this.v = v;
        this.context = context;
    }

    @Override
    public void detachView() {
        cancelBiz();
    }

    /**
     * 取消代理层发起的业务，不提供实现，必须被实现
     */
    public abstract void cancelBiz();
}
