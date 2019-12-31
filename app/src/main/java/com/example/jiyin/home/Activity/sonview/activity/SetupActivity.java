package com.example.jiyin.home.Activity.sonview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.MLImageView;
import com.example.jiyin.home.Activity.sonview.base.UserInfoBean;
import com.example.jiyin.home.presenter.Impl.MypageImpl;
import com.example.jiyin.home.presenter.view.MypageView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.GlideImageLoader;
import com.example.jiyin.utils.PreferenceUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 个人中心 设置页面
 */
public class SetupActivity extends JiYingActivity {

    @BindView(R.id.iv_back_btn)
    ImageView ivBackBtn;
    @BindView(R.id.genduoportrait_btn)
    ImageView genduoportraitBtn;
    @BindView(R.id.Namegenduos)
    ImageView Namegenduos;
    @BindView(R.id.studioStr)
    TextView studioStr;
    @BindView(R.id.phonenumber_btn)
    ImageView phonenumberBtn;
    @BindView(R.id.tv_phoneStr)
    TextView tvPhoneStr;
    @BindView(R.id.address_btn)
    ImageView addressBtn;
    @BindView(R.id.ChangePassword_btn)
    ImageView ChangePasswordBtn;
    @BindView(R.id.logOut_btn)
    TextView logOutBtn;
    @BindView(R.id.imageaseview)
    MLImageView imageaseview;
    private String imgas;
    private String name;
    private String phont;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_setup;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        imgas = intent.getStringExtra("imgas");
        name = intent.getStringExtra("name");
        phont = intent.getStringExtra("phont");
        GlideImageLoader.loadLogh(activity,BaseConfig.ROOT_IMAGES_API+imgas,imageaseview);
        studioStr.setText(name);
        tvPhoneStr.setText(phont);

    }

    @OnClick({R.id.iv_back_btn, R.id.genduoportrait_btn, R.id.phonenumber_btn,
            R.id.address_btn, R.id.ChangePassword_btn, R.id.logOut_btn,R.id.Namegenduos})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back_btn:
                finish();
                break;
            case R.id.genduoportrait_btn://设置头像
                activity.startActivity(new Intent(activity,MyPhotoActivity.class)
                    .putExtra("img", BaseConfig.ROOT_IMAGES_API+imgas)
                );
                break;
            case R.id.phonenumber_btn://修改手机号
                activity.startActivity(new Intent(activity,SetPhonenumberActivity.class));
                break;
            case R.id.address_btn://修改地址
                startActivity(new Intent(activity, WebVIewActivity.class)
                        .putExtra(ConstantUtil.KEY_CODE,"upaddress")


                );
                break;
            case R.id.Namegenduos://修改名称
                activity.startActivity(new Intent(activity,SetNameActivity.class)
                        .putExtra("name",name)
                );
                break;
            case R.id.ChangePassword_btn://修改密码
                activity.startActivity(new Intent(activity,SetPasswordActivity.class));
                break;
            case R.id.logOut_btn:
                PreferenceUtil.remove(ConstantUtil.KEY_TOKEN);
                toast("退出成功");
                break;
        }
    }




}
