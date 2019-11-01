package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.sonview.adapter.HeadlinesAdapter;
import com.example.jiyin.home.Activity.sonview.sonimpl.HeadlinesImpl;
import com.example.jiyin.home.Activity.sonview.sonview.HeadlinesView;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 头条页面
 */
public class HeadlinesActivity extends JiYingActivity<HeadlinesView, HeadlinesImpl> implements HeadlinesView {

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
    @BindView(R.id.ry_headlineList)
    RecyclerView ryHeadlineList;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_headlines;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("头条");

        ryHeadlineList.setLayoutManager(new LinearLayoutManager(this));
        List<String>  list=new ArrayList<>();
        HeadlinesAdapter<String> stringHeadlinesAdapter = new HeadlinesAdapter<>(this, list);
        ryHeadlineList.setAdapter(stringHeadlinesAdapter);


    }

    @OnClick({R.id.gobank_btn, R.id.searech_news_btn, R.id.searech_Shopping_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn: //消息

                break;
        }
    }
}
