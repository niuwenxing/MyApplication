package com.example.jiyin.home.presenter;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class MypagePresenter <V extends IBaseView> extends BasePresenter<V> {

    public abstract void getUserInfo();//个人数据


    public abstract void getUserAvatarEdit(String s);//设置修改头像

    public abstract void getNameSetName(String name);//修改名字

    public abstract void getCode(String toString);//获取验证码

    public abstract void getUserTelEdit(String toString, String toString1);//修改手机号

    public abstract void getUserPassEdit(String toString, String toString1, String toString2);//修改密码

    public abstract void getMineApplyDos();//申请记录

    public abstract void getMinemyUp(int page);//我的赞
}
