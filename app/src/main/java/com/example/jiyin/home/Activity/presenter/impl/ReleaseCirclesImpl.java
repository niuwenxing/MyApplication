package com.example.jiyin.home.Activity.presenter.impl;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.homeview.base.ImageArr;
import com.example.jiyin.home.Activity.homeview.base.ReleaseBean;
import com.example.jiyin.home.Activity.presenter.ReleaseCirclesPresenter;
import com.example.jiyin.home.Activity.presenter.view.ReleaseCirclesView;
import com.example.jiyin.home.UserCallManager;
import com.example.jiyin.interactive.JiYingRequestModel;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.PreferenceUtil;
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
     *                   /upload/app/20191121/e25e83c7220589aac9b10103347f3993.png
     */
    @Override
    public void UpImages(List<LocalMedia> selectList) {
        release=new BeanNetUnit<ImageArr>()
                .setCall(UserCallManager.upimages(selectList))
                .request(new NetBeanListener<ImageArr>() {
                    @Override
                    public void onSuc(ImageArr bean) {

                        v.setImageUrl(bean);
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

    /**
     * 发布圈子
     * @param circle_title
     * @param ification_id
     * @param circle_type
     * @param data
     */
    @Override
    public void releaseCircles(String circle_title, int ification_id, int circle_type, String data) {
        release=new BeanNetUnit<ReleaseBean>()
                .setCall(UserCallManager.uprelease(circle_title,ification_id,circle_type,data))
                .request(new NetBeanListener<ReleaseBean>() {
                    @Override
                    public void onSuc(ReleaseBean bean) {
                        if (bean!=null) {
                            v.releasedSuccessfully(bean);
                        }
                    }

                    @Override
                    public void onLoadStart() {

                    }

                    @Override
                    public void onLoadFinished() {

                    }

                    @Override
                    public void onNetErr() {
                        v.releaseFail("网络异常","");

                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {

                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.releaseFail("发布失败",status+message.toString());
                    }
                });


    }

}
