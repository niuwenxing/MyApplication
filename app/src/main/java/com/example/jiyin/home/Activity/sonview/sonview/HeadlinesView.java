package com.example.jiyin.home.Activity.sonview.sonview;


import com.example.jiyin.home.Activity.sonview.base.NewIndexBean;
import com.example.jiyin.home.Activity.sonview.base.NewdetailBean;
import com.example.jiyin.home.Activity.sonview.base.Toutiao;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.rootlib.mvp.view.IBaseView;

public interface HeadlinesView extends IBaseView {

    void retNewIndex(NewIndexBean bean);//头条列表

    void retNewDetail(NewdetailBean bean);//头条 详情

    void retNewdetails(Toutiao bean);//头条评论
}
