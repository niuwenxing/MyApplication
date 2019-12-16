package com.example.jiyin.home.Activity.sonview.activity;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.VideoindexBean;
import com.example.jiyin.utils.ConstantUtil;

import java.util.List;

class videoListAdapter extends BaseQuickAdapter<VideoindexBean.DataBean.VideoBean, BaseViewHolder> {


    public videoListAdapter(@Nullable List<VideoindexBean.DataBean.VideoBean> data) {
        super(R.layout.top_item,data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, VideoindexBean.DataBean.VideoBean item) {
        helper.setText(R.id.tv_topItemTitle,item.getVideo_title());//标题
        helper.setText(R.id.tv_SpecialityStr,item.getVideo_label());//标签
        helper.setText(R.id.tv_videoNum,item.getHeat_num()+"");//播放量
        helper.setText(R.id.tv_topTime,item.getVideo_time()+"");//时间
        helper.setText(R.id.tv_heat,item.getHeat_num()+"");//热度
        Glide.with(mContext).load(BaseConfig.ROOT_IMAGES_API+item.getVideo_path()).into((ImageView) helper.getView(R.id.ml_topImg));


    }


}
