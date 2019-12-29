package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.sonview.adapter.HeadlinesAdapter;
import com.example.jiyin.home.Activity.sonview.base.NewIndexBean;
import com.example.jiyin.home.Activity.sonview.base.NewdetailBean;
import com.example.jiyin.home.Activity.sonview.base.Toutiao;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.HeadlinesImpl;
import com.example.jiyin.home.Activity.sonview.sonview.HeadlinesView;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 头条页面
 */
public class HeadlinesActivity extends JiYingActivity<HeadlinesView, HeadlinesImpl> implements HeadlinesView {

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
    @BindView(R.id.ry_headlineList)
    RecyclerView ryHeadlineList;

    private  int page=1;
    private List<NewIndexBean.DataBean> data=new ArrayList<>();
    private HeadlinesAdapter stringHeadlinesAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_headlines;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter=new HeadlinesImpl();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("头条");

        ryHeadlineList.setLayoutManager(new LinearLayoutManager(this));
        stringHeadlinesAdapter = new HeadlinesAdapter(data);
        ryHeadlineList.setAdapter(stringHeadlinesAdapter);

        stringHeadlinesAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HeadlinesDetailsActivity.startheadActivity(activity,data.get(position).getNew_id());
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getNewIndex(page);
    }

    @Override
    public void retNewIndex(NewIndexBean bean) {
        data.clear();
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        data.addAll(bean.getData());
        stringHeadlinesAdapter.notifyDataSetChanged();

    }

    @Override
    public void retNewDetail(NewdetailBean bean) {}//废弃

    @Override
    public void retNewdetails(Toutiao bean) { }//废弃

    @OnClick({R.id.gobank_btn, R.id.searech_news_btn, R.id.searech_Shopping_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn: //消息

                break;
        }
    }
}
