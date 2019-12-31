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

    public abstract void Agencycomment(int online_id, String trim);//线上课堂 详情评论

    public abstract void getAgencyUp(String id);//线上课堂 点赞

    public abstract void getVideovideoUp(int video_id);//top点赞详情

    public abstract void Videocomment(int video_id,String comtext);//视频评论

    public abstract void getVideoup(String id);//评论点赞
}
