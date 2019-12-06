package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.sonview.adapter.OfflinetingAdapter;
import com.example.jiyin.home.Activity.sonview.adapter.StudyAgencyApdpter;
import com.example.jiyin.home.Activity.sonview.base.OfflineTrainingBean;
import com.example.jiyin.home.Activity.sonview.base.StudyAgencyIndexBean;
import com.example.jiyin.home.Activity.sonview.base.UnderDetailBean;
import com.example.jiyin.home.Activity.sonview.base.UnderThLine;
import com.example.jiyin.home.Activity.sonview.sonimpl.StudyAgencyImpl;
import com.example.jiyin.home.Activity.sonview.sonview.StudyAgencyView;
import com.example.jiyin.utils.GlideImageLoader;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 研习社 首页
 */

public class StudyAgencyActivity extends JiYingActivity<StudyAgencyView, StudyAgencyImpl> implements StudyAgencyView, RadioGroup.OnCheckedChangeListener {

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
    @BindView(R.id.studyImage)
    ImageView studyImage;
    @BindView(R.id.studyTextHtml)
    TextView studyTextHtml;
    @BindView(R.id.rb_OnlineClass_bt)
    RadioButton rbOnlineClassBt;
    @BindView(R.id.rb_Underline_btn)
    RadioButton rbUnderlineBtn;
    @BindView(R.id.rg_StudyGroup)
    RadioGroup rgStudyGroup;
    @BindView(R.id.rv_Studylist)
    RecyclerView rvStudylist;


    private List<StudyAgencyIndexBean.DataBean.OnlineBean> onlin=new ArrayList<>();//线上课堂

    private StudyAgencyApdpter studyAgencyApdpter;
    private OfflinetingAdapter offlineting;

    //列表数据
    private List<List<OfflineTrainingBean.DataBean.OclassBean>> data=new ArrayList<>();

    List<OfflineTrainingBean.DataBean.OclassBean> oclassArr =new  ArrayList<>();
    List<OfflineTrainingBean.DataBean.OclassBean> tcampArr = new ArrayList<>();
    private RadioButton[] radioButtons;
    //公开课数据集
//    List<UnderThLine.StudyBean.DataBean> gongkaikeData=new ArrayList<>();
    //训练营数据集
//    List<UnderThLine.StudyBean.DataBean> trainingData=new ArrayList<>();



    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_study_agency;
    }

    private int page=1;

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new StudyAgencyImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_study_agency);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("研习社");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        rvStudylist.setLayoutManager(linearLayoutManager);
        studyAgencyApdpter = new StudyAgencyApdpter(onlin);//线上课堂
        rvStudylist.setAdapter(studyAgencyApdpter);

        offlineting = new OfflinetingAdapter(this,data);//线下培训
        rgStudyGroup.setOnCheckedChangeListener(this);

        //获取首页数据/线上课堂
        presenter.getIndex(page);


        initCHlck();//事件初始化

    }

    //事件初始化
    private void initCHlck() {
        //点击事件
        studyAgencyApdpter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {


            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @OnClick({R.id.gobank_btn, R.id.rb_OnlineClass_bt, R.id.rb_Underline_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.rb_OnlineClass_bt:

                break;
            case R.id.rb_Underline_btn:

                break;
        }
    }

    //返回 首页数据
    @Override
    public void retIndexData(StudyAgencyIndexBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        GlideImageLoader.load(this,bean.getData().getMaintain().getMaintain_path(),studyImage);
        studyTextHtml.setText(Html.fromHtml(bean.getData().getMaintain().getMaintain_text()));
        onlin = bean.getData().getOnline();
        rvStudylist.setAdapter(studyAgencyApdpter);
        studyAgencyApdpter.setNewData(bean.getData().getOnline());


    }

    //线下培训
    @Override
    public void retOfflineTraining(OfflineTrainingBean bean) {
        data.clear();
        if (bean.getCode()==-1) {
            toast(bean.getMsg().toString());
            return;
        }
        List<OfflineTrainingBean.DataBean.OclassBean> oclass = bean.getData().getOclass();
        List<OfflineTrainingBean.DataBean.OclassBean> tcamp = bean.getData().getTcamp();
        data.add(tcamp);
        data.add(oclass);
        rvStudylist.setAdapter(offlineting);
        offlineting.notifyDataSetChanged();
    }


    @Override
    public void retUnderDetailData(UnderDetailBean bean) {}//废弃

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == R.id.rb_OnlineClass_bt) {//线下培训
                //获取线上培训
                presenter.getIndex(page);

            }
            if(checkedId == R.id.rb_Underline_btn){//线上课堂
                Toast.makeText(activity, "xianxia ", Toast.LENGTH_SHORT).show();
                presenter.getofflineTraining(page);
            }

    }
}
