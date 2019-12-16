package com.example.jiyin.home.Activity.sonview.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.FilePathbean;
import com.example.jiyin.home.Activity.sonview.base.PositionEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.ZtimeIndexBean;
import com.example.jiyin.home.Activity.sonview.base.ZtimedetailBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.CarveouttimeImpl;
import com.example.jiyin.home.Activity.sonview.sonview.CarveouttimeView;
import com.example.rootfilelibs.DocumentViewActivity;
import com.example.rootlib.utils.LogUtils;
import com.example.rootlib.utils.MobileCheckUtil;
import com.example.rootlib.utils.StringUtil;
import com.example.rootlib.widget.common.ThrowLayout;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * 琢璞时间 申请
 */

public class CarveouttimeApplyActivity extends JiYingActivity<CarveouttimeView, CarveouttimeImpl> implements CarveouttimeView {

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
    @BindView(R.id.throw_layout)
    ThrowLayout throwLayout;
    @BindView(R.id.teamName)
    TextView teamName;
    @BindView(R.id.et_teamNameEdit_str)
    EditText etTeamNameEditStr;
    @BindView(R.id.Yourschool)
    TextView Yourschool;
    @BindView(R.id.et_YourschoolEdit_str)
    EditText etYourschoolEditStr;
    @BindView(R.id.Teamsize)
    TextView Teamsize;
    @BindView(R.id.et_TeamsizeEdit_str)
    EditText etTeamsizeEditStr;
    @BindView(R.id.EstablishTimeapplyfor)
    TextView EstablishTimeapplyfor;
    @BindView(R.id.et_EstablishTimeapplyforEdit_str)
    EditText etEstablishTimeapplyforEditStr;
    @BindView(R.id.tv_EstablishTimeapplyfor_btn)
    ImageView tvEstablishTimeapplyforBtn;
    @BindView(R.id.ProjectType)
    TextView ProjectType;
    @BindView(R.id.et_ProjectTypeEdit_str)
    EditText etProjectTypeEditStr;
    @BindView(R.id.IsGender)
    TextView IsGender;
    @BindView(R.id.IsYesRegister_btn)
    RadioButton IsYesRegisterBtn;
    @BindView(R.id.IsNoRegister_btn)
    RadioButton IsNoRegisterBtn;
    @BindView(R.id.IsRegister_btn)
    RadioGroup IsRegisterBtn;
    @BindView(R.id.Teamleader)
    TextView Teamleader;
    @BindView(R.id.et_TeamleaderEdit_str)
    EditText etTeamleaderEditStr;
    @BindView(R.id.CarvePhone)
    TextView CarvePhone;
    @BindView(R.id.et_CarvePhoneEdit_str)
    EditText etCarvePhoneEditStr;
    @BindView(R.id.CarveMailbox)
    TextView CarveMailbox;
    @BindView(R.id.et_CarveMailboxEdit_str)
    EditText etCarveMailboxEditStr;
    @BindView(R.id.Fagitt)
    TextView Fagitt;
    @BindView(R.id.IsYesFagitt_btn)
    RadioButton IsYesFagittBtn;
    @BindView(R.id.IsNoFagitt_btn)
    RadioButton IsNoFagittBtn;
    @BindView(R.id.IsFagitt_btn)
    RadioGroup IsFagittBtn;
    @BindView(R.id.teamIntroduction)
    TextView teamIntroduction;
    @BindView(R.id.et_teamIntroductionEdit_str)
    EditText etTeamIntroductionEditStr;
    @BindView(R.id.projectIntroduction)
    TextView projectIntroduction;
    @BindView(R.id.et_projectIntroductionEdit_str)
    EditText etProjectIntroductionEditStr;
    @BindView(R.id.UploadFlie)
    TextView UploadFlie;
    @BindView(R.id.tv_UploadFlie_btn)
    TextView tvUploadFlieBtn;
    @BindView(R.id.tv_CarveSubmission_btn)
    TextView tvCarveSubmissionBtn;
    private int mZid;
    private String mTitle;

    private String register="2";//默认否
    private String Fagitttag="1";//默认是


    private TimePickerView timePickerBuilder;

    public static void startActivity(Context context, int mMCzid, String z_title) {
        context.startActivity(new Intent(context, CarveouttimeApplyActivity.class)
                .putExtra("zid", mMCzid)
                .putExtra("title", z_title)
        );
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_carveouttime_apply;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new CarveouttimeImpl();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("申请报名");
        mZid = getIntent().getIntExtra("zid", BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);
        mTitle = getIntent().getStringExtra("title");
        etProjectTypeEditStr.setText(mTitle);


        initView();

    }

