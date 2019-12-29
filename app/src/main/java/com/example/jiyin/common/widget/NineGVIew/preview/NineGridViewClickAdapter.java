package com.example.jiyin.common.widget.NineGVIew.preview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.jiyin.common.widget.NineGVIew.ImageInfo;
import com.example.jiyin.common.widget.NineGVIew.NineGridView;
import com.example.jiyin.common.widget.NineGVIew.NineGridViewAdapter;
import com.example.jiyin.home.Activity.view.ImagePreviewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：廖子尧
 * 版    本：1.0
 * 创建日期：2016/3/21
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class NineGridViewClickAdapter extends NineGridViewAdapter {

    private int statusHeight;

    public NineGridViewClickAdapter(Context context, List<ImageInfo> imageInfo) {
        super(context, imageInfo);
        statusHeight = getStatusHeight(context);
    }

    @SuppressLint("NewApi")
    @Override
    protected void onImageItemClick(Context context, NineGridView nineGridView, int index, List<ImageInfo> imageInfo) {
        for (int i = 0; i < imageInfo.size(); i++) {
            ImageInfo info = imageInfo.get(i);
            View imageView;
            if (i < nineGridView.getMaxSize()) {
                imageView = nineGridView.getChildAt(i);
            } else {
                //如果图片的数量大于显示的数量，则超过部分的返回动画统一退回到最后一个图片的位置
                imageView = nineGridView.getChildAt(nineGridView.getMaxSize() - 1);
            }
            info.imageViewWidth = imageView.getWidth();
            info.imageViewHeight = imageView.getHeight();
            int[] points = new int[2];
            imageView.getLocationInWindow(points);
            info.imageViewX = points[0];
            info.imageViewY = points[1] - statusHeight;
        }
        ArrayList<String> objects = new ArrayList<>();
        for (ImageInfo info : imageInfo) {
            objects.add(info.getThumbnailUrl());
        }
        Intent intent = new Intent(context, ImagePreviewActivity.class);
            intent.putStringArrayListExtra("imageList", objects);
            intent.putExtra(ImagePreviewActivity.P.START_ITEM_POSITION, index);
            intent.putExtra(ImagePreviewActivity.P.START_IAMGE_POSITION, index);
            context.startActivity(intent);
    }

    /**
     * 获得状态栏的高度
     */
    public int getStatusHeight(Context context) {
        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }
}
