package com.example.jiyin.home.Activity.sonview.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置页面
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

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_setup;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @OnClick({R.id.iv_back_btn, R.id.genduoportrait_btn, R.id.phonenumber_btn, R.id.address_btn, R.id.ChangePassword_btn, R.id.logOut_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back_btn:
                finish();
                break;
            case R.id.genduoportrait_btn:
                break;
            case R.id.phonenumber_btn:
                break;
            case R.id.address_btn:
                break;
            case R.id.ChangePassword_btn:
                break;
            case R.id.logOut_btn:
                break;
        }
    }
}
