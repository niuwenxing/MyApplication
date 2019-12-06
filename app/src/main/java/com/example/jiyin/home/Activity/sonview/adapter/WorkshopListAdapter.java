package com.example.jiyin.home.Activity.sonview.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.home.Activity.sonview.base.WorkshopMainBase;

import java.util.List;

public class WorkshopListAdapter extends BaseQuickAdapter<WorkshopMainBase.DataBean.WorkshopBean,BaseViewHolder> {

    public WorkshopListAdapter( @Nullable List data) {
        super(R.layout.workshop_layout_item, data);
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, WorkshopMainBase.DataBean.WorkshopBean item) {
        helper.setText(R.id.workItem_table,item.getWork_title());
        helper.setText(R.id.workItem_time,item.getWork_time());
        helper.setText(R.id.workItem_context,item.getWork_content());
    }
}
