package com.example.jiyin.home.Activity.sonview.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.adapter.RecyclerViewSpacesItemDecoration;
import com.example.jiyin.home.Activity.sonview.base.PositionDetailBean;
import com.example.jiyin.home.Activity.sonview.base.PositionEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIficationBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIndexBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.OccupationalImpl;
import com.example.jiyin.home.Activity.sonview.sonview.OccupationalVeiw;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.view.CollapsibleTextView;
import com.example.rootlib.widget.common.ThrowLayout;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 职呼 职位详情
 */
public class JobdetailsActivity extends JiYingActivity<OccupationalVeiw, OccupationalImpl> implements OccupationalVeiw {

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
    @BindView(R.id.tv_JobTable_str)
    TextView tvJobTableStr;
    @BindView(R.id.tv_salary_str)
    TextView tvSalaryStr;
    @BindView(R.id.tv_CorporateName_str)
    TextView tvCorporateNameStr;
    @BindView(R.id.tv_Address_str)
    TextView tvAddressStr;
    @BindView(R.id.tv_Education_str)
    TextView tvEducationStr;
    @BindView(R.id.tv_Jobdescription_str)
    TextView tvJobdescriptionStr;
    @BindView(R.id.tv)
    CollapsibleTextView tv;
    @BindView(R.id.re_LabelTag_list)
    RecyclerView reLabelTagList;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.tv_IntRoduce_str)
    TextView tvIntRoduceStr;
    @BindView(R.id.tv_Submission_btn)
    TextView tvSubmissionBtn;
    private int positionId;
    private int position_id;
    private List<String> label=new ArrayList<>();
    private LabelTagAdapter labeltag;
    private HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
    private String education;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_jobdetails;
    }

    public static void startcActivity(Context context,int position_id){
        context.startActivity(new Intent(context,JobdetailsActivity.class)
                .putExtra(ConstantUtil.KEY_CODE,position_id)
        );
    }


    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new OccupationalImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setText("");
        tvSearchTextTitle.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
//        ((CollapsibleTextView) findViewById(R.id.tv)).setDesc(getString(R.string.dummy_text), TextView.BufferType.NORMAL);
        positionId = getIntent().getIntExtra(ConstantUtil.KEY_CODE, BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.RIGHT_DECORATION,
                (int)getResources().getDimension(R.dimen.dp_12));
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION,
                (int)getResources().getDimension(R.dimen.dp_10));
        labeltag = new LabelTagAdapter(label);
        reLabelTagList.setAdapter(labeltag);
        reLabelTagList.setLayoutManager(new FlexboxLayoutManager(this));
        reLabelTagList.addItemDecoration(new RecyclerViewSpacesItemDecoration(stringIntegerHashMap));

        presenter.getPositionDetail(positionId);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.getPositionDetail(positionId);
    }

    @Override//废弃
    public void retPositionIndex(PositionIndexBean bean) {
    }

    @Override//废弃
    public void retPositionIfication(PositionIficationBean bean) {
    }

    /**
     * 职呼 详情数据
     * @param bean
     */
    @Override
    public void retPositionDetail(PositionDetailBean bean) {
        label.clear();
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        PositionDetailBean.DataBean data = bean.getData();
        position_id = data.getPosition_id();
        tvSearchTextTitle.setText(data.getCname()+"");
        tvJobTableStr.setText(data.getPosition_name());
        tvSalaryStr.setText(data.getPosition_money()+"K");
        tvCorporateNameStr.setText(data.getCname());
        tvAddressStr.setText(data.getPosition_site());
        education = data.getEducation();//学历
        tvEducationStr.setText(education);
        tv.setDesc(Html.fromHtml(data.getPosition_text()),TextView.BufferType.NORMAL);
        label.addAll(data.getLabel());
        labeltag.notifyDataSetChanged();
        tvIntRoduceStr.setText(Html.fromHtml(data.getC_text()));

        tvSubmissionBtn.setEnabled(data.getEnroll()==1?false:true);
        tvSubmissionBtn.setBackground(data.getEnroll()==1?getResources().getDrawable(R.drawable.fromsubmission_false)
                    :getResources().getDrawable(R.drawable.fromsubmission)
        );
        tvSubmissionBtn.setText(data.getEnroll()==1?"已经报名":"报名申请");
    }

    @Override
    public void retPositionEnroll(PositionEnrollBean bean) { }//废弃

    @OnClick({R.id.gobank_btn, R.id.tv_Submission_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.tv_Submission_btn:
                VocationalShengActivity.startcActivitys(this,position_id,education);
                break;
        }
    }

    public class LabelTagAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public LabelTagAdapter(@Nullable List<String> data) {super(R.layout.textviewitem, data);}

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {helper.setText(R.id.textview,item.toString());}
    }

}
