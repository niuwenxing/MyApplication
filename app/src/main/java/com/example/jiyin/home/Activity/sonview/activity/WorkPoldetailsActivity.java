package com.example.jiyin.home.Activity.sonview.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.MLImageView;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.homeview.base.UserCircleUpBean;
import com.example.jiyin.home.Activity.presenter.impl.WorkshopImpl;
import com.example.jiyin.home.Activity.presenter.view.WorkshopView;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.Activity.sonview.base.UsercircleDetailBean;
import com.example.jiyin.utils.ConstantUtil;
import com.gyf.immersionbar.ImmersionBar;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 圈子个人详情
 */

public class WorkPoldetailsActivity extends JiYingActivity<WorkshopView, WorkshopImpl> implements WorkshopView {

    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.relativeLayout3)
    RelativeLayout relativeLayout3;
    @BindView(R.id.headview)
    View headview;
    @BindView(R.id.callback)
    ImageView callback;
    @BindView(R.id.tv_followtitle)
    TextView tvFollowtitle;
    @BindView(R.id.tv_follow_btn)
    TextView tvFollowBtn;
    @BindView(R.id.MLImageView)
    com.example.jiyin.common.widget.MLImageView MLImageView;
    @BindView(R.id.constraintLayout2)
    ConstraintLayout constraintLayout2;
    @BindView(R.id.listtagNunber)
    TextView listtagNunber;
    @BindView(R.id.quanzi_RecyclerView)
    RecyclerView quanziRecyclerView;
    private int circleId;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_work_poldetails;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new WorkshopImpl();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ImmersionBar.with(this).navigationBarColor(R.color.colorMenu).init();
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        ImmersionBar.setStatusBarView(this, headview);
        circleId = getIntent().getIntExtra(ConstantUtil.KEY_CODE, BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);


    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    public void returnLabel(List<CirclelabelBean.DataBean> data) {
    }//废弃

    @Override
    public void ReturnCircle(CircleListBean bean) {
    }//废弃

    @Override
    public void retUsercircleUp(UserCircleUpBean bean, boolean zan) {
    }//废弃

    @Override
    public void retUserfollow(UserCircleUpBean bean) {
    }//废弃

    @Override
    public void retUsercircleShare(UserCircleUpBean bean) {
    }//废弃

    @Override
    public void retUsercircleDetail(UsercircleDetailBean bean) {}//废弃

    @Override
    public void retNetErr(String err) {
        toast(err);
    }

    @Override
    public void retUserReply(UserReplyBean bean) { }//废弃

    @Override
    public void retMinemyUprelease(CircleListBean bean) { }//废弃

    @Override
    public void retUserCircleDel(UserReplyBean bean) {}//废弃

    @OnClick({R.id.callback, R.id.tv_follow_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.callback:
                finish();
                break;
            case R.id.tv_follow_btn://关注

                break;
        }
    }
}
