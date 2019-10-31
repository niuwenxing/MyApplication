package com.example.jiyin.home.Activity.sonview.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.sonview.adapter.CommodityAdapter;
import com.example.jiyin.home.Activity.sonview.sonimpl.ShopCategoryImpl;
import com.example.jiyin.home.Activity.sonview.sonview.ShopCategoryView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 商品页面
 */

public class ShopCategoryActivity extends JiYingActivity<ShopCategoryView, ShopCategoryImpl> implements ShopCategoryView {

    @BindView(R.id.gobank_btn)
    ImageView gobankBtn;
    @BindView(R.id.searchText)
    EditText searchText;
    @BindView(R.id.searech_news_btn)
    ImageView searechNewsBtn;
    @BindView(R.id.searech_Shopping_btn)
    ImageView searechShoppingBtn;
    @BindView(R.id.add_btn)
    TextView addBtn;
    @BindView(R.id.ry_ShopCommoditylist)
    RecyclerView ryShopCommoditylist;
    @BindView(R.id.tv_searchTextTitle)
    TextView tvSearchTextTitle;
    @BindView(R.id.searchView)
    LinearLayout searchView;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_shop_category;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new ShopCategoryImpl();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        searechShoppingBtn.setVisibility(View.VISIBLE);

        List<Object> objects = new ArrayList<>();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        ryShopCommoditylist.setLayoutManager(gridLayoutManager);
        ryShopCommoditylist.setNestedScrollingEnabled(false);
        ryShopCommoditylist.addItemDecoration(new SpaceItemDecoration((int) getResources().getDimension(R.dimen.dp_5),(int) getResources().getDimension(R.dimen.dp_5)));
        CommodityAdapter commodityAdapter = new CommodityAdapter(this, objects);
        ryShopCommoditylist.setAdapter(commodityAdapter);




    }

    @OnClick({R.id.gobank_btn, R.id.searech_Shopping_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_Shopping_btn:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
