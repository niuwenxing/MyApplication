package com.example.jiyin.common.activity;

import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.jiyin.R;
import com.example.jiyin.common.widget.DefaultPresenterImpl;
import com.example.rootlib.mvp.activity.BaseActivity;
import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.jessyan.autosize.AutoSizeCompat;

public abstract class JiYingActivity<V extends IBaseView,P extends BasePresenter<V>> extends BaseActivity<V,P> {

    private ConnectivityManager cm;
    /**
     * 上次点击退出计时
     */
    private long firstClickTime = 0L;
    private Unbinder bind;
    /**
     * 标记是否是首页
     */
    private boolean isHome = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ButterKnife.bind(this);
        checkNetWork();

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

    @Override
    protected void createPresenter() {
        presenter = (P) new DefaultPresenterImpl();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    /**
     * 设置当前是首页
     * @param home
     */
    public void setHome(boolean home) {
        isHome = home;
    }

    /**
     * 两次点击退出
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && isHome ) {
            if ((System.currentTimeMillis() - firstClickTime) > 2000) {
                firstClickTime = System.currentTimeMillis();
                toast(R.string.common_exit_warn);
                return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }


}
