package com.example.jiyin.home.Activity.sonview.sonview;

import com.example.jiyin.home.Activity.sonview.base.VideoDetailBean;
import com.example.jiyin.home.Activity.sonview.base.VideoindexBean;
import com.example.rootlib.mvp.view.IBaseView;

public interface TopView extends IBaseView {

    void retVideoindex(VideoindexBean bean);//返回 首页数据

    void retVideoDetailData(VideoDetailBean bean);//top 视频详情
}
