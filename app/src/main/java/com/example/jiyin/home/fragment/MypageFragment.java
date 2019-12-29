package com.example.jiyin.home.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.MLImageView;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.sonview.activity.ApplicationrecordActivity;
import com.example.jiyin.home.Activity.sonview.activity.MypraiseActivity;
import com.example.jiyin.home.Activity.sonview.activity.MyreleaseActivity;
import com.example.jiyin.home.Activity.sonview.activity.SetupActivity;
import com.example.jiyin.home.Activity.sonview.base.MineAplyDosBean;
import com.example.jiyin.home.Activity.sonview.base.UserInfoBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.presenter.Impl.MypageImpl;
import com.example.jiyin.home.presenter.view.MypageView;
import com.example.jiyin.utils.GlideImageLoader;
import com.example.rootlib.widget.common.CommonItem;
import com.gyf.immersionbar.ImmersionBar;

import java.util.prefs.BackingStoreException;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 个人中心
 */
public class MypageFragment extends JiYingFragment<MypageView, MypageImpl> implements MypageView {
    @BindView(R.id.view)
    View view;
    @BindView(R.id.uptop)
    TextView uptop;
    @BindView(R.id.img_myImage_btn)
    MLImageView imgMyImageBtn;
    @BindView(R.id.tv_UserName)
    TextView tvUserName;
    @BindView(R.id.tv_Setup_btn)
    TextView tvSetupBtn;
    @BindView(R.id.topView)
    RelativeLayout topView;
    @BindView(R.id.tv_Myorder_btn)
    TextView tvMyorderBtn;
    @BindView(R.id.tv_ShoppingCart_btn)
    TextView tvShoppingCartBtn;
    @BindView(R.id.tv_Collection_btn)
    TextView tvCollectionBtn;
    @BindView(R.id.tv_Fabulous_btn)
    TextView tvFabulousBtn;
    @BindView(R.id.menuMey)
    RelativeLayout menuMey;
    @BindView(R.id.Applicationrecord_btn)
    CommonItem ApplicationrecordBtn;
    @BindView(R.id.Myrelease_btn)
    CommonItem MyreleaseBtn;
    @BindView(R.id.MyCustomer_btn)
    CommonItem MyCustomerBtn;
    @BindView(R.id.Aboutus_btn)
    CommonItem AboutusBtn;

    private boolean isCreated=false;
    private String avatar;
    private String username;
    private String tel;


    @Override
    protected int attachLayoutRes() {
        return R.layout.mypagefragment_layout;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new MypageImpl();
    }
    @Override
    protected void init() {
        ImmersionBar.setStatusBarView(this, view);
        isCreated=true;
        //个人中心数据
        presenter.getUserInfo();

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getUserInfo();
    }

    @OnClick({R.id.img_myImage_btn, R.id.tv_Setup_btn, R.id.tv_Myorder_btn, R.id.tv_ShoppingCart_btn, R.id.tv_Collection_btn, R.id.tv_Fabulous_btn, R.id.Applicationrecord_btn, R.id.Myrelease_btn, R.id.MyCustomer_btn, R.id.Aboutus_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_myImage_btn://头像
                break;
            case R.id.tv_Setup_btn://设置
                Intent intent = new Intent(getContext(), SetupActivity.class)
                        .putExtra("imgas",avatar)
                        .putExtra("name",username)
                        .putExtra("phont",tel);
                startActivity(intent);
                break;
            case R.id.tv_Myorder_btn://我的订单
                break;
            case R.id.tv_ShoppingCart_btn://购物车
                break;
            case R.id.tv_Collection_btn://我的收藏
                break;
            case R.id.tv_Fabulous_btn://我的赞
                activity.startActivity(new Intent(activity, MypraiseActivity.class));
                break;
            case R.id.Applicationrecord_btn://申请记录
                activity.startActivity(new Intent(activity, ApplicationrecordActivity.class));
                break;
            case R.id.Myrelease_btn://我的发布
                activity.startActivity(new Intent(activity, MyreleaseActivity.class));
                break;
            case R.id.MyCustomer_btn://我的客服
                break;
            case R.id.Aboutus_btn://关于我们
                break;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            toast("个人中心");
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!isCreated) {
            return;
        }
        if (!hidden) {
            presenter.getUserInfo();
        } else {
            //data.clear();
        }
    }

    //个人中心数据返回
    @Override
    public void retUserInfo(UserInfoBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        UserInfoBean.DataBean data = bean.getData();
        avatar = bean.getData().getAvatar();
        username = data.getUsername();
        tel = data.getTel();
        tvUserName.setText(username);
        GlideImageLoader.loadLogh(activity, BaseConfig.ROOT_IMAGES_API+avatar,imgMyImageBtn);
    }

    //失败返回
    @Override
    public void err(String str) {
        toast(str);
    }

    @Override
    public void retUserAvatarEdit(UserReplyBean bean) { } //废弃

    @Override
    public void retNameSetName(UserReplyBean bean) { } //废弃

    @Override
    public void Code(CodeBase bean) { }

    @Override
    public void retUserTelEdit(UserReplyBean bean) {  }//废弃

    @Override
    public void retUserPassEdit(UserReplyBean bean) {   }//废弃

    @Override
    public void retMineApplyDos(MineAplyDosBean bean) {//废弃

    }

    @Override
    public void retMinemyUp(CircleListBean bean) { }//废弃
}
