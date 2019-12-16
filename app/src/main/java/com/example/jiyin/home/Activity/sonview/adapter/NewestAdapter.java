package com.example.jiyin.home.Activity.sonview.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.ScreationBeans;
import com.example.jiyin.utils.GlideImageLoader;

import java.util.List;

public class NewestAdapter extends BaseQuickAdapter<ScreationBeans.DataBean.ScreationBean,BaseViewHolder> {


    public NewestAdapter( @Nullable List data) {
        super(R.layout.creation_item, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ScreationBeans.DataBean.ScreationBean item) {

        GlideImageLoader.load(mContext, BaseConfig.ROOT_IMAGES_API+item.getCreation_path(), helper.getView(R.id.tv_imageNewest));
        helper.setText(R.id.tv_TitleNewest,item.getCreation_title()+"");//标题
//        helper.setText(R.id.tv_SubheadingStr,"");//副标题
        helper.setText(R.id.tv_NewestTime,"活动时间："+item.getCreation_stime());//
        helper.setText(R.id.textView7,mContext.getResources().getString(R.string.reduStr)+item.getCreation_hnum());//热度



    }
}
