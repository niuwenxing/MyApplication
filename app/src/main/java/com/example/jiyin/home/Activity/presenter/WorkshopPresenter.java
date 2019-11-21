package com.example.jiyin.home.Activity.presenter;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class WorkshopPresenter<V extends IBaseView> extends BasePresenter<V> {


    public abstract void getCircle();//获取圈子标签

    public abstract void circle(int pages, int mType);//获取圈子列表
}
