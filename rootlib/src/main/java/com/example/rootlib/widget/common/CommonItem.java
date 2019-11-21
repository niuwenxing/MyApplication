package com.example.rootlib.widget.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.rootlib.R;

/**
 * Created by Administrator on 2018/4/18.
 */

public class CommonItem extends RelativeLayout {
    public Switch switchBtn;
    public ImageView rightImgView, leftImg;
    public TextView rightText, titleTv;
    public TextView hint;


    public CommonItem(Context context) {
        super(context);
        init(context, null);
    }

    public CommonItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CommonItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @SuppressLint("NewApi")
    public CommonItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CommonItem);
        Drawable imgLeft = ta.getDrawable(R.styleable.CommonItem_img_src);
        int dividerVis = ta.getInt(R.styleable.CommonItem_dividerVis, View.VISIBLE);
        int imgVis = ta.getInt(R.styleable.CommonItem_img_vis, View.GONE);
        String titleStr = ta.getString(R.styleable.CommonItem_title_text);
        int titleVis = ta.getInt(R.styleable.CommonItem_title_vis, View.GONE);
        String hintStr = ta.getString(R.styleable.CommonItem_hint_text);
        int hintVis = ta.getInt(R.styleable.CommonItem_hint_vis, View.GONE);
        String rightStr = ta.getString(R.styleable.CommonItem_right_text);
        int rightTxtVis = ta.getInt(R.styleable.CommonItem_right_text_vis, View.GONE);
        Drawable rightImg = ta.getDrawable(R.styleable.CommonItem_right_img);
        int rightImgVis = ta.getInt(R.styleable.CommonItem_right_img_vis, View.GONE);
        int rightSwitchVis = ta.getInt(R.styleable.CommonItem_right_switch_vis, View.GONE);
        int lines = ta.getInt(R.styleable.CommonItem_right_txt_line, 1);
        int titleSize = ta.getInteger(R.styleable.CommonItem_title_size, 15);
        int hintSize = ta.getInteger(R.styleable.CommonItem_hint_size, 14);
        int rightSize = ta.getInteger(R.styleable.CommonItem_right_size, 13);
        int titleColor = ta.getColor(R.styleable.CommonItem_title_color, context.getResources().getColor(R.color.txt_light_gray));
        int hintColor = ta.getColor(R.styleable.CommonItem_hint_color, context.getResources().getColor(R.color.hint_text_color));
        int rightColor = ta.getColor(R.styleable.CommonItem_right_color, context.getResources().getColor(R.color.hint_text_color));
//        int maxLength = ta.getInteger(R.styleable.CommonItem_title_text, 0);

        ta.recycle();

        LayoutInflater.from(context).inflate(R.layout.item_setting_common, this);
        leftImg = findViewById(R.id.img_left);
        titleTv = findViewById(R.id.tv_item_title);
        hint = findViewById(R.id.tv_item_hint);
        rightImgView = findViewById(R.id.img_item_next);
        rightText = findViewById(R.id.tv_item_next);
        switchBtn = findViewById(R.id.switch_item_next);
        View divider = findViewById(R.id.item_divider);


        leftImg.setVisibility(imgVis);
        if (imgLeft != null) {
            leftImg.setImageDrawable(imgLeft);
        }
        titleTv.setText(TextUtils.isEmpty(titleStr) ? "" : titleStr);
        titleTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, titleSize);
        titleTv.setTextColor(titleColor);
        titleTv.setVisibility(titleVis);
//        if (maxLength > 0) {
//            titleTv.setMaxEms(maxLength);
//            titleTv.setEllipsize(TextUtils.TruncateAt.END);
//        }
        hint.setVisibility(hintVis);
        hint.setText(TextUtils.isEmpty(hintStr) ? "" : hintStr);
        hint.setTextColor(hintColor);
        hint.setTextSize(TypedValue.COMPLEX_UNIT_SP, hintSize);
        rightImgView.setVisibility(rightImgVis);
        if (rightImg != null) {
            rightImgView.setImageDrawable(rightImg);
        }
        rightText.setText(TextUtils.isEmpty(rightStr) ? "" : rightStr);
        rightText.setVisibility(rightTxtVis);
        if (rightImgVis == 0) {
            rightText.setPadding(40, 0, 25, 0);
        }
        switchBtn.setVisibility(rightSwitchVis);
        rightText.setMaxLines(lines);
        rightText.setEllipsize(TextUtils.TruncateAt.END);
        rightText.setTextSize(TypedValue.COMPLEX_UNIT_SP, rightSize);
        rightText.setTextColor(rightColor);

        divider.setVisibility(dividerVis);
    }
}
