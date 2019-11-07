package com.example.jiyin.home.Activity.presenter.view;

import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.homeview.base.LoginData;
import com.example.jiyin.home.Activity.homeview.base.RegisterBase;
import com.example.rootlib.mvp.view.IBaseView;

public interface EntranceView extends IBaseView {

    //验证码
    void Code(CodeBase bean);

    //注册
    void sucRegister(RegisterBase bean);

    //失败返回
    void err(String status, String message);

    //忘记密码
    void retrieve(CodeBase bean);

    //登陆成功
    void logindata(LoginData bean);
}
