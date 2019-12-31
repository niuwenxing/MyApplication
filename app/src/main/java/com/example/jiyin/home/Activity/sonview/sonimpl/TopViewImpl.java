package com.example.jiyin.home.Activity.sonview.sonimpl;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.sonview.base.AgencyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.Toutiao;
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

    /**
     * 研习社 视频详情
     * @param page
     * @param videoId
     */
    @Override
    public void Agencydetail(int page, int videoId) {
        video=new BeanNetUnit<AgencyDetailBean>()
                .setCall(UserCallManager.getAgencydetail(page,videoId))
                .request(new NetBeanListener<AgencyDetailBean>() {
                    @Override
                    public void onSuc(AgencyDetailBean bean) {
                        if (bean.getData() != null) {
                            v.hideExpectionPages();
                            v.retAgencydetail(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    Agencydetail(page,videoId);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                Agencydetail(page,videoId);
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
                    public void onNetErr() {v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                        @Override
                        public void onRetry() {
                            Agencydetail(page,videoId);
                        }
                    });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                Agencydetail(page,videoId);
                            }
                        });
                    }
                });

    }

    /**
     * 线下课堂 详情评论
     * @param online_id
     * @param trim
     */
    @Override
    public void Agencycomment(int online_id, String trim) {
        video = new BeanNetUnit<Toutiao>()
                .setCall(UserCallManager.getAgencycomment(online_id,trim))
                .request(new NetBeanListener<Toutiao>() {
                    @Override
                    public void onSuc(Toutiao bean) {
                    v.retAgencycomment(bean);
                    }

                    @Override
                    public void onFail(int status, String message) {

                    }

                    @Override
                    public void onLoadStart() {v.showProgress();

                    }

                    @Override
                    public void onLoadFinished() {v.hideProgress();

                    }

                    @Override
                    public void onNetErr() {

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {

                    }
                });
    }

    /**
     * 线上课堂 点赞
     * @param id
     */
    @Override
    public void getAgencyUp(String id) {
        video = new BeanNetUnit<Toutiao>()
                .setCall(UserCallManager.getAgencyUp(id))
                .request(new NetBeanListener<Toutiao>() {
                    @Override
                    public void onSuc(Toutiao bean) {
                        if (bean != null) {
                            v.retAgencyUp(bean);
                        }else{

                        }
                    }

                    @Override
                    public void onFail(int status, String message) {

                    }

                    @Override
                    public void onLoadStart() { v.showProgress();

                    }

                    @Override
                    public void onLoadFinished() {v.hideProgress();

                    }

                    @Override
                    public void onNetErr() {

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {

                    }
                });
    }

    /**
     * top 点赞详情
     * @param video_id
     */
    @Override
    public void getVideovideoUp(int video_id) {
        video = new BeanNetUnit<Toutiao>()
                .setCall(UserCallManager.getVideovideoUp(video_id))
                .request(new NetBeanListener<Toutiao>() {
            @Override
            public void onSuc(Toutiao bean) {
                v.retVideovideoUp(bean);
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

            }

            @Override
            public void onSysErr(int httpCode, String msg) {

            }
        });
    }

    /**
     * 视频评论
     * @param video_id
     */
    @Override
    public void Videocomment(int video_id,String comtext) {
            video = new BeanNetUnit<Toutiao>()
                    .setCall(UserCallManager.getVideocomment(video_id, comtext))
                    .request(new NetBeanListener<Toutiao>() {
                        @Override
                        public void onSuc(Toutiao bean) {
                            v.retVideocomment(bean);
                        }

                        @Override
                        public void onFail(int status, String message) {

                        }

                        @Override
                        public void onLoadStart() {v.showProgress();

                        }

                        @Override
                        public void onLoadFinished() {v.hideProgress();

                        }

                        @Override
                        public void onNetErr() {

                        }

                        @Override
                        public void onSysErr(int httpCode, String msg) {

                        }
                    });
    }

    /**
     * 评论点赞
     * @param id
     */
    @Override
    public void getVideoup(String id) {
        video = new BeanNetUnit<Toutiao>()
                .setCall(UserCallManager.getVideoup(id))
                .request(new NetBeanListener<Toutiao>() {
                    @Override
                    public void onSuc(Toutiao bean) {
                        v.retVideoup(bean);
                    }

                    @Override
                    public void onFail(int status, String message) {

                    }

                    @Override
                    public void onLoadStart() { v.showProgress();

                    }

                    @Override
                    public void onLoadFinished() {v.hideProgress();

                    }

                    @Override
                    public void onNetErr() {

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {

                    }
                });
    }

}
