package com.example.jiyin.home.Activity.presenter;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class EntrancePresenter<V extends IBaseView> extends BasePresenter<V> {

    public abstract void login();
}
