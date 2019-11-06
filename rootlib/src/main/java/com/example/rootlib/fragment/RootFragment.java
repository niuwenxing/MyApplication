package com.example.rootlib.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
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

/**
 * Created by junweiliu on 17/3/31.
 */
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
     * 提示对话框
     */

    /**
     * 底部列表pop
     */

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

    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        // 获取键盘管理
        inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        //获取布局反射器
        mInflater = LayoutInflater.from(activity);
    }
    public View getLayoutFragment(){
        return mRootView;
    }

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


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // 初始化fragment，由子fragment具体实现
        init();
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 绑定布局文件
     *
     * @return 布局文件ID
     */
    protected abstract int attachLayoutRes();

    /**
     * onViewCreate时初始化调用
     */
    protected abstract void init();

    /**
     * 设置common_title_layout的标题
     *
     * @param str 标题名称
     */
    public void settitle(String str) {
//        TextView titleTv = mRootView.findViewById(R.id.tv_common_title);
//        if (titleTv != null) {
//            titleTv.setVisibility(View.VISIBLE);
//            titleTv.setText(str);
//        }
    }



    /**
     * 初始化异常布局
     */
    private void initThrowView() {
        if (throwLayout == null) {
            throwLayout = mRootView.findViewById(R.id.throw_layout);
        }
    }

    /**
     * 界面请求无数据展示页面
     */
    public void showNullMessageLayout(ThrowLayout.OnRetryListener listener) {
        setThrowLayout(ThrowLayout.STATUS_NO_DATA, listener);
    }

    /**
     * 显示Progress框
     */
    public void showProgress() {
        setThrowLayout(ThrowLayout.STATUS_LOADING, null);
    }

    /**
     * 隐藏Progress框
     */
    public void hideProgress() {
        setThrowLayout(ThrowLayout.STATUS_HIDE, null);
    }

    /**
     * 网络异常页面显示
     *
     * @param listener 重试监听
     */
    public void showNetErrorLayout(ThrowLayout.OnRetryListener listener) {
        setThrowLayout(ThrowLayout.STATUS_NO_NET, listener);
    }

    /**
     * 接口异常页面显示
     *
     * @param errMsg   错误信息
     * @param listener 重试的点击回调
     */
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

    public void baseFinish(int resultCode) {
        baseFinish(resultCode, null);
    }

    public void baseFinish(int resultCode, Intent data) {
        if (data != null) {
            getActivity().setResult(resultCode, data);
        } else {
            getActivity().setResult(resultCode);
        }
        getActivity().finish();
    }






    /**
     * 切换输入法输入
     */
    @Override
    public void toggleSoftInput() {
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 隐藏软键盘
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

    /**
     * 改变背景透明度
     *
     * @param bgAlpha 透明度
     */
//    @Override
//    public void backgroundAlpha(float bgAlpha) {
//        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
//        lp.alpha = bgAlpha; // 0.0-1.0
//        activity.getWindow().setAttributes(lp);
//    }

    /** ====================== start 公共提示对话框 ============================= */



    /**
     * 显示对话框
     * <p>
     * 弹出只有一个按钮的、其余属性自定义的对话框    <br>
     * 注意：canTouchOutside为true时，canCancel失效
     *
     * @param resId                   图片id
     * @param titleId                 标题
     * @param msgId                   通知内容
     * @param btnTextId               按钮文本
     * @param positionId              文本位置
     * @param positiveOnClickListener 确定点击事件
     * @param canCancel               点击返回键是否消息
     * @param canTouchOutside         点击dialog外部和返回键是否消失
     */


    /** ====================== end 公共提示对话框 ============================= */

    /** ====================== start 公共选择对话框 ============================= */



    /**
     * 显示接口异常的选择对话框
     *
     * @param errMsg                  错误信息
     * @param positiveOnClickListener 重试按钮的监听
     * @param negativeOnClickListener 返回按钮的监听
     */


    /**
     * 检验登录，未登录跳转登录
     *
     * @param requestCode 是否要求返回值
     * @return 返回是否登录
     */
    public boolean checkLogin(int requestCode) {
        return false;
    }

    /**
     * 检查是否登录
     *
     * @return true:登陆，false 未登录
     */
    @Override
    public boolean checkLogin() {
        return false;
    }

    /**
     * 隐藏异常布局  只需调用这个就可以了
     */
    public void hideExpectionPages() {
        if (throwLayout != null) {
            throwLayout.hide();
        }
    }

    /**
     * toast提示--短时间
     *
     * @param str 提示语
     */
    @Override
    public void toast(CharSequence str) {
        CToast.showShort(activity, str);
    }

    /**
     * toast提示--短时间
     *
     * @param id 提示语资源文件
     */
    @Override
    public void toast(int id) {
        toast(getString(id));
    }

    /**
     * toast提示--长时间
     *
     * @param str 提示语
     */
    @Override
    public void toastLong(CharSequence str) {
        CToast.showLong(activity, str);
    }

    /**
     * toast提示--长时间
     *
     * @param id 提示语资源文件
     */
    @Override
    public void toastLong(int id) {
        toastLong(getString(id));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }





}
