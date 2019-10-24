package com.example.rootlib.mvp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.rootlib.fragment.RootFragment;
import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class BaseFragment<V extends IBaseView,P extends BasePresenter> extends RootFragment implements IBaseView {

    protected P presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
    public void onDestroyView() {

        presenter.detachView();
        super.onDestroyView();
    }


}
