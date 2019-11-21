package com.example.jiyin.home.Activity.presenter.view;

import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.rootlib.mvp.view.IBaseView;

import java.util.List;

public interface WorkshopView extends IBaseView {
    void returnLabel(List<CirclelabelBean.DataBean> data);//返回 标签数据集

    void ReturnCircle(CircleListBean bean);//圈子列表
}
