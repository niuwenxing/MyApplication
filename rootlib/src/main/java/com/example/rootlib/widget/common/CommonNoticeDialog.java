package com.example.rootlib.widget.common;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import com.example.rootlib.R;
import com.example.rootlib.utils.DisplayUtil;
import com.example.rootlib.utils.StringUtil;

/**
 * 全局弹窗
 */

public class CommonNoticeDialog extends Dialog implements View.OnClickListener {

    private Context context;
    /**
     * 默认布局id
     */
    public static int default_layout_id = R.layout.layout_dialog_common_reminder;

    private TextView titleTv;
    private ImageView iconIv;
    private TextView contentTv;
    private Button positiveBtn;
    private Button cancelBtn;
    /**
     * 视图容器
     */
    FrameLayout containerFl;

    public CommonNoticeDialog(@NonNull Context context) {
        super(context, R.style.DialogStyle);
    }

    public CommonNoticeDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        setContentView(R.layout.layout_common_dialog);
        initView();
    }

    private void initView() {
        View content = LayoutInflater.from(context).inflate(default_layout_id, null);
        titleTv = findViewById(R.id.tv_notice_dialog_title);
        iconIv = findViewById(R.id.iv_notice_dialog_icon);
        contentTv = findViewById(R.id.tv_notice_dialog_content);
        positiveBtn = findViewById(R.id.btn_notice_dialog_confirm);
        cancelBtn = findViewById(R.id.btn_notice_dialog_cancel);
        cancelBtn.setOnClickListener(this);
        positiveBtn.setOnClickListener(this);


        containerFl = (FrameLayout) findViewById(R.id.fl_dialog_def_content);
        containerFl.removeAllViews();
        containerFl.addView(content);

    }

    public void setTitle(String title) {
        if (StringUtil.isEmpty(title)) {
            titleTv.setVisibility(View.GONE);
        } else {
            titleTv.setText(title);
            titleTv.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 设置图标，非法时隐藏
     *
     * @param resId Drawable资源文件
     */
    @SuppressLint("ResourceType")
    public void setIcon(@DrawableRes int resId){
        if (resId > 0) {
            iconIv.setImageResource(resId);
            iconIv.setVisibility(View.VISIBLE);
        } else {
            iconIv.setVisibility(View.GONE);
        }
    }

    /**
     * 设置确定按钮文字
     * @param title
     */
    public void setPosiText(String title){
        if (StringUtil.isEmpty(title)) {
            positiveBtn.setVisibility(View.GONE);
        } else {
            positiveBtn.setText(title);
            positiveBtn.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 设置消极按钮文字
     *
     * @param title
     */
    public void setNegText(String title) {
        if (StringUtil.isEmpty(title)) {
            cancelBtn.setVisibility(View.GONE);
        } else {
            cancelBtn.setText(title);
            cancelBtn.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 积极按钮监听
     */
    private OnClickListener positiveListener;
    /**
     * 消极按钮监听
     */
    private OnClickListener cancelListener;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_notice_dialog_confirm) {
            positiveListener.onClick(this, R.id.btn_notice_dialog_confirm);
        }
        if(v.getId()==R.id.btn_notice_dialog_confirm){
            cancelListener.onClick(this, R.id.btn_notice_dialog_cancel);
        }
    }

    /**
     * 设置弹框里显示的内容
     *
     * @param content 内容文字
     * @return TextView
     */
    public void setMessage(String content) {
        if (!StringUtil.isEmpty(content)) {
            contentTv.setText(content);

            contentTv.setVisibility(View.VISIBLE);
        } else {
            contentTv.setVisibility(View.GONE);
        }
    }

    /**
     * 设置内容文本的位置
     *
     * @param gravity
     */
    public void setContentPosi(int gravity) {
        contentTv.setGravity(gravity);
    }


    /**
     * 设置取消事件监听
     *
     * @param listener 监听器
     */
    public void setCancelBtnListener(OnClickListener listener) {
        this.cancelListener = listener;
    }


    /**
     * 设置 点击确定按钮 事件监听
     *
     * @param listener 监听器
     */
    public void setPositiveBtnListener(OnClickListener listener) {
        this.positiveListener = listener;
    }

    /**
     * 预留按钮监听
     */
    private OnClickListener prepareListener;
    /**
     * 设置 点击预留按钮 事件监听
     *
     * @param listener 监听器
     */
    public void setPrepareBtnListener(OnClickListener listener) {
        this.prepareListener = listener;
    }


    /**
     * 获取弹框内容视图
     *
     * @return ViewGroup
     */
    public ViewGroup getContentView() {
        return containerFl;
    }

    /**
     * 获取消息文本内容
     *
     * @return String
     */
    public String getContent() {
        return this.contentTv.getText().toString();
    }

    /**
     * 内容文本字体大小
     */
    private float mContentTextSize = 0;
    /**
     * 设置Message的字体大小
     *
     * @param size
     */
    public void setMessageTextSize(float size) {
        if (size > 0) {
            contentTv.setTextSize(DisplayUtil.sp2px(context, mContentTextSize));
        }

    }

    public void setMessageTextColor(int colorId) {
        if (colorId != 0) {
            contentTv.setTextColor(colorId);
        }
    }

    @Override
    public void show() {
        try {
            super.show();
        } catch (WindowManager.BadTokenException e) {
            this.dismiss();
        } catch (IllegalStateException e1) {
            this.dismiss();
        }
    }

}
