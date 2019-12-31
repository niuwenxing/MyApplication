package com.example.jiyin.home.presenter.view;

import com.example.jiyin.home.Activity.homeview.base.ReleaseBean;
import com.example.jiyin.home.Activity.sonview.base.MessagecommentDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessagefollowDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessagenewDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessageupDosBean;
import com.example.rootlib.mvp.view.IBaseLoadView;

public interface NewsView extends IBaseLoadView {

    void retMessagefollowDos(MessagefollowDosBean bean);//粉丝列表

    void retMessageupDos(MessageupDosBean bean);//点赞列表

    void retMessageCommentDos(MessagecommentDosBean bean);//评论列表

    void retMessagenewDos(MessagenewDosBean bean);//官方列表

    void retMessagehConcern(ReleaseBean bean);//粉丝回关
}
