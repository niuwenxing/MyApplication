package com.example.jiyin.home.presenter.Impl;

import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.net.manager.HttpManager;
import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.sonview.base.MineAplyDosBean;
import com.example.jiyin.home.Activity.sonview.base.UserInfoBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.UserCallManager;
import com.example.jiyin.home.presenter.MypagePresenter;
import com.example.jiyin.home.presenter.view.MypageView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.utils.CollectionUtil;
import com.example.rootlib.widget.common.ThrowLayout;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

import okhttp3.Call;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MypageImpl extends MypagePresenter<MypageView> {

    private BeanNetUnit userInfo;

    @Override
    public void cancelBiz() {
        cancelRequest(userInfo);
    }

    /**
     * 个人中心
     */
    @Override
    public void getUserInfo() {
        userInfo = new BeanNetUnit<UserInfoBean>()
                .setCall(UserCallManager.getUserInfo())
                .request(new NetBeanListener<UserInfoBean>() {
                    @Override
                    public void onSuc(UserInfoBean bean) {
                        if (bean != null) {
                            v.retUserInfo(bean);
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {

                    }

                    @Override
                    public void onLoadStart() {
                        v.showProgress();
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
     * 修改头像
     *
     * @param s
     */
    @Override
    public void getUserAvatarEdit(String s) {
        userInfo = new BeanNetUnit<UserReplyBean>()
                .setCall(UserCallManager.getUserAvatarEdit(s))
                .request(new NetBeanListener<UserReplyBean>() {
                    @Override
                    public void onSuc(UserReplyBean bean) {
                        if (bean != null) {
                            v.retUserAvatarEdit(bean);

                        } else {
                            v.err(bean.getMsg());
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {

                    }

                    @Override
                    public void onLoadStart() {
                        v.showProgress();
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
     * 修改名字
     */
    @Override
    public void getNameSetName(String name) {
        userInfo = new BeanNetUnit<UserReplyBean>()
                .setCall(UserCallManager.getUserReplyBean(name))
                .request(new NetBeanListener<UserReplyBean>() {
                    @Override
                    public void onSuc(UserReplyBean bean) {
                        if (bean != null) {
                            v.retNameSetName(bean);
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.err("修改失败");
                    }

                    @Override
                    public void onLoadStart() {
                        v.showProgress();

                    }

                    @Override
                    public void onLoadFinished() {
                        v.hideProgress();

                    }

                    @Override
                    public void onNetErr() {
                        v.err("修改失败");
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.err("修改失败");
                    }
                });
    }

    /**
     * 设置手机号 获取验证码
     *
     * @param phone
     */
    @Override
    public void getCode(String phone) {
        userInfo = new BeanNetUnit<CodeBase>()
                .setCall(UserCallManager.getCodedata(phone))
                .request(new NetBeanListener<CodeBase>() {
                    @Override
                    public void onSuc(CodeBase bean) {
                        v.Code(bean);
                    }


                    @Override
                    public void onFail(int status, String message) {
                        v.err("获取失败");
                    }

                    @Override
                    public void onLoadStart() {
                        v.showProgress();
                    }

                    @Override
                    public void onLoadFinished() {
                        v.hideProgress();
                    }

                    @Override
                    public void onNetErr() {
                        v.err("获取失败");
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.err("获取失败");
                    }
                });
    }

    /**
     * 修改手机号
     *
     * @param phone
     * @param code
     */
    @Override
    public void getUserTelEdit(String phone, String code) {
        userInfo = new BeanNetUnit<UserReplyBean>()
                .setCall(UserCallManager.getUserTelEdit(phone, code))
                .request(new NetBeanListener<UserReplyBean>() {
                    @Override
                    public void onSuc(UserReplyBean bean) {
                        if (bean != null) {
                            v.retUserTelEdit(bean);
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.err("修改失败");
                    }

                    @Override
                    public void onLoadStart() {
                        v.showProgress();
                    }

                    @Override
                    public void onLoadFinished() {
                        v.hideProgress();
                    }

                    @Override
                    public void onNetErr() {
                        v.err("修改失败");
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.err("修改失败");
                    }
                });
    }

    /**
     * 设置新的密码
     *
     * @param oldPass
     * @param pass
     * @param password
     */
    @Override
    public void getUserPassEdit(String oldPass, String pass, String password) {
        userInfo = new BeanNetUnit<UserReplyBean>()
                .setCall(UserCallManager.getUserPassEdit(oldPass, pass, password))
                .request(new NetBeanListener<UserReplyBean>() {
                    @Override
                    public void onSuc(UserReplyBean bean) {
                        if (bean != null) {
                            v.retUserPassEdit(bean);
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.err("修改失败");
                    }

                    @Override
                    public void onLoadStart() {
                        v.showProgress();
                    }

                    @Override
                    public void onLoadFinished() {
                        v.hideProgress();

                    }

                    @Override
                    public void onNetErr() {
                        v.err("修改失败");
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.err("修改失败");
                    }
                });

    }

    /**
     * 申请记录
     */
    @Override
    public void getMineApplyDos() {
        userInfo = new BeanNetUnit<MineAplyDosBean>()
                .setCall(UserCallManager.getMineApplyDos())
                .request(new NetBeanListener<MineAplyDosBean>() {
                    @Override
                    public void onSuc(MineAplyDosBean bean) {
                        if (bean != null) {
                            v.hideExpectionPages();
                            v.retMineApplyDos(bean);
                        } else {
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getMineApplyDos();
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getMineApplyDos();
                            }
                        });
                    }

                    @Override
                    public void onLoadStart() {
                        v.showProgress();
                    }

                    @Override
                    public void onLoadFinished() {
                        v.hideProgress();

                    }

                    @Override
                    public void onNetErr() {
                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getMineApplyDos();
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getMineApplyDos();
                            }
                        });
                    }
                });

    }

    /**
     * 我的赞
     * @param page
     */
    @Override
    public void getMinemyUp(int page) {
        userInfo=new BeanNetUnit<CircleListBean>()
                .setCall(UserCallManager.gettMinemyUp(page))
                .request(new NetBeanListener<CircleListBean>() {
                    @Override
                    public void onSuc(CircleListBean bean) {
                        if (bean != null) {
                            if (CollectionUtil.isEmpty(bean.getData())) {
                                v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                    @Override
                                    public void onRetry() {
                                        getMinemyUp(page);
                                    }
                                });
                            }else{
                                v.hideExpectionPages();
                                v.retMinemyUp(bean);
                            }
                        }else{
                            v.showSysErrLayout("数据异常", new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getMinemyUp(page);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getMinemyUp(page);
                            }
                        });
                    }

                    @Override
                    public void onLoadStart() { v.showProgress();
                    }

                    @Override
                    public void onLoadFinished() {v.hideProgress();
                    }

                    @Override
                    public void onNetErr() {
                        v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getMinemyUp(page);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getMinemyUp(page);
                            }
                        });
                    }
                });
    }


    //上传图片
    public Call Upimages(List<LocalMedia> list) {
        MultipartBody okhttpImage = HttpManager.getInstance().getOkhttpImage(list);
        final Request request = new Request.Builder()
                .url(BaseConfig.imgArr)
                .post(okhttpImage)
                .build();
        OkHttpClient mOkHttpClient = new OkHttpClient();
        return mOkHttpClient.newCall(request);
    }

}
