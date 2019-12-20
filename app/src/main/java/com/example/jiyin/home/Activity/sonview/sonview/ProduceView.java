package com.example.jiyin.home.Activity.sonview.sonview;

import com.example.jiyin.home.Activity.sonview.base.ProduceDetailBean;
import com.example.jiyin.home.Activity.sonview.base.ProduceIndexBean;
import com.example.rootlib.mvp.view.IBaseView;

public interface ProduceView extends IBaseView {

    void retProduceIndex(ProduceIndexBean bean);//玑瑛出品列表

    void retProduceDetail(ProduceDetailBean bean);//玑瑛出品详情
}
