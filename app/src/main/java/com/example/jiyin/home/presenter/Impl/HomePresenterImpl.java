package com.example.jiyin.home.presenter.Impl;

import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.fragment.view.HomeView;
import com.example.jiyin.home.presenter.HomePresenter;

//package com.example.jiyin.home.presenter.Impl;
//
//
//import com.example.jiyin.common.net.netunti.BeanNetUnit;
//import com.example.jiyin.home.presenter.HomePresenter;
//import com.example.jiyin.home.presenter.view.HomeView;
//
public class HomePresenterImpl extends HomePresenter<HomeView> {

    private BeanNetUnit beanNetUnit;
    @Override
    public void cancelBiz() {
        cancelRequest(beanNetUnit);
    }


//
//    //        v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
////            @Override
////            public void onRetry() {
////                getUserDate("kongshuju");
////            }
////        });
//
//
//
//
//    @Override
//    public void cancelBiz() {
//
//    }
}
