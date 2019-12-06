package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.sonview.sonimpl.TopViewImpl;
import com.example.jiyin.home.Activity.sonview.sonview.TopView;
import com.example.rootlib.widget.common.ThrowLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Top
 * 视屏列表页
 */

public class TopActivity extends JiYingActivity<TopView, TopViewImpl> implements TopView{

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
    @BindView(R.id.topLabelHlist)
    RecyclerView topLabelHlist;
    @BindView(R.id.throw_layout)
    ThrowLayout throwLayout;
    @BindView(R.id.headerview)
    ClassicsHeader headerview;
    @BindView(R.id.topVlist)
    RecyclerView topVlist;
    @BindView(R.id.topfooterview)
    ClassicsFooter topfooterview;


    private int pages;
    private int type;
    private int ificationId;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_top;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new TopViewImpl();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("Top");


//        Spanned spanned = ("");



    }

    @OnClick(R.id.gobank_btn)
    public void onViewClicked() {
        finish();
    }
}
