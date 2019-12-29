package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.presenter.impl.SearchpagePImpl;
import com.example.jiyin.home.Activity.presenter.view.SearchpageView;
import com.example.jiyin.home.Activity.sonview.base.ClassifyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.ClassifyIndexBean;
import com.example.jiyin.home.Activity.sonview.base.FounderListBean;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.PreferenceUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 红人详情
 */
public class MoreredMenActivity extends JiYingActivity<SearchpageView, SearchpagePImpl> implements SearchpageView {

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
    @BindView(R.id.wv_webview)
    WebView wvWebview;
    private int founder_id;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_morered_men;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new SearchpagePImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setText("详情");
        founder_id = getIntent().getIntExtra(ConstantUtil.KEY_CODE, 12313);

        initView();
    }

    private void initView() {


    }


    @Override
    public void retClassifyDetail(ClassifyIndexBean bean) { }

    @Override
    public void retClassifyDetailNew(ClassifyDetailBean bean) { }

    @Override
    public void retFounderfounderList(FounderListBean bean) { }

    @OnClick(R.id.gobank_btn)
    public void onViewClicked() {
        finish();
    }
}
