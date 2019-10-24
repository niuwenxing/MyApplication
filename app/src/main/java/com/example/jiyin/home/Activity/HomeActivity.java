package com.example.jiyin.home.Activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.net.beas.BaseResponseModel;
import com.example.jiyin.common.net.manager.HttpManager;
import com.example.jiyin.common.utils.SunriseUtils;
import com.example.jiyin.home.Activity.Impl.MainPresenterImpl;
import com.example.jiyin.home.Activity.view.MainView;
import com.example.jiyin.home.fragment.NewHomeFregment;
import com.example.myapplication.R;
import com.example.rootlib.permission.RequestPermissionListener;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;


public class HomeActivity extends JiYingActivity<MainView, MainPresenterImpl> implements MainView {

    private List<LocalMedia> selectList = new ArrayList<>();
    private Fragment[] fragments;
    private NewHomeFregment newHomeFregment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //沉浸式状态栏适配
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        initFragment();
        RelativeLayout viewById = findViewById(R.id.fragment_container_driver);
        viewById.getGravity();

//            presenter.getUserDate("123");
//        upDataFile();

//        button = (Button) findViewById(R.id.updata_btn);
//        ImageView imageView= (ImageView) findViewById(R.id.goTo_Video);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


    }

    private void initFragment() {
        newHomeFregment = new NewHomeFregment();
        fragments = new Fragment[]{newHomeFregment};
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.add(R.id.fragment_container_driver, newHomeFregment).show(newHomeFregment).commit();

    }

    private void upDataFile() {
        requestPermission(0x1301, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, new RequestPermissionListener() {
            @Override
            public void onPass(String[] strings) {
                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                        PictureSelector.create(activity)
                                .openGallery(PictureMimeType.ofVideo())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                                .theme(R.style.picture_default_style)//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                                .imageSpanCount(4)// 每行显示个数 int
                                .selectionMode(PictureConfig.SINGLE)
                                .previewVideo(true)
                                .enablePreviewAudio(true)
                                .isCamera(true)//
                                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                                .isZoomAnim(false)// 图片列表点击 缩放效果 默认true
                                .selectionMedia(selectList)// 是否传入已选图片 List<LocalMedia> list
                                .videoMaxSecond(16)// 显示多少秒以内的视频or音频也可适用 int
                                .videoMinSecond(1)// 显示多少秒以内的视频or音频也可适用 int
                                .recordVideoSecond(15)//视频秒数录制 默认60s int
                                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
                    }


                }

            }

            @Override
            public void onUnPass(String[] uPas) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    selectList = PictureSelector.obtainMultipleResult(data);

            }
        }

    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void createPresenter() {
        presenter = new MainPresenterImpl();
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_home;
    }

    /**
     * 接口回调
     *
     * @param tag
     */
    public void setFunctionForFragment(String tag) {

    }


}

class MomentCallManager {

    public static Call<BaseResponseModel<Ponse>> getReplyCall(String content, List<LocalMedia> paths, Map<String, String> map) {
        Map<String, RequestBody> params = new HashMap<>();
        List<MultipartBody.Part> parts = new ArrayList<>();
        String pictureType = null;
        for (LocalMedia imgStr : paths) {
            pictureType = imgStr.getPictureType();
            File file;
            try {
                if (imgStr.getPath().endsWith(".gif")) {
                    file = new File(imgStr.getPath());
                } else {
                    if (imgStr.getPictureType().equals("image/webp")) {
                        file = new File(imgStr.getPath());
                    } else {
                        file = new File(imgStr.getPath());
                    }
                }

                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                MultipartBody.Part facePart;
                if (pictureType.equals("image/webp")) {
                    facePart = MultipartBody.Part.createFormData("issueDynamicFile", file.getName().replace(".jpg", ".webp"), requestFile);
                } else {
                    facePart = MultipartBody.Part.createFormData("issueDynamicFile", file.getName(), requestFile);
                }

                parts.add(facePart);
                Log.e("---", "img --- " + imgStr.getWidth() + "  " + imgStr.getHeight());
                Log.e("---", "imgsss --- " + imgStr.toString());
            } catch (Exception e) {
            }
            params.put("mediaSize", SunriseUtils.convertToRequestBody(imgStr.getWidth() + "," + imgStr.getHeight()));

        }

        return HttpManager.getInstance().req(MomentService.class).getFabuData(params, parts);
    }

}


interface MomentService {
    @Multipart
    @POST("image/imgFile")
    retrofit2.Call<BaseResponseModel<Ponse>> getFabuData(@PartMap Map<String, RequestBody> map, @Part List<MultipartBody.Part> parts);

}

class Ponse implements Serializable {


}


// button.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
////                if(selectList!=null)return;
//        BeanNetUnit<Object> mypublish = new BeanNetUnit<>()
//        .setCall(MomentCallManager.getReplyCall("123",selectList,null))
//        .request(new NetBeanListener() {
//@Override
//public void onSuc(Object bean) {
//        Log.d("7895","上传成功");
//        }
//
//@Override
//public void onFail(String status, String message) {
//        Log.d("7895","上传失败");
//        }
//
//@Override
//public void onLoadStart() {
//
//        }
//
//@Override
//public void onLoadFinished() {
//
//        }
//
//@Override
//public void onNetErr() {
//        Log.d("7895","err");
//        }
//
//@Override
//public void onSysErr(int httpCode, String msg) {
//
//        }
//        });
//
//
//        }
//        });
