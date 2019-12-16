package com.example.jiyin.home.Activity.sonview.activity;

import android.content.Context;

import com.example.jiyin.R;
import com.example.jiyin.home.Activity.adapter.AbsRecycleAdapter;
import com.example.jiyin.home.Activity.sonview.base.VideoindexBean;

class IfIcationAdapter extends AbsRecycleAdapter<VideoindexBean.DataBean.IficationBean> {

    private Context context;

    public IfIcationAdapter(Context contexts) {
        this.context=contexts;
    }


    @Override
    public int getLayoutId(int viewType) {
        return R.layout.circleitem;
    }

    @Override
    public void convert(VH holder, VideoindexBean.DataBean.IficationBean data, int position) {
        holder.setText(R.id.CircleText,data.getIfication_title());
        holder.setBackgroundResource(R.id.CircleText,data.isChecked()?R.drawable.tablayouts:R.drawable.tablayout);
        holder.setTextColor(R.id.CircleText,data.isChecked()?context.getResources().getColor(R.color.white):context.getResources().getColor(R.color.colorCel));

    }
}