    private void initView() {
        //是否 注册
        IsRegisterBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.IsYesRegister_btn) {
                    register = "1";
                }else{
                    register = "2";
                }
            }
        });
        //
        IsFagittBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.IsYesFagitt_btn) {
                    Fagitttag = "1";
                }else{
                    Fagitttag = "2";
                }
            }
        });
    }

    @Override
    public void retZtimeIndex(ZtimeIndexBean bean) {    }//废弃

    @Override
    public void retZtimedetail(ZtimedetailBean bean) {    }//废弃

    //成功返回
    @Override
    public void retZtimeenroll(PositionEnrollBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        toast(bean.getMsg());
        finish();
    }
    //失败
    @Override
    public void retSysErr(String errn) {
        toast(errn);
    }

    @OnClick({R.id.gobank_btn, R.id.tv_UploadFlie_btn, R.id.tv_CarveSubmission_btn,R.id.tv_EstablishTimeapplyfor_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.tv_UploadFlie_btn://文件选择器
                DocumentViewActivity.startsActivitys(this,0X1235);
                break;
            case R.id.tv_CarveSubmission_btn:
                CarveSubmissionbtn();
                break;
            case R.id.tv_EstablishTimeapplyfor_btn://时间选择器
                showTimeBirthbay();
                break;
        }
    }

    //文件选择器
    private void CarveSubmissionbtn() {
        if (StringUtil.isEmpty(etTeamNameEditStr.getText().toString())) {
            toast("团队名称 不能为空");return;
        }
        if (StringUtil.isEmpty(etYourschoolEditStr.getText().toString())) {
            toast("所在学校 不能为空");return;
        }
        if (StringUtil.isEmpty(etTeamsizeEditStr.getText().toString())) {
            toast("团队人数 不能为空");return;
        }
        if (StringUtil.isEmpty(etEstablishTimeapplyforEditStr.getText().toString())) {
            toast("成立时间 不能为空");return;
        }
        if (StringUtil.isEmpty(etProjectTypeEditStr.getText().toString())) {
            toast("项目类型 不能为空");return;
        }
        if (StringUtil.isEmpty(etTeamleaderEditStr.getText().toString())) {
            toast("团队负责人 不能为空");return;
        }
        if (!MobileCheckUtil.isChinaPhoneLegal(etCarvePhoneEditStr.getText().toString().trim())) {
            toast("手机号不正确/不能为空");return;
        }
        if (!MobileCheckUtil.isEmail(etCarveMailboxEditStr.getText().toString().trim())) {
            toast("邮箱不正确/不能为空");return;
        }
        if (StringUtil.isEmpty(etProjectIntroductionEditStr.getText().toString())) {
            toast("项目介绍 不能为空"); return;
        }
        if (StringUtil.isEmpty(tvUploadFlieBtn.getText().toString())) {
            toast("上传附件 不能为空");return;
        }
        showProgress();

        presenter.CommonuploadPPT(tvUploadFlieBtn.getText().toString()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                toast("上传附件异常");
                hideProgress();
            }

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

    //
    private void setFileUrl(FilePathbean filepathbean) {
        if (StringUtil.isEmpty(filepathbean.getData())) {
            hideProgress();
            toast("文件上传异常");
            return;
        }
        presenter.Ztimeenroll(
                mZid,
                etTeamNameEditStr.getText().toString(),
                etTeamsizeEditStr.getText().toString(),
                etEstablishTimeapplyforEditStr.getText().toString(),
                etProjectTypeEditStr.getText().toString(),
                etYourschoolEditStr.getText().toString(),
                register.toString(),
                etTeamleaderEditStr.getText().toString(),
                etCarvePhoneEditStr.getText().toString().trim(),
                etCarveMailboxEditStr.getText().toString().trim(),
                filepathbean.getData().toString(),
                Fagitttag.toString(),
                etTeamIntroductionEditStr.getText().toString(),
                etProjectIntroductionEditStr.getText().toString());

    }

    //时间选择器
    private void showTimeBirthbay() {
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2000,1,1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(endDate.get(Calendar.YEAR),endDate.get(Calendar.MONTH)+1,endDate.get(Calendar.DAY_OF_MONTH));
        timePickerBuilder = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                etEstablishTimeapplyforEditStr.setText(sdf.format(date));
            }
        }).setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {
            @Override
            public void customLayout(View v) {
                TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
                tvSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        timePickerBuilder.returnData();
                        timePickerBuilder.dismiss();
                    }
                });
                ivCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        timePickerBuilder.dismiss();
                    }
                });
            }
        })
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
//                .setTitleSize(20)//标题文字大小
//                .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(false)//是否循环滚动
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setRangDate(startDate,endDate)//起始终止年月日设定
                .isCenterLabel(true)
                .setLabel("年","月","日","时","分","秒")//默认设置为年月日时分秒
//                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                .isDialog(true)//是否显示为对话框样式
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK)
                .setContentTextSize(16)
                .build();
        timePickerBuilder.show();
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
