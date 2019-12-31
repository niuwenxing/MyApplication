package com.example.jiyin.home.Activity.sonview.sonimpl;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.sonview.base.CommunityindexBean;
import com.example.jiyin.home.Activity.sonview.impl.CommunityPresenter;
import com.example.jiyin.home.Activity.sonview.sonview.CommunityView;
import com.example.jiyin.home.UserCallManager;
import com.example.rootlib.widget.common.ThrowLayout;

public class CommunityImpl extends CommunityPresenter<CommunityView> {

    private BeanNetUnit community;

    @Override
    public void cancelBiz() {
        cancelRequest(community);
    }

    /**
     * 首页
     * @param name
     * @param page
     */
    @Override
    public void Communityindex(String name, int page) {
        community = new BeanNetUnit<CommunityindexBean>()
                .setCall(UserCallManager.getCommunityindex(name,page))
                .request(new NetBeanListener<CommunityindexBean>() {
                    @Override
                    public void onSuc(CommunityindexBean bean) {
                        if (bean != null) {
                            v.hideExpectionPages();
                            v.retCommunityindex(bean);
                        }else{
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    Communityindex(name,page);
                                }
                            });
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                Communityindex(name,page);
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
                    public void onNetErr() { v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                        @Override
                        public void onRetry() {
                            Communityindex(name,page);
                        }
                    });

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                Communityindex(name,page);
                            }
                        });
                    }
                });

    }
}
