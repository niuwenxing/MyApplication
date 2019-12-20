package com.example.jiyin.home.Activity.presenter.impl;


import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.presenter.SearchpagePresenter;
import com.example.jiyin.home.Activity.presenter.view.SearchpageView;
import com.example.jiyin.home.Activity.sonview.base.ClassifyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.ClassifyIndexBean;
import com.example.jiyin.home.UserCallManager;
import com.example.jiyin.interactive.UserService;
import com.example.rootlib.widget.common.ThrowLayout;

/**
 * 搜索页面
 */
public class SearchpagePImpl extends SearchpagePresenter<SearchpageView> {

    private BeanNetUnit mClassify;

    @Override
    public void cancelBiz() {
        cancelRequest(mClassify);
    }


    /**
     * 项目列表
     * @param nameStr
     * @param page
     */
    @Override
    public void getClassifyDetail(String nameStr, int page) {
        mClassify = new BeanNetUnit<ClassifyIndexBean>()
                .setCall(UserCallManager.getClassifyDetail(nameStr,page))
                .request(new NetBeanListener<ClassifyIndexBean>() {
                    @Override
                    public void onSuc(ClassifyIndexBean bean) {
                        if (bean != null) {
                            v.hideExpectionPages();
                            v.retClassifyDetail(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getClassifyDetail(nameStr,page);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getClassifyDetail(nameStr,page);
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
                                getClassifyDetail(nameStr,page);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getClassifyDetail(nameStr,page);
                            }
                        });
                    }
                });
    }

    /**
     * 项目详情
     * @param newId
     */
    @Override
    public void getClassifyDetailNew(int newId) {
        mClassify =new BeanNetUnit<ClassifyDetailBean>()
                .setCall(UserCallManager.getClassifyDetailNew(newId))
                .request(new NetBeanListener<ClassifyDetailBean>() {
                    @Override
                    public void onSuc(ClassifyDetailBean bean) {
                        if (bean != null) {
                            v.hideExpectionPages();
                            v.retClassifyDetailNew(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getClassifyDetailNew(newId);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getClassifyDetailNew(newId);
                            }
                        });
                    }

                    @Override
                    public void onLoadStart() { v.showProgress();

                    }

                    @Override
                    public void onLoadFinished() { v.hideProgress();

                    }

                    @Override
                    public void onNetErr() {
                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getClassifyDetailNew(newId);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getClassifyDetailNew(newId);
                            }
                        });
                    }
                });


    }


}
