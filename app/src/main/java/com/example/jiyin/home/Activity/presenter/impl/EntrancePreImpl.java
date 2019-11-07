package com.example.jiyin.home.Activity.presenter.impl;

import android.util.Log;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.homeview.base.LoginData;
import com.example.jiyin.home.Activity.homeview.base.RegisterBase;
import com.example.jiyin.home.Activity.presenter.EntrancePresenter;
import com.example.jiyin.home.Activity.presenter.view.EntranceView;
import com.example.jiyin.interactive.UserCallManager;
import com.example.rootlib.utils.LogUtils;

public class EntrancePreImpl extends EntrancePresenter<EntranceView> {
    /**
     * 网络访问单元
     */
    private BeanNetUnit loginUnit;

    @Override
    public void cancelBiz() {//批量取消网络请求
        cancelRequest(loginUnit);
    }

    @Override
    public void login() {

    }

    /**
     * 注册
     * @param phone
     * @param code
     * @param psd
     */
    @Override
    public void userRegister(String phone, String code, String psd) {
        loginUnit=new BeanNetUnit<RegisterBase>()
                .setCall(UserCallManager.getRegister(phone,code,psd))
                .request(new NetBeanListener<RegisterBase>() {
                    @Override
                    public void onSuc(RegisterBase bean) {
                        if(bean!=null){
                            v.sucRegister(bean);
                        }

                    }
                    @Override
                    public void onFail(String status, String message) {
                        v.err(status,message);
                    }

                    @Override
                    public void onLoadStart() {

                    }

                    @Override
                    public void onLoadFinished() {

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
        loginUnit = new BeanNetUnit<CodeBase>()
                .setCall(UserCallManager.getCode(phone))
                .request(new NetBeanListener<CodeBase>() {
                    @Override
                    public void onSuc(CodeBase bean) {
                        v.Code(bean);

                    }

                    @Override
                    public void onFail(String status, String message) {
                        Log.d("123456", "onFail: "+message.toString()+"+++"+status);

                    }

                    @Override
                    public void onLoadStart() {

                    }

                    @Override
                    public void onLoadFinished() {

                    }

                    @Override
                    public void onNetErr() {

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        Log.d("123456", "onFail: "+msg.toString()+"+++"+httpCode);
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
        loginUnit = new BeanNetUnit<CodeBase>()
                .setCall(UserCallManager.getUserRetrieve(phone,code,psd))
                .request(new NetBeanListener<CodeBase>() {
                    @Override
                    public void onSuc(CodeBase bean) {
                        if(bean!=null){
                            v.retrieve(bean);
                        }
                    }

                    @Override
                    public void onFail(String status, String message) {

                    }

                    @Override
                    public void onLoadStart() {

                    }

                    @Override
                    public void onLoadFinished() {

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
                    public void onSuc(LoginData bean) {
                        if(bean!=null){
                            v.logindata(bean);
                        }
                    }

                    @Override
                    public void onFail(String status, String message) {
                        v.err(status,message);
                    }
                    @Override
                    public void onLoadStart() {

                    }

                    @Override
                    public void onLoadFinished() {

                    }

                    @Override
                    public void onNetErr() {

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        LogUtils.d(httpCode+"--"+msg);
                    }


                });
    }
}
