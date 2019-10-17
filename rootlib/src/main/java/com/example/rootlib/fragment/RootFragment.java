package com.example.rootlib.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rootlib.R;
import com.example.rootlib.config.AppConfig;
import com.example.rootlib.mvp.view.IBaseView;
import com.example.rootlib.utils.CToast;
import com.example.rootlib.utils.StringUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class RootFragment extends Fragment implements IBaseView {


    /**
     * 当前上下文实例
     */
    protected Activity activity;

    /**
     * 左上角返回键
     */
    protected View goBackView;

    /**
     * 布局缓存
     */
    protected View mRootView;

    /**
     * 把 ThrowLayout 放在基类统一处理
     * 可以为空
     */
    @Nullable
    protected ThrowLayout throwLayout;

    /**
     * 布局反射器
     */
    public LayoutInflater mInflater;

    /**
     * 输入法管理器
     */
    protected InputMethodManager inputMethodManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        // 获取键盘管理
        inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        //获取布局反射器
        mInflater = LayoutInflater.from(activity);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // 初始化fragment，由子fragment具体实现
        init();
        super.onActivityCreated(savedInstanceState);
    }
    /**
     * onViewCreate时初始化调用
     */
    protected abstract void init();
    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(attachLayoutRes(), container, false);
            unbinder = ButterKnife.bind(this, mRootView);
            // 初始化异常布局
            initThrowView();
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        return mRootView;
    }

    /**
     * 绑定布局文件
     *
     * @return 布局文件ID
     */
    protected abstract int attachLayoutRes();

    /**
     * 初始化异常布局
     */
    private void initThrowView() {
        if (throwLayout == null) {
            throwLayout = mRootView.findViewById(R.id.throw_layout);
        }
    }

    @Override
    public void toggleSoftInput() {

    }

    /**
     * 显示Progress框
     */
    @Override
    public void showProgress() {
        setThrowLayout(ThrowLayout.STATUS_LOADING, null);
    }
    /**
     * 隐藏Progress框
     */
    @Override
    public void hideProgress() {
        setThrowLayout(ThrowLayout.STATUS_HIDE, null);
    }

    /**
     * toast提示
     * @param str 提示语
     */
    @Override
    public void toast(CharSequence str) {
        CToast.showShort(activity, str);
    }

    @Override
    public void toast(int id) {
        toast(getString(id));
    }



    @Override
    public void toastLong(int id) {
        toastLong(getString(id));
    }

    @Override
    public void toastLong(CharSequence str) {
        CToast.showLong(activity, str);
    }

    @Override
    public boolean checkLogin() {
        return false;
    }

    @Override
    public boolean checkLogin(int requestCode) {
        return false;
    }

    @Override
    public void hideExpectionPages() {

    }

    /**
     * 界面请求无数据展示页面
     */
    @Override
    public void showNullMessageLayout(ThrowLayout.OnRetryListener listener) {
        setThrowLayout(ThrowLayout.STATUS_NO_DATA, listener);
    }






    /**
     * 网络异常页面显示
     *
     * @param listener 重试监听
     */
    @Override
    public void showNetErrorLayout(ThrowLayout.OnRetryListener listener) {
        setThrowLayout(ThrowLayout.STATUS_NO_NET, listener);
    }
    /**
     * 接口异常页面显示
     *
     * @param errMsg   错误信息
     * @param listener 重试的点击回调
     */
    @Override
    public void showSysErrLayout(String errMsg, ThrowLayout.OnRetryListener listener) {
        if (AppConfig.IS_SERVER_ERR_TOAST && !StringUtil.isEmpty(errMsg)) {         // 是否弹出错误信息
            toast(errMsg);
        }
        setThrowLayout(ThrowLayout.STATUS_SYS_ERR, listener);
    }

    /**
     * 重置异常布局
     */
    private void setThrowLayout(@ThrowLayout.EmptyStatus int emptyStatus, ThrowLayout.OnRetryListener listener) {
        try {
            throwLayout.setEmptyStatus(emptyStatus);
            throwLayout.setRetryListener(listener);
        } catch (Exception e) {
            if (AppConfig.DEVELOP_DEBUG_MODE) {
                CToast.showShort(activity, "未引入相关异常和loading布局");
            }
        }
    }

    @Override
    public void baseFinish() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }
    @Override
    public void baseFinish(int resultCode) {
        baseFinish(resultCode, null);
    }
    @Override
    public void baseFinish(int resultCode, Intent data) {
        if (data != null) {
            getActivity().setResult(resultCode, data);
        } else {
            getActivity().setResult(resultCode);
        }
        getActivity().finish();
    }

    /**
     * 键盘隐藏
     */
    public void hideSoftKeyboard() {
        inputMethodManager = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (activity.getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (activity.getCurrentFocus() != null)
                inputMethodManager.hideSoftInputFromWindow(activity
                                .getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(unbinder!=null){
            unbinder.unbind();
        }
    }
}
