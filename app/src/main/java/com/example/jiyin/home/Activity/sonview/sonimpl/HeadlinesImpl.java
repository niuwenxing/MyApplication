package com.example.jiyin.home.Activity.sonview.sonimpl;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.sonview.base.NewIndexBean;
import com.example.jiyin.home.Activity.sonview.base.NewdetailBean;
import com.example.jiyin.home.Activity.sonview.base.Toutiao;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.Activity.sonview.impl.HeadlinesPresenter;
import com.example.jiyin.home.Activity.sonview.sonview.HeadlinesView;
import com.example.jiyin.home.UserCallManager;
import com.example.jiyin.interactive.UserService;
import com.example.rootlib.widget.common.ThrowLayout;

public class HeadlinesImpl extends HeadlinesPresenter<HeadlinesView> {

    private BeanNetUnit headNew;

    @Override
    public void cancelBiz() {
        cancelRequest(headNew);
    }

    /**
     * 头条列表
     * @param page
     */
    @Override
    public void getNewIndex(int page) {
        headNew = new BeanNetUnit<NewIndexBean>()
                .setCall(UserCallManager.getNewIndex(page))
                .request(new NetBeanListener<NewIndexBean>() {
                    @Override
                    public void onSuc(NewIndexBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retNewIndex(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getNewIndex(page);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getNewIndex(page);
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
                                getNewIndex(page);
                            }
                        });

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getNewIndex(page);
                            }
                        });
                    }
                });


    }

    /**
     * 头条详情
     * @param newId
     */
    @Override
    public void getNewDetail(int page,int newId) {
        headNew=new BeanNetUnit<NewdetailBean>()
                .setCall(UserCallManager.getNewDetail(page,newId))
                .request(new NetBeanListener<NewdetailBean>() {
                    @Override
                    public void onSuc(NewdetailBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retNewDetail(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getNewDetail(page,newId);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getNewDetail(page,newId);
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
                                getNewDetail(page,newId);
                            }
                        });
                    }


                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getNewDetail(page,newId);
                            }
                        });
                    }
                });

    }

    /**
     * 头条 评论
     * @param newId
     * @param toString
     */
    @Override
    public void getNewdetail(int newId, String toString) {
        headNew=new BeanNetUnit<Toutiao>()
                .setCall(UserCallManager.getNewdetail(newId,toString))
                .request(new NetBeanListener<Toutiao>() {
                    @Override
                    public void onSuc(Toutiao bean) {
                        if (bean != null) {
                            v.hideExpectionPages();
                            v.retNewdetails(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getNewdetail(newId,toString);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getNewdetail(newId,toString);
                            }
                        });
                    }

                    @Override
                    public void onLoadStart() {v.showProgress();

                    }

                    @Override
                    public void onLoadFinished() {v.hideProgress();

                    }

                    @Override
                    public void onNetErr() {v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                        @Override
                        public void onRetry() {
                            getNewdetail(newId,toString);
                        }
                    });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getNewdetail(newId,toString);
                            }
                        });
                    }
                });
    }
}
