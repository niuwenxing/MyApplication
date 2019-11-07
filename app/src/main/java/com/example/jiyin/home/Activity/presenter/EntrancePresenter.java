package com.example.jiyin.home.Activity.presenter;

import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class EntrancePresenter<V extends IBaseView> extends BasePresenter<V> {

    public abstract void login();

    public abstract void userRegister(String toString, String toString1, String trim);

    public abstract void getCode(String phone);

    public abstract void userRetrieve(String toString, String toString1, String trim);
}
