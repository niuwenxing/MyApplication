package com.example.jiyin.home.Activity.sonview.sonview;

import com.example.jiyin.home.Activity.sonview.base.ScreationBean;
import com.example.jiyin.home.Activity.sonview.base.ScreationBeans;
import com.example.jiyin.home.Activity.sonview.base.ScreationEnrollBean;
import com.example.rootlib.mvp.view.IBaseView;

public interface CreationcollView extends IBaseView {

    void retScreation(ScreationBeans bean);//获取造物集 首页数据

    void retScreationData(ScreationBean bean);//获取造物集 详情

    void retScreationEnroll(ScreationEnrollBean bean);//造物集 申请返回
}
