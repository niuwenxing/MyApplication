package com.example.jiyin.common.activity;



import com.example.jiyin.common.widget.DefaultPresenterImpl;
import com.example.rootlib.mvp.fragment.BaseFragment;
import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public abstract class JiYingFragment<V extends IBaseView,P extends BasePresenter<V>> extends BaseFragment<V,P> {


    @Override
    protected void createPresenter() {
        presenter=(P) new DefaultPresenterImpl();
    }
}
