package com.example.jiyin.home.Activity.Impl;


import com.example.jiyin.home.Activity.SearchpagePresenter;
import com.example.jiyin.home.Activity.view.SearchpageView;
import com.example.rootlib.widget.common.ThrowLayout;

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
                  }
            }
        });


    }
}
