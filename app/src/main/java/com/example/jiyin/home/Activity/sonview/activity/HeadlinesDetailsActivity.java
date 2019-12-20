package com.example.jiyin.home.Activity.sonview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.detail.CommentExpandableListView;
import com.example.jiyin.home.Activity.sonview.base.NewIndexBean;
import com.example.jiyin.home.Activity.sonview.base.NewdetailBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.HeadlinesImpl;
import com.example.jiyin.home.Activity.sonview.sonview.HeadlinesView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 头条 详情
 */

public class HeadlinesDetailsActivity extends JiYingActivity<HeadlinesView, HeadlinesImpl> implements HeadlinesView {

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
    @BindView(R.id.webviewwhity)
    WebView webviewwhity;
    @BindView(R.id.expandableListView)
    CommentExpandableListView expandableListView;
    @BindView(R.id.tv_comment_btn)
    TextView tvCommentBtn;
    @BindView(R.id.cb_headlineCheck_btn)
    CheckBox cbHeadlineCheckBtn;

    private int page;
    private int newId;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_headlines_details;
    }

    public static void startheadActivity(Context context, int new_id) {
        context.startActivity(new Intent(context, HeadlinesDetailsActivity.class)
                .putExtra(ConstantUtil.KEY_CODE, new_id)
        );
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new HeadlinesImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("详情");
        newId = getIntent().getIntExtra(ConstantUtil.KEY_CODE, BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);

        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getNewDetail(page, newId);


    }

    private void initView() {
        cbHeadlineCheckBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!cbHeadlineCheckBtn.isChecked()){
                    cbHeadlineCheckBtn.setChecked(false);
                }else {
                    cbHeadlineCheckBtn.setChecked(true);
                }
            }
        });
    }

    @Override
    public void retNewIndex(NewIndexBean bean) {
    } //废弃

    /**
     * 头条详情 数据返回
     *
     * @param bean
     */
    @Override
    public void retNewDetail(NewdetailBean bean) {
        if (bean.getCode() == -1) {
            toast(bean.getMsg());
            return;
        }
        tvSearchTextTitle.setText(bean.getData().getNew_title());


    }

    @OnClick({R.id.gobank_btn, R.id.searech_news_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn:
                break;
        }
    }
}
