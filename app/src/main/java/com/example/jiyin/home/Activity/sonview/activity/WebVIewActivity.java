package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.PreferenceUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * webView
 */
public class WebVIewActivity extends JiYingActivity {

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
    @BindView(R.id.webviewAll)
    WebView webviewAll;
    private String stringExtra;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("详情");
        stringExtra = getIntent().getStringExtra(ConstantUtil.KEY_CODE);

        startWebView(webviewAll);

        if(stringExtra.equals("hongren")){
            int founder_id = getIntent().getIntExtra("founder_id", 11);
            webviewAll.loadUrl("http://a.gensbox.cn/jyH5/personalDetails.html?founder_id="+founder_id);
        }else if(stringExtra.equals("toutiao")){
            int new_id = getIntent().getIntExtra("new_id", 11);
            webviewAll.loadUrl("http://a.gensbox.cn/jyH5/newsDetails.html?token="+ PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00")
            +"&new_id="+new_id+"&stories_id="+"&page=1"
            );
        }else if(stringExtra.equals("xiangmu")){
            int new_id = getIntent().getIntExtra("new_id", 11);
            webviewAll.loadUrl("http://a.gensbox.cn/jyH5/projectDetails.html?new_id="+new_id);
        }else if(stringExtra.equals("shequ")){
            int community_id = getIntent().getIntExtra("community_id", 11);
            webviewAll.loadUrl("http://a.gensbox.cn/jyH5/baseDetails.html?community_id="+community_id);
        }else if(stringExtra.equals("wodedingdan")){
            webviewAll.loadUrl("http://a.gensbox.cn/jyH5/myOrder.html");
        }else if(stringExtra.equals("gouwuche")){
            webviewAll.loadUrl("http://a.gensbox.cn/jyH5/shopCar.html");
        }else if(stringExtra.equals("wodeshoucan")){
            webviewAll.loadUrl("http://a.gensbox.cn/jyH5/wholePage_enshrine.html");
        }else if(stringExtra.equals("upaddress")){
            webviewAll.loadUrl("http://a.gensbox.cn/jyH5/shippingAddress.html");
        }

    }

    @OnClick(R.id.gobank_btn)
    public void onViewClicked() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }
    }
}
