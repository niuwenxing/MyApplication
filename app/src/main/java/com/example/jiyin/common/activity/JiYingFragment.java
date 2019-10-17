package com.example.jiyin.common.activity;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.jiyin.common.widget.DefaultPresenterImpl;
import com.example.jiyin.home.Activity.HomeActivity;
import com.example.jiyin.utils.intefacestruct.FunctionsManager;
import com.example.rootlib.mvp.fragment.BaseFragment;
import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class JiYingFragment<V extends IBaseView,P extends BasePresenter<V>> extends BaseFragment<V,P> {


    @Override
    protected void createPresenter() {
        presenter=(P) new DefaultPresenterImpl();
    }

    @Override
    protected void init() {

    }

    HomeActivity homeActivity;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof HomeActivity){
            homeActivity=(HomeActivity)context;
            homeActivity.setFunctionForFragment(getTag());
        }
    }

    protected FunctionsManager mFunctionsManager;
    public void setmFunctionsManager(FunctionsManager mFunctionsManager){
        this.mFunctionsManager=mFunctionsManager;
    }

}
