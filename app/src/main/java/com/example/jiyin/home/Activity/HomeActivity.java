package com.example.jiyin.home.Activity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.home.fragment.NewHomeFregment;
import com.example.jiyin.home.presenter.Impl.HomePresenterImpl;
import com.example.jiyin.home.presenter.view.HomeView;
import com.example.jiyin.utils.intefacestruct.FunctionWithParamAndResult;
import com.example.jiyin.utils.intefacestruct.FunctionsManager;
import com.example.myapplication.R;


public class HomeActivity extends JiYingActivity<HomeView, HomePresenterImpl> implements HomeView {

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            presenter.getUserDate("123");



        }
        @Override
        protected void init() {
            super.init();
        }

        @Override
        protected void createPresenter() {
            presenter=new HomePresenterImpl();
        }


        @Override
        protected int attachLayoutRes() {
            return R.layout.activity_home;
        }

    /**
     * 接口回调
     * @param tag
     */
    public void setFunctionForFragment(String tag) {
         FragmentManager fm = getSupportFragmentManager();
         JiYingFragment fragmentByTag = (JiYingFragment) fm.findFragmentByTag(tag);
         fragmentByTag.setmFunctionsManager( FunctionsManager.getInstance().addFunction(new FunctionWithParamAndResult<String,String>(NewHomeFregment.NOSAK) {
             @Override
             public String function(String o) {
                 return "";
             }
         }));
    }


}
