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
import com.example.jiyin.home.Activity.sonview.base.MinecircleBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.Activity.sonview.base.UsercircleDetailBean;
import com.example.jiyin.home.fragment.adapter.WorkShopPolAdapter;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.GlideImageLoader;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
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
    private int uid;
    private String avatar;
    private String username;
    private List<MinecircleBean.DataBean.ListBean> list1=new ArrayList<>();
    private WorkShopPolAdapter workShopPolAdapter;

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

        presenter.getMinecircle(circleId);

        workShopPolAdapter = new WorkShopPolAdapter(list1);
        quanziRecyclerView.setAdapter(workShopPolAdapter);
//        MinecircleBean();

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
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
        }else{
            toast(bean.getMsg());
        }
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
    public void retUserCircleDel(UserReplyBean bean,int pos) {}//废弃

    /**
     * 圈子 用户信息
     * @param data
     */
    @Override
    public void retMinecircle(MinecircleBean.DataBean data) {
        List<MinecircleBean.DataBean.ListBean> list = data.getList();
        MinecircleBean.DataBean.ListBean listBean = list.get(0);

        MinecircleBean.DataBean.UserBean user = data.getUser();



        //个人信息
        if (data.getFollow()==0?false:true){
            tvFollowBtn.setVisibility(View.INVISIBLE);
        }else{
            tvFollowBtn.setVisibility(View.VISIBLE);
        }
        uid = user.getId();

        avatar = user.getAvatar();
        //头像
        GlideImageLoader.loadLogh(activity,BaseConfig.ROOT_IMAGES_API+avatar,MLImageView);
        //名字
        username = user.getUsername();
        tvFollowtitle.setText(username+"");

        list1.clear();
        list1.addAll(data.getList());
        workShopPolAdapter.notifyDataSetChanged();

        listtagNunber.setText("全部圈子("+list1.size()+")");

    }

    @OnClick({R.id.callback, R.id.tv_follow_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.callback:
                finish();
                break;
            case R.id.tv_follow_btn://关注
//                presenter
                presenter.Userfollow(uid);
                break;
        }
    }
}
