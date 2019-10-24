package com.example.jiyin.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;

import java.lang.reflect.Field;

public class TranslucentStatusUtil {
    /**
     * 动态的设置状态栏  实现沉浸式状态栏
     */
    public static void initState(Activity activity, LinearLayout titleBar) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
//            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
////            //透明导航栏
//            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            titleBar.setVisibility(View.VISIBLE);
            //获取到状态栏的高度
            int statusHeight = getStatusBarHeight(activity);
            //动态的设置隐藏布局的高度
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) titleBar.getLayoutParams();
            params.height = statusHeight;
            titleBar.setLayoutParams(params);
        }
    }

    /**
     * 通过反射的方式获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return activity.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
