package com.example.jiyin.home.Activity.adapter;


import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.FounderfounderBean;

import java.util.List;

public class FounderAdapter extends BaseQuickAdapter<FounderfounderBean.DataBean.RecommendBean, BaseViewHolder> {


    public FounderAdapter( @Nullable List<FounderfounderBean.DataBean.RecommendBean> data) {
        super(R.layout.searchdetailed_item , data);
    }
    @Override
    protected void convert(@NonNull BaseViewHolder helper, FounderfounderBean.DataBean.RecommendBean item) {
        Glide.with(mContext).load(BaseConfig.ROOT_IMAGES_API+item.getFounder_head()).into((ImageView) helper.getView(R.id.img_portrait));
        helper.setText(R.id.tv_FounderName,item.getFounder_name());
        helper.setText(R.id.tv_Initiation,item.getFounder_job());
        helper.setText(R.id.tv_synopsis,item.getFounder_brief());
    }
}
