package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.widget.banner.BannerLayout;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.sonview.adapter.ShoppingBannerAdapter;
import com.example.jiyin.home.Activity.sonview.adapter.ShoppingListAdapter;
import com.example.jiyin.home.Activity.sonview.sonimpl.ShoppingPresenterImpl;
import com.example.jiyin.home.Activity.sonview.sonview.ShoppingView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 商城页面
 */

public class ShoppingActivity extends JiYingActivity<ShoppingView, ShoppingPresenterImpl> implements ShoppingView, BannerLayout.OnBannerItemClickListener {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.tv_LocationText_btn)
    TextView tvLocationText_btn;
    @BindView(R.id.img_shoppingvehicle_btn)
    ImageView imgShoppingvehicleBtn;
    @BindView(R.id.gobank_btn)
    ImageView gobankBtn;
    @BindView(R.id.searchText)
    EditText searchText;
    @BindView(R.id.searech_news_btn)
    ImageView searechNewsBtn;
    @BindView(R.id.add_btn)
    TextView addBtn;
    @BindView(R.id.bl_Bannerrecycler)
    BannerLayout blBannerrecycler;
    @BindView(R.id.ry_commodityList)
    RecyclerView ryCommodityList;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_shopping;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new ShoppingPresenterImpl();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searechNewsBtn.setVisibility(View.INVISIBLE);

        List<String> objit=new ArrayList<>();

        ShoppingBannerAdapter<Object> objectShoppingBannerAdapter = new ShoppingBannerAdapter(this,objit);
        blBannerrecycler.setAdapter(objectShoppingBannerAdapter);
        LinearLayoutManager ShopingManager = new LinearLayoutManager(this);
        ryCommodityList.setLayoutManager(ShopingManager);
        ryCommodityList.setNestedScrollingEnabled(false);
        ryCommodityList.addItemDecoration(new SpaceItemDecoration((int) getResources().getDimension(R.dimen.dp_10),0));
        ShoppingListAdapter<String> shoppingListAdapter = new ShoppingListAdapter(this, objit);
        ryCommodityList.setAdapter(shoppingListAdapter);
        objectShoppingBannerAdapter.setOnBannerItemClickListener(this);

    }

    @OnClick({R.id.img_shoppingvehicle_btn, R.id.gobank_btn, R.id.searech_news_btn,R.id.tv_LocationText_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_shoppingvehicle_btn://购物车
                break;
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn://
                break;
            case R.id.tv_LocationText_btn://定位

                break;
        }
    }

    @Override
    public void onItemClick(int position) {

    }
}
