package com.example.jiyin.home.fragment.adapter;

import android.content.Context;

import com.example.jiyin.R;
import com.example.jiyin.home.Activity.adapter.AbsRecycleAdapter;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.luck.picture.lib.tools.Constant;

public class CircleAdapter extends AbsRecycleAdapter<CirclelabelBean.DataBean> {

    private Context context;

    public CircleAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.circleitem;
    }

    @Override
    public void convert(VH holder, CirclelabelBean.DataBean data, int position) {
        holder.setText(R.id.CircleText,data.getIfication_title());
        holder.setBackgroundResource(R.id.CircleText,data.isChecked()?R.drawable.tablayouts:R.drawable.tablayout);
        holder.setTextColor(R.id.CircleText,data.isChecked()?context.getResources().getColor(R.color.white):context.getResources().getColor(R.color.colorCel));
    }
}
