package com.example.jiyin.home.Activity.sonview.sonimpl;

import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.net.manager.HttpManager;
import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.sonview.base.PositionDetailBean;
import com.example.jiyin.home.Activity.sonview.base.PositionEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIficationBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIndexBean;
import com.example.jiyin.home.Activity.sonview.impl.OccupationalPresenetr;
import com.example.jiyin.home.Activity.sonview.sonview.OccupationalVeiw;
import com.example.jiyin.home.UserCallManager;
import com.example.rootlib.widget.common.ThrowLayout;

import okhttp3.Call;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OccupationalImpl extends OccupationalPresenetr<OccupationalVeiw> {
    private BeanNetUnit occupational;

    @Override
    public void cancelBiz() {
        cancelRequest(occupational);
    }

    //职呼 首页数据
    @Override
    public void getPositionIndex(int page, int gificationId, int xificationId, int zificationId) {
         occupational= new BeanNetUnit<PositionIndexBean>()
                .setCall(UserCallManager.getPositionIndexData(page,gificationId,xificationId,zificationId))
                .request(new NetBeanListener<PositionIndexBean>() {
                    @Override
                    public void onSuc(PositionIndexBean bean) {
                        if (bean==null) {
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getPositionIndex(page,gificationId,   xificationId,   zificationId);
                                }
                            });
                        }else{
                            v.hideExpectionPages();
                        }
                        v.retPositionIndex(bean);
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getPositionIndex(  page,   gificationId,   xificationId,   zificationId);
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
                        v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getPositionIndex(  page,   gificationId,   xificationId,   zificationId);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getPositionIndex(  page,   gificationId,   xificationId,   zificationId);
                            }
                        });
                    }
                });



    }

    /**
     * 筛选
     */
    @Override
    public void getPositionIfication() {
        occupational=new BeanNetUnit<PositionIficationBean>()
                .setCall(UserCallManager.getPositionIfications())
                .request(new NetBeanListener<PositionIficationBean>() {
                    @Override
                    public void onSuc(PositionIficationBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retPositionIfication(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getPositionIfication();
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getPositionIfication();
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
                                getPositionIfication();
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getPositionIfication();
                            }
                        });
                    }
                });
    }

    /**
     * 职呼 详情
     * @param positionId
     */
    @Override
    public void getPositionDetail(int positionId) {
        occupational= new BeanNetUnit<PositionDetailBean>()
                .setCall(UserCallManager.getPositionDetailData(positionId))
                .request(new NetBeanListener<PositionDetailBean>() {
                    @Override
                    public void onSuc(PositionDetailBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retPositionDetail(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getPositionDetail( positionId);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getPositionDetail( positionId);
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
                                getPositionDetail( positionId);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getPositionDetail( positionId);
                            }
                        });
                    }
                });
    }

    @Override
    public void getPositionEnroll(int positionId, String toString, String isGender_btn,
                                  String toString1, String toString2, String toString3,
                                  String toString4, String toString5, String toString6,
                                  String toString7, String toString8, String toString9) {
        occupational= new BeanNetUnit<PositionEnrollBean>()
                .setCall(UserCallManager.getPositionEnrollData( positionId,  toString,  isGender_btn,
                 toString1,  toString2,  toString3,
                 toString4,  toString5,  toString6,
                 toString7,  toString8,  toString9))
                .request(new NetBeanListener<PositionEnrollBean>() {
                    @Override
                    public void onSuc(PositionEnrollBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retPositionEnroll(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getPositionEnroll(positionId,  toString,  isGender_btn,
                                            toString1,  toString2,  toString3,
                                            toString4,  toString5,  toString6,
                                            toString7,  toString8,  toString9);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getPositionEnroll(positionId,  toString,  isGender_btn,
                                        toString1,  toString2,  toString3,
                                        toString4,  toString5,  toString6,
                                        toString7,  toString8,  toString9);
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
                                getPositionEnroll(positionId,  toString,  isGender_btn,
                                        toString1,  toString2,  toString3,
                                        toString4,  toString5,  toString6,
                                        toString7,  toString8,  toString9);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getPositionEnroll(positionId,  toString,  isGender_btn,
                                        toString1,  toString2,  toString3,
                                        toString4,  toString5,  toString6,
                                        toString7,  toString8,  toString9);
                            }
                        });
                    }
                });
    }


    public Call CommonuploadImg(String trim) {
        MultipartBody okhttpImage = HttpManager.getInstance().getOkhttpFile(trim);
        final Request request = new Request.Builder()
                .url(BaseConfig.imgFile)
                .post(okhttpImage)
                .build();
        OkHttpClient mOkHttpClient = new OkHttpClient();
        return mOkHttpClient.newCall(request);
    }


}
