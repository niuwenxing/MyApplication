package com.example.jiyin.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.jiyin.common.widget.NineGVIew.NineGridView;

/**
 * 九宫格 加载
 */

public class GlideImage implements NineGridView.ImageLoader {
    @Override
    public void onDisplayImage(Context context, ImageView imageView, String url) {
//        Glide.with(context).load(url).into(imageView);
        GlideImageLoader.loadLogh(context,url,imageView);
    }
    @Override
    public Bitmap getCacheImage(String url) {
        return null;
    }
}
