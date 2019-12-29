package com.example.jiyin.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.example.jiyin.R;

import java.io.File;

/**
 * 使用Glide加载圆形ImageView(如头像)时，不要使用占位图
 */
public class GlideImageLoader {

    public static DrawableCrossFadeFactory getDefaultDrawableCrossFadeFactory() {
        return new DrawableCrossFadeFactory.Builder()
                .setCrossFadeEnabled(true).build();
    }



    public static void load(Context context, String url, ImageView iv) {

        Glide.with(context)
                .load(url)
                .transition(new DrawableTransitionOptions().transition(getDefaultDrawableCrossFadeFactory()))
                .apply(GlideUtils.defaultOption())
                .into(iv);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void load(Activity activity, String url, ImageView iv) {
        if (!activity.isDestroyed()) {
            Glide.with(activity).load(url)
                    .transition(new DrawableTransitionOptions().transition(getDefaultDrawableCrossFadeFactory()))
                    .apply(GlideUtils.defaultOption())
                    .into(iv);
        }
    }

    public static void load(Context context, int imgId, ImageView iv) {
        Glide.with(context)
                .load(imgId)
                .apply(GlideUtils.defaultOption())
                .into(iv);
    }

    /**
     * 占位图/错误图
     *
     * @param context
     * @param url
     * @param iv
     * @param placeHolder
     * @param errorHolder
     */
    public static void load(Context context, String url, int placeHolder, int errorHolder, ImageView iv) {
        Glide.with(context).load(url)
                .thumbnail(0.1f)
                .transition(new DrawableTransitionOptions().transition(getDefaultDrawableCrossFadeFactory()))
                .apply(GlideUtils.defaultErrorOption(placeHolder, errorHolder))
                .into(iv);
    }

    /**
     * 占位图/错误图
     *
     * @param context
     * @param url
     * @param iv
     * @param placeHolder
     * @param errorHolder
     */
    public static void loadto(Context context, String url, @Nullable int placeHolder, @Nullable  int errorHolder, ImageView iv) {
        Glide.with(context).load(url)
                .transition(new DrawableTransitionOptions().transition(getDefaultDrawableCrossFadeFactory()))
                .apply(GlideUtils.defaultErrorOption(placeHolder, errorHolder))
                .into(iv);
    }

    /**
     * @param context
     * @param url
     * @param iv
     */
    public static void loadto(Context context, String url, ImageView iv) {
        Glide.with(context).load(url)
                .transition(new DrawableTransitionOptions().transition(getDefaultDrawableCrossFadeFactory()))
                .apply(GlideUtils.defaultCenterOption())
                .into(iv);
    }

    /**
     * 占位图/错误图 同一张
     */
    public static void load(Context context, String url, int placeHolder, ImageView iv) {
        load(context, url, placeHolder, placeHolder, iv);
    }
    /**
     * 占位图/错误图 同一张
     */
    public static void loadLogh(Context context, String url, ImageView iv) {
        loadto(context,url,R.mipmap.zanwufabu,R.mipmap.zanwufabu,iv);
    }
    /**
     * 加载图片使用默认图片
     */
    public static void loadMerchantImg(Context context, String url, ImageView iv) {
//        load(context, url, R.drawable.arrow_down, R.drawable.arrow_down, iv);
    }

    /**
     * 加载圆图,暂时用到显示头像
     * <p>
     * 使用Glide加载圆形ImageView(如头像)时，不要使用占位图
     */
    public static void displayCircle(String imageUrl, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .transition(new DrawableTransitionOptions().transition(getDefaultDrawableCrossFadeFactory()))
//                .apply(GlideUtils.defaultCircleCenterOption(R.mipmap.mine_head, R.mipmap.mine_head))
                .into(imageView);
    }

    /**
     * 加载圆图,暂时用到显示头像
     * <p>
     * 使用Glide加载圆形ImageView(如头像)时，不要使用占位图
     */
    public static void displayCircleFile(File file, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(file)
                .transition(new DrawableTransitionOptions().transition(getDefaultDrawableCrossFadeFactory()))
//                .apply(GlideUtils.defaultCircleCenterOption(R.drawable.arrow_down, R.drawable.arrow_down))
                .into(imageView);
    }


    /**
     * 加载圆图,暂时用到显示头像
     * <p>
     * 使用Glide加载圆形ImageView(如头像)时，不要使用占位图
     */
    public static void displayCircleMct(String imageUrl, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .transition(new DrawableTransitionOptions().transition(getDefaultDrawableCrossFadeFactory()))
//                .apply(GlideUtils.defaultCircleCenterOption(R.drawable.arrow_down, R.drawable.arrow_down))
                .into(imageView);
    }

}