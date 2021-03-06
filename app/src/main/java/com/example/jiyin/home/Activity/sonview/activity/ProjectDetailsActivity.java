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
import com.example.jiyin.home.Activity.presenter.impl.SearchpagePImpl;
import com.example.jiyin.home.Activity.presenter.view.SearchpageView;
import com.example.jiyin.home.Activity.sonview.base.ClassifyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.ClassifyIndexBean;
import com.example.jiyin.home.Activity.sonview.base.CommunityindexBean;
import com.example.jiyin.home.Activity.sonview.base.FounderListBean;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 项目详情
 */
public class ProjectDetailsActivity extends JiYingActivity<SearchpageView, SearchpagePImpl> implements SearchpageView {

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
    @BindView(R.id.tv_ProjectPhone_btn)
    TextView tvProjectPhoneBtn;
    @BindView(R.id.tv_Projectpate_btn)
    TextView tvProjectpateBtn;
    @BindView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @BindView(R.id.relatvelayout)
    ConstraintLayout relatvelayout;
    private int newId;
    private int new_idS;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_project_details;
    }

    public static void startProjectDetails(Context context,int new_id){
        context.startActivity(new Intent(context,ProjectDetailsActivity.class)
            .putExtra(ConstantUtil.KEY_CODE,new_id)
        );

    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new SearchpagePImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("项目");

        newId = getIntent().getIntExtra(ConstantUtil.KEY_CODE, BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);


    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getClassifyDetailNew(newId);
    }

    /**
     * 项目详情
     * @param bean
     */
    @Override
    public void retClassifyDetailNew(ClassifyDetailBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        ClassifyDetailBean.DataBean data = bean.getData();
        new_idS = data.getNew_id();
        String new_title = data.getNew_title();
        String new_text = data.getNew_text();

        tvSearchTextTitle.setText(new_title);
        tvProjectpateBtn.setBackgroundColor(getResources().getColor(R.color.colorSearch));

    }

    @Override
    public void retFounderfounderList(FounderListBean bean) { }//废弃

    @Override
    public void retCommunityindex(CommunityindexBean bean) {

    }

    @Override
    public void retClassifyDetail(ClassifyIndexBean bean) {
    }//废弃 项目列表

    @OnClick({R.id.gobank_btn, R.id.tv_ProjectPhone_btn, R.id.tv_Projectpate_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.tv_ProjectPhone_btn:
                break;
            case R.id.tv_Projectpate_btn:

                break;
        }
    }
}
