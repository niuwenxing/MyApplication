package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class WorkshopenrollActivity extends JiYingActivity {

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

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_workshopenroll;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setText("报名成功");
    }

    @OnClick(R.id.gobank_btn)
    public void onViewClicked() {
        finish();
    }
}
