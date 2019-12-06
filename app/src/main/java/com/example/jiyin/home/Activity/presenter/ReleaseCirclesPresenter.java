package com.example.jiyin.home.Activity.presenter;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

import okhttp3.Call;

public abstract class ReleaseCirclesPresenter<V extends IBaseView> extends BasePresenter<V> {
    public abstract Call UpImages(List<LocalMedia> selectList);

    public abstract void releaseCircles(String circle_title, int ification_id, int circle_type,  List<String> data);

//    public abstract void relVoideCircles(String trim, int ification_id, int circle_type, String data);
}
