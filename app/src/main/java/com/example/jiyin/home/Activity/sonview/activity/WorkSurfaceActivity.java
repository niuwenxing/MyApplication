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
import com.example.jiyin.common.net.netunti.Callcode;
import com.example.jiyin.home.Activity.sonview.base.WorkDetailsBase;
import com.example.jiyin.home.Activity.sonview.base.WorkProjectbase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopLabelBase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopMainBase;
import com.example.jiyin.home.Activity.sonview.sonimpl.WorkRoomImpl;
import com.example.jiyin.home.Activity.sonview.sonview.WorkRoomView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.utils.MobileCheckUtil;
import com.example.rootlib.utils.StringUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 工作坊  申请表
 */

public class WorkSurfaceActivity extends JiYingActivity<WorkRoomView, WorkRoomImpl> implements WorkRoomView {


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
    @BindView(R.id.Teamname)
    TextView Teamname;
    @BindView(R.id.et_TeamnameEdit_str)
    EditText etTeamnameEditStr;
    @BindView(R.id.Yourschool)
    TextView Yourschool;
    @BindView(R.id.et_YourschoolEdit_str)
    EditText etYourschoolEditStr;
    @BindView(R.id.Teamsize)
    TextView Teamsize;
    @BindView(R.id.et_TeamsizeEdit_str)
    EditText etTeamsizeEditStr;
    @BindView(R.id.EstablishTime)
    TextView EstablishTime;
    @BindView(R.id.et_EstablishTimeEdit_str)
    EditText etEstablishTimeEditStr;
    @BindView(R.id.tv_EstablishTime_btn)
    ImageView tvEstablishTimeBtn;
    @BindView(R.id.ProjectType)
    TextView ProjectType;
    @BindView(R.id.et_ProjectTypeEdit_str)
    EditText etProjectTypeEditStr;
    @BindView(R.id.tv_ProjectType_btn)
    ImageView tvProjectTypeBtn;
    @BindView(R.id.IsRegistered)
    TextView IsRegistered;
    @BindView(R.id.IsYesRegistered_btn)
    RadioButton IsYesRegisteredBtn;
    @BindView(R.id.IsNoRegistered_btn)
    RadioButton IsNoRegisteredBtn;
    @BindView(R.id.IsRegistered_btn)
    RadioGroup IsRegisteredBtn;
    @BindView(R.id.Teamleader)
    TextView Teamleader;
    @BindView(R.id.et_TeamleaderEdit_str)
    EditText etTeamleaderEditStr;
    @BindView(R.id.Telephone)
    TextView Telephone;
    @BindView(R.id.et_TelephoneEdit_str)
    EditText etTelephoneEditStr;
    @BindView(R.id.WorkMailbox)
    TextView WorkMailbox;
    @BindView(R.id.et_WorkMailboxEdit_str)
    EditText etWorkMailboxEditStr;
    @BindView(R.id.Personalprofile)
    TextView Personalprofile;
    @BindView(R.id.et_PersonalEdit_str)
    EditText etPersonalEditStr;
    @BindView(R.id.tv_Submission_btn)
    TextView tvSubmissionBtn;

    private int workId; //id 提交

    private String isregistereds="2";  //标示
    private TimePickerView timePickerBuilder;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_work_surface;
    }

    public static void staSurfaceActivity(Context context, int work_id) {
        Intent intent = new Intent(context, WorkSurfaceActivity.class).putExtra(
                ConstantUtil.WORKSHOPKEY, work_id
        );
        context.startActivity(intent);
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new WorkRoomImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("报名申请");
        tvSearchTextTitle.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        workId = getIntent().getIntExtra(ConstantUtil.WORKSHOPKEY, 253);

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

    @Override
    public void returnDatalabel(WorkshopLabelBase data) { }//废弃

    @Override
    public void retWorkShopMainData(WorkshopMainBase bean) { } //废弃

    @Override
    public void retDataWorkDetails(WorkDetailsBase bean) { }//废弃

    //请求返回结果
    @Override
    public void retworkShenQ(breakCode bean) {
        if (bean.getCode()==-1) {
            toastLong(bean.getMsg());
            return;
        }else{
            toast(bean.getMsg());
            finish();
        }
    }

    //请求失败 返回
    @Override
    public void onfailure(String message) {
        toast(message);
    }

    //设置项目类型
    @Override
    public void retStudioLabel(WorkProjectbase bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        etProjectTypeEditStr.setText(bean.getData().getWork_title());

    }

    @OnClick({R.id.gobank_btn, R.id.tv_EstablishTime_btn, R.id.tv_ProjectType_btn, R.id.tv_Submission_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.tv_EstablishTime_btn://时间选择器
                showTimeBirthbay();
                break;
            case R.id.tv_ProjectType_btn://项目类型
                presenter.studioLabel(workId);
                break;
            case R.id.tv_Submission_btn://提交申请
                rtSubmission();
                break;
        }
    }

    /**
     * 时间选择器
     */
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
                etEstablishTimeEditStr.setText(sdf.format(date));
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

    private void rtSubmission() {
        if (StringUtil.isEmpty(etTeamnameEditStr.getText().toString())) {
            toast("团队名称不能为空");
            return;
        }
        if (StringUtil.isEmpty(etYourschoolEditStr.getText().toString())) {
            toast("所在学校不能为空");
            return;
        }
        if (StringUtil.isEmpty(etTeamsizeEditStr.getText().toString())) {
            toast("团队人数不能为空");
            return;
        }
        if (StringUtil.isEmpty(etEstablishTimeEditStr.getText().toString())) {
            toast("请选择成立时间");
            return;
        }
        if (StringUtil.isEmpty(etProjectTypeEditStr.getText().toString())) {
            toast("请选择项目类型");
            return;
        }
        if (StringUtil.isEmpty(etTeamleaderEditStr.getText().toString())) {
            toast("团队负责人不能为空");
            return;
        }
        if (!MobileCheckUtil.isChinaPhoneLegal(etTelephoneEditStr.getText().toString().trim())) {
            toast("手机号不正确/不能为空");
            return;
        }
        if (!MobileCheckUtil.isEmail(etWorkMailboxEditStr.getText().toString().trim())) {
            toast("邮箱不正确/不能为空");
            return;
        }

        presenter.workShenQing(
                workId,//id
                etTeamnameEditStr.getText().toString(),//名字
                etYourschoolEditStr.getText().toString(),//学校名称
                etTeamsizeEditStr.getText().toString(),//团队人数
                etEstablishTimeEditStr.getText().toString(),//成立时间
                etProjectTypeEditStr.getText().toString(),//项目类型
                isregistereds,
                etTeamleaderEditStr.getText().toString(),//团队负责人
                etTelephoneEditStr.getText().toString().trim(),//手机号
                etWorkMailboxEditStr.getText().toString().trim(),//邮箱
                etPersonalEditStr.getText().toString().trim()//团队介绍
                );
    }

    public class breakCode extends Callcode {

        private String msg;
        private int time;
        private List<?> data;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public List<?> getData() {
            return data;
        }

        public void setData(List<?> data) {
            this.data = data;
        }
    }

}
