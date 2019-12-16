package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.adapter.NewestAdapter;
import com.example.jiyin.home.Activity.sonview.adapter.PastperiodAdapter;
import com.example.jiyin.home.Activity.sonview.base.ScreationBean;
import com.example.jiyin.home.Activity.sonview.base.ScreationBeans;
import com.example.jiyin.home.Activity.sonview.base.ScreationEnrollBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.CreationcollImpl;
import com.example.jiyin.home.Activity.sonview.sonview.CreationcollView;
import com.example.jiyin.utils.GlideImageLoader;
import com.example.rootlib.utils.LogUtils;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 造物集 首页
 */

public class CreationcollectionActivity extends JiYingActivity<CreationcollView, CreationcollImpl> implements CreationcollView, RadioGroup.OnCheckedChangeListener {

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
    @BindView(R.id.iv_CreationImage)
    ImageView ivCreationImage;
    @BindView(R.id.tv_CreationTextHtml)
    TextView tvCreationTextHtml;
    @BindView(R.id.rb_NewestClass_bt)
    RadioButton rbNewestClassBt;
    @BindView(R.id.rb_Pastperiod_btn)
    RadioButton rbPastperiodBtn;
    @BindView(R.id.rg_StudyGroup)
    RadioGroup rgStudyGroup;
    @BindView(R.id.rv_Creationlist)
    RecyclerView rvCreationlist;

    private List<ScreationBeans.DataBean.ScreationBean> screation = new ArrayList<>();//最新
    private List<ScreationBeans.DataBean.TscreationBean> tscreation=new ArrayList<>();//推荐

    private int page=1;
    private NewestAdapter newestAdapter;
    private PastperiodAdapter pastperiodAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_creationcollection;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new CreationcollImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("造物集");
        rgStudyGroup.setOnCheckedChangeListener(this);

        newestAdapter = new NewestAdapter(screation);
        rvCreationlist.setAdapter(newestAdapter);


        pastperiodAdapter = new PastperiodAdapter(tscreation);


        presenter.getScreationIndex(page);

        initView();


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.getScreationIndex(page);
    }

    private void initView() {
        //最新点击事件
        newestAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                CreationDetailsActivity.staticActivity(CreationcollectionActivity.this,screation.get(position).getCreation_id());
            }
        });
        //往期 推荐
        pastperiodAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CreationDetailsActivity.staticActivity(CreationcollectionActivity.this,tscreation.get(position).getCreation_id());
            }
        });
    }

    @OnClick({R.id.gobank_btn, R.id.iv_CreationImage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.iv_CreationImage:

                break;
        }
    }

    //点击时间
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId==R.id.rb_NewestClass_bt) {
            rvCreationlist.setAdapter(newestAdapter);
            newestAdapter.notifyDataSetChanged();
        }
        if (checkedId==R.id.rb_Pastperiod_btn) {
            rvCreationlist.setAdapter(pastperiodAdapter);
        }
    }

    @Override
    public void retScreation(ScreationBeans bean) {
        screation.clear();
        tscreation.clear();
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        tvCreationTextHtml.setText(Html.fromHtml(bean.getData().getMaintain().getMaintain_text()));
        GlideImageLoader.load(this, BaseConfig.ROOT_IMAGES_API+bean.getData().getMaintain().getMaintain_path(),ivCreationImage);
        screation.addAll( bean.getData().getScreation());//最新
        tscreation.addAll(bean.getData().getTscreation());//推荐
        rbNewestClassBt.setChecked(true);
        newestAdapter.notifyDataSetChanged();

    }

    @Override
    public void retScreationData(ScreationBean bean) {}//废弃

    @Override
    public void retScreationEnroll(ScreationEnrollBean bean) { }//废弃
}
