package com.example.jiyin.home.presenter.Impl;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.sonview.base.IndexindexBean;
import com.example.jiyin.home.UserCallManager;
import com.example.jiyin.home.fragment.view.HomeView;
import com.example.jiyin.home.presenter.HomePresenter;
import com.example.rootlib.utils.ACache;
import com.example.rootlib.utils.ApplicationConfig;
import com.example.rootlib.utils.JSONUtil;
import com.example.rootlib.widget.common.ThrowLayout;

public class HomePresenterImpl extends HomePresenter<HomeView> {

    private BeanNetUnit beanNetUnit;
    @Override
    public void cancelBiz() {
        cancelRequest(beanNetUnit);
    }

    @Override
    public void getIndexindex() {
        beanNetUnit=new BeanNetUnit<IndexindexBean>()
                .setCall(UserCallManager.getIndexindex())
                .request(new NetBeanListener<IndexindexBean>() {
                    @Override
                    public void onSuc(IndexindexBean bean) {
                        if (bean.getCode()==-1) {
                            //缓存首页数据
                            ACache.get(context).put(ApplicationConfig.CACHE_HOME_DATA, JSONUtil.objectToJSON(bean));
                            v.showSysErrLayout(bean.getMsg(), new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getIndexindex();
                                }
                            });
                        }else if(bean.getData()==null){
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getIndexindex();
                                }
                            });
                        }else{
                            v.hideExpectionPages();
                            v.retIndexindex(bean);
                        }

                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getIndexindex();
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
                                getIndexindex();
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getIndexindex();
                            }
                        });
                    }
                });
    }



}
