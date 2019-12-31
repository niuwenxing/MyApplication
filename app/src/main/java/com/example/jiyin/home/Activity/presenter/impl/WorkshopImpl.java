package com.example.jiyin.home.Activity.presenter.impl;

import androidx.annotation.NonNull;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.homeview.base.UserCircleUpBean;
import com.example.jiyin.home.Activity.presenter.WorkshopPresenter;
import com.example.jiyin.home.Activity.presenter.view.WorkshopView;
import com.example.jiyin.home.Activity.sonview.base.MinecircleBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.Activity.sonview.base.UsercircleDetailBean;
import com.example.jiyin.home.UserCallManager;
import com.example.jiyin.interactive.UserService;
import com.example.rootlib.utils.CollectionUtil;
import com.example.rootlib.utils.LogUtils;
import com.example.rootlib.widget.common.ThrowLayout;

/**
 * 圈子网络层
 */

public  class WorkshopImpl extends WorkshopPresenter<WorkshopView> {


    private BeanNetUnit loginUnit;

    @Override
    public void cancelBiz() {
        cancelRequest(loginUnit);
    }

    /**
     * 圈子标签数据集
     */
    @Override
    public void getCircle() {
        loginUnit = new BeanNetUnit<CirclelabelBean>()
                .setCall(UserCallManager.getCircle())
                .request(new NetBeanListener<CirclelabelBean>() {
                    @Override
                    public void onSuc(CirclelabelBean bean) {
                        if(bean.getData()!=null){
                            v.returnLabel(bean.getData());
//                            carTypeAdapter.setData(bean.getData());
//                            data=bean;
//                            carTypeAdapter.notifyDataSetChanged();
                        }
                    }


                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getCircle();
                            }
                        });
                    }

                    @Override
                    public void onLoadStart() {
                        v.showProgress();
                    }

                    @Override
                    public void onLoadFinished() {
                        v. hideProgress();
                    }

                    @Override
                    public void onNetErr() {
                        LogUtils.e("网络错误++");

                        v. showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getCircle();
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout("msg", new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getCircle();
                            }
                        });
                    }
                });

    }


    /**
     * 获取圈子列表
     * @param pages
     * @param mType
     */
    @Override
    public void circle(int pages, int mType) {
        loginUnit = new BeanNetUnit<CircleListBean>()
                .setCall(UserCallManager.getcircleList(pages,mType))
                .request(new NetBeanListener<CircleListBean>(){
                    @Override
                    public void onSuc(CircleListBean bean) {
                        if (bean!=null) {
                            if (CollectionUtil.isEmpty(bean.getData())) {
                                v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                    @Override
                                    public void onRetry() {
                                        circle(pages,mType);
                                    }
                                });
                            }else{
                                v.hideExpectionPages();
                                v.ReturnCircle(bean);
                            }

                        }
                    }

                    @Override
                    public void onFail(int status, String message) {

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
                                circle(pages,mType);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                circle(pages,mType);
                            }
                        });
                    }
                });
    }

    /**
     * 点赞
     * @param circleid  id
     */
    @Override
    public void UsercircleUp(int circleid,boolean zan) {
        loginUnit=new BeanNetUnit<UserCircleUpBean>()
                .setCall(UserCallManager.getUsercircleUp(circleid))
                .request(new NetBeanListener<UserCircleUpBean>() {
                    @Override
                    public void onSuc(UserCircleUpBean bean) {
                        if (bean != null) {
                            v.hideExpectionPages();
                            v.retUsercircleUp(bean,zan);
                        }else{
//                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
//                                @Override
//                                public void onRetry() {
//                                    UsercircleUp(circleid,zan);
//                                }
//                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
//                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
//                            @Override
//                            public void onRetry() {
//                                UsercircleUp(circleid,zan);
//                            }
//                        });
                    }

                    @Override
                    public void onLoadStart() {v.showProgress();
                    }

                    @Override
                    public void onLoadFinished() {v.hideProgress();
                    }

                    @Override
                    public void onNetErr() {
//                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
//                            @Override
//                            public void onRetry() {
//                                UsercircleUp(circleid,zan);
//                            }
//                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
//                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
//                            @Override
//                            public void onRetry() {
//                                UsercircleUp(circleid,zan);
//                            }
//                        });
                    }
                });
    }

    /**
     * 圈子关注
     * @param follow_uid
     */
    @Override
    public void Userfollow(int follow_uid) {
        loginUnit=new BeanNetUnit<UserCircleUpBean>()
                .setCall(UserCallManager.getUserfollow(follow_uid))
                .request(new NetBeanListener<UserCircleUpBean>() {
                    @Override
                    public void onSuc(UserCircleUpBean bean) {
                        if (bean != null) {
                            v.hideExpectionPages();
                            v.retUserfollow(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    Userfollow(follow_uid);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                Userfollow(follow_uid);
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
                        v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                Userfollow(follow_uid);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                Userfollow(follow_uid);
                            }
                        });
                    }
                });
    }

    /**
     * 分享
     * @param circle_id
     */
    @Override
    public void UsercircleShare(int circle_id) {
        loginUnit=new BeanNetUnit<UserCircleUpBean>()
                .setCall(UserCallManager.getUsercircleShare(circle_id))
                .request(new NetBeanListener<UserCircleUpBean>() {
                    @Override
                    public void onSuc(UserCircleUpBean bean) {
                        if (bean != null) {
                            v.hideExpectionPages();
                            v.retUsercircleShare(bean);
                        }else{
//                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
//                                @Override
//                                public void onRetry() {
//                                    UsercircleShare(circle_id);
//                                }
//                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
//                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
//                            @Override
//                            public void onRetry() {
//                                UsercircleShare(circle_id);
//                            }
//                        });
                    }

                    @Override
                    public void onLoadStart() {v.showProgress();
                    }

                    @Override
                    public void onLoadFinished() {v.hideProgress();
                    }

                    @Override
                    public void onNetErr() {
//                        v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
//                            @Override
//                            public void onRetry() {
//                                UsercircleShare(circle_id);
//                            }
//                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
//                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
//                            @Override
//                            public void onRetry() {
//                                UsercircleShare(circle_id);
//                            }
//                        });
                    }
                });
    }

    /**
     * 圈子个人详情
     * @param circleid
     */
    @Override
    public void UsercircleDetail(int circleid) {
        loginUnit = new BeanNetUnit<UsercircleDetailBean>()
                .setCall(UserCallManager.getUsercircleDetail(circleid))
                .request(new NetBeanListener<UsercircleDetailBean>() {
                    @Override
                    public void onSuc(UsercircleDetailBean bean) {
                        if (bean != null) {
                            v.hideExpectionPages();
                            v.retUsercircleDetail(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    UsercircleDetail(circleid);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                UsercircleDetail(circleid);
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
                                UsercircleDetail(circleid);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                UsercircleDetail(circleid);
                            }
                        });
                    }
                });
    }

    /**
     * 圈子详情评论
     * @param circle_id
     * 圈子id
     * @param to_uId
     * 被回复人的id 如果是直接评论的传0 否则传入(comment_uid) 上一条评论者的id
     * @param fid
     * 评论id 如果是一级评论传0 如果是回复 传 圈子详情接口(comment_id)这个对应的参数
     * @param commentStr
     */
    @Override
    public void getUserReply(int circle_id, int to_uId, int fid, @NonNull String commentStr) {
        loginUnit = new BeanNetUnit<UserReplyBean>()
                .setCall(UserCallManager.getUserReply(circle_id,to_uId,fid,commentStr))
                .request(new NetBeanListener<UserReplyBean>() {
                    @Override
                    public void onSuc(UserReplyBean bean) {
                        if (bean != null) {
                            v.retUserReply(bean);
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
                        v.retNetErr("网络异常");
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {

                    }
                });

    }

    /**
     * 我的发布
     * @param page
     */
    @Override
    public void getMinemyUp(int page) {
        loginUnit =new BeanNetUnit<CircleListBean>()
                .setCall(UserCallManager.getMinemyUp(page))
                .request(new NetBeanListener<CircleListBean>() {
                    @Override
                    public void onSuc(CircleListBean bean) {
                        if (CollectionUtil.isEmpty(bean.getData())) {
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getMinemyUp(page);
                                }
                            });
                        }else{
                            v.hideExpectionPages();
                            v.retMinemyUprelease(bean);
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getMinemyUp(page);
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
                                getMinemyUp(page);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getMinemyUp(page);
                            }
                        });
                    }
                });
    }

    /**
     * 删除圈子
     * @param circle_id
     */
    @Override
    public void UserCircleDel(int circle_id,int pos) {
        loginUnit=new BeanNetUnit<UserReplyBean>()
                .setCall(UserCallManager.getUserCircleDel(circle_id))
                .request(new NetBeanListener<UserReplyBean>() {
                    @Override
                    public void onSuc(UserReplyBean bean) {
                        if (bean != null) {
                            v.retUserCircleDel(bean,pos);
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.retNetErr("删除失败");
                    }

                    @Override
                    public void onLoadStart() { v.showProgress(); }

                    @Override
                    public void onLoadFinished() {v.hideProgress(); }

                    @Override
                    public void onNetErr() {
                        v.retNetErr("删除失败");
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.retNetErr("删除失败");
                    }
                });
    }

    /**
     * 圈子个人 详情
     * @param circleId
     */
    @Override
    public void getMinecircle(int circleId) {
        loginUnit =new BeanNetUnit<MinecircleBean>()
                .setCall(UserCallManager.getMinecircle(circleId))
                .request(new NetBeanListener<MinecircleBean>() {
                    @Override
                    public void onSuc(MinecircleBean bean) {
                        if (CollectionUtil.isEmpty(bean.getData().getList())) {
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getMinecircle(circleId);
                                }
                            });
                        }else{

                            v.retMinecircle(bean.getData());
                            v.hideExpectionPages();
                        }

                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getMinecircle(circleId);
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
                                getMinecircle(circleId);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getMinecircle(circleId);
                            }
                        });
                    }
                });
    }
}
