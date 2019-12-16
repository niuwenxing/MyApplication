package com.example.jiyin.home.Activity.sonview.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.home.Activity.sonview.base.PositionIndexBean;

import java.util.List;

public class OccupationalAdapter extends BaseQuickAdapter<PositionIndexBean.DataBean.PositionBean, BaseViewHolder> {
    public OccupationalAdapter(@Nullable List<PositionIndexBean.DataBean.PositionBean> data) {
        super(R.layout.item_position,data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, PositionIndexBean.DataBean.PositionBean item) {
        helper.setText(R.id.tv_Titlezhihu_str,item.getPosition_name()+"");
        helper.setText(R.id.tv_Salaryscale_str,item.getPosition_money()+"K");
        helper.setText(R.id.tv_companyName_str,item.getCname()+"");
        helper.setText(R.id.textView9,item.getPosition_site()+"");
        helper.setText(R.id.tv_Education_str,item.getEducation()+"");
    }
}
