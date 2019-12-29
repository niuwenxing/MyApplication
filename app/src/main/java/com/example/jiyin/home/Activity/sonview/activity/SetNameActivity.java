package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
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
import com.example.rootlib.utils.StringUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 修改昵称
 */

public class SetNameActivity extends JiYingActivity<MypageView, MypageImpl> implements MypageView {

    @BindView(R.id.textView23)
    TextView textView23;
    @BindView(R.id.goback)
    ImageView goback;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.clear)
    ImageView clear;
    @BindView(R.id.sure)
    Button sure;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_set_name;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new MypageImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void retUserInfo(UserInfoBean bean) {
    }//废弃

    @Override
    public void err(String str) {
    }//废弃

    @Override
    public void retUserAvatarEdit(UserReplyBean bean) {
    }//废弃

    @Override
    public void retNameSetName(UserReplyBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
        }
        toast(bean.getMsg());
        finish();
    }

    @Override
    public void Code(CodeBase bean) { }//废弃

    @Override
    public void retUserTelEdit(UserReplyBean bean) { }//废弃

    @Override
    public void retUserPassEdit(UserReplyBean bean) { }//废弃

    @Override
    public void retMineApplyDos(MineAplyDosBean bean) {//废弃

    }

    @Override
    public void retMinemyUp(CircleListBean bean) { }//废弃

    @OnClick({R.id.goback, R.id.sure,R.id.clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.goback:
                finish();
                break;
            case R.id.sure:
                if (!StringUtil.isEmpty(inputName.getText().toString())) {
                    presenter.getNameSetName(inputName.getText().toString());
                }else{
                    toast("昵称不能为空");
                }
                break;
            case R.id.clear:
                inputName.setText("");
                break;
        }
    }
}
