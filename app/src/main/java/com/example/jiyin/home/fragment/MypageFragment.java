package com.example.jiyin.home.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.common.widget.MLImageView;
import com.example.jiyin.home.Activity.sonview.activity.SetupActivity;
import com.example.rootlib.widget.common.CommonItem;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;
import butterknife.OnClick;

//我的页面
public class MypageFragment extends JiYingFragment {
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

    @Override
    protected int attachLayoutRes() {
        return R.layout.mypagefragment_layout;
    }

    @Override
    protected void init() {
        ImmersionBar.setStatusBarView(this, view);

    }

    @OnClick({R.id.img_myImage_btn, R.id.tv_Setup_btn, R.id.tv_Myorder_btn, R.id.tv_ShoppingCart_btn, R.id.tv_Collection_btn, R.id.tv_Fabulous_btn, R.id.Applicationrecord_btn, R.id.Myrelease_btn, R.id.MyCustomer_btn, R.id.Aboutus_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_myImage_btn://头像
                break;
            case R.id.tv_Setup_btn://设置
                Intent intent = new Intent(getContext(), SetupActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_Myorder_btn://我的订单
                break;
            case R.id.tv_ShoppingCart_btn://购物车
                break;
            case R.id.tv_Collection_btn://我的收藏
                break;
            case R.id.tv_Fabulous_btn://我的赞
                break;
            case R.id.Applicationrecord_btn://申请记录
                break;
            case R.id.Myrelease_btn://我的发布
                break;
            case R.id.MyCustomer_btn://我的客服
                break;
            case R.id.Aboutus_btn://关于我们
                break;
        }
    }
}
