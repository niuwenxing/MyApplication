package com.example.rootlib.widget.common;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.rootlib.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ThirteenYao on 2017/5/4.
 * 异常布局，包括加载中，接口异常，网络异常，空数据
 */

public class ThrowLayout extends FrameLayout {

    //隐藏所有的异常界面
    public static final int STATUS_HIDE = 1001;
    //加载
    public static final int STATUS_LOADING = 1002;
    //没有网络
    public static final int STATUS_NO_NET = 1003;
    //空数据
    public static final int STATUS_NO_DATA = 1004;
    //系统异常
    public static final int STATUS_SYS_ERR = 1005;
    /**
     * 页面异常展示的View
     */
    View throwStubView;

    private Context mContext;

    private TextView textView;

    private OnRetryListener mOnRetryListener;


    /**
     * Loading框--暂用
     */
    protected Dialog loadingDialog;
    /**
     * 自定义loading获取器
     */
    private CustomerProgressCreator progressCreator;


    public ThrowLayout(@NonNull Context context) {
        super(context);
    }

    public ThrowLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    private void init() {
        View.inflate(mContext, R.layout.layout_common_frame, this);
        switchEmptyView();

    }

    /**
     * 隐藏视图
     */
    public void hide() {
        mStatus = STATUS_HIDE;
        switchEmptyView();
    }

    @Retention(RetentionPolicy.SOURCE)   //这种类型的Annotations只在源代码级别保留,编译时就会被忽略
    @IntDef({STATUS_LOADING, STATUS_NO_NET, STATUS_NO_DATA, STATUS_SYS_ERR, STATUS_HIDE})
    //避免使用枚举
    public @interface EmptyStatus {
    }
    /**
     * 设置状态
     * @param emptyStatus 异常状态
     */
    public void setEmptyStatus(@EmptyStatus int emptyStatus) {
        mStatus = emptyStatus;
        switchEmptyView();
    }
    /**
     * 获取状态
     *
     * @return 状态
     */
    public int getEmptyStatus() {
        return mStatus;
    }
    /**
     * 切换异常视图
     * 状态  默认是隐藏
     */
    private int mStatus = STATUS_HIDE;
    private void switchEmptyView() {
        switch (mStatus) {
            case STATUS_LOADING:                   //加载中
                setVisibility(VISIBLE);
                if (throwStubView != null) {       //=null的时候证明还没加载就不用GONE 掉了
                    throwStubView.setVisibility(GONE);
                }
                showProgress();
                break;
            case STATUS_NO_DATA:                   //无数据
                setVisibility(VISIBLE);
                hideProgress();
                inflateLayout(STATUS_NO_DATA);
                break;
            case STATUS_NO_NET:                    //网络异常
                setVisibility(VISIBLE);
                hideProgress();
                inflateLayout(STATUS_NO_NET);
                break;
            case STATUS_SYS_ERR:                   //接口异常
                setVisibility(VISIBLE);
                hideProgress();
                inflateLayout(STATUS_SYS_ERR);
                break;
            case STATUS_HIDE:                     //隐藏所有布局
                hideProgress();
                setVisibility(GONE);
                break;
            default:
                break;
        }
    }


    /**
     * 点击重试监听器
     */
    public interface OnRetryListener {
        void onRetry();
    }

    /***
     * 加载中 showDialog
     */
    private void showProgress() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            return;
        } else {
            if (progressCreator != null) {
                loadingDialog = progressCreator.getPrgressDialog();
            }
            if (loadingDialog == null) {
                loadingDialog = CommonProgressDialog.create(mContext, mContext.getString(R.string.app_name));
                loadingDialog.setCancelable(true);
                loadingDialog.setCanceledOnTouchOutside(false);
            }

            loadingDialog.show();
        }
    }
    /**
     * 隐藏showDialog
     */
    private void hideProgress() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    private void inflateLayout(@EmptyStatus int status) {
        if (throwStubView == null) {
            ViewStub temp = (ViewStub) findViewById(R.id.stub_throw);
            throwStubView = temp.inflate();

        }
            textView = findViewById(R.id.btn_net_again);
            switch (status) {
                case STATUS_NO_DATA:       //空数据异常加载布局
                    textView.setText("刷新、暂无数据");
                    break;
                case STATUS_SYS_ERR:      //接口异常加载布局
                    textView.setText("数据异常");
                    break;
                case STATUS_NO_NET:      //网络异常加载布局
                    textView.setText("再试一次、网络不好");
                    break;
            }
            throwStubView.setVisibility(VISIBLE);
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnRetryListener!=null) {
                        mOnRetryListener.onRetry();
                    }
                }
            });


    }

    public void setRetryListener(OnRetryListener retryListener) {
        this.mOnRetryListener = retryListener;
    }

    /**
     * 获取用户自定义dialog
     */
    public interface CustomerProgressCreator {
        Dialog getPrgressDialog();
    }

    public void setProgressCreator(CustomerProgressCreator progressCreator) {
        this.progressCreator = progressCreator;
    }


}
