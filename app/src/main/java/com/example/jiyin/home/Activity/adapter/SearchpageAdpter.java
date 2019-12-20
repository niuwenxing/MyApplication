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

public class SearchpageAdpter extends BaseQuickAdapter<FounderfounderBean.DataBean.FounderBean, BaseViewHolder> {


    public SearchpageAdpter( @Nullable List<FounderfounderBean.DataBean.FounderBean> data) {
        super(R.layout.search_item, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, FounderfounderBean.DataBean.FounderBean item) {
        Glide.with(mContext).load(BaseConfig.ROOT_IMAGES_API+item.getFounder_head()).into((ImageView) helper.getView(R.id.iv_imagesearch));
        helper.setText(R.id.tv_textsearch,item.getFounder_name());
        helper.setText(R.id.tv_Culturebelongs,item.getFounder_job());
        helper.setText(R.id.tv_Culturedescribe,item.getFounder_brief());


    }
}
