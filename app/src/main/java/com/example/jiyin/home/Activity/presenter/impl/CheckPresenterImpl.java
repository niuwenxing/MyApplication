package com.example.jiyin.home.Activity.presenter.impl;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.presenter.CheckPresenter;
import com.example.jiyin.home.Activity.presenter.view.CheckView;
import com.example.jiyin.home.Activity.sonview.base.FounderfounderBean;
import com.example.jiyin.home.UserCallManager;
import com.example.jiyin.interactive.UserService;
import com.example.rootlib.widget.common.ThrowLayout;

public class CheckPresenterImpl extends CheckPresenter<CheckView> {

    private BeanNetUnit founder;

    @Override
    public void cancelBiz() {
        cancelRequest(founder);
    }

    @Override
    public void getFounderfounder() {
        founder = new BeanNetUnit<FounderfounderBean>()
                .setCall(UserCallManager.getFounderfounder())
                .request(new NetBeanListener<FounderfounderBean>() {
                    @Override
                    public void onSuc(FounderfounderBean bean) {
                        if (bean != null) {
                            v.hideExpectionPages();
                            v.retFounderfounder(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getFounderfounder();
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getFounderfounder();
                            }
                        });
                    }

                    @Override
                    public void onLoadStart() {
                        v.showProgress();
                    }

                    @Override
                    public void onLoadFinished() { v.hideProgress();

                    }

                    @Override
                    public void onNetErr() {
                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getFounderfounder();
                            }
                        });
                    }
                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getFounderfounder();
                            }
                        });
                    }
                });




    }
}
