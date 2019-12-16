package com.example.jiyin.home.Activity.sonview.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.homeview.base.ImageArr;
import com.example.jiyin.home.Activity.sonview.base.FilePathbean;
import com.example.jiyin.home.Activity.sonview.base.PositionDetailBean;
import com.example.jiyin.home.Activity.sonview.base.PositionEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIficationBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIndexBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.OccupationalImpl;
import com.example.jiyin.home.Activity.sonview.sonview.OccupationalVeiw;
import com.example.rootfilelibs.DocumentViewActivity;
import com.example.rootlib.utils.IDCard;
import com.example.rootlib.utils.LogUtils;
import com.example.rootlib.utils.MobileCheckUtil;
import com.example.rootlib.utils.StringUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 职呼 申请
 */
public class VocationalShengActivity extends JiYingActivity<OccupationalVeiw, OccupationalImpl> implements OccupationalVeiw {

    @BindView(R.id.gobank_btn)
    ImageView gobankBtn;
    @BindView(R.id.searchText)
    EditText searchText;
    @BindView(R.id.searchView)
    LinearLayout searchView;
    @BindView(R.id.tv_searchTextTitle)
    TextView tvSearchTextTitle;
    @BindView(R.id.searech_news_btn)
    ImageView searechNewsBtn;
    @BindView(R.id.searech_Shopping_btn)
    ImageView searechShoppingBtn;
    @BindView(R.id.add_btn)
    TextView addBtn;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.et_NameEdit_str)
    EditText etNameEditStr;
    @BindView(R.id.IsGender)
    TextView IsGender;
    @BindView(R.id.IsYesGender_btn)
    RadioButton IsYesGenderBtn;
    @BindView(R.id.IsNoGender_btn)
    RadioButton IsNoGenderBtn;
    @BindView(R.id.IsGender_btn)
    RadioGroup IsGenderBtn;
    @BindView(R.id.tvAge)
    TextView tvAge;
    @BindView(R.id.et_tvAgeEdit_str)
    EditText etTvAgeEditStr;
    @BindView(R.id.Educations)
    TextView Educations;
    @BindView(R.id.et_EducationEdit_str)
    EditText etEducationEditStr;
    @BindView(R.id.OccuSchool)
    TextView OccuSchool;
    @BindView(R.id.et_OccuSchoolEdit_str)
    EditText etOccuSchoolEditStr;
    @BindView(R.id.jobs)
    TextView jobs;
    @BindView(R.id.et_jobsEdit_str)
    EditText etJobsEditStr;
    @BindView(R.id.OccuPhone)
    TextView OccuPhone;
    @BindView(R.id.et_OccuPhoneEdit_str)
    EditText etOccuPhoneEditStr;
    @BindView(R.id.OccuMailbox)
    TextView OccuMailbox;
    @BindView(R.id.et_OccuMailboxEdit_str)
    EditText etOccuMailboxEditStr;
    @BindView(R.id.iDNumber)
    TextView iDNumber;
    @BindView(R.id.et_iDNumberEdit_str)
    EditText etIDNumberEditStr;
    @BindView(R.id.OuucIntroduction)
    TextView OuucIntroduction;
    @BindView(R.id.UploadFlie)
    TextView UploadFlie;
    @BindView(R.id.tv_UploadFlie_btn)
    TextView tvUploadFlieBtn;
    @BindView(R.id.tv_CuuoSubmission_btn)
    TextView tvCuuoSubmissionBtn;
    @BindView(R.id.et_OuucIntroductionEdit_str)
    EditText etOuucIntroductionEditstr;
    private int positionId;
    private String education;
    private String IsGender_btn="1";//默认男
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_vocational_sheng;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new OccupationalImpl();
    }

    public static void startcActivitys(Context jobdetailsActivity, int position_id, String education) {
        jobdetailsActivity.startActivity(new Intent(jobdetailsActivity, VocationalShengActivity.class)
                .putExtra("position_id", position_id)
                .putExtra("education", education)
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("申请报名");
        tvSearchTextTitle.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        positionId = getIntent().getIntExtra("position_id", BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);
        education = getIntent().getStringExtra("education");
        etEducationEditStr.setText(education+"");

        initViewChecked();


    }

    private void initViewChecked() {
        IsGenderBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.IsYesGender_btn) {
                    IsGender_btn="1";
                }else{
                    IsGender_btn="2";
                }
            }
        });
    }

    @Override
    public void retPositionIndex(PositionIndexBean bean) { } //废弃

    @Override
    public void retPositionIfication(PositionIficationBean bean) { }//废弃

    @Override
    public void retPositionDetail(PositionDetailBean bean) { }//废弃

    @Override
    public void retPositionEnroll(PositionEnrollBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        toast(bean.getMsg());
        finish();

    }

    @OnClick({R.id.gobank_btn, R.id.searech_news_btn, R.id.tv_UploadFlie_btn, R.id.tv_CuuoSubmission_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn:
                break;
            case R.id.tv_UploadFlie_btn:
                DocumentViewActivity.startsActivitys(this,0X1235);
                break;
            case R.id.tv_CuuoSubmission_btn:
                CuuoSubmission();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    /**
     * 提交申请
     */
    private void CuuoSubmission() {
        if(StringUtil.isEmpty(etNameEditStr.getText().toString())){
            toast("名字不能为空");
            return;
        }
        if(StringUtil.isEmpty(etTvAgeEditStr.getText().toString())){
            toast("年龄不能为空");
            return;
        }
        if(StringUtil.isEmpty(etEducationEditStr.getText().toString())){
            toast("学历不能为空");
            return;
        }
        if(StringUtil.isEmpty(etOccuSchoolEditStr.getText().toString())){
            toast("所在学校不能为空");
            return;
        }
        if(StringUtil.isEmpty(etJobsEditStr.getText().toString())){
            toast("意向职位不能为空");
            return;
        }
        if(!MobileCheckUtil.isChinaPhoneLegal(etOccuPhoneEditStr.getText().toString().trim())){
            toast("手机号不正确/不能为空");
            return;
        }
        if(!MobileCheckUtil.isEmail(etOccuMailboxEditStr.getText().toString().trim())){
            toast("邮箱不能为空");
            return;
        }
        if(!StringUtil.isEmpty(IDCard.IDCardValidate(etIDNumberEditStr.getText().toString()))){
            toast(IDCard.IDCardValidate(etIDNumberEditStr.getText().toString()));
            return;
        }
        if(StringUtil.isEmpty(tvUploadFlieBtn.getText().toString())){
            toast("请选择文件");
            return;
        }

        showProgress();
        presenter.CommonuploadImg(tvUploadFlieBtn.getText().toString().trim()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()) {
                    FilePathbean filepathbean = new Gson().fromJson(response.body().string(), FilePathbean.class);
                    LogUtils.i(filepathbean.toString()+"1452");
                    setFileUrl(filepathbean);
                }
            }
        });
    }

    private void setFileUrl(FilePathbean filepathbean) {
        if (StringUtil.isEmpty(filepathbean.getData())) {
            hideProgress();
            toast("文件上传异常");
            return;
        }
        presenter.getPositionEnroll(positionId
        ,etNameEditStr.getText().toString(),
                IsGender_btn,
                etTvAgeEditStr.getText().toString(),
                etEducationEditStr.getText().toString(),
                etOccuSchoolEditStr.getText().toString(),
                etJobsEditStr.getText().toString(),
                etOccuPhoneEditStr.getText().toString(),
                etOccuMailboxEditStr.getText().toString(),
                etIDNumberEditStr.getText().toString(),
                filepathbean.getData().toString(),
                etOuucIntroductionEditstr.getText().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0X1235&&resultCode==0x25326){
            String keyPathstr = data.getStringExtra("KeyPathstr");
            if (StringUtil.isEmpty(keyPathstr)) {
                tvUploadFlieBtn.setText("");
            }else{
                tvUploadFlieBtn.setText(keyPathstr+"");
            }
        }
    }
}
