package com.example.jiyin.home.Activity.adapter;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.MLImageView;
import com.example.jiyin.home.Activity.sonview.base.ClassifyIndexBean;

import java.util.List;

public class ProjectAdapter extends BaseQuickAdapter<ClassifyIndexBean.DataBean, BaseViewHolder> {

    public ProjectAdapter( @Nullable List<ClassifyIndexBean.DataBean> data) {
        super(R.layout.project_item, data);
    }
    @Override
    protected void convert(@NonNull BaseViewHolder helper, ClassifyIndexBean.DataBean item) {
        helper.setText(R.id.tv_projectContext,item.getNew_title());
        helper.setText(R.id.tv_projectTime,item.getNew_time());
        Glide.with(mContext).load(BaseConfig.ROOT_IMAGES_API+item.getPath()).into((MLImageView) helper.getView(R.id.img_projectImage));

    }
}
