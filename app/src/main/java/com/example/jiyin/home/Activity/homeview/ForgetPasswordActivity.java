package com.example.jiyin.home.Activity.homeview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.homeview.base.LoginData;
import com.example.jiyin.home.Activity.homeview.base.RegisterBase;
import com.example.jiyin.home.Activity.presenter.impl.EntrancePreImpl;
import com.example.jiyin.home.Activity.presenter.view.EntranceView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.utils.MobileCheckUtil;
import com.example.rootlib.utils.StringUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 忘记密码/注册
 */
public class ForgetPasswordActivity extends JiYingActivity<EntranceView, EntrancePreImpl> implements EntranceView {

    @BindView(R.id.iconPsd_image)
    ImageView iconPsdImage;
    @BindView(R.id.et_forget_phone)
    EditText etForgetPhone;
    @BindView(R.id.tv_getcode_btn)
    TextView tvGetcodeBtn;
    @BindView(R.id.iconfor_image)
    ImageView iconforImage;
    @BindView(R.id.et_forget_code)
    EditText etForgetCode;
    @BindView(R.id.iconPsd_images)
    ImageView iconPsdImages;
    @BindView(R.id.et_for_password)
    EditText etForPassword;
    @BindView(R.id.img_passWords)
    ImageView imgPassWords;
    @BindView(R.id.forget_image)
    ImageView forgetImage;
    @BindView(R.id.et_forget_password)
    EditText etForgetPassword;
    @BindView(R.id.img_passWord)
    ImageView imgPassWord;
    @BindView(R.id.bt_Landingbutton)
    Button btLandingbutton;
    @BindView(R.id.tv_immediately_btn)
    TextView tvImmediatelyBtn;


    /**
     * 验证码剩余冷却时间
     */
    private int mLeftFrozenTime;
    private Intent intent;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_forget_password;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new EntrancePreImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgPassWord.setSelected(false);
        etForgetPassword.setSelected(false);
        etForPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
        etForgetPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
        intent = getIntent();


//        忘记密码
        if(intent.getStringExtra(ConstantUtil.KEY_CODE).equals(ConstantUtil.KEY_FORGET_CODE)){
            btLandingbutton.setText("确认修改");
        }
        //注册
        if(intent.getStringExtra(ConstantUtil.KEY_CODE).equals(ConstantUtil.KEY_REGISTERED_CODE)){
            SpannableString spanColor = new SpannableString("已有账号？立即登录");
            MyClickableSpan myClickableSpan = new MyClickableSpan();
            spanColor.setSpan(myClickableSpan, 5, spanColor.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            tvImmediatelyBtn.setMovementMethod(LinkMovementMethod.getInstance());
            spanColor.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorCode)), 5,spanColor.length() , 0);
            tvImmediatelyBtn.setText(spanColor);
        }

        initView();

    }

    private void initView() {


    }

    @OnClick({ R.id.et_forget_phone, R.id.tv_getcode_btn, R.id.iconfor_image, R.id.et_forget_code,
            R.id.iconPsd_images, R.id.img_passWords, R.id.forget_image, R.id.et_forget_password,
            R.id.img_passWord, R.id.bt_Landingbutton, R.id.tv_immediately_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_forget_phone:
                break;
            case R.id.tv_getcode_btn://验证码
                getcode();
                break;
            case R.id.iconfor_image:

                break;
            case R.id.et_forget_code:
                break;
            case R.id.iconPsd_images:
                break;

            case R.id.img_passWords:
                imgPassWords.setSelected(!imgPassWords.isSelected());
                etForPassword.setInputType(imgPassWords.isSelected() ? InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD : InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                etForPassword.setSelection(etForPassword.getText().toString().length());

                break;
            case R.id.forget_image:
                break;
            case R.id.et_forget_password:
                break;
            case R.id.img_passWord:
                imgPassWord.setSelected(!imgPassWord.isSelected());
                etForgetPassword.setInputType(imgPassWord.isSelected() ? InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD : InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                etForgetPassword.setSelection(etForgetPassword.getText().toString().length());

                break;
            case R.id.bt_Landingbutton:
                Landingbutton();
                break;
            case R.id.tv_immediately_btn:
                break;
        }
    }

    //提交
    private void Landingbutton() {
        if (StringUtil.isEmpty(etForgetPhone.getText().toString())){
            toast("手机号不能空"); return;
        }

        if(StringUtil.isEmpty(etForgetCode.getText().toString())){
            toast("验证码不能空"); return;
        }

        if(!etForPassword.getText().toString().trim().equals(etForgetPassword.getText().toString().trim())&&etForgetPassword.getText().toString().length()==etForPassword.getText().toString().length()) {
            toast("密码不否,请重新输入");
            etForPassword.setText(null);
            etForgetPassword.setText(null);
            return;
        }


        if(intent.getStringExtra(ConstantUtil.KEY_CODE).equals(ConstantUtil.KEY_REGISTERED_CODE)){
            presenter.userRegister(etForgetPhone.getText().toString(),etForgetCode.getText().toString(),etForgetPassword.getText().toString().trim());
        }else{//忘记密码
            presenter.userRetrieve(etForgetPhone.getText().toString(),etForgetCode.getText().toString(),etForgetPassword.getText().toString().trim());
        }
    }

    private void getcode() {
        if(!MobileCheckUtil.isChinaPhoneLegal(etForgetPhone.getText().toString().trim())){
            toast("请输入正确的手机号");
            return;
        }else{
            resetTimer();
            presenter.getCode(etForgetPhone.getText().toString().trim());

        }

    }


    /**
     * 重置倒计时，60s内只能发送一条验证码
     */
    private void resetTimer() {
        new CountDownTimer(60000,1000) {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onTick(long millisUntilFinished) {
                if(tvGetcodeBtn==null){return;}
                tvGetcodeBtn.setClickable(false);
                tvGetcodeBtn.setText(getString(R.string.user_validcode_sending, millisUntilFinished / 1000));
                tvGetcodeBtn.setTextColor(R.color.white);
            }
            @SuppressLint("ResourceAsColor")
            @Override
            public void onFinish() {
                if(tvGetcodeBtn==null){return;}
                tvGetcodeBtn.setClickable(true);
                tvGetcodeBtn.setText("重新获取");
                tvGetcodeBtn.setTextColor(R.color.white);
//                tvGetcode.setBackground(getResources().getDrawable(R.color.color_fff));

            }
        }.start();
    }

    @Override
    public void Code(CodeBase bean) {//
            toast(bean.getMsg());
    }

    @Override
    public void sucRegister(RegisterBase bean) {//注册
            toast(bean.getMsg());
        if (bean.getCode()==1) {
            finish();
        }
    }

    @Override
    public void err(String status, String message) {
        toastLong(message.toString());
    }


    @Override
    public void retrieve(CodeBase bean) {//忘记密码
        toast(bean.getMsg());
        if (bean.getCode()==1) {
            finish();
        }
    }

    public class MyClickableSpan extends ClickableSpan {
        @Override
        public void onClick(@NonNull View widget) {
            startActivity(new Intent(ForgetPasswordActivity.this,SigninActivity.class));
            finish();
        }
    }


    @Override
    public void logindata(LoginData bean) {//忽略

    }
}
