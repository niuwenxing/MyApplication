package com.example.jiyin.home.Activity.sonview.sonimpl;

import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.net.manager.HttpManager;
import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.sonview.base.PositionEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.ZtimeIndexBean;
import com.example.jiyin.home.Activity.sonview.base.ZtimedetailBean;
import com.example.jiyin.home.Activity.sonview.impl.CarveouttimePresenter;
import com.example.jiyin.home.Activity.sonview.sonview.CarveouttimeView;
import com.example.jiyin.home.UserCallManager;
import com.example.rootlib.widget.common.ThrowLayout;
import okhttp3.Call;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class CarveouttimeImpl extends CarveouttimePresenter<CarveouttimeView> {

    private BeanNetUnit ztimeNetUnit;

    @Override
    public void cancelBiz() {
        cancelRequest(ztimeNetUnit);
    }

    /**
     * 首页数据
     * @param page
     */
    @Override
    public void getZtimeIndex(int page) {
        ztimeNetUnit = new BeanNetUnit<ZtimeIndexBean>()
                .setCall(UserCallManager.getZtimeIndex(page))
                .request(new NetBeanListener<ZtimeIndexBean>() {
                    @Override
                    public void onSuc(ZtimeIndexBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retZtimeIndex(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getZtimeIndex(page);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getZtimeIndex(page);
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
                                getZtimeIndex(page);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getZtimeIndex(page);
                            }
                        });
                    }
                });

    }

    /**
     * 详情
     * @param mZid
     */
    @Override
    public void getZtimedetail(int mZid) {
        ztimeNetUnit=new BeanNetUnit<ZtimedetailBean>()
                .setCall(UserCallManager.getZtimedetail(mZid))
                .request(new NetBeanListener<ZtimedetailBean>() {
                    @Override
                    public void onSuc(ZtimedetailBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retZtimedetail(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getZtimedetail(mZid);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getZtimedetail(mZid);
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
                                getZtimedetail(mZid);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getZtimedetail(mZid);
                            }
                        });
                    }
                });
    }

    @Override
    public void Ztimeenroll(int mZid, String toString, String toString1, String toString2, String toString3, String toString4, String toString5, String toString6, String trim, String trim1, String toString7, String toString8, String toString9, String toString10) {
        ztimeNetUnit=new BeanNetUnit<PositionEnrollBean>()
                .setCall(UserCallManager.getZtimeenroll( mZid,  toString,
                 toString1,  toString2,  toString3,
                 toString4,  toString5,  toString6,
                 trim,  trim1,  toString7,
                 toString8,  toString9,  toString10))
                .request(new NetBeanListener<PositionEnrollBean>() {
                    @Override
                    public void onSuc(PositionEnrollBean bean) {
                        if (bean!=null) {
                            v.retZtimeenroll(bean);
                        }else{
                            v.retSysErr("报名申请 异常");
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.retSysErr(message.toString());
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
                        v.retSysErr("网络 异常");
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.retSysErr("报名申请 异常");
                    }
                });
    }


    //文件上传
    public Call CommonuploadPPT(String path){
        MultipartBody okhttpImage = HttpManager.getInstance().getOkhttpFile(path);
        final Request request = new Request.Builder()
                .url(BaseConfig.imgFile)
                .post(okhttpImage)
                .build();
        OkHttpClient mOkHttpClient = new OkHttpClient();
        return mOkHttpClient.newCall(request);
    }
}
