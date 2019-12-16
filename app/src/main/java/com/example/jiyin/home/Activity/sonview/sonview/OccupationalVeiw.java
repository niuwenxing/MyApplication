package com.example.jiyin.home.Activity.sonview.sonview;

import com.example.jiyin.home.Activity.sonview.base.PositionDetailBean;
import com.example.jiyin.home.Activity.sonview.base.PositionEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIficationBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIndexBean;
import com.example.rootlib.mvp.view.IBaseView;
//职呼
public interface OccupationalVeiw extends IBaseView {
    void retPositionIndex(PositionIndexBean bean);//首页数据

    void retPositionIfication(PositionIficationBean bean);//筛选

    void retPositionDetail(PositionDetailBean bean);//详情数据

    void retPositionEnroll(PositionEnrollBean bean);//职呼 申请
}
