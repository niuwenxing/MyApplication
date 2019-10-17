package com.example.jiyin.home.presenter.Impl;


import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.presenter.HomePresenter;
import com.example.jiyin.home.presenter.view.HomeView;
import com.example.rootlib.widget.common.ThrowLayout;

public class HomePresenterImpl extends HomePresenter<HomeView> {

    private BeanNetUnit beanNetUnit;

    public void getUserDate(String user){




        v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
            @Override
            public void onRetry() {
//                getUserDate("kongshuju");
            }
        });


    }


    @Override
    public void cancelBiz() {
        cancelRequest(beanNetUnit);
    }

    @Override
    public void upDateApp() {

    }
}
