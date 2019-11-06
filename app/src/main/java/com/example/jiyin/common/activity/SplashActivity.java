package com.example.jiyin.common.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


import com.example.jiyin.R;
import com.example.jiyin.home.Activity.HomeActivity;
import com.example.rootlib.permission.RequestPermissionListener;


public class SplashActivity extends JiYingActivity {

    private boolean isDirectEnter = false;
    private final int SETTING_CODE = 0x1211;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusNavigationBar();
        initAuthority();
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode ==SETTING_CODE){
            initAuthority();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void initAuthority() {
        requestPermission(0x1208, new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.INTERNET,
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_FINE_LOCATION
        }, new RequestPermissionListener() {
            @Override
            public void onPass(String[] strings) {

//                for (int i = 0; i < strings.length; i++) {
//                    if (strings[i].equals(Manifest.permission.READ_PHONE_STATE)) {
//                        // 初始化请求参数
//                    }
//                }
            }

            @Override
            public void onUnPass(String[] uPas) {
                if (null == uPas || uPas.length == 0) {    // 证明没有没通过的权限
                    // 设置延迟跳转
                    int delay = isDirectEnter ? 100 : 2000;
                    new Handler(new Handler.Callback() {
                        @Override
                        public boolean handleMessage(Message msg) {
                            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                            finish();
                            return true;
                        }
                    }).sendEmptyMessageDelayed(0, delay);
                } else {               // 有没有申请的权限
//                    dialogShowRemind(0, getString(R.string.common_prompt), getString(R.string.common_authority_warn),
//                            getString(R.string.common_open), getString(R.string.common_cancel), new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.dismiss();
                                    startActivityForResult(getAppDetailSettingIntent(), SETTING_CODE); //直接进入手机中设置界面
//                                }
//                            }, new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.dismiss();
//                                    finish();
//                                }
//                            });
                }
            }
        });
    }


//    private static String IMG_PATH = null;
//    private FrameLayout splashView;
//    private static final String IMG_URL = "splash_img_url";
//    private static final String ACT_URL = "splash_act_url";
//    private String imgUrl = null;
//    private String actUrl = null;
//    private ImageView splashImageView;
//    private Integer duration = 3;
//    private static final int delayTime = 1000;
//    private Handler handler = new Handler();
//    private Runnable timerRunnable =new Runnable() {
//        @Override
//        public void run() {
//            if(0== duration){
//                dismissSplashView(false);
//                return;
//            }else{
//                duration=--duration;
//            }
//            handler.postDelayed(timerRunnable, delayTime);
//        }
//    };
//    private ProduceActivity parent;
//
//    private void dismissSplashView(boolean initiativeDismiss) {
//        handler.removeCallbacks(timerRunnable);
//             @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animator = ObjectAnimator.ofFloat(this, "scale", 0.0f, 0.5f).setDuration(600);
//             animator.start();
//             animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                 @Override
//                 public void onAnimationUpdate(ValueAnimator animation) {
//                     float cVal = (Float) animation.getAnimatedValue();
//                     splashView.setAlpha (1.0f - 2.0f * cVal);
//                     splashView.setScaleX(1.0f + cVal);
//                     splashView.setScaleX(1.0f + cVal);
//
//                 }
//             });
//            animator.addListener(new Animator.AnimatorListener() {
//                @Override
//                public void onAnimationStart(Animator animation) {
//                }
//
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    splashView.removeView(splashView);
//                }
//
//                @Override
//                public void onAnimationCancel(Animator animation) {
//                    splashView.removeView(splashView);
//                }
//                @Override
//                public void onAnimationRepeat(Animator animation) {
//
//                }
//            });
//
//    }



//    private void initVeiw(@Nullable Integer defaultBitmapRes) {
//        //本地缓存路径
//        IMG_PATH=getFilesDir().getAbsolutePath().toString()+"/splash_img.jpg";
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        Bitmap bitmapToShow = null;
//        if(isExistsLocalSplashData()){
//            bitmapToShow = BitmapFactory.decodeFile(IMG_PATH);
//            imgUrl= PreferenceUtil.getString(IMG_URL, null);
//            actUrl= PreferenceUtil.getString(ACT_URL, null);
//        }else if ( null!= defaultBitmapRes) {
//            bitmapToShow = BitmapFactory.decodeResource(getResources(), defaultBitmapRes);
//        }
//
//        if(null == bitmapToShow) return;
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        splashImageView = new ImageView(this);
//        splashImageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        splashImageView.setBackgroundColor(getResources().getColor(android.R.color.white));
//        LinearLayout.LayoutParams imageViewLayoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        splashImageView.setLayoutParams(imageViewLayoutParams);
//        splashImageView.setImageBitmap(bitmapToShow);
//        splashView.addView(splashImageView);
//
//        handler.postAtTime(timerRunnable,delayTime);
//
//
//    }

//    private boolean isExistsLocalSplashData() {
//        String imgUrl = PreferenceUtil.getString(IMG_URL, null);
//        return !TextUtils.isEmpty(imgUrl) && isFileExist(IMG_PATH);
//    }

//    private boolean isFileExist(String filePath) {
//        if(TextUtils.isEmpty(filePath)){
//            return  false;
//        }else{
//            File file = new File(filePath);
//            return file.exists()&& file.isFile();
//        }
//    }
     private void hideStatusNavigationBar(){
         Window window = getWindow();
         if(Build.VERSION.SDK_INT<Build.VERSION_CODES.KITKAT){
             window.getDecorView().setSystemUiVisibility(
                     View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                             | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                             | View.SYSTEM_UI_FLAG_FULLSCREEN //hide statusBar
                             | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION); //hide navigationBar
         }else if(Build.VERSION.SDK_INT<Build.VERSION_CODES.JELLY_BEAN){
             this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                     WindowManager.LayoutParams.FLAG_FULLSCREEN);
         }
         else if(Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP){
             //半透明
             window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
         }else {
             window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
             window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
             window.setStatusBarColor(0);
         }
         window.getDecorView().setSystemUiVisibility(
                 View.SYSTEM_UI_FLAG_LAYOUT_STABLE|
                         View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                         View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
         );
     }


}


