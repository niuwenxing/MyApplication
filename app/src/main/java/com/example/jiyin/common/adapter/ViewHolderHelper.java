package com.example.jiyin.common.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Spanned;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rootlib.utils.StringUtil;

import java.util.List;


public class ViewHolderHelper {
    // 用于获取初始化的控件集合
    private SparseArray<View> mViews = new SparseArray<View>();
    private int mPosition;
    private View mConvertView;
    private Context mContext;

    // 设置CheckBox回调
    public interface checkBoxOnClickListener {
        void checked(int price);

        void Unchecked(int price);
    }


    public ViewHolderHelper(Context context, ViewGroup parent, int layoutId,
                            int positon) {

        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        mConvertView.setTag(this);
        mContext = context;
    }

    public static ViewHolderHelper getViewHolderHelper(Context context,
                                                       ViewGroup parent, View convertview, int layoutId, int position) {
        if (null == convertview) {
            return new ViewHolderHelper(context, parent, layoutId, position);
        } else {
            ViewHolderHelper viewHolderHelper = (ViewHolderHelper) convertview
                    .getTag();
            // 重置当前的位置
            viewHolderHelper.mPosition = position;
            return viewHolderHelper;
        }
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            // 初始化完成过的控件放入已经存在集合中,避免重复初始化控件
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

    // 添加扩展功能

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolderHelper setText(int viewId, String text) {
        TextView mTextView = getView(viewId);
        if (!StringUtil.isEmpty(text)) {
            mTextView.setText(text);
        } else {
            mTextView.setText("");
        }


        return this;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolderHelper setText(int viewId, Spanned text) {
        TextView mTextView = getView(viewId);
        mTextView.setText(text);
        return this;
    }

    /**
     * 为TextView设置时间
     *
     * @param viewId
     * @param time
     * @return
     */
    public ViewHolderHelper setTimeText(int viewId, String time) {
        TextView mTextView = getView(viewId);
        if (!StringUtil.isEmpty(time)) {
            mTextView.setText(time);
        } else {
            mTextView.setText("--");
        }
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolderHelper setImageResource(int viewId, int drawableId) {
        ImageView mImageview = getView(viewId);
        mImageview.setImageResource(drawableId);
        return this;
    }


    /**
     * 为ImageView设置bitmap图片
     *
     * @param viewId
     * @param bm
     * @return
     */
    public ViewHolderHelper setImageBitmap(int viewId, Bitmap bm) {
        ImageView miImageview = getView(viewId);
        miImageview.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置网络图片
     *
     * @param viewId
     * @param url
     * @return
     */
    public ViewHolderHelper setImageByUrl(int viewId, String url) {
//        Glide.with(mContext)
//                .load(url)
//                .into((ImageView) getView(viewId));
        return this;
    }

    /**
     * 为ImageView设置网络图片
     *
     * @param viewId
     * @param url
     * @param resid  默认显示图片资源
     * @return
     */
    public ViewHolderHelper setImageByUrl(int viewId, String url, int resid) {
        // TODO: 2019/10/28  tupainweidingyi
//        GlideApp.with(mContext)
//                .load(url)// .dontAnimate()
//                .placeholder(resid)
//                .error(resid)
//                .into((ImageView) getView(viewId));
        return this;
    }

    /**
     * 为ImageView设置是否显示
     *
     * @param viewId
     * @param visable
     * @return
     */
    public ViewHolderHelper setImageVisable(int viewId, boolean visable) {
        ImageView miImageview = getView(viewId);
        if (visable) {
            miImageview.setVisibility(View.VISIBLE);
        } else {
            miImageview.setVisibility(View.GONE);
        }
        return this;
    }

    /**
     * 为CheckBox添加处理
     *
     * @param viewId
     * @param mCheckBoxStatus
     * @param price
     * @return
     */
    public ViewHolderHelper setCheckBoxChecked(int viewId,
                                               final List<Integer> mCheckBoxStatus, final int position,
                                               final int price) {
        final CheckBox mCheckBox = getView(viewId);
        mCheckBox.setChecked(false);
        if (mCheckBoxStatus.contains(position)) {
            mCheckBox.setChecked(true);
        }
        mCheckBox.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (mCheckBox.isChecked()) {
                    listener.checked(price);
                    mCheckBoxStatus.add(position);
                } else {
                    listener.Unchecked(price);
                    mCheckBoxStatus.remove((Integer) position);
                }
            }
        });
        return this;
    }


    /**
     * 用于接收回调接口
     */
    private checkBoxOnClickListener listener;

    /**
     * 预留接口
     */
    public void setCheckBoxOnClickListener(
            checkBoxOnClickListener cheBoxOnClickListener) {
        listener = cheBoxOnClickListener;
    }

    /**
     * 绑定点击事件
     */
    public void setOnClickListener(int viewId, OnClickListener listener){
        View v = getView(viewId);
        if (v != null){
            v.setOnClickListener(listener);
        }
    }

    /**
     * 返回当前位置
     */
    public int getPosition() {
        return mPosition;
    }
}
