package com.example.jiyin.home.Activity.sonview.sonimpl;

import android.util.Log;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.sonview.base.OfflineTrainingBean;
import com.example.jiyin.home.Activity.sonview.base.StudyAgencyIndexBean;
import com.example.jiyin.home.Activity.sonview.base.UnderDetailBean;
import com.example.jiyin.home.Activity.sonview.impl.StudyAgencyPresenter;
import com.example.jiyin.home.Activity.sonview.sonview.StudyAgencyView;
import com.example.jiyin.home.UserCallManager;
import com.example.rootlib.widget.common.ThrowLayout;

public class StudyAgencyImpl extends StudyAgencyPresenter<StudyAgencyView> {

    private BeanNetUnit studyagency;

    @Override
    public void cancelBiz() {
        cancelRequest(studyagency);
    }


    /**
     * 研习社 首页数据
     * @param page
     */
    @Override
    public void getIndex(int page) {
        studyagency = new BeanNetUnit<StudyAgencyIndexBean>()
                .setCall(UserCallManager.getIndex(page))
                .request(new NetBeanListener<StudyAgencyIndexBean>() {
                    @Override
                    public void onSuc(StudyAgencyIndexBean bean) {
                        if (bean.getData()!=null) {
                            v.retIndexData(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getIndex( page);
                                }
                            });
                        }
                    }
                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message.toString(),new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getIndex(page);
                            }
                        });
                    }
                    @Override
                    public void onLoadStart() {

                    }

                    @Override
                    public void onLoadFinished() {

                    }

                    @Override
                    public void onNetErr() {
                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getIndex(page);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg,new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getIndex(page);
                            }
                        });
                    }
                });



    }

    /**
     * 线下培训
     * @param page
     */
    @Override
    public void getofflineTraining(int page) {
        studyagency = new BeanNetUnit<OfflineTrainingBean>()
                .setCall(UserCallManager.getOfflineTraining(page))
                .request(new NetBeanListener<OfflineTrainingBean>() {
                    @Override
                    public void onSuc(OfflineTrainingBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retOfflineTraining(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getofflineTraining(page);
                                }
                            });
                        }


                    }

                    @Override
                    public void onFail(int status, String message) {

                    }

                    @Override
                    public void onLoadStart() {

                    }

                    @Override
                    public void onLoadFinished() {

                    }

                    @Override
                    public void onNetErr() {
                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getofflineTraining(page);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg.toString(),new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getofflineTraining(page);
                            }
                        });
                    }
                });



    }

    /**
     * 研习社 详情
     */
    @Override
    public void getUnderDetail(int under_id) {
        studyagency=new BeanNetUnit()
                .setCall(UserCallManager.getUnderDetail(under_id))
                .request(new NetBeanListener<String>() {
                    @Override
                    public void onSuc(String bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
//                            v.retUnderDetailData(bean);
                            Log.d("as", "onSuc: "
                            );
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getUnderDetail(under_id);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {

                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getUnderDetail(under_id);
                            }
                        });
                    }

                    @Override
                    public void onLoadStart() {

                    }

                    @Override
                    public void onLoadFinished() {

                    }

                    @Override
                    public void onNetErr() {
                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getUnderDetail(under_id);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getUnderDetail(under_id);
                            }
                        });
                    }
                });
    }
}
