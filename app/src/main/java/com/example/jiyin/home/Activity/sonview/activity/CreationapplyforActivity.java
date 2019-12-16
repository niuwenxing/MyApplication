package com.example.jiyin.home.Activity.sonview.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.OfflineTrainingBean;
import com.example.jiyin.home.Activity.sonview.base.ScreationBean;
import com.example.jiyin.home.Activity.sonview.base.ScreationBeans;
import com.example.jiyin.home.Activity.sonview.base.ScreationEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.StudyAgencyIndexBean;
import com.example.jiyin.home.Activity.sonview.base.UnderDetailBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.CreationcollImpl;
import com.example.jiyin.home.Activity.sonview.sonimpl.StudyAgencyImpl;
import com.example.jiyin.home.Activity.sonview.sonview.CreationcollView;
import com.example.jiyin.home.Activity.sonview.sonview.StudyAgencyView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.utils.IDCard;
import com.example.rootlib.utils.MobileCheckUtil;
import com.example.rootlib.utils.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 造物集 申请
 */

public class CreationapplyforActivity extends JiYingActivity<CreationcollView, CreationcollImpl> implements CreationcollView {

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
    @BindView(R.id.Teamname_applyfor)
    TextView TeamnameApplyfor;
    @BindView(R.id.et_TeamnameapplyforEdit_str)
    EditText etTeamnameapplyforEditStr;
    @BindView(R.id.Yourschoolapplyfor)
    TextView Yourschoolapplyfor;
    @BindView(R.id.et_YourschoolapplyforEdit_str)
    EditText etYourschoolapplyforEditStr;
    @BindView(R.id.Teamsizeapplyfor)
    TextView Teamsizeapplyfor;
    @BindView(R.id.et_TeamsizeapplyforEdit_str)
    EditText etTeamsizeapplyforEditStr;
    @BindView(R.id.EstablishTimeapplyfor)
    TextView EstablishTimeapplyfor;
    @BindView(R.id.et_EstablishTimeapplyforEdit_str)
    EditText etEstablishTimeapplyforEditStr;
    @BindView(R.id.tv_EstablishTimeapplyfor_btn)
    ImageView tvEstablishTimeapplyforBtn;
    @BindView(R.id.ProjectTypeapplyfor)
    TextView ProjectTypeapplyfor;
    @BindView(R.id.et_ProjectTypeapplyforEdit_str)
    EditText etProjectTypeapplyforEditStr;
    @BindView(R.id.tv_ProjectTypeapplyfor_btn)
    ImageView tvProjectTypeapplyforBtn;
    @BindView(R.id.IsRegistered)
    TextView IsRegistered;
    @BindView(R.id.IsYesRegistered_btn)
    RadioButton IsYesRegisteredBtn;
    @BindView(R.id.IsNoRegistered_btn)
    RadioButton IsNoRegisteredBtn;
    @BindView(R.id.IsRegistered_btn)
    RadioGroup IsRegisteredBtn;
    @BindView(R.id.Teamleaderapplyfor)
    TextView Teamleaderapplyfor;
    @BindView(R.id.et_TeamleaderapplyforEdit_str)
    EditText etTeamleaderapplyforEditStr;
    @BindView(R.id.Telephoneapplyfor)
    TextView Telephoneapplyfor;
    @BindView(R.id.et_TelephoneapplyforEdit_str)
    EditText etTelephoneapplyforEditStr;
    @BindView(R.id.WorkMailboxapplyfor)
    TextView WorkMailboxapplyfor;
    @BindView(R.id.et_WorkMailboxapplyforEdit_str)
    EditText etWorkMailboxapplyforEditStr;
    @BindView(R.id.Personalprofileapplyfor)
    TextView Personalprofileapplyfor;
    @BindView(R.id.et_PersonalapplyforEdit_str)
    EditText etPersonalapplyforEditStr;
    @BindView(R.id.tv_Submission_btn)
    TextView tvSubmissionBtn;

