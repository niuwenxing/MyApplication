package com.example.jiyin.home.Activity.sonview.sonimpl;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.sonview.base.VideoDetailBean;
import com.example.jiyin.home.Activity.sonview.base.VideoindexBean;
import com.example.jiyin.home.Activity.sonview.impl.TopViewPresenter;
import com.example.jiyin.home.Activity.sonview.sonview.TopView;
import com.example.jiyin.home.UserCallManager;
import com.example.rootlib.widget.common.ThrowLayout;

public class TopViewImpl extends TopViewPresenter<TopView> {

    private BeanNetUnit video;

    @Override
    public void cancelBiz() {
         cancelRequest(video);
    }


    //获取视频列表
    @Override
    public void getVideoindex(int pages, int ificationId, String name) {
        video = new BeanNetUnit<VideoindexBean>()
                .setCall(UserCallManager.getVideoindex(pages,ificationId,name))
                .request(new NetBeanListener<VideoindexBean>() {
                    @Override
                    public void onSuc(VideoindexBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retVideoindex(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getVideoindex(pages,ificationId,name);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getVideoindex(pages,ificationId,name);
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
                                getVideoindex(pages,ificationId,name);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getVideoindex(pages,ificationId,name);
                            }
                        });
                    }
                });



    }

    /**
     * top 视频 详情
     * @param page
     * @param videoId
     */
    @Override
    public void getVideoDetail(int page, int videoId) {
        video = new BeanNetUnit<VideoDetailBean>()
                .setCall(UserCallManager.getVideoDetail(page,videoId))
                .request(new NetBeanListener<VideoDetailBean>() {
                    @Override
                    public void onSuc(VideoDetailBean bean) {
                        if (bean!=null) {
                            v.hideExpectionPages();
                            v.retVideoDetailData(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getVideoDetail(page,videoId);
                                }
                            });
                        }

                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getVideoDetail(page,videoId);
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
                                getVideoDetail(page,videoId);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                            v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getVideoDetail(page,videoId);
                                }
                            });
                    }
                });

    }


}
