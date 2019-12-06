package com.example.jiyin.home.Activity.sonview.sonview;

import com.example.jiyin.home.Activity.sonview.activity.WorkSurfaceActivity;
import com.example.jiyin.home.Activity.sonview.base.WorkDetailsBase;
import com.example.jiyin.home.Activity.sonview.base.WorkProjectbase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopLabelBase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopMainBase;
import com.example.rootlib.mvp.view.IBaseView;


/**
 * <p>
 *     工作坊
 * </p>
 */

public interface WorkRoomView extends IBaseView {

    void returnDatalabel(WorkshopLabelBase data);//返回数据

    void retWorkShopMainData(WorkshopMainBase bean);//返回首页数据

    void retDataWorkDetails(WorkDetailsBase bean);//工作坊详情

    void retworkShenQ(WorkSurfaceActivity.breakCode bean);//工作坊申请提交

    void onfailure(String message);//返回失败

    void retStudioLabel(WorkProjectbase bean);//工作坊 项目类型
}
