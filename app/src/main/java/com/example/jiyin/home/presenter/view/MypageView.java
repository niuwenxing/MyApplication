package com.example.jiyin.home.presenter.view;

import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.sonview.base.MineAplyDosBean;
import com.example.jiyin.home.Activity.sonview.base.UserInfoBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.rootlib.mvp.view.IBaseView;

public interface MypageView extends IBaseView {

    //个人中心
    void retUserInfo(UserInfoBean bean);
    //失败
    void err(String str);

    void retUserAvatarEdit(UserReplyBean bean);//修改成功返回

    void retNameSetName(UserReplyBean bean);//修改昵称

    void Code(CodeBase bean);//验证码返回

    void retUserTelEdit(UserReplyBean bean);//设置手机号

    void retUserPassEdit(UserReplyBean bean);//修改密码

    void retMineApplyDos(MineAplyDosBean bean);//申请记录

    void retMinemyUp(CircleListBean bean);//我的
}
