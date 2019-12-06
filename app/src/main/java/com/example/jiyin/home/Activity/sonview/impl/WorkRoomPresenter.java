package com.example.jiyin.home.Activity.sonview.impl;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class WorkRoomPresenter<V extends IBaseView> extends BasePresenter<V> {

    public abstract void workshoplabel();//获取工作仿标签

    public abstract void globaldata(int pages, int ification_id);//获取首页数据

    public abstract void inFormation(int workshop_id);

    //工作坊申请
    public abstract void workShenQing(int workId, String etTeamnameEditStr, String etYourschoolEditStr,
                                      String etTeamsizeEditStr, String etEstablishTimeEditStr, String etProjectTypeEditStr,
                                      String isregistereds,String etTeamleaderEditStr, String etTelephoneEditStr, String etWorkMailboxEditStr, String etPersonalEditStr);

    public abstract void studioLabel(int workId);//工作坊 标签
}
