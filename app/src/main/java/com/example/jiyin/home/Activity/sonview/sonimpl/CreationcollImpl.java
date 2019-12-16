package com.example.jiyin.home.Activity.sonview.sonimpl;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.common.utils.SunriseUtils;
import com.example.jiyin.home.Activity.sonview.base.ScreationBean;
import com.example.jiyin.home.Activity.sonview.base.ScreationBeans;
import com.example.jiyin.home.Activity.sonview.base.ScreationEnrollBean;
import com.example.jiyin.home.Activity.sonview.impl.CreationcollPresenter;
import com.example.jiyin.home.Activity.sonview.sonview.CreationcollView;
import com.example.jiyin.home.UserCallManager;
import com.example.rootlib.widget.common.ThrowLayout;

public class CreationcollImpl extends CreationcollPresenter<CreationcollView> {

    private BeanNetUnit screation;

    @Override
    public void cancelBiz() {
        cancelRequest();
    }

    @Override
    public void getScreationIndex(int page) {
        screation = new BeanNetUnit<ScreationBeans>()
                .setCall(UserCallManager.getScreationIndex(page))
                .request(new NetBeanListener<ScreationBeans>() {
                    @Override
                    public void onSuc(ScreationBeans bean) {
                        if (bean.getData()!=null) {
                            v.hideExpectionPages();
                            v.retScreation(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getScreationIndex(page);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getScreationIndex(page);
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
                    public void onNetErr() {
                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getScreationIndex(page);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getScreationIndex(page);
                            }
                        });
                    }
                });



    }

    /**
     * 造物集 详情
     * @param creationId
     */
    @Override
    public void getScreationData(int creationId) {
        screation = new BeanNetUnit<ScreationBean>()
                .setCall(UserCallManager.getScreation(creationId))
                .request(new NetBeanListener<ScreationBean>() {
                    @Override
                    public void onSuc(ScreationBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retScreationData(bean);

                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getScreationData(creationId);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getScreationData(creationId);
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
                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getScreationData(creationId);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getScreationData(creationId);
                            }
                        });
                    }
                });
    }

    /**
     * 造物集 申请
     * @param creationId
     * @param toString
     * @param toString1
     * @param toString2
     * @param toString3
     * @param toString4
     * @param isregistereds
     * @param toString5
     * @param toString6
     * @param toString7
     * @param s
     */
    @Override
    public void getScreationEnroll(int creationId, String toString, String toString1, String toString2, String toString3, String toString4, String isregistereds, String toString5, String toString6, String toString7, String s) {
        screation=new BeanNetUnit<ScreationEnrollBean>()
                .setCall(UserCallManager.getScreationEnrolls(creationId,toString,toString1,toString2,toString3,toString4,isregistereds,toString5,toString6,toString7,s))
                .request(new NetBeanListener<ScreationEnrollBean>() {
                    @Override
                    public void onSuc(ScreationEnrollBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retScreationEnroll(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getScreationEnroll(creationId,toString,toString1,toString2,toString3,toString4,isregistereds,toString5,toString6,toString7,s);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getScreationEnroll(creationId,toString,toString1,toString2,toString3,toString4,isregistereds,toString5,toString6,toString7,s);
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
                    public void onNetErr() {
                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getScreationEnroll(creationId,toString,toString1,toString2,toString3,toString4,isregistereds,toString5,toString6,toString7,s);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getScreationEnroll(creationId,toString,toString1,toString2,toString3,toString4,isregistereds,toString5,toString6,toString7,s);
                            }
                        });
                    }
                });
    }


}
