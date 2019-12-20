package com.example.jiyin.home.Activity.sonview.impl;


import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class HeadlinesPresenter<V extends IBaseView> extends BasePresenter<V> {

    public abstract void getNewIndex(int page);//头条列表

    public abstract void getNewDetail(int page,int newId);//头条详情
}
