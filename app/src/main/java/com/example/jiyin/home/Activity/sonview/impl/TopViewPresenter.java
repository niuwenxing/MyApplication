package com.example.jiyin.home.Activity.sonview.impl;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

/**
 * top
 * @param <V>
 */

public abstract class TopViewPresenter<V extends IBaseView> extends BasePresenter<V> {

    public abstract void getVideoindex(int pages, int ificationId, String name);//top 视频列表

    public abstract void getVideoDetail(int page, int videoId);// 视频详情

    public abstract void Agencydetail(int page, int videoId);//研习社详情

}
