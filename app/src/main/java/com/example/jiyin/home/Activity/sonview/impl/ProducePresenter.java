package com.example.jiyin.home.Activity.sonview.impl;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class ProducePresenter<V extends IBaseView> extends BasePresenter<V> {
    //玑瑛出品
    public abstract void getProduceIndex(int page, String searchStr);
    //玑瑛详情
    public abstract void getProduceDetail(int produceId);
}
