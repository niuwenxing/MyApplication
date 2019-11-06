package com.example.jiyin.home.Activity.sonview.activity;

import android.content.Intent;
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
import com.example.jiyin.common.widget.banner.BannerLayout;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.homeview.SearchpageActivity;
import com.example.jiyin.home.Activity.sonview.adapter.CommunityAdapter;
import com.example.jiyin.home.Activity.sonview.adapter.ShoppingBannerAdapter;
import com.example.jiyin.home.Activity.sonview.sonimpl.CommunityImpl;
import com.example.jiyin.home.Activity.sonview.sonview.CommunityView;
import com.example.jiyin.utils.ConstantUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 社群页面
 */

public class CommunityActivity extends JiYingActivity<CommunityView, CommunityImpl> implements CommunityView, BannerLayout.OnBannerItemClickListener {

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
    @BindView(R.id.bl_CommunityBanner)
    BannerLayout blCommunityBanner;
    @BindView(R.id.CommunityList)
    RecyclerView CommunityList;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_community;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new CommunityImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchText.setFocusable(false);
        searchText.setFocusableInTouchMode(false);
        List<Object> objects = new ArrayList<>();


        ShoppingBannerAdapter communityBanner= new ShoppingBannerAdapter(this,objects,R.layout.communitybanner_item);
        blCommunityBanner.setAdapter(communityBanner);
        communityBanner.setOnBannerItemClickListener(this);


        LinearLayoutManager ShopingManager = new LinearLayoutManager(this);
        CommunityList.setLayoutManager(ShopingManager);
        CommunityList.setNestedScrollingEnabled(false);
        CommunityList.addItemDecoration(new SpaceItemDecoration(0,(int) getResources().getDimension(R.dimen.dp_10)));
        CommunityAdapter communityAdapter = new CommunityAdapter(this,objects);
        CommunityList.setAdapter(communityAdapter);


    }

    @OnClick({R.id.gobank_btn, R.id.searchText, R.id.searchView, R.id.tv_searchTextTitle, R.id.searech_news_btn, R.id.searech_Shopping_btn, R.id.bl_CommunityBanner, R.id.CommunityList})
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
            case R.id.searchView:
                break;
            case R.id.tv_searchTextTitle:
                break;
            case R.id.searech_news_btn:
                break;
            case R.id.searech_Shopping_btn:
                break;
            case R.id.bl_CommunityBanner:
                break;
            case R.id.CommunityList:
                break;
        }
    }

    //banner 事件监听
    @Override
    public void onItemClick(int position) {

    }
}
