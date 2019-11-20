package com.example.jiyin.utils;

import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.jiyin.R;

/**
 * @author leo, ZhangWei
 * @date 2018/6/25
 */
public class GlideUtils {

    public static RequestOptions defaultOption() {
        return new RequestOptions()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
    }

    public static RequestOptions defaultCenterOption() {
        return new RequestOptions()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .transform(new CenterCrop())
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
    }

    public static RequestOptions defaultCenterOption(int placeholderRes) {
        return new RequestOptions()
                .placeholder(placeholderRes)
                .error(R.mipmap.ic_launcher_round)
                .transform(new CenterCrop())
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
    }

    public static RequestOptions defaultErrorOption(int placeholderRes, int errorRes) {
        return new RequestOptions()
                .placeholder(placeholderRes)
                .error(errorRes)
                .transform(new CenterCrop())
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
    }

    public static RequestOptions defaultErrorOption() {
        return new RequestOptions()
                .transform(new CenterCrop())
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
    }


    public static RequestOptions defaultCircleCenterOption(int placeholderRes, int errorRes) {

        MultiTransformation multi = new MultiTransformation(new CircleCrop(), new CenterCrop());

        return new RequestOptions()
                .placeholder(placeholderRes)
                .error(errorRes)
                .transform(multi)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
    }
}
