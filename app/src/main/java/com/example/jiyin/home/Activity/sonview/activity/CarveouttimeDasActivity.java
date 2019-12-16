package com.example.jiyin.home.Activity.sonview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.PositionEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.ZtimeIndexBean;
import com.example.jiyin.home.Activity.sonview.base.ZtimedetailBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.CarveouttimeImpl;
import com.example.jiyin.home.Activity.sonview.sonview.CarveouttimeView;
import com.example.rootlib.widget.common.ThrowLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 琢璞 时间 详情
 */

public class CarveouttimeDasActivity extends JiYingActivity<CarveouttimeView, CarveouttimeImpl> implements CarveouttimeView {

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
    TextView lpk;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.tv_CarveouttimePhone_btn)
    TextView tvCarveouttimePhoneBtn;
    @BindView(R.id.carveouttime_btn)
    TextView carveouttimeBtn;
    @BindView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @BindView(R.id.relatvelayout)
    ConstraintLayout relatvelayout;
    private int mZid;
    private int mZid1;
    private String z_text;
    private String z_title;
    private int mMCzid;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_carveouttime_das;
    }

    public static void startActivity(Context context,int zid){
        context.startActivity(new Intent(context,CarveouttimeDasActivity.class)
            .putExtra("zid",zid)
        );
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new CarveouttimeImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("琢璞时间活动...");
        //id
        mZid = getIntent().getIntExtra("zid", BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);


        presenter.getZtimedetail(mZid);

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.getZtimedetail(mZid);
    }

    @Override
    public void retZtimeIndex(ZtimeIndexBean bean) { }//废弃

    /**
     * 详情数据
     * @param bean
     */
    @Override
    public void retZtimedetail(ZtimedetailBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        mZid1 = bean.getData().getZid();
        z_title = bean.getData().getZ_title();
        mMCzid = bean.getData().getZid();

        tvSearchTextTitle.setText(z_title);


        if (bean.getData().getStatus()==1) {
            carveouttimeBtn.setEnabled(false);
            carveouttimeBtn.setBackgroundColor(getResources().getColor(R.color.colorcbcbcb));
            carveouttimeBtn.setText("已过期");
        }else{
            carveouttimeBtn.setEnabled(bean.getData().getEnroll()==1?false:true);
            carveouttimeBtn.setBackgroundColor(bean.getData().getEnroll()==1?
                    getResources().getColor(R.color.colorcbcbcb):
                    getResources().getColor(R.color.colorSearch));
            carveouttimeBtn.setText(bean.getData().getEnroll()==1?"已经报名":"报名申请");
        }




    }

    @Override
    public void retZtimeenroll(PositionEnrollBean bean) {  }//废弃

    @Override
    public void retSysErr(String errn) { }//废弃

    @OnClick({R.id.gobank_btn, R.id.carveouttime_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.carveouttime_btn://报名
                CarveouttimeApplyActivity.startActivity(this,mMCzid,z_title);
                break;
        }
    }



}
