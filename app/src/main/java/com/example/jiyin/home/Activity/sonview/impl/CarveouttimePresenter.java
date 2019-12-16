package com.example.jiyin.home.Activity.sonview.impl;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class CarveouttimePresenter<V extends IBaseView> extends BasePresenter<V> {
    public abstract void getZtimeIndex(int page); //琢璞 时间

    public abstract void getZtimedetail(int mZid);//琢璞时间详情

    //琢璞时间 申请
    public abstract void Ztimeenroll(int mZid, String toString, String toString1, String toString2, String toString3, String toString4, String toString5, String toString6, String trim, String trim1, String toString7, String toString8, String toString9, String toString10);


















}
