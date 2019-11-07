package com.example.jiyin.home.fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;

import java.util.List;

public class SlideRecyAdapter<T> extends BaseRecyclerViewAdapter<T> {

    private List<T> datas;

    public SlideRecyAdapter(Context context, List<T> data) {
        super(context, data, R.layout.newstarget_item);
        this.datas=data;
    }

    @Override
    protected void onBindData(RecyclerViewHolder holder, T bean, int position) {
        TextView xiaoxi = holder.itemView.findViewById(R.id.tv_information);
        xiaoxi.setText(datas.get(position)+"");
        RelativeLayout mRelativeLayout = holder.itemView.findViewById(R.id.itemNews);
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.onClick(v,position);
                }
            }
        });
        View view = holder.itemView.findViewById(R.id.tv_delete);
        view.setTag(position);
        view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (mDeleteClickListener != null) {
                   mDeleteClickListener.onDeleteClick(v, (Integer) v.getTag());
               }
           }
        });


    }

    //删除
    private OnDeleteClickLister mDeleteClickListener;
    public void setOnDeleteClickListener(OnDeleteClickLister listener) {
        this.mDeleteClickListener = listener;
    }
    public interface OnDeleteClickLister {
        void onDeleteClick(View view, int position);
    }
    //点击用户事件返回
    private OnClickLister mClickListener;
    public void setOnClickListener(OnClickLister listener) {
        this.mClickListener = listener;
    }
    public interface OnClickLister {
        void onClick(View view, int position);
    }
}
