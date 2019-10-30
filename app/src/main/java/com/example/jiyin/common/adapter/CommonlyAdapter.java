package com.example.jiyin.common.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class CommonlyAdapter<T> extends BaseAdapter {
    // 设置属性
    protected List<T> mDates;
    protected Context context;
    // 布局ID
    protected final int mLayoutId;

    // 创建构造方法
    public CommonlyAdapter(List<T> mDates, Context context, int mLayoutId) {
        this.mDates = mDates;
        this.context = context;
        this.mLayoutId = mLayoutId;
    }

    @Override
    public int getCount() {
        return mDates.size();
    }

    @Override
    public T getItem(int position) {
        return mDates.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 获取viewHolderHelper
        ViewHolderHelper viewHolderHelper = ViewHolderHelper
                .getViewHolderHelper(context, parent, convertView, mLayoutId,
                        position);
        convert(viewHolderHelper, getItem(position), position);
        return viewHolderHelper.getConvertView();
    }

    // 用于初始化viewHolderHelper中控件
    public abstract void convert(ViewHolderHelper viewHolderHelper, T item,
                                 int position);
}
