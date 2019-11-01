package com.example.jiyin.home.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.net.beas.BaseResponseModel;
import com.example.jiyin.customwidget.NoScrollViewPager;
import com.example.jiyin.home.Activity.presenter.impl.MainPresenterImpl;
import com.example.jiyin.home.Activity.presenter.view.MainView;
import com.example.jiyin.home.fragment.MypageFragment;
import com.example.jiyin.home.fragment.NewHomeFregment;
import com.example.jiyin.home.fragment.NewsFragment;
import com.example.jiyin.home.fragment.WorkshopFragment;
import com.example.rootlib.utils.StatusBarUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;


public class HomeActivity extends JiYingActivity<MainView, MainPresenterImpl> implements MainView, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.vp_main)
    NoScrollViewPager vpMain;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    private NewHomeFregment newHomeFregment;
    private WorkshopFragment workshopFragment;
    private NewsFragment newsFragment;
    private MypageFragment mypageFragment;
    private Fragment[] fragments1;
    private static RadioButton[] RadioButtons;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //沉浸式状态栏适配
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        statusBarHide(this);
        initFragment();


    }

    private void initFragment() {
        newHomeFregment = new NewHomeFregment();
        workshopFragment = new WorkshopFragment();
        newsFragment = new NewsFragment();
        mypageFragment = new MypageFragment();
        fragments1 = new Fragment[]{newHomeFregment, workshopFragment,new WorkshopFragment(), newsFragment,mypageFragment};

        vpMain.setOffscreenPageLimit(fragments1.length);
        vpMain.setAdapter(new HomeFragmentAdapter(getSupportFragmentManager(), fragments1));
        rgMain.setOnCheckedChangeListener(this);
        RadioButtons = new RadioButton[fragments1.length];
        for (int i = 0; i < RadioButtons.length; i++) {
            RadioButtons[i] = (RadioButton) rgMain.getChildAt(i);
        }
        RadioButtons[0].setChecked(true);

    }

    int anInt=0;
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < RadioButtons.length; i++) {
            if (checkedId == RadioButtons[i].getId()) {
                if(i!=2){
                    anInt=i;
                    vpMain.setCurrentItem(i);
                }
                switch (i){
                    case 1:
                    case 2:
                    case 3:
                        StatusBarUtil.setStatusBarMode(this,true,R.color.white);
                    break;
                    case 0:
                    case 4:
                        statusBarHide(this);
                        break;

                }
            }
        }
        RadioButtons[anInt].setChecked(true);
    }
//    private void upDataFile() {
//        requestPermission(0x1301, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE
//        }, new RequestPermissionListener() {
//            @Override
//            public void onPass(String[] strings) {
//                for (int i = 0; i < strings.length; i++) {
//                    if (strings[i].equals(Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                        PictureSelector.create(activity)
//                                .openGallery(PictureMimeType.ofVideo())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
//                                .theme(R.style.picture_default_style)//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
//                                .imageSpanCount(4)// 每行显示个数 int
//                                .selectionMode(PictureConfig.SINGLE)
//                                .previewVideo(true)
//                                .enablePreviewAudio(true)
//                                .isCamera(true)//
//                                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
//                                .isZoomAnim(false)// 图片列表点击 缩放效果 默认true
//                                .selectionMedia(selectList)// 是否传入已选图片 List<LocalMedia> list
//                                .videoMaxSecond(16)// 显示多少秒以内的视频or音频也可适用 int
//                                .videoMinSecond(1)// 显示多少秒以内的视频or音频也可适用 int
//                                .recordVideoSecond(15)//视频秒数录制 默认60s int
//                                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
//                    }
//
//
//                }
//
//            }
//
//            @Override
//            public void onUnPass(String[] uPas) {
//
//            }
//        });
//
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
//                case PictureConfig.CHOOSE_REQUEST:
//                    selectList = PictureSelector.obtainMultipleResult(data);

            }
        }

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

    public static void statusBarHide(Activity activity) {
        // 代表 5.0 及以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            return;
        }
        // versionCode > 4.4  and versionCode < 5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }




}

class MomentCallManager {

//    public static Call<BaseResponseModel<Ponse>> getReplyCall(String content, List<LocalMedia> paths, Map<String, String> map) {
//        Map<String, RequestBody> params = new HashMap<>();
//        List<MultipartBody.Part> parts = new ArrayList<>();
//        String pictureType = null;
//        for (LocalMedia imgStr : paths) {
//            pictureType = imgStr.getPictureType();
//            File file;
//            try {
//                if (imgStr.getPath().endsWith(".gif")) {
//                    file = new File(imgStr.getPath());
//                } else {
//                    if (imgStr.getPictureType().equals("image/webp")) {
//                        file = new File(imgStr.getPath());
//                    } else {
//                        file = new File(imgStr.getPath());
//                    }
//                }
//
//                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//                MultipartBody.Part facePart;
//                if (pictureType.equals("image/webp")) {
//                    facePart = MultipartBody.Part.createFormData("issueDynamicFile", file.getName().replace(".jpg", ".webp"), requestFile);
//                } else {
//                    facePart = MultipartBody.Part.createFormData("issueDynamicFile", file.getName(), requestFile);
//                }
//
//                parts.add(facePart);
//                Log.e("---", "img --- " + imgStr.getWidth() + "  " + imgStr.getHeight());
//                Log.e("---", "imgsss --- " + imgStr.toString());
//            } catch (Exception e) {
//            }
//            params.put("mediaSize", SunriseUtils.convertToRequestBody(imgStr.getWidth() + "," + imgStr.getHeight()));
//
//        }
//
//        return HttpManager.getInstance().req(MomentService.class).getFabuData(params, parts);
//    }



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
 class HomeFragmentAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments1;

    public HomeFragmentAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments1 = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments1[position]!=null) {
            return fragments1[position];
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragments1.length;
    }
}