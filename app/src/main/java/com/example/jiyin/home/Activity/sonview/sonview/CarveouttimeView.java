package com.example.jiyin.home.Activity.sonview.sonview;

import com.example.jiyin.home.Activity.sonview.base.PositionEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.ZtimeIndexBean;
import com.example.jiyin.home.Activity.sonview.base.ZtimedetailBean;
import com.example.rootlib.mvp.view.IBaseView;

public interface CarveouttimeView extends IBaseView {
    void retZtimeIndex(ZtimeIndexBean bean);//琢璞时间 首页

    void retZtimedetail(ZtimedetailBean bean);//琢璞时间 详情

    void retZtimeenroll(PositionEnrollBean bean);//申请成功返回

    void retSysErr(String errn);//申请失败
}
