package com.example.jiyin.home.Activity.presenter.impl;


import com.example.jiyin.home.Activity.presenter.SearchpagePresenter;
import com.example.jiyin.home.Activity.presenter.view.SearchpageView;
import com.example.rootlib.widget.common.ThrowLayout;

/**
 * 搜索页面
 */
public class SearchpagePImpl extends SearchpagePresenter<SearchpageView> {

    @Override
    public void cancelBiz() {

    }
   int i=0;
    @Override
    public void getData() {
        v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
            @Override
            public void onRetry() {
                i++;
                  if(i>5){
                    v.upData("shuju yihui");
                  }else if(i<6){
                      v.hideExpectionPages();
                  }

            }
        });


    }
}
