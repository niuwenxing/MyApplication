package com.example.jiyin.home.presenter;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseLoadView;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class NewsPresenter<V extends IBaseView> extends BasePresenter<V> {


    public abstract void MessagefollowDos();//粉丝列表

    public abstract void MessageupDos();//点赞列表

    public abstract void MessageCommentDos();//评论

    public abstract void MessagenewDos();//官方列表

    public abstract void MessagehConcern(int follow_uid);//回关
}
