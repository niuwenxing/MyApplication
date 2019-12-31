package com.example.jiyin.home.Activity.presenter.impl;

import android.util.Log;

import com.example.jiyin.common.net.beas.BaseResponseModel;
import com.example.jiyin.common.net.manager.HttpManager;
import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.homeview.base.LoginData;
import com.example.jiyin.home.Activity.homeview.base.RegisterBase;
import com.example.jiyin.home.Activity.presenter.EntrancePresenter;
import com.example.jiyin.home.Activity.presenter.view.EntranceView;
//import com.example.jiyin.interactive.UserCallManager;
import com.example.jiyin.home.Activity.sonview.base.AuthregCodeBean;
import com.example.jiyin.home.UserCallManager;
import com.example.jiyin.interactive.UserService;
import com.example.rootlib.utils.LogUtils;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntrancePreImpl extends EntrancePresenter<EntranceView> {
    /**
     * 网络访问单元
     */
    private BeanNetUnit loginUnit=null;

    @Override
    public void cancelBiz() {//批量取消网络请求
        cancelRequest(loginUnit);
    }

    /**
     * 注册
     * @param phone
     * @param code
     * @param psd
     */
    @Override
    public void userRegister(String phone, String code, String psd) {

        loginUnit=new BeanNetUnit<AuthregCodeBean>()
                .setCall(UserCallManager.getRegister(phone,code,psd))
                .request(new NetBeanListener<AuthregCodeBean>() {
                    @Override
                    public void onSuc(AuthregCodeBean bean) {
                        v.sucRegister(bean);
                    }


                    @Override
                    public void onFail(int status, String message) {

                    }

                    @Override
                    public void onLoadStart() {v.showProgress();

                    }

                    @Override
                    public void onLoadFinished() {
v.hideProgress();
                    }

                    @Override
                    public void onNetErr() {

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {

                    }
                });



    }

    /**
     * 获取验证码
     * @param phone
     */
    @Override
    public void getCode(String phone) {

        loginUnit=new BeanNetUnit<CodeBase>()
                .setCall(UserCallManager.getCodedata(phone))
                .request(new NetBeanListener<CodeBase>() {
                    @Override
                    public void onSuc(CodeBase bean) {
                        v.Code(bean);
                    }


                    @Override
                    public void onFail(int status, String message) {
                    }

                    @Override
                    public void onLoadStart() {v.showProgress();
                    }

                    @Override
                    public void onLoadFinished() {v.hideProgress();
                    }

                    @Override
                    public void onNetErr() {
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                    }
                });
    }

    /**
     * 忘记密码
     * @param phone
     * @param code
     * @param psd
     */
    @Override
    public void userRetrieve(String phone, String code, String psd) {

        loginUnit=new BeanNetUnit<CodeBase>()
                .setCall(UserCallManager.getRetrieve(phone,code,psd))
                .request(new NetBeanListener<CodeBase>() {
                    @Override
                    public void onSuc(CodeBase bean) {
                        v.retrieve(bean);
                    }


                    @Override
                    public void onFail(int status, String message) {
                        LogUtils.d(status+"***"+message);
                    }

                    @Override
                    public void onLoadStart() {v.showProgress();

                    }

                    @Override
                    public void onLoadFinished() {v.hideProgress();
                    }

                    @Override
                    public void onNetErr() {

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {

                    }
                });

    }

    /**
     * 登陆
     * @param phone
     * @param psd
     */
    public void login(String phone, String psd) {

        loginUnit=new BeanNetUnit<LoginData>()
                .setCall(UserCallManager.getlogin(phone,psd))
                .request(new NetBeanListener<LoginData>() {
                    @Override
                    public void onLoadStart() { v.showProgress();}

                    @Override
                    public void onLoadFinished() {v.hideProgress();  }

                    @Override
                    public void onNetErr() { }

                    @Override
                    public void onSysErr(int httpCode, String msg) {  }

                    @Override
                    public void onSuc(LoginData bean) {
                        v.logindata(bean);
                    }


                    @Override
                    public void onFail(int status, String message) { }
                });
    }
}
