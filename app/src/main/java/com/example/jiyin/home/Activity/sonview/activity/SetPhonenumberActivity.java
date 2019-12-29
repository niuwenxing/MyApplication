package com.example.jiyin.home.Activity.sonview.activity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.sonview.base.MineAplyDosBean;
import com.example.jiyin.home.Activity.sonview.base.UserInfoBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.presenter.Impl.MypageImpl;
import com.example.jiyin.home.presenter.view.MypageView;
import com.example.rootlib.utils.MobileCheckUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *修改手机号
 */

public class SetPhonenumberActivity extends JiYingActivity<MypageView, MypageImpl> implements MypageView {

    @BindView(R.id.throw_layout)
    ThrowLayout throwLayout;
    @BindView(R.id.textView23)
    TextView textView23;
    @BindView(R.id.goback)
    ImageView goback;
    @BindView(R.id.oksure)
    Button oksure;
    @BindView(R.id.et_newPhone)
    EditText etNewPhone;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.et_codeeditText)
    EditText etCodeeditText;
    @BindView(R.id.textView8)
    TextView textView8;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_set_phonenumber;
    }
    private boolean isphone=false;
    private boolean nonullcode=false;

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new MypageImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        oksure.setEnabled(false);
        etNewPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (MobileCheckUtil.isChinaPhoneLegal(charSequence.toString())) {
                    isphone=true;
                    if(nonullcode){
                        oksure.setEnabled(true);
                        oksure.setTextColor(activity.getResources().getColor(R.color.white));
                    }else{
                        oksure.setEnabled(false);
                        oksure.setTextColor(activity.getResources().getColor(R.color.colorbotline));
                    }
                }else{
                    isphone=false;
                    oksure.setEnabled(false);
                    oksure.setTextColor(activity.getResources().getColor(R.color.colorbotline));
                }
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        etCodeeditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String s1 = s.toString();
                if (s1.length()>=4) {
                    nonullcode=true;
                    if(isphone){
                        oksure.setEnabled(true);
                        oksure.setTextColor(activity.getResources().getColor(R.color.white));
                    }else{
                        oksure.setEnabled(false);
                        oksure.setTextColor(activity.getResources().getColor(R.color.colorbotline));
                    }
                }else{
                    nonullcode=false;
                    oksure.setEnabled(false);
                    oksure.setTextColor(activity.getResources().getColor(R.color.colorbotline));
                }
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

    }

    @Override
    public void retUserInfo(UserInfoBean bean) { }//废弃

    @Override
    public void err(String str) {
        toast(str);
    }

    @Override
    public void retUserAvatarEdit(UserReplyBean bean) {}//废弃

    @Override
    public void retNameSetName(UserReplyBean bean) { }//废弃

    @Override
    public void Code(CodeBase bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }else{
            toast(bean.getMsg());
            resetTimer();
        }

    }

    @Override
    public void retUserTelEdit(UserReplyBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
        }else{
            toast(bean.getMsg());
            finish();
        }
    }

    @Override
    public void retUserPassEdit(UserReplyBean bean) { }//废弃

    @Override
    public void retMineApplyDos(MineAplyDosBean bean) {//废弃

    }

    @Override
    public void retMinemyUp(CircleListBean bean) { }//废弃

    private void resetTimer() {
        new CountDownTimer(60000,1000) {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onTick(long millisUntilFinished) {
                if(textView6==null){return;}
                textView6.setClickable(false);
                textView6.setText(getString(R.string.user_validcode_sending, millisUntilFinished / 1000));
                textView6.setTextColor(R.color.white);
            }
            @SuppressLint("ResourceAsColor")
            @Override
            public void onFinish() {
                if(textView6==null){return;}
                textView6.setClickable(true);
                textView6.setText("重新获取");
                textView6.setTextColor(R.color.white);
//                tvGetcode.setBackground(getResources().getDrawable(R.color.color_fff));

            }
        }.start();
    }

    @OnClick({R.id.goback, R.id.oksure, R.id.et_newPhone, R.id.textView6, R.id.et_codeeditText})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.goback:
                finish();
                break;
            case R.id.oksure:
                commitPhone();
                break;
            case R.id.et_newPhone:
                break;
            case R.id.textView6://验证码
                getCodestr();
                break;
            case R.id.et_codeeditText:
                break;
        }
    }
    //提交手机号
    private void commitPhone() {
        presenter.getUserTelEdit(etNewPhone.getText().toString(),etCodeeditText.getText().toString());
    }

    private void getCodestr() {
        if (MobileCheckUtil.isChinaPhoneLegal(etNewPhone.getText().toString())) {
            presenter.getCode(etNewPhone.getText().toString());
        }else{
            toast("请输入正确的手机号");
        }
    }
}
