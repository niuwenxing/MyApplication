package com.example.jiyin.home.Activity.sonview.sonview;

import com.example.jiyin.home.Activity.sonview.base.AgencyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.Toutiao;
import com.example.jiyin.home.Activity.sonview.base.VideoDetailBean;
import com.example.jiyin.home.Activity.sonview.base.VideoindexBean;
import com.example.rootlib.mvp.view.IBaseView;

public interface TopView extends IBaseView {

    void retVideoindex(VideoindexBean bean);//返回 首页数据

    void retVideoDetailData(VideoDetailBean bean);//top 视频详情

    void retAgencydetail(AgencyDetailBean bean);//研习社视频详情

    void retAgencycomment(Toutiao bean);//线上课堂评论

    void retAgencyUp(Toutiao bean);//线上课堂 评论点赞

    void retVideovideoUp(Toutiao bean);//top点赞返回

    void retVideocomment(Toutiao bean);//视频评论返回

    void retVideoup(Toutiao bean);//评论点赞
}
