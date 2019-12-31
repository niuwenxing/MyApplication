package com.example.jiyin.home.fragment.adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jiyin.R;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.IndexindexBean;

import org.w3c.dom.Text;

import java.util.List;


public class CoverFlowAdapter extends RecyclerView.Adapter<CoverFlowAdapter.ViewHolder> {

    private List<IndexindexBean.DataBean.ProjectBean> list;
    private Context context;

    public CoverFlowAdapter(List<IndexindexBean.DataBean.ProjectBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public CoverFlowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homewheelplanting_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoverFlowAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(BaseConfig.ROOT_IMAGES_API+list.get(position).getPath()).into(holder.ivhomeimg);

        holder.tv_textTitle.setText(list.get(position).getNew_title());

        holder.textString.setText(context.getString(R.string.reduStr)+list.get(position).getNew_hot());

        holder.tv_introduce.setText(""+list.get(position).getNew_vice());


    }
    @Override
    public int getItemCount() { return list.size(); }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivhomeimg;
        private final TextView tv_textTitle;
        private final TextView tv_introduce;
        private final TextView textString;
        private final TextView tv_contextText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivhomeimg = (ImageView)itemView.findViewById(R.id.iv_homeimg);
            tv_textTitle = itemView.findViewById(R.id.tv_textTitle);
            tv_introduce = itemView.findViewById(R.id.tv_introduce);
            textString = itemView.findViewById(R.id.textString);
            tv_contextText = itemView.findViewById(R.id.tv_ContextText);

        }
    }

    public static class MyLayoutManager extends LinearLayoutManager{

        public MyLayoutManager(Context context) {
            super(context);
        }
        @Override
        public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
            View view = recycler.getViewForPosition(0);
            if(view != null){
                measureChild(view, widthSpec, heightSpec);
                int measuredWidth = View.MeasureSpec.getSize(widthSpec);
                int measuredHeight = view.getMeasuredHeight();
                setMeasuredDimension(measuredWidth, measuredHeight);
            }
        }

    }

}
