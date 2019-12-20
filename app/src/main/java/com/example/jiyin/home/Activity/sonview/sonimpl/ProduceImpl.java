package com.example.jiyin.home.Activity.sonview.sonimpl;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.sonview.base.ProduceDetailBean;
import com.example.jiyin.home.Activity.sonview.base.ProduceIndexBean;
import com.example.jiyin.home.Activity.sonview.impl.ProducePresenter;
import com.example.jiyin.home.Activity.sonview.sonview.ProduceView;
import com.example.jiyin.home.UserCallManager;
import com.example.rootlib.widget.common.ThrowLayout;

/**
 * 玑瑛 出品
 */

public class ProduceImpl extends ProducePresenter<ProduceView> {

    private BeanNetUnit produce;

    @Override
    public void cancelBiz() {
        cancelRequest(produce);
    }

    /**
     * 玑瑛出品
     * @param page
     * @param searchStr
     */
    @Override
    public void getProduceIndex(int page, String searchStr) {
        produce = new BeanNetUnit<ProduceIndexBean>()
                .setCall(UserCallManager.getProduceIndex(page,searchStr))
                .request(new NetBeanListener<ProduceIndexBean>() {
                    @Override
                    public void onSuc(ProduceIndexBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retProduceIndex(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getProduceIndex(page,searchStr);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getProduceIndex(page,searchStr);
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
                                getProduceIndex(page,searchStr);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getProduceIndex(page,searchStr);
                            }
                        });
                    }
                });


    }

    /**
     * 玑瑛详情
     * @param produceId
     */
    @Override
    public void getProduceDetail(int produceId) {
        produce=new BeanNetUnit<ProduceDetailBean>()
                .setCall(UserCallManager.getProduceDetail(produceId))
                .request(new NetBeanListener<ProduceDetailBean>() {
                    @Override
                    public void onSuc(ProduceDetailBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retProduceDetail(bean);
                        }
                        else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getProduceDetail(produceId);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getProduceDetail(produceId);
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
                                getProduceDetail(produceId);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getProduceDetail(produceId);
                            }
                        });
                    }
                });


    }
}
