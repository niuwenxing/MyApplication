package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.sonview.base.MineAplyDosBean;
import com.example.jiyin.home.Activity.sonview.base.UserInfoBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.presenter.Impl.MypageImpl;
import com.example.jiyin.home.presenter.view.MypageView;
import com.example.jiyin.utils.GlideImageLoader;

/**
 * 修改密码
 */

public class SetPasswordActivity extends JiYingActivity<MypageView, MypageImpl> implements MypageView, View.OnClickListener {

    private EditText ed_old_pass,ed_new_password1,ed_new_password2;
    private Button sure;
    private ImageView goback;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_set_password;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new MypageImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

    }


    private void initView(){
        ed_old_pass = findViewById(R.id.ed_old_pass);
        goback = findViewById(R.id.goback);
        goback.setOnClickListener(this);
        ed_new_password1 = findViewById(R.id.ed_new_password1);
        ed_new_password2 = findViewById(R.id.ed_new_password2);
        sure = findViewById(R.id.sure);
        sure.setClickable(false);
        ed_old_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                if (ed_old_pass.getText().toString().equals("")) {
                    sure.setClickable(false);
                    sure.setTextColor(getResources().getColor(R.color.colorButtonNoClickable));
                }else {
                    if(!ed_new_password1.getText().toString().equals("")&&!ed_new_password2.getText().toString().equals("")){
                        sure.setClickable(true);
                        sure.setTextColor(getResources().getColor(R.color.white));
                    }
                }
            }
        });
        ed_new_password1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (ed_new_password1.getText().toString().equals("")) {
                    sure.setClickable(false);
                    sure.setTextColor(getResources().getColor(R.color.colorButtonNoClickable));
                }else {
                    if(!ed_old_pass.getText().toString().equals("")&&!ed_new_password2.getText().toString().equals("")){
                        sure.setClickable(true);
                        sure.setTextColor(getResources().getColor(R.color.white));
                    }
                }
            }
        });
        ed_new_password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (ed_new_password2.getText().toString().equals("")) {
                    sure.setClickable(false);
                    sure.setTextColor(getResources().getColor(R.color.colorButtonNoClickable));
                }else {
                    if(!ed_old_pass.getText().toString().equals("")&&!ed_new_password1.getText().toString().equals("")){
                        sure.setClickable(true);
                        sure.setTextColor(getResources().getColor(R.color.white));
                    }

                }
            }
        });

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_new_password1.getText().toString().equals(ed_new_password1.getText().toString())) {
                    presenter.getUserPassEdit(ed_old_pass.getText().toString(),ed_new_password1.getText().toString(),ed_new_password1.getText().toString());
                }else{
                    toast("两次密码不一致");
                }
            }
        });
    }



    @Override
    public void retUserInfo(UserInfoBean bean) {}//废弃

    @Override
    public void err(String str) {
        toast(str);
    }

    @Override
    public void retUserAvatarEdit(UserReplyBean bean) {
    }//废弃

    @Override
    public void retNameSetName(UserReplyBean bean) {
    }//废弃

    @Override
    public void Code(CodeBase bean) {
    }//废弃

    @Override
    public void retUserTelEdit(UserReplyBean bean) {
    }//废弃

    //修改密码
    @Override
    public void retUserPassEdit(UserReplyBean bean) {
        if (bean.getCode() == -1) {
            toast(bean.getMsg());
        }else{
            toast(bean.getMsg());
            finish();
        }
    }

    @Override
    public void retMineApplyDos(MineAplyDosBean bean) {//废弃

    }

    @Override
    public void retMinemyUp(CircleListBean bean) { }//废弃

    @Override
    public void onClick(View v) {
        finish();
    }
}
