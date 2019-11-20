package com.example.jiyin.home.Activity.presenter;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

public abstract class ReleaseCirclesPresenter<V extends IBaseView> extends BasePresenter<V> {
    public abstract void UpImages(List<LocalMedia> selectList);
}
