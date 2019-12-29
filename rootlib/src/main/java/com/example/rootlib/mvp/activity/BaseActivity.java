package com.example.rootlib.mvp.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

import com.example.rootlib.activity.RootActivity;
import com.example.rootlib.mvp.presenter.BasePresenter;
import com.example.rootlib.mvp.view.IBaseView;
import com.example.rootlib.utils.LogUtils;

public abstract class BaseActivity<V extends IBaseView,P extends BasePresenter<V>> extends RootActivity  {

    protected  P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();
        presenter.attachView((V) this, activity);
    }

    protected abstract void createPresenter();

    protected void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    protected P getPresenter() {
        return presenter;
    }


    @Override
    protected void onDestroy() {
        if (presenter!=null) {
            presenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    /**
     * 跳转到权限设置界面
     *
     * @return
     */
    public Intent getAppDetailSettingIntent() {
        //启动应用详情页
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        return intent;
    }

    /**--------------------------------------------WebView------------------------------------*/
    public WebView webView;
    public void startWebView(WebView webView) {
        this.webView=webView;
        webView.canGoForward();
        webView.canGoBack();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setGeolocationEnabled(true);
//        webSettings.setLoadsImagesAutomatically(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);

                //返回true
                return true;
            }
        });

        if (Build.VERSION.SDK_INT >= 19) {
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setAppCacheEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        //webSettings.setBlockNetworkLoads(true);
        webView.requestFocus();
        webView.canGoBack();
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                try {
                    if(url.startsWith("weixin://") //微信
                            || url.startsWith("alipays://") //支付宝
                            || url.startsWith("mailto://") //邮件
                            || url.startsWith("tel://")//电话
                            || url.startsWith("dianping://")//大众点评
                            || url.startsWith("cmbmobilebank://")
                            || url.startsWith("paesuperbank://")
                            || url.startsWith("baiduboxlite://")
                            || url.endsWith(".apk")
                        //其他自定义的scheme
                    ) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        activity.startActivity(intent);
                        return true;
                    }
                } catch (Exception e) { //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
                    return true;//没有安装该app时，返回true，表示拦截自定义链接，但不跳转，避免弹出上面的错误页面
                }
                view.loadUrl(url);
                return true;
            }
        });


    }
    /**
     * js 交互webView.addJavascriptInterface(new android() {@interface},"android");
     *  @Override
     *     protected void onDestroy() {
     *         super.onDestroy();
     *         webView.clearCache(true);
     *         webView.clearHistory();
     *         webView.destroy();
     *     }
     * setOnClickListener(new View.OnClickListener() {
     *             @Override
     *             public void onClick(View v) {
     *                 if(webView.canGoBack()){
     *                     webView.goBack();
     *                 }else {
     *                     finish();
     *                 }
     *             }
     *         });
     *  public boolean onKeyDown(int keyCode, KeyEvent event) {
     *      if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
     *          webView.goBack();//返回上个页面
     *          return true;
     *      }
     *         return super.onKeyDown(keyCode, event);//退出H5界面
     *     }
     *
     */



}
