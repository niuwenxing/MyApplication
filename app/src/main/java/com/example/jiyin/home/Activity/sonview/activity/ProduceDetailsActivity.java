package com.example.jiyin.home.Activity.sonview.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.net.android;
import com.example.jiyin.home.Activity.sonview.base.ProduceDetailBean;
import com.example.jiyin.home.Activity.sonview.base.ProduceIndexBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.ProduceImpl;
import com.example.jiyin.home.Activity.sonview.sonview.ProduceView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 玑瑛出品详情
 */
public class ProduceDetailsActivity extends JiYingActivity<ProduceView, ProduceImpl> implements ProduceView {

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
    @BindView(R.id.lpk)
    WebView lpk;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.tv_CreaPhone_btn)
    TextView tvCreationsPhoneBtn;
    @BindView(R.id.creationpatea_btn)
    TextView creationpateBtn;
    @BindView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @BindView(R.id.relatvelayout)
    ConstraintLayout relatvelayout;
    private int produceId;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_produce_details;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new ProduceImpl();
    }

    public static void startsActvity(Context context,int produce_id){
        context.startActivity(new Intent(context,ProduceDetailsActivity.class)
            .putExtra(ConstantUtil.KEY_CODE,produce_id)
        );
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("玑瑛出品");
        produceId = getIntent().getIntExtra(ConstantUtil.KEY_CODE, BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);

    }

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onStart() {
        super.onStart();
        presenter.getProduceDetail(produceId);


        startWebView(lpk);
        lpk.loadUrl("http://a.gensbox.cn/jyH5/detailPage.html?produce_id="+produceId);
        lpk.addJavascriptInterface(new android() {
            @Override
            public void btn_seekCooperation(String work_id,String token) {

            }

            @Override
            public void btn_seekCooperation() {
                
            }

            @Override
            public void btn_collect(String work_id,String token) {

            }

            @Override
            public void btn_application() {

            }

            @Override
            public void ipt_application() {

            }

            @Override
            public void btn_overdue() {

            }
        }, "android");




    }

    @Override
    public void retProduceDetail(ProduceDetailBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        tvSearchTextTitle.setText(bean.getData().getProduce_title());

    }

    @Override
    public void retProduceIndex(ProduceIndexBean bean) {
    }//废弃

    @OnClick({R.id.gobank_btn, R.id.tv_CreaPhone_btn, R.id.creationpatea_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.tv_CreaPhone_btn:

                break;
            case R.id.creationpatea_btn:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.clearCache(true);
        webView.clearHistory();
        webView.destroy();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && lpk.canGoBack()) {
            lpk.goBack();//返回上个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);//退出H5界面
    }

}
