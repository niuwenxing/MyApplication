package com.example.jiyin.home.Activity.sonview.impl;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class CommunityPresenter<V extends IBaseView> extends BasePresenter<V> {
    //社区列表
    public abstract void Communityindex(String name, int page);
}
