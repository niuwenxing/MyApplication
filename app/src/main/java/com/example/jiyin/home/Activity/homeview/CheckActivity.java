package com.example.jiyin.home.Activity.homeview;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.adapter.FounderAdapter;
import com.example.jiyin.home.Activity.adapter.SearchpageAdpter;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.presenter.impl.CheckPresenterImpl;
import com.example.jiyin.home.Activity.presenter.view.CheckView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 查 页面
 */
public class CheckActivity extends JiYingActivity<CheckView, CheckPresenterImpl> implements CheckView {

    @BindView(R.id.gobank_btn)
    ImageView gobankBtn;
    @BindView(R.id.searchText)
    EditText searchText;
    @BindView(R.id.searech_news_btn)
    ImageView searechNewsBtn;
    @BindView(R.id.add_btn)
    TextView addBtn;
    @BindView(R.id.throw_layout)
    ThrowLayout throwLayout;
    @BindView(R.id.iv_topimage_btn)
    ImageView ivTopimageBtn;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.tv_checkTitle)
    TextView tvCheckTitle;
    @BindView(R.id.tv_chechViewmore_btn)
    TextView tvChechViewmoreBtn;
    @BindView(R.id.titleBarNo)
    RelativeLayout titleBarNo;
    @BindView(R.id.ry_checkFounderList)
    RecyclerView ryCheckFounderList;
    @BindView(R.id.Moreline)
    View Moreline;
    @BindView(R.id.tv_checkTitleMore)
    TextView tvCheckTitleMore;
    @BindView(R.id.tv_chechViewmoreMore_btn)
    TextView tvChechViewmoreMoreBtn;
    @BindView(R.id.titleBarMore)
    RelativeLayout titleBarMore;
    @BindView(R.id.ry_checkMoreList)
    RecyclerView ryCheckMoreList;
    @BindView(R.id.checkScrollView)
    ScrollView checkScrollView;
    private SearchpageAdpter searchpageAdpter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_check;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new CheckPresenterImpl();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchText.setFocusable(false);
        searchText.setFocusableInTouchMode(false);

        LinearLayoutManager FounderLayoutManager = new LinearLayoutManager(this);
        LinearLayoutManager MoreLayoutManager = new LinearLayoutManager(this);
        FounderLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        ryCheckFounderList.setLayoutManager(FounderLayoutManager);
        ryCheckFounderList.setNestedScrollingEnabled(false);
        ryCheckFounderList.addItemDecoration(new SpaceItemDecoration((int) getResources().getDimension(R.dimen.dp_10),0));
        MoreLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ryCheckMoreList.setLayoutManager(MoreLayoutManager);
        ryCheckMoreList.setNestedScrollingEnabled(false);

        List<Object> objects = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            objects.add("1");
        }

        FounderAdapter<Object> objectFounderAdapter = new FounderAdapter<>(this, objects);
        ryCheckFounderList.setAdapter(objectFounderAdapter);
        searchpageAdpter = new SearchpageAdpter(this,objects);
        ryCheckMoreList.setAdapter(searchpageAdpter);

    }

    @OnClick({R.id.gobank_btn, R.id.searchText, R.id.searech_news_btn, R.id.iv_topimage_btn, R.id.tv_chechViewmore_btn, R.id.tv_chechViewmoreMore_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searchText://搜索页面
                Intent intentSearchpage = new Intent(this, SearchpageActivity.class);
                intentSearchpage.putExtra(ConstantUtil.KEY_CODE,ConstantUtil.KEY_MORE_CODE);
                startActivity(intentSearchpage);
                break;
            case R.id.searech_news_btn:

                break;
            case R.id.iv_topimage_btn:

                break;
            case R.id.tv_chechViewmore_btn:

                break;
            case R.id.tv_chechViewmoreMore_btn:

                break;
        }
    }
}
