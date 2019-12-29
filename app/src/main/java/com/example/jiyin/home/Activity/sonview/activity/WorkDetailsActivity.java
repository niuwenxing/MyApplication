package com.example.jiyin.home.Activity.sonview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.sonview.base.WorkDetailsBase;
import com.example.jiyin.home.Activity.sonview.base.WorkProjectbase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopLabelBase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopMainBase;
import com.example.jiyin.home.Activity.sonview.sonimpl.WorkRoomImpl;
import com.example.jiyin.home.Activity.sonview.sonview.WorkRoomView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.PreferenceUtil;
import com.example.rootlib.utils.LogUtils;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 工作坊 详情页面
 */

public class WorkDetailsActivity extends JiYingActivity<WorkRoomView, WorkRoomImpl> implements WorkRoomView {

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
    @BindView(R.id.participate_btn)
    TextView mParticipate_btn;
    @BindView(R.id.tv_CustomerPhone_btn)
    TextView tv_CustomerPhone_btn;
    @BindView(R.id.webviewvv)
    WebView webviewvv;

    private int workshop_id;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_work_details;
    }

    public static void startActivity(@NonNull int work_id, Context context){
        Intent intent = new Intent(context, WorkDetailsActivity.class);
        intent.putExtra(ConstantUtil.WORKSHOPKEY,work_id);
        context.startActivity(intent);
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new WorkRoomImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("工作坊详情...");

            //详情id
        workshop_id = getIntent().getIntExtra(ConstantUtil.WORKSHOPKEY,0);
        //获取工作坊详细信息
        presenter.inFormation(workshop_id);

    }




    //事件处理
    private void initView(int enroll) {
        mParticipate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //工作坊提交view
                WorkSurfaceActivity.staSurfaceActivity(WorkDetailsActivity.this,workshop_id);
            }
        });


        webviewvv.loadUrl("http://a.gensbox.cn/jyH5/workshop.html?token="+
                PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"")
                +"&work_id="+workshop_id);
        startWebView(webviewvv);

    }


    @OnClick({R.id.gobank_btn, R.id.searech_news_btn,R.id.tv_CustomerPhone_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn:
                break;
            case R.id.tv_CustomerPhone_btn://联系客服

                break;
        }
    }


    @Override
    public void returnDatalabel(WorkshopLabelBase data) {//废弃
    }
    @Override
    public void retWorkShopMainData(WorkshopMainBase bean) {//废弃
    }

    /**
     * 返回详情信息
     * @param bean
     */
    @Override
    public void retDataWorkDetails(WorkDetailsBase bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg()); return;
        }
        //标题
        tvSearchTextTitle.setText(bean.getData().getWork_title()+"");

        mParticipate_btn.setEnabled(bean.getData().getEnroll()==0?true:false);
        mParticipate_btn.setBackgroundColor(bean.getData().getEnroll()==0?
                getResources().getColor(R.color.colorSearch):
                getResources().getColor(R.color.colorcbcbcb));
        initView(bean.getData().getEnroll());
    }

    @Override
    public void retworkShenQ(WorkSurfaceActivity.breakCode bean) { }//废弃

    @Override
    public void onfailure(String message) {}//废弃

    @Override
    public void retStudioLabel(WorkProjectbase bean) {} //废弃

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d("重新获取焦点");
        presenter.inFormation(workshop_id);
    }
}
