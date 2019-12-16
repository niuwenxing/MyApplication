package com.example.jiyin.home.Activity.sonview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.OfflineTrainingBean;
import com.example.jiyin.home.Activity.sonview.base.ScreationEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.StudyAgencyIndexBean;
import com.example.jiyin.home.Activity.sonview.base.UnderDetailBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.StudyAgencyImpl;
import com.example.jiyin.home.Activity.sonview.sonview.StudyAgencyView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <P> 研习社 报名</P>
 */
public class StudyparticipateActivity extends JiYingActivity<StudyAgencyView, StudyAgencyImpl> implements StudyAgencyView {

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
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.participate_btn)
    TextView participateBtn;
    @BindView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @BindView(R.id.relatvelayout)
    ConstraintLayout relatvelayout;
    @BindView(R.id.tv_CustomerPhone_btn)
    TextView tv_CustomerPhone_btn;
    @BindView(R.id.lpk)
    WebView lpk;
    private int underId;
    private int underType;
    private int under_id;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_studyparticipate;
    }

    //启动本页面
    public static void staticActivity(Context context, int under_id, int under_type){
        context.startActivity(new Intent(context, StudyparticipateActivity.class)
            .putExtra("under_id",under_id)
            .putExtra("under_type",under_type)
        );

    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new StudyAgencyImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();


    }

    private void initData() {

    }

    private void initView() {
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("研习社详情...");
        under_id = getIntent().getIntExtra("under_id", 1252);

        presenter.getUnderDetail(under_id);//研习社详情
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.getUnderDetail(under_id);
    }

    @Override
    public void retIndexData(StudyAgencyIndexBean bean) {}//废弃

    @Override
    public void retOfflineTraining(OfflineTrainingBean bean) {} //废弃

    //线下详情
    @Override
    public void retUnderDetailData(UnderDetailBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg().toString());
            return;
        }
        tvSearchTextTitle.setText(bean.getData().getUnder_title()+"");

        participateBtn.setEnabled(bean.getData().getEnroll()==1?false:true);
        participateBtn.setBackgroundColor(bean.getData().getEnroll()==1?
                getResources().getColor(R.color.colorcbcbcb):
                getResources().getColor(R.color.colorSearch));
        if (bean.getData().getEnroll()==1) {
            participateBtn.setText("已报名了");
        }else{
            participateBtn.setText(bean.getData().getUnder_money()==0?"免费报名":"￥"+bean.getData().getUnder_money()+" 报名");
        }

    }

    @Override
    public void retScreationEnroll(ScreationEnrollBean bean) { } //废弃

    @OnClick({R.id.gobank_btn, R.id.participate_btn,R.id.tv_CustomerPhone_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.participate_btn:


                break;
            case R.id.tv_CustomerPhone_btn://联系客服


                break;
        }
    }
}
