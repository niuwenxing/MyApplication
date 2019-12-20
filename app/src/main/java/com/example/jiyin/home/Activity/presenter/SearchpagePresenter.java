package com.example.jiyin.home.Activity.presenter;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class SearchpagePresenter<V extends IBaseView> extends BasePresenter<V> {

    public abstract void getClassifyDetail(String nameStr, int page);//项目 列表


    public abstract void getClassifyDetailNew(int newId);//项目详情
}
