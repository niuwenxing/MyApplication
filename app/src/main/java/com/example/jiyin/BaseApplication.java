package com.example.jiyin;

import android.app.Activity;
import android.app.Application;
import com.example.rootlib.utils.LogUtils;
import java.util.Locale;
import butterknife.ButterKnife;
import me.jessyan.autosize.AutoAdaptStrategy;
import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.onAdaptListener;

/**
 * Created by guolei on 2019/10/15.
 */

public class BaseApplication extends Application {
    /**
     * 是否开启调试模式
     */
    public static final boolean DEVELOP_DEBUG_MODE = true;

    private static BaseApplication instance;
    @Override
    public void onCreate() {
        instance=this;
        super.onCreate();
        AutoSizeConfig.getInstance().setCustomFragment(true)
                .setExcludeFontScale(true)
                //屏幕适配监听器
                .setOnAdaptListener(new onAdaptListener() {
                    @Override
                    public void onAdaptBefore(Object target, Activity activity) {
                        //使用以下代码, 可支持 Android 的分屏或缩放模式, 但前提是在分屏或缩放模式下当用户改变您 App 的窗口大小时
                        //系统会重绘当前的页面, 经测试在某些机型, 某些情况下系统不会重绘当前页面, ScreenUtils.getScreenSize(activity) 的参数一定要不要传 Application!!!
//                        AutoSizeConfig.getInstance().setScreenWidth(ScreenUtils.getScreenSize(activity)[0]);
//                        AutoSizeConfig.getInstance().setScreenHeight(ScreenUtils.getScreenSize(activity)[1]);
                        LogUtils.d(String.format(Locale.ENGLISH, "%s onAdaptBefore!", target.getClass().getName()));
                    }

                    @Override
                    public void onAdaptAfter(Object target, Activity activity) {
                        LogUtils.d(String.format(Locale.ENGLISH, "%s onAdaptAfter!", target.getClass().getName()));
                    }
                }).setLog(false)
                .setUseDeviceSize(true)
                .setBaseOnWidth(false)
                .setAutoAdaptStrategy(new AutoAdaptStrategy() {
                    @Override
                    public void applyAdapt(Object target, Activity activity) {

                    }
                });

        AutoSize.initCompatMultiProcess(this);

        initDebugModel();

    }
    /**
     * 初始化各个组件的调试模式
     */
    private void initDebugModel() {
        // 组件注入模块调试
        ButterKnife.setDebug(DEVELOP_DEBUG_MODE);
        //

    }

    public static synchronized BaseApplication getInstance() {
        return instance;
    }
}
