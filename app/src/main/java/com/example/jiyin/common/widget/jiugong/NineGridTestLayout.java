package com.example.jiyin.common.widget.jiugong;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jiyin.R;
import com.example.jiyin.utils.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

public class NineGridTestLayout  extends NineGridLayout {

    private Context context;
    private int itemPosition;
    private OnItemPictureClickListener listener;

    public NineGridTestLayout(Context context) {
        this(context,null);
    }

    public NineGridTestLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }


    @Override
    protected void displayImage(int position,RatioImageView imageView, String url) {
        if(context!=null){
            GlideImageLoader.displayCircle(url,(ImageView) imageView);

//            Picasso.with(context).load(url).error(context.getResources().getDrawable(R.mipmap.head)).into(imageView);
//            imageView.setTag(Utils.getNameByPosition(itemPosition,position));
//            imageView.setTransitionName(Utils.getNameByPosition(itemPosition,position));
        }
    }

    @Override
    protected void onClickImage(int imageIndex, String url, List<String> urlList, ImageView imageView) {
        listener.onItemPictureClick(itemPosition,imageIndex,url,urlList,(ImageView) imageView);
    }


    public void setItemPosition(int itemPosition) {
        this.itemPosition = itemPosition;
    }

    public void setListener(OnItemPictureClickListener listener) {
        this.listener = listener;
    }


}
