package com.example.jiyin.home.Activity.sonview.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.ZtimeIndexBean;
import com.example.jiyin.utils.GlideImageLoader;

import java.util.List;

public class TscreationAdapter  extends BaseQuickAdapter<ZtimeIndexBean.DataBean.ScreationBean, BaseViewHolder> {
    public TscreationAdapter( @Nullable List<ZtimeIndexBean.DataBean.ScreationBean> data) {
        super(R.layout.item_zp_time_pastperiod, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ZtimeIndexBean.DataBean.ScreationBean item) {

        GlideImageLoader.load(mContext, BaseConfig.ROOT_IMAGES_API+item.getZ_path(),(ImageView)helper.getView(R.id.ml_CarveimageView));
        helper.setText(R.id.tv_CarveTextstr,item.getZ_title());
        helper.setText(R.id.tv_CarveoutTime,"活动时间："+item.getZ_stime()+" - "+item.getZ_etime());

    }
}