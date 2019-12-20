package com.example.jiyin.home.Activity.sonview.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.StudyAgencyIndexBean;

import java.util.List;

public class StudyAgencyApdpter extends BaseQuickAdapter<StudyAgencyIndexBean.DataBean.OnlineBean, BaseViewHolder> {


    public StudyAgencyApdpter( @Nullable List<StudyAgencyIndexBean.DataBean.OnlineBean> data) {
        super(R.layout.studyageny_item, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, StudyAgencyIndexBean.DataBean.OnlineBean item) {
        helper.setText(R.id.tv_topItemTitle,item.getOnline_title());
        helper.setText(R.id.tv_SpecialityStr,item.getOnline_label());
        helper.setText(R.id.tv_volumeStr,item.getOnline_num()+"");
        helper.setText(R.id.tv_topTime,item.getOnline_time());
        helper.setText(R.id.tv_heat,"热度"+item.getOnline_hot()+"");
        Glide.with(mContext).load(BaseConfig.ROOT_IMAGES_API+item.getOnline_path()).into((ImageView) helper.getView(R.id.ml_topImg));

    }
}
