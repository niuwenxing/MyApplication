package com.example.jiyin.common.activity;

import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.rootlib.mvp.activity.BaseActivity;
import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

import me.jessyan.autosize.AutoSizeCompat;

public abstract class JiYingActivity<V extends IBaseView,P extends BasePresenter<V>> extends BaseActivity<V,P> {

    private ConnectivityManager cm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkNetWork();
        init();
    }

    @Override
    protected void init() {

    }

    public void checkNetWork() {
        NetworkInfo netIntfo = null;
        try {
            cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
            netIntfo = cm.getActiveNetworkInfo();
        } catch (Exception e) {
            //异常处理
            Toast.makeText(this, "没有网络权限，请给予相关权限", Toast.LENGTH_LONG).show();

        }

        if (netIntfo == null) {
            //如果没有网络 显示不正常
            toast("暂时没有网络，请是否连接检查网络");
        } else {
            //如果没有网络 显示不正常
//            text = act.getResources().getString(R.string.netWerk_0);
//            color = act.getResources().getColor(R.color.beige);

        }
    }

    @Override
    public Resources getResources() {
        //需要升级到 v1.1.2 及以上版本才能使用 AutoSizeCompat
        AutoSizeCompat.autoConvertDensityOfGlobal(super.getResources());//如果没有自定义需求用这个方法
        AutoSizeCompat.autoConvertDensity(super.getResources(), 667, false);//如果有自定义需求就用这个方法
        return super.getResources();
    }
}
