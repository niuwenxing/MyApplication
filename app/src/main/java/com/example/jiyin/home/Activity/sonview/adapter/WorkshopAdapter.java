package com.example.jiyin.home.Activity.sonview.adapter;

import android.content.Context;

import com.example.jiyin.R;
import com.example.jiyin.home.Activity.adapter.AbsRecycleAdapter;
import com.example.jiyin.home.Activity.sonview.base.WorkshopLabelBase;

public class WorkshopAdapter extends AbsRecycleAdapter<WorkshopLabelBase.DataBean> {

    private Context context;

    public WorkshopAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.circleitem;
    }

    @Override
    public void convert(VH holder, WorkshopLabelBase.DataBean data, int position) {
        holder.setText(R.id.CircleText,data.getIfication_title());
        holder.setBackgroundResource(R.id.CircleText,data.isChecked()?R.drawable.tablayouts:R.drawable.tablayout);
        holder.setTextColor(R.id.CircleText,data.isChecked()?context.getResources().getColor(R.color.white):context.getResources().getColor(R.color.colorCel));
    }
}
