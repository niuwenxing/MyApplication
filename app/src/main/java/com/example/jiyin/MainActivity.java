package com.example.jiyin;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.R;
import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public class MainActivity extends JiYingActivity<Iview,IpImpl> implements Iview {

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void createPresenter() {
        presenter =new IpImpl();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.getUIM();

    }


}
interface Iview extends IBaseView {

}

class IpImpl extends IPrese<Iview>{

    @Override
    public void cancelBiz() {

    }

    @Override
    public void getUIM() {

    }
}

abstract class IPrese<V extends IBaseView> extends BasePresenter<V> {

    public abstract void getUIM();
}



