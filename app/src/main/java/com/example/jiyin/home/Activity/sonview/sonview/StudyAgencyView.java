package com.example.jiyin.home.Activity.sonview.sonview;

import com.example.jiyin.home.Activity.sonview.base.OfflineTrainingBean;
import com.example.jiyin.home.Activity.sonview.base.StudyAgencyIndexBean;
import com.example.jiyin.home.Activity.sonview.base.UnderDetailBean;
import com.example.rootlib.mvp.view.IBaseView;

public interface StudyAgencyView extends IBaseView {

    void retIndexData(StudyAgencyIndexBean bean); //研习社 首页数据

    void retOfflineTraining(OfflineTrainingBean bean);//线下培训

    void retUnderDetailData(UnderDetailBean bean);//线下培训详情
}
