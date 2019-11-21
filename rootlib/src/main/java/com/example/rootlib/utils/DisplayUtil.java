package com.example.rootlib.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * dp、sp 转换为 px 的工具类
 * @author Administrator
 */
public class DisplayUtil {

    /**
     * 获取屏幕的相关属性
     *
     * @param context  上下文
     * @return DisplayMetrics
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    /**
     * 获取屏幕的宽度
     *
     * @param context    上下文
     * @return           int
     */
    public static int getScreenWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    /**
     * 获取屏幕的高度
     *
     * @param context    上下文
     * @return           int
     */
    public static int getScreenHeight(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    /**
     * 获取屏幕的密度
     *
     * @param context   上下文
     * @return float
     */
    public static float getDensity(Context context) {
        return getDisplayMetrics(context).density;
    }

    /**
     * 获取屏幕的SP密度
     *
     * @param context   上下文
     * @return float
     */
    public static float getScaledDensity(Context context) {
        return getDisplayMetrics(context).scaledDensity;
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param context 上下文
     * @param dp 要转化的dp值
     * @return int
     */
    public static int dp2px(Context context, int dp) {
        return (int) (dp * getDensity(context) + 0.5f);
    }

    /**
     * 将px值转换为dp或dip值，保证尺寸大小不变
     *
     * @param context 上下文
     * @param px 要转化的值
     * @return int
     */
    public static int px2dp(Context context, int px) {
        return (int) (px / getDensity(context) + 0.5f);
    }


    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue 要转化的px值
     * @return int
     */
    public static int px2sp(Context context, float pxValue) {
        return (int) (pxValue / getScaledDensity(context) + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue 要转化的sp值
     * @return int
     */
    public static int sp2px(Context context, float spValue) {
        return (int) (spValue * getScaledDensity(context) + 0.5f);
    }

}