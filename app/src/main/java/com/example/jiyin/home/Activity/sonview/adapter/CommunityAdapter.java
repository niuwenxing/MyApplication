package com.example.jiyin.home.Activity.sonview.adapter;


import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.CommunityindexBean;
import com.example.jiyin.utils.GlideImageLoader;

import java.util.List;

public class CommunityAdapter extends BaseQuickAdapter<CommunityindexBean.DataBean.ListBean, BaseViewHolder> {


    public CommunityAdapter( @Nullable List<CommunityindexBean.DataBean.ListBean> data) {
        super(R.layout.communitylist_item, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CommunityindexBean.DataBean.ListBean item) {
        helper.setText(R.id.tv_communityTitile,item.getCommunity_title());
        GlideImageLoader.loadLogh(mContext, BaseConfig.ROOT_IMAGES_API+item.getCommunity_path(),(ImageView)helper.getView(R.id.iv_imageLeft));
        GlideImageLoader.loadLogh(mContext, BaseConfig.ROOT_IMAGES_API+item.getCommunity_paths(),(ImageView)helper.getView(R.id.iv_imageRight));
        helper.setText(R.id.tv_commiunityContext,item.getCommunity_vtitle());
    }
}
