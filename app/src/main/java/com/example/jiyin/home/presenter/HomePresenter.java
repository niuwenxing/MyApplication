package com.example.jiyin.home.presenter;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseLoadView;
import com.example.rootlib.mvp.view.IBaseView;

/**
 * 回调
 * @param <V>
 */

public abstract class HomePresenter<V extends IBaseLoadView> extends BasePresenter<V> {


    public abstract void getIndexindex(); //获取

}
