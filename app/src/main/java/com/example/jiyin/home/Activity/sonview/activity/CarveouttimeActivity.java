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

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.adapter.ScreationAdapter;
import com.example.jiyin.home.Activity.sonview.adapter.TscreationAdapter;
import com.example.jiyin.home.Activity.sonview.base.PositionEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.ZtimeIndexBean;
import com.example.jiyin.home.Activity.sonview.base.ZtimedetailBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.CarveouttimeImpl;
import com.example.jiyin.home.Activity.sonview.sonview.CarveouttimeView;
import com.example.jiyin.utils.GlideImageLoader;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 琢璞时间
 */
public class CarveouttimeActivity extends JiYingActivity<CarveouttimeView, CarveouttimeImpl> implements CarveouttimeView, RadioGroup.OnCheckedChangeListener {

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
    @BindView(R.id.iv_CarveoutTimeImage)
    ImageView ivCarveoutTimeImage;
    @BindView(R.id.tv_CarveoutTimeTextHtml)
    TextView tvCarveoutTimeTextHtml;
    @BindView(R.id.rb_NewestWeekly_bt)
    RadioButton rbNewestWeeklyBt;
    @BindView(R.id.rb_Pastperiod_btn)
    RadioButton rbPastperiodBtn;
    @BindView(R.id.rg_CarveoutTimeGroup)
    RadioGroup rgCarveoutTimeGroup;
    @BindView(R.id.rv_CarveoutTimeList)
    RecyclerView rvCarveoutTimeList;

    private int page=1;

    private List<ZtimeIndexBean.DataBean.ScreationBean> screation=new ArrayList<>();//最新

    private List<ZtimeIndexBean.DataBean.ScreationBean> tscreation=new ArrayList<>();//往期
    private ScreationAdapter screationAdapter;
    private TscreationAdapter tscreationAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_carveouttime;
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
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setText("琢璞时间");
        rgCarveoutTimeGroup.setOnCheckedChangeListener(this);


        screationAdapter = new ScreationAdapter(screation);
        rvCarveoutTimeList.setAdapter(screationAdapter);

        tscreationAdapter = new TscreationAdapter(tscreation);




        presenter.getZtimeIndex(page);

        initView();


    }

    private void initView() {
        //点击事件 最新
        screationAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CarveouttimeDasActivity.startActivity(CarveouttimeActivity.this,screation.get(position).getZid());
            }
        });
        //点击事件
        tscreationAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CarveouttimeDasActivity.startActivity(CarveouttimeActivity.this,tscreation.get(position).getZid());
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.getZtimeIndex(page);
    }

    @OnClick({R.id.gobank_btn, R.id.searech_news_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn:
                break;
        }
    }
    //首页数据 返回
    @Override
    public void retZtimeIndex(ZtimeIndexBean bean) {
        screation.clear();
        tscreation.clear();
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        tvCarveoutTimeTextHtml.setText(Html.fromHtml(bean.getData().getMaintain().getMaintain_text()));
        GlideImageLoader.load(this, BaseConfig.ROOT_IMAGES_API+bean.getData().getMaintain().getMaintain_path(),ivCarveoutTimeImage);

        screation.addAll(bean.getData().getScreation());
        tscreation.addAll(bean.getData().getTscreation());

        screationAdapter.notifyDataSetChanged();
        tscreationAdapter.notifyDataSetChanged();
    }

    @Override
    public void retZtimedetail(ZtimedetailBean bean) {  } //废弃

    @Override
    public void retZtimeenroll(PositionEnrollBean bean) { }//废弃

    @Override
    public void retSysErr(String errn) {  }//废弃

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId==R.id.rb_NewestWeekly_bt) {//每周推荐
            rvCarveoutTimeList.setAdapter(screationAdapter);
            screationAdapter.notifyDataSetChanged();

        }
        if(checkedId==R.id.rb_Pastperiod_btn){//往期展示
            rvCarveoutTimeList.setAdapter(tscreationAdapter);
            tscreationAdapter.notifyDataSetChanged();

        }
    }
}
