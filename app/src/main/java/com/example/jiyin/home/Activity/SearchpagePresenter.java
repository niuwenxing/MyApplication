package com.example.jiyin.home.Activity;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class SearchpagePresenter<V extends IBaseView> extends BasePresenter<V> {
    public abstract void getData();
}
