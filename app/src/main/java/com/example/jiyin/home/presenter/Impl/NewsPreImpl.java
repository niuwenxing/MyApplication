package com.example.jiyin.home.presenter.Impl;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.homeview.base.ReleaseBean;
import com.example.jiyin.home.Activity.sonview.base.MessagecommentDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessagefollowDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessagenewDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessageupDosBean;
import com.example.jiyin.home.UserCallManager;
import com.example.jiyin.home.presenter.NewsPresenter;
import com.example.jiyin.home.presenter.view.NewsView;
import com.example.rootlib.utils.CollectionUtil;
import com.example.rootlib.widget.common.ThrowLayout;

public class NewsPreImpl extends NewsPresenter<NewsView> {

    private BeanNetUnit news;

    @Override
    public void cancelBiz() {
        cancelRequest(news);
    }

    /**
     * 粉丝列表
     */
    @Override
    public void MessagefollowDos() {
        news = new BeanNetUnit<MessagefollowDosBean>()
                .setCall(UserCallManager.getMessagefollowDos())
                .request(new NetBeanListener<MessagefollowDosBean>() {
                    @Override
                    public void onSuc(MessagefollowDosBean bean) {
                        if (CollectionUtil.isEmpty(bean.getData())) {
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    MessagefollowDos();
                                }
                            });
                        }else{
                            v.hideExpectionPages();
                            v.retMessagefollowDos(bean);
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                MessagefollowDos();
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
                                MessagefollowDos();
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                MessagefollowDos();
                            }
                        });
                    }
                });


    }

    /**
     * 点赞列表
     */
    @Override
    public void MessageupDos() {
        news=new BeanNetUnit<MessageupDosBean>()
                .setCall(UserCallManager.getMessageupDos())
                .request(new NetBeanListener<MessageupDosBean>() {
                    @Override
                    public void onSuc(MessageupDosBean bean) {
                        if (CollectionUtil.isEmpty( bean.getData())) {
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    MessageupDos();
                                }
                            });
                        }else{
                            v.hideExpectionPages();
                            v.retMessageupDos(bean);
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                MessageupDos();
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
                    public void onNetErr() {v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                        @Override
                        public void onRetry() {
                            MessageupDos();
                        }
                    });

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                MessageupDos();
                            }
                        });
                    }
                });
    }

    /**
     * 评论页面
     */
    @Override
    public void MessageCommentDos() {
        news=new BeanNetUnit<MessagecommentDosBean>()
                .setCall(UserCallManager.getMessageCommentDos())
                .request(new NetBeanListener<MessagecommentDosBean>() {
                    @Override
                    public void onSuc(MessagecommentDosBean bean) {
                        if (CollectionUtil.isEmpty(bean.getData())) {
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    MessageCommentDos();
                                }
                            });
                        }else{
                            v.hideExpectionPages();
                            v.retMessageCommentDos(bean);
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                MessageCommentDos();
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
                                MessageCommentDos();
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                MessageCommentDos();
                            }
                        });
                    }
                });
    }

    /**
     * 官方列表
     */
    @Override
    public void MessagenewDos() {
        news=new BeanNetUnit<MessagenewDosBean>()
                .setCall(UserCallManager.getMessagenewDos())
                .request(new NetBeanListener<MessagenewDosBean>() {
                    @Override
                    public void onSuc(MessagenewDosBean bean) {
                        if (CollectionUtil.isEmpty(bean.getData())) {
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    MessageCommentDos();
                                }
                            });
                        }else{
                            v.hideExpectionPages();
                            v.retMessagenewDos(bean);
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                MessageCommentDos();
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
                            MessageCommentDos();
                        }
                    });

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                MessageCommentDos();
                            }
                        });
                    }
                });
    }

    /**
     * 粉丝回关
     * @param follow_uid
     */
    @Override
    public void MessagehConcern(int follow_uid) {
        news=new BeanNetUnit<ReleaseBean>()
                .setCall(UserCallManager.getMessagehConcern(follow_uid))
                .request(new NetBeanListener<ReleaseBean>() {
                    @Override
                    public void onSuc(ReleaseBean bean) {
                        if (bean != null) {
                            v.hideExpectionPages();
                            v.retMessagehConcern(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    MessagehConcern(follow_uid);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                 MessagehConcern(follow_uid);
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
                                MessagehConcern(follow_uid);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                MessagehConcern(follow_uid);
                            }
                        });
                    }
                });
    }
}