    private String isregistereds="2";
    private int creationId;
    private String tvSearchTextTitle1;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_creationapplyfor;
    }

    public static void startActivity(Context context, int creation_id,String tvSearchTextTitle) {
        context.startActivity(new Intent(context, CreationapplyforActivity.class)
                .putExtra(ConstantUtil.KEY_CODE, creation_id)
                .putExtra("tvSearchTextTitle", tvSearchTextTitle)
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("报名申请");
        tvSearchTextTitle.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        creationId = getIntent().getIntExtra(ConstantUtil.KEY_CODE, BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);
        tvSearchTextTitle1 = getIntent().getStringExtra("tvSearchTextTitle");
        etProjectTypeapplyforEditStr.setText(tvSearchTextTitle1);
        initViewChecked();
    }

    //事件处理
    private void initViewChecked() {
        IsRegisteredBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.IsYesRegistered_btn) {
                    isregistereds="1";
                }else{
                    isregistereds="2";
                }
            }
        });
    }

//    @Override
//    public void retIndexData(StudyAgencyIndexBean bean) { }//废弃
//
//    @Override
//    public void retOfflineTraining(OfflineTrainingBean bean) { }//废弃
//
//    @Override
//    public void retUnderDetailData(UnderDetailBean bean) { }//废弃

    //申请提交返回
    @Override
    public void retScreationEnroll(ScreationEnrollBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        toast(bean.getMsg());
        finish();
    }

    @OnClick({R.id.gobank_btn, R.id.searech_news_btn,R.id.tv_EstablishTimeapplyfor_btn,R.id.tv_Submission_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn:
                break;
            case R.id.tv_EstablishTimeapplyfor_btn://时间选择器
                showTimeBirthbay();
                break;
            case R.id.tv_Submission_btn://提交申请
                rtSubmission();
                break;
        }
    }

    //提交
    private void rtSubmission() {
        if (StringUtil.isEmpty(etTeamnameapplyforEditStr.getText().toString())) {
            toast("团队名称不能为空");
            return;
        }
        if (StringUtil.isEmpty(etYourschoolapplyforEditStr.getText().toString())) {
            toast("所在学校不能为空");
            return;
        }
        if (StringUtil.isEmpty(etTeamsizeapplyforEditStr.getText().toString())) {
            toast("团队人数不能为空");
            return;
        }
        if (StringUtil.isEmpty(etEstablishTimeapplyforEditStr.getText().toString())) {
            toast("请选择成立时间");
            return;
        }
        if (StringUtil.isEmpty(etProjectTypeapplyforEditStr.getText().toString())) {
            toast("请选择项目类型");
            return;
        }
        if (StringUtil.isEmpty(etTeamleaderapplyforEditStr.getText().toString())) {
            toast("团队负责人不能为空");
            return;
        }
        if (!MobileCheckUtil.isChinaPhoneLegal(etTelephoneapplyforEditStr.getText().toString().trim())) {
            toast("手机号不正确/不能为空");
            return;
        }
        if (!MobileCheckUtil.isEmail(etWorkMailboxapplyforEditStr.getText().toString().trim())) {
            toast("邮箱不正确/不能为空");
            return;
        }



        presenter.getScreationEnroll(
                creationId,//id
                etTeamnameapplyforEditStr.getText().toString(),//团队名称
                etTeamsizeapplyforEditStr.getText().toString(),//团队人数
                etEstablishTimeapplyforEditStr.getText().toString(),//成立时间
                etProjectTypeapplyforEditStr.getText().toString(),//团队项目类型
                etYourschoolapplyforEditStr.getText().toString(),//学校名称
                isregistereds,//是否注册
                etTeamleaderapplyforEditStr.getText().toString(),//团队负责人
                etTelephoneapplyforEditStr.getText().toString(),//手机号
                etWorkMailboxapplyforEditStr.getText().toString(),//邮箱
                etPersonalapplyforEditStr.getText().toString()+""//团队介绍
        );




    }

    private TimePickerView timePickerBuilder;
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
    public void retScreation(ScreationBeans bean) {}

    @Override
    public void retScreationData(ScreationBean bean) {}
}
