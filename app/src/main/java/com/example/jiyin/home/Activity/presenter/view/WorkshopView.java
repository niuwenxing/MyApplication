package com.example.jiyin.home.Activity.presenter.view;

import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.homeview.base.UserCircleUpBean;
import com.example.jiyin.home.Activity.sonview.base.MinecircleBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.Activity.sonview.base.UsercircleDetailBean;
import com.example.rootlib.mvp.view.IBaseView;

import java.util.List;

public interface WorkshopView extends IBaseView {

    void returnLabel(List<CirclelabelBean.DataBean> data);//返回 标签数据集

    void ReturnCircle(CircleListBean bean);//圈子列表

    void retUsercircleUp(UserCircleUpBean bean,boolean zan);//圈子点赞

    void retUserfollow(UserCircleUpBean bean);//圈子关注

    void retUsercircleShare(UserCircleUpBean bean);//圈子分享

    void retUsercircleDetail(UsercircleDetailBean bean);//圈子个人详情

    void retNetErr(String err);//失败异常返回

    void retUserReply(UserReplyBean bean);//评论返回数据

    void retMinemyUprelease(CircleListBean bean);//我的发布

    void retUserCircleDel(UserReplyBean bean,int pos);//我的发布 圈子删除

    void retMinecircle(MinecircleBean.DataBean data);//圈子 用户个人中心
}
