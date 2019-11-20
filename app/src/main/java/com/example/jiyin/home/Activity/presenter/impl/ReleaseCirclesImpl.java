package com.example.jiyin.home.Activity.presenter.impl;

import android.content.Context;
import android.util.Log;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.homeview.base.ImageArr;
import com.example.jiyin.home.Activity.presenter.ReleaseCirclesPresenter;
import com.example.jiyin.home.Activity.presenter.view.ReleaseCirclesView;
import com.example.jiyin.home.UserCallManager;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

public class ReleaseCirclesImpl extends ReleaseCirclesPresenter<ReleaseCirclesView> {

    private BeanNetUnit release=null;
    @Override
    public void cancelBiz() {
        cancelRequest(release);
    }


    /**
     *  上传图片
     * @param selectList 图片路径
     */
    @Override
    public void UpImages(List<LocalMedia> selectList) {
        release=new BeanNetUnit<ImageArr>()
                .setCall(UserCallManager.upimages(selectList))
                .request(new NetBeanListener<ImageArr>() {
                    @Override
                    public void onSuc(ImageArr bean) {
                        Log.d("1232", "onSuc: "+bean.getData());
                    }
                    @Override
                    public void onFail(String status, boolean canceled, String message) {

                    }
                    @Override
                    public void onFail(int status, String message) {

                    }
                    @Override
                    public void onLoadStart() {

                    }
                    @Override
                    public void onLoadFinished() {

                    }
                    @Override
                    public void onNetErr() {

                    }
                    @Override
                    public void onSysErr(int httpCode, String msg) {

                    }
                });

    }

}
