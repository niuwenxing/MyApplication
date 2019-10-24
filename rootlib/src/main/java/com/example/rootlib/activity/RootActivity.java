package com.example.rootlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import com.example.rootlib.R;
import com.example.rootlib.config.AppConfig;
import com.example.rootlib.mvp.view.IBaseView;
import com.example.rootlib.permission.RequestPermissionListener;
import com.example.rootlib.utils.CToast;
import com.example.rootlib.utils.StringUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract   class RootActivity extends AppCompatActivity implements IBaseView {



    /**
     * 当前上下文实例
     */
    protected Activity activity;
    /**
     * 输入法管理器
     */
    protected InputMethodManager inputMethodManager;
    /**
     * 布局反射器
     */
    public LayoutInflater mInflater;
    /**
     * 已通过权限集合
     */
    List<String> passedPermissions = new ArrayList<>();
    /**
     * 未通过权限集合
     */
    List<String> unPassedPermissions = new ArrayList<>();
    /**
     * 允许权限列表
     */
    private Map<Integer, RequestPermissionListener> permissionListeners = new HashMap<>();

    private ThrowLayout throwLayout;

    /**
     * 绑定布局文件
     * @return 布局文件ID
     */
    @LayoutRes
    protected abstract int attachLayoutRes();
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 放大当前上下文
        activity = this;
        // 反射组件
        unbinder = ButterKnife.bind(this);
        // 绑定子类具体layout
        setContentView(attachLayoutRes());

        // 获取键盘管理
        inputMethodManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        // 获取布局反射器
        mInflater = LayoutInflater.from(activity);
        // 初始化异常布局
        initThrowView();
        init();

    }

    protected abstract void init();

    /**
     * 初始化异常布局
     */
    private void initThrowView() {
        if (throwLayout == null) {
            throwLayout = findViewById(R.id.throw_layout);
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
     * toast提示--短时间
     * @param str 提示语
     */
    @Override
    public void toast(CharSequence str) {
        CToast.showShort(activity, str);
    }

    @Override
    public void toast(int id) {

    }

    @Override
    public void toastLong(CharSequence c) {

    }

    @Override
    public void toastLong(int id) {

    }

    @Override
    public void baseFinish() {
        finish();
    }

    @Override
    public void baseFinish(int resultCode) {
        baseFinish(resultCode, null);
    }

    @Override
    public void baseFinish(int resultCode, Intent data) {
        if (data != null) {
            setResult(resultCode, data);
        } else {
            setResult(resultCode);
        }
        finish();
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
     * @param listener 重试监听
     */
    @Override
    public void showNetErrorLayout(ThrowLayout.OnRetryListener listener) {
        setThrowLayout(ThrowLayout.STATUS_NO_NET, listener);
    }

    /**
     * 接口异常页面显示
     * @param errMsg   错误信息
     * @param listener 重试的点击回调
     */
    @Override
    public void showSysErrLayout(String errMsg, ThrowLayout.OnRetryListener listener) {
        if (AppConfig.IS_SERVER_ERR_TOAST && !StringUtil.isEmpty(errMsg)) {// 是否弹出错误信息
            toast(errMsg);
        }
        setThrowLayout(ThrowLayout.STATUS_SYS_ERR, listener);
    }

    /**
     * 检查是否登录
     * @return 返回是否登录
     */
    @Override
    public boolean checkLogin() {
        return false;
    }

    /**
     * 检验登录，未登录跳转登录
     * @param requestCode 是否要求返回值
     * @return 返回是否登录
     */
    @Override
    public boolean checkLogin(int requestCode) {
        return false;
    }

    @Override
    public void hideExpectionPages() {
        if (throwLayout != null) {
            throwLayout.hide();
        }
    }

    /**
     * 按钮监听
     * @param keyCode 键
     * @param event   动作时间
     * @return boolean
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            baseFinish();
        }
        return super.onKeyDown(keyCode, event);
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
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder!=null) {
            unbinder.unbind();
        }
    }


    protected void requestPermission(int id, String[] permissions, RequestPermissionListener listener){
        if (listener == null || permissions == null || permissions.length == 0) {
            throw new IllegalArgumentException("permissionListener == null");
        }
        permissionListeners.put(id, listener);
        passedPermissions.clear();
        unPassedPermissions.clear();
        int targetSdkVersion = getTargetSdk();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<String> pers = new ArrayList<>();    //待申请集合

            for (int i = 0; i < permissions.length; i++) {
                int checkCallPhonePermission = -1;
                if (targetSdkVersion >= Build.VERSION_CODES.M) {    //target版本大于等于23
                    checkCallPhonePermission = ContextCompat.checkSelfPermission(getApplicationContext(),
                            permissions[i]);
                }else{
                    checkCallPhonePermission = PermissionChecker.checkSelfPermission(getApplicationContext(), permissions[i]);
                }

                if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {        //未通过
                    pers.add(permissions[i]);
                } else {                                                                    //已通过
                    passedPermissions.add(permissions[i]);
                }
            }

            if (pers.isEmpty()) {                           //全部都授过权
                listener.onPass(permissions);
                listener.onUnPass(null);}
            else{
                //弹出对话框接收权限
                ActivityCompat.requestPermissions(activity, pers.toArray(new String[pers.size()]), id);
            }

        }
        else{
            listener.onPass(permissions);
            listener.onUnPass(null);
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //循环判断
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                passedPermissions.add(permissions[i]);
            } else {
                unPassedPermissions.add(permissions[i]);
            }
        }
        //回调
        if (permissionListeners.get(requestCode) != null) {
            permissionListeners.get(requestCode).onPass(
                    passedPermissions.toArray(new String[passedPermissions.size()]));
            permissionListeners.get(requestCode).onUnPass(
                    unPassedPermissions.toArray(new String[unPassedPermissions.size()]));
        }

    }

    /**
     * 获取targetSdk版本号
     *
     * @return
     */
    private int getTargetSdk() {
        int targetSdkVersion = 0;
        try {
            final PackageInfo info = activity.getPackageManager().getPackageInfo(
                    activity.getPackageName(), 0);
            targetSdkVersion = info.applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return targetSdkVersion;
    }


    /**
     * 跳转到权限设置界面
     *
     * @return
     */
    public Intent getAppDetailSettingIntent() {
        //启动应用详情页
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        return intent;
    }


}
