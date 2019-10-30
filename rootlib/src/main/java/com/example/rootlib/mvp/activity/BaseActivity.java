package com.example.rootlib.mvp.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.rootlib.activity.RootActivity;
import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class BaseActivity<V extends IBaseView,P extends BasePresenter<V>> extends RootActivity  {

    protected  P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();
        presenter.attachView((V) this, activity);
    }

    protected abstract void createPresenter();

    protected void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    protected P getPresenter() {
        return presenter;
    }


    @Override
    protected void onDestroy() {
        if (presenter!=null) {
            presenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
    }
}
