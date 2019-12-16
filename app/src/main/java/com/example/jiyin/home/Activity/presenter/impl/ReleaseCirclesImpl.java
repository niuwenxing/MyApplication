package com.example.jiyin.home.Activity.presenter.impl;

import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.net.manager.HttpManager;
import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.homeview.base.ImageArr;
import com.example.jiyin.home.Activity.homeview.base.ImageBase;
import com.example.jiyin.home.Activity.homeview.base.ReleaseBean;
import com.example.jiyin.home.Activity.presenter.ReleaseCirclesPresenter;
import com.example.jiyin.home.Activity.presenter.view.ReleaseCirclesView;
import com.example.jiyin.home.UserCallManager;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

import okhttp3.Call;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ReleaseCirclesImpl extends ReleaseCirclesPresenter<ReleaseCirclesView> {

    private BeanNetUnit release=null;
    @Override
    public void cancelBiz() {
        cancelRequest(release);
    }



    /**
     * 发布圈子
     * @param circle_title
     * @param ification_id
     * @param circle_type
     * @param data
     */
    @Override
    public void releaseCircles(String circle_title, int ification_id, int circle_type, List<String> data) {
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
                    public void onLoadStart() {v.showProgress();

                    }

                    @Override
                    public void onLoadFinished() {v.hideProgress();

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



    /**
     * 上传图片
     * @return
     */
    public Call UpImages(List<LocalMedia> list) {
        MultipartBody okhttpImage = HttpManager.getInstance().getOkhttpImage(list);
        final Request request = new Request.Builder()
                .url(BaseConfig.imgArr)
                .post(okhttpImage)
                .build();
        OkHttpClient mOkHttpClient = new OkHttpClient();
        return mOkHttpClient.newCall(request);

    }

    /**
     * 上传视频
     * @param list
     * @return
     */
    public Call UpVoide(List<LocalMedia> list) {
        MultipartBody okhttpImage = HttpManager.getInstance().getOkhttpVoide(list);
        final Request request = new Request.Builder()
                .url(BaseConfig.imgArr)
                .post(okhttpImage)
                .build();
        OkHttpClient mOkHttpClient = new OkHttpClient();
        return mOkHttpClient.newCall(request);

    }
}
