package com.example.jiyin.home.fragment;

import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;

public class NewHomeFregment extends JiYingFragment<textView,hometextImpl> implements textView {

    public static final String NOSAK=NewHomeFregment.class.getName();

    @Override
    protected int attachLayoutRes() {
        return 0x001;
    }

    @Override
    protected void init() {
        super.init();
        mFunctionsManager.invokeFunction(NOSAK,0);
    }


}

interface textView extends IBaseView{

}

class hometextImpl extends textPresenter<textView> {
    /**
     * 网络访问单元
     */
    private BeanNetUnit homeUnit;

    @Override
    public void cancelBiz() {
        cancelRequest(homeUnit);

    }
}

abstract class textPresenter<V extends IBaseView> extends BasePresenter<V>{

}
