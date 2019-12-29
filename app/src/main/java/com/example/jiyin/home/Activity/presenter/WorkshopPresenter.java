package com.example.jiyin.home.Activity.presenter;

import androidx.annotation.NonNull;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class WorkshopPresenter<V extends IBaseView> extends BasePresenter<V> {

    public abstract void getCircle();//获取圈子标签

    public abstract void circle(int pages, int mType);//获取圈子列表

    public abstract void UsercircleUp(int circleid,boolean zan);//点赞

    public abstract void Userfollow(int follow_uid);//关注

    public abstract void UsercircleShare(int circle_id);//分享

    public abstract void UsercircleDetail(int circleid);//圈子个人详情

    /**
     *
     * @param circle_id
     * 圈子id
     * @param to_uId
     * 被回复人的id 如果是直接评论的传0 否则传入(comment_uid) 上一条评论者的id
     * @param fid
     * 评论id 如果是一级评论传0 如果是回复 传 圈子详情接口(comment_id)这个对应的参数
     * @param commentStr
     * 评论内容
     */
    public abstract void getUserReply(int circle_id, int to_uId, int fid,@NonNull String commentStr);//圈子评论

    /**
     * 我的点赞
     * @param page
     */
    public abstract void getMinemyUp(int page);

    public abstract void UserCircleDel(int circle_id);//删除圈子
}
