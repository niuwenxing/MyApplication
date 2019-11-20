package com.example.jiyin.home.Activity.homeview;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.homeview.base.LoginData;
import com.example.jiyin.home.Activity.homeview.base.RegisterBase;
import com.example.jiyin.home.Activity.presenter.impl.EntrancePreImpl;
import com.example.jiyin.home.Activity.presenter.view.EntranceView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.PreferenceUtil;
import com.example.rootlib.utils.MobileCheckUtil;
import com.example.rootlib.utils.StatusBarUtil;
import com.example.rootlib.utils.StringUtil;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 登录页面
 */

public class SigninActivity extends JiYingActivity<EntranceView, EntrancePreImpl> implements EntranceView {

    @BindView(R.id.iconPhone_image)
    ImageView iconPhoneImage;
    @BindView(R.id.xet_login_phone)
    EditText xetLoginPhone;
    @BindView(R.id.img_show)
    ImageView imgShow;

    boolean isPhone, isCode, isPsd;
    @BindView(R.id.iconPsd_image)
    ImageView iconPsdImage;
    @BindView(R.id.xet_login_password)
    EditText xetLoginPassword;
    @BindView(R.id.img_passWord)
    ImageView imgPassWord;
    @BindView(R.id.bt_Landingbutton)
    Button btLandingbutton;
    @BindView(R.id.tv_ForgetPassword_btn)
    TextView tvForgetPasswordBtn;
    @BindView(R.id.tv_registerAccount_btn)
    TextView tvRegisterAccountBtn;
    private Typeface font;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_signin;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter =new EntrancePreImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);
        font = Typeface.create("sans-serif-smallcaps", Typeface.NORMAL);
        init();

    }

    private void init() {
        imgPassWord.setSelected(false);
        xetLoginPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
        //账号
        xetLoginPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String s = charSequence.toString();
                if (s.length() == 11) {
                    isPhone = true;
                    if(isCode){
                        btLandingbutton.setEnabled(true);
                    }else{
                        btLandingbutton.setEnabled(false);
                    }
                } else {
                    btLandingbutton.setEnabled(false);
                    isPhone = false;
                }
                imgShow.setSelected(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //密码
        xetLoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String s = charSequence.toString();
                if (s.length() >= 6) {
                    isCode = true;
                    if (isPhone) {
                        btLandingbutton.setEnabled(true);
                    } else {
                        btLandingbutton.setEnabled(false);
                    }
                } else {
                    btLandingbutton.setEnabled(false);
                    isCode = false;
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });

    }

    @OnClick({ R.id.img_show, R.id.img_passWord,
            R.id.bt_Landingbutton, R.id.tv_ForgetPassword_btn, R.id.tv_registerAccount_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_show:
                if (imgShow.isSelected()) {
                    xetLoginPhone.setText(null);
                }
                break;
            case R.id.img_passWord:
                imgPassWord.setSelected(!imgPassWord.isSelected());
                xetLoginPassword.setInputType(imgPassWord.isSelected() ? InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD : InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                xetLoginPassword.setSelection(xetLoginPassword.getText().toString().length());
                break;
            case R.id.bt_Landingbutton://登录
                Landingbutton();
                break;
            case R.id.tv_ForgetPassword_btn://忘记密码
                Intent forget = new Intent(this, ForgetPasswordActivity.class);
                forget.putExtra(ConstantUtil.KEY_CODE,ConstantUtil.KEY_FORGET_CODE);
                startActivity(forget);
                break;
            case R.id.tv_registerAccount_btn://注册
                Intent registered = new Intent(this, ForgetPasswordActivity.class);
                registered.putExtra(ConstantUtil.KEY_CODE,ConstantUtil.KEY_REGISTERED_CODE);
                startActivity(registered);
                break;
        }
    }

    private void Landingbutton() {
        if (!MobileCheckUtil.isChinaPhoneLegal(xetLoginPhone.getText().toString().trim())) {
            toast("请输入正确的手机号");
            return;
        }
        if(StringUtil.isEmpty(xetLoginPassword.getText().toString())){
            toast("请输入密码");
            return;
        }
        presenter.login(xetLoginPhone.getText().toString().trim(),xetLoginPassword.getText().toString());

    }



    @Override
    public void logindata(LoginData bean) {//登陆成功返回
        toast(bean.getMsg());
        if(bean.getCode()==1){
            PreferenceUtil.put(ConstantUtil.KEY_TOKEN,bean.getData());
            finish();
        }
    }


    @Override
    public void Code(CodeBase bean) {
        toast(bean.getMsg().toString());
    }

    @Override
    public void sucRegister(RegisterBase bean) {
    }

    @Override
    public void err(String status, String message) {
    }

    @Override
    public void retrieve(CodeBase bean) {

    }


}
