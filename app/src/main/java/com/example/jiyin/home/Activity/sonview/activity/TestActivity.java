package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.widget.ImageView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;

public class TestActivity extends JiYingActivity {

//    StandardGSYVideoPlayer detailPlayer;
//
//    private boolean isPlay;
//    private boolean isPause;
//
//    private OrientationUtils orientationUtils;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_test;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView();

//        detailPlayer = (StandardGSYVideoPlayer) findViewById(R.id.video_player);

        String url = "http://7xjmzj.com1.z0.glb.clouddn.com/20171026175005_JObCxCE2.mp4";

        //增加封面
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
        //增加title
//        detailPlayer.getTitleTextView().setVisibility(View.GONE);
//        detailPlayer.getBackButton().setVisibility(View.GONE);
//
//        //外部辅助的旋转，帮助全屏
//        orientationUtils = new OrientationUtils(this, detailPlayer);
//        //初始化不打开外部的旋转
//        orientationUtils.setEnable(false);
//
//        GSYVideoOptionBuilder gsyVideoOption = new GSYVideoOptionBuilder();
//        gsyVideoOption.setThumbImageView(imageView)
//                .setIsTouchWiget(true)
//                .setRotateViewAuto(false)
//                .setLockLand(false)
//                .setAutoFullWithSize(true)
//                .setShowFullAnimation(false)
//                .setNeedLockFull(true)
//                .setUrl(url)
//                .setCacheWithPlay(false)
//                .setVideoTitle("测试视频")
//                .setVideoAllCallBack(new GSYSampleCallBack() {
//                    @Override
//                    public void onPrepared(String url, Object... objects) {
//                        super.onPrepared(url, objects);
//                        //开始播放了才能旋转和全屏
//                        orientationUtils.setEnable(true);
//                        isPlay = true;
//                    }
//
//                    @Override
//                    public void onQuitFullscreen(String url, Object... objects) {
//                        super.onQuitFullscreen(url, objects);
//                        if (orientationUtils != null) {
//                            orientationUtils.backToProtVideo();
//                        }
//                    }
//                }).setLockClickListener(new LockClickListener() {
//            @Override
//            public void onClick(View view, boolean lock) {
//                if (orientationUtils != null) {
//                    //配合下方的onConfigurationChanged
//                    orientationUtils.setEnable(!lock);
//                }
//            }
//        }).build(detailPlayer);
//
//        detailPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //直接横屏
//                orientationUtils.resolveByClick();
//                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
//                detailPlayer.startWindowFullscreen(TestActivity.this, true, true);
//            }
//        });
//
//
//
//    }
//
//
//    @Override
//    public void onBackPressed() {
//        if (orientationUtils != null) {
//            orientationUtils.backToProtVideo();
//        }
//        if (GSYVideoManager.backFromWindowFull(this)) {
//            return;
//        }
//        super.onBackPressed();
//    }
//
//
//    @Override
//    public  void onPause() {
//        detailPlayer.getCurrentPlayer().onVideoPause();
//        super.onPause();
//        isPause = true;
//    }
//
//    @Override
//    public void onResume() {
//        detailPlayer.getCurrentPlayer().onVideoResume(false);
//        super.onResume();
//        isPause = false;
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (isPlay) {
//            detailPlayer.getCurrentPlayer().release();
//        }
//        if (orientationUtils != null)
//            orientationUtils.releaseListener();
//    }
//
//
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        //如果旋转了就全屏
//        if (isPlay && !isPause) {
//            detailPlayer.onConfigurationChanged(this, newConfig, orientationUtils, true, true);
//        }
//    }
}
