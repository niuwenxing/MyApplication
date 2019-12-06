package com.example.jiyin.home.Activity.sonview.impl;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class StudyAgencyPresenter<V extends IBaseView> extends BasePresenter<V> {

    public abstract void getIndex(int page);//研习社首页

    public abstract void getofflineTraining(int page);//线下培训

    public abstract void getUnderDetail(int under_id);//研习社 详情
}
