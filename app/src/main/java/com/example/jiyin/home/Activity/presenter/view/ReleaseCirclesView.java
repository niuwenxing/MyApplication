package com.example.jiyin.home.Activity.presenter.view;

import com.example.jiyin.home.Activity.homeview.base.ImageArr;
import com.example.jiyin.home.Activity.homeview.base.ReleaseBean;
import com.example.rootlib.mvp.view.IBaseView;

public interface ReleaseCirclesView extends IBaseView {
    void setImageUrl(ImageArr data);//返回图片路径


    void releasedSuccessfully(ReleaseBean bean);//发布成功 返回

    void releaseFail(String mge, String s);
}
