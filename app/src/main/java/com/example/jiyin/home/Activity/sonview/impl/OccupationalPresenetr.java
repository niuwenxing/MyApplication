package com.example.jiyin.home.Activity.sonview.impl;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class OccupationalPresenetr<V extends IBaseView> extends BasePresenter<V> {
    //玑瑛职呼
    public abstract void getPositionIndex(int page, int gificationId, int xificationId, int zificationId);

    public abstract void getPositionIfication();//职呼筛选分类

    public abstract void getPositionDetail(int positionId);//职呼 详情
    //职位 申请
    public abstract void getPositionEnroll(int positionId, String toString, String isGender_btn, String toString1, String toString2, String toString3, String toString4, String toString5, String toString6, String toString7, String toString8, String toString9);
}
