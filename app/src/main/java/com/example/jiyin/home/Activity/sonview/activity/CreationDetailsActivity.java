package com.example.jiyin.home.Activity.sonview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.ScreationBean;
import com.example.jiyin.home.Activity.sonview.base.ScreationBeans;
import com.example.jiyin.home.Activity.sonview.base.ScreationEnrollBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.CreationcollImpl;
import com.example.jiyin.home.Activity.sonview.sonview.CreationcollView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.utils.LogUtils;
import com.example.rootlib.widget.common.ThrowLayout;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 造物集 详情
 */
public class CreationDetailsActivity extends JiYingActivity<CreationcollView, CreationcollImpl> implements CreationcollView {

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
    @BindView(R.id.tv_CreationsPhone_btn)
    TextView tvCreationsPhoneBtn;
    @BindView(R.id.creationpate_btn)
    TextView creationpateBtn;
    @BindView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @BindView(R.id.relatvelayout)
    ConstraintLayout relatvelayout;
    private int creationId;

    private int creation_id=BaseConfig.SERVER_ERR_LOGIN_OBSOLETE;

    public static void staticActivity(Context context,int creation_id){
        context.startActivity(new Intent(context,CreationDetailsActivity.class)
                                .putExtra(ConstantUtil.KEY_CODE,creation_id)
        );
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_creation_details;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new CreationcollImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("造物季活动...");
        creationId = getIntent().getIntExtra(ConstantUtil.KEY_CODE, BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);
        if (creationId== BaseConfig.SERVER_ERR_LOGIN_OBSOLETE) {
            showSysErrLayout("数据异常，请尝试重新进入", new ThrowLayout.OnRetryListener() {
                @Override
                public void onRetry() {
                    finish();
                }
            });
        }
        presenter.getScreationData(creationId);



    }

    private void initView() {



    }

    @Override
    public void retScreation(ScreationBeans bean) {} //废弃


    /**
     * 造物集 详情
     * @param bean
     */
    @Override
    public void retScreationData(ScreationBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        creation_id = bean.getData().getCreation_id();
        tvSearchTextTitle.setText(bean.getData().getCreation_title());

        if (bean.getData().getStatus()==1) {
            creationpateBtn.setEnabled(false);
            creationpateBtn.setBackgroundColor(getResources().getColor(R.color.colorcbcbcb));
            creationpateBtn.setText("已过期");
        }else{
            creationpateBtn.setEnabled(bean.getData().getEnroll()==1?false:true);
            creationpateBtn.setBackgroundColor(bean.getData().getEnroll()==1?
                    getResources().getColor(R.color.colorcbcbcb):
                    getResources().getColor(R.color.colorSearch));
            creationpateBtn.setText(bean.getData().getEnroll()==1?"已经报名":"报名申请");
        }


        int enroll = bean.getData().getEnroll();


    }

    @Override
    public void retScreationEnroll(ScreationEnrollBean bean) {  } //废弃

    @OnClick({R.id.gobank_btn, R.id.searech_news_btn,R.id.tv_CreationsPhone_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn:

                break;
            case R.id.tv_CreationsPhone_btn: //客服

                break;
            case R.id.creationpate_btn:
                CreationapplyforActivity.startActivity(this,creation_id,tvSearchTextTitle.getText().toString());
                break;
        }
    }


}
