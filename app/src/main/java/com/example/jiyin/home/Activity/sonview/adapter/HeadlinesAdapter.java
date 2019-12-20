package com.example.jiyin.home.Activity.sonview.adapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.NewIndexBean;
import com.example.jiyin.utils.GlideImageLoader;

import java.util.List;
public class HeadlinesAdapter extends BaseQuickAdapter<NewIndexBean.DataBean, BaseViewHolder> {


    public HeadlinesAdapter(@Nullable List<NewIndexBean.DataBean> data) {
        super(R.layout.headlines_item, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, NewIndexBean.DataBean item) {
        helper.setText(R.id.tv_contextText,item.getNew_title());
        helper.setText(R.id.tv_contextTime,item.getNew_time());
        GlideImageLoader.load(mContext, BaseConfig.ROOT_IMAGES_API+item.getPath(),helper.getView(R.id.img_headlineImage));
    }



}
