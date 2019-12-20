package com.example.jiyin.utils;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.loader.ImageLoader;

public class GlideImageBannerLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context)
                .load(String.valueOf(path))
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
                        .dontAnimate().centerCrop()
                ).into(imageView);
    }
}