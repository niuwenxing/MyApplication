package com.example.jiyin.home.Activity.presenter.view;

import com.example.jiyin.home.Activity.sonview.base.ClassifyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.ClassifyIndexBean;
import com.example.jiyin.home.Activity.sonview.base.FounderListBean;
import com.example.rootlib.mvp.view.IBaseView;

public interface SearchpageView extends IBaseView {

    void retClassifyDetail(ClassifyIndexBean bean);//项目列表数据集

    void retClassifyDetailNew(ClassifyDetailBean bean);//项目详情

    void retFounderfounderList(FounderListBean bean);//红人更多
}
