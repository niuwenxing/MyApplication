package com.example.jiyin.home.Activity.presenter.impl;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.presenter.WorkshopPresenter;
import com.example.jiyin.home.Activity.presenter.view.WorkshopView;
import com.example.jiyin.home.UserCallManager;
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
                            v.ReturnCircle(bean);
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

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {

                    }


                });



    }
}
