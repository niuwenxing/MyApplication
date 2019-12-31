package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.widget.banner.BannerLayout;
import com.example.jiyin.home.Activity.sonview.sonimpl.ShoppingPresenterImpl;
import com.example.jiyin.home.Activity.sonview.sonview.ShoppingView;

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
    @BindView(R.id.webview_view)
    WebView webview_view;
    @BindView(R.id.searchView)
    LinearLayout searchView;
    @BindView(R.id.tv_searchTextTitle)
    TextView tvSearchTextTitle;
    @BindView(R.id.searech_Shopping_btn)
    ImageView searechShoppingBtn;

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
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setText("市集");
        startWebView(webview_view);
        webview_view.loadUrl("http://a.gensbox.cn/jyH5/fair.html");

//        List<String> objit=new ArrayList<>();
//
//        ShoppingBannerAdapter<Object> objectShoppingBannerAdapter = new ShoppingBannerAdapter(this,objit,R.layout.item_image);
//        blBannerrecycler.setAdapter(objectShoppingBannerAdapter);
//        LinearLayoutManager ShopingManager = new LinearLayoutManager(this);
//        ryCommodityList.setLayoutManager(ShopingManager);
//        ryCommodityList.setNestedScrollingEnabled(false);
//        ryCommodityList.addItemDecoration(new SpaceItemDecoration((int) getResources().getDimension(R.dimen.dp_10),0));
//        ShoppingListAdapter<String> shoppingListAdapter = new ShoppingListAdapter(this, objit);
//        ryCommodityList.setAdapter(shoppingListAdapter);
//        objectShoppingBannerAdapter.setOnBannerItemClickListener(this);

    }

    @OnClick({R.id.img_shoppingvehicle_btn, R.id.gobank_btn, R.id.searech_news_btn, R.id.tv_LocationText_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_shoppingvehicle_btn://购物车
                break;
            case R.id.gobank_btn:
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
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

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();//返回上个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);//退出H5界面
    }
}
