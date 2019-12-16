package com.example.jiyin.home.Activity.sonview.impl;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class CreationcollPresenter<V extends IBaseView> extends BasePresenter<V> {

    public abstract void getScreationIndex(int page); //造物季

    public abstract void getScreationData(int creationId);//造物集详情

    //造物集 申请
    public abstract void getScreationEnroll(int creationId, String toString, String toString1, String toString2, String toString3, String toString4, String isregistereds, String toString5, String toString6, String toString7, String s);
}
