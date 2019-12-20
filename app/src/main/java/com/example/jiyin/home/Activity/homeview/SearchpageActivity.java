package com.example.jiyin.home.Activity.homeview;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.adapter.ProjectAdapter;
import com.example.jiyin.home.Activity.presenter.impl.SearchpagePImpl;
import com.example.jiyin.home.Activity.adapter.SearchpageAdpter;
import com.example.jiyin.home.Activity.presenter.view.SearchpageView;
import com.example.jiyin.home.Activity.sonview.activity.ProduceDetailsActivity;
import com.example.jiyin.home.Activity.sonview.activity.ProjectDetailsActivity;
import com.example.jiyin.home.Activity.sonview.base.ClassifyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.ClassifyIndexBean;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.utils.StringUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 搜索页面
 *
 */

public class SearchpageActivity extends JiYingActivity<SearchpageView, SearchpagePImpl> implements SearchpageView {

    @BindView(R.id.gobank_btn)
    ImageView gobankBtn;
    @BindView(R.id.searchText)
    EditText searchText;
    @BindView(R.id.searech_news_btn)
    ImageView searechNewsBtn;
    @BindView(R.id.searchList)
    RecyclerView searchList;
    @BindView(R.id.add_btn)
    TextView addBtn;
    @BindView(R.id.throw_layout)
    ThrowLayout throwLayout;
    private SearchpageAdpter searchpageAdpter;

    private String contextKey;
    private ProjectAdapter objectProjectAdapter;
    private List objects;
    private String nameStr="";
    private int page=1;
    private List<ClassifyIndexBean.DataBean> data=new ArrayList<>();

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_searchpage;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        contextKey = intent.getStringExtra(ConstantUtil.KEY_CODE);
        searchList.setLayoutManager(new LinearLayoutManager(this));
        objects = new ArrayList<>();

        //短视屏
        if (!StringUtil.isEmpty(contextKey)&&contextKey.equals(ConstantUtil.KEY_SHORTVIDEO_CODE)) {

        }

        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //点击搜索的时候隐藏软键盘
                    searchText.clearFocus();
                    hideKeyboard(searchText);
                    if (StringUtil.isEmpty(contextKey)&&contextKey.equals(ConstantUtil.KEY_MORE_CODE)){
                        searchpageAdpter.notifyDataSetChanged();

                    }
                    if (StringUtil.isEmpty(contextKey)&&contextKey.equals(ConstantUtil.KEY_PROJECT_CODE)) {
                        nameStr=searchText.getText().toString();
                        presenter.getClassifyDetail(nameStr,page);
                    }

                    // 在这里写搜索的操作,一般都是网络请求数据
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //更多
        if (!StringUtil.isEmpty(contextKey)&&contextKey.equals(ConstantUtil.KEY_MORE_CODE)) {
//            searchpageAdpter = new SearchpageAdpter(this, objects);
//            searchList.setAdapter(searchpageAdpter);


        }
        //项目
        if (!StringUtil.isEmpty(contextKey)&&contextKey.equals(ConstantUtil.KEY_PROJECT_CODE)) {
            objectProjectAdapter = new ProjectAdapter(data); //
            searchList.setAdapter(objectProjectAdapter);
            presenter.getClassifyDetail(nameStr,page);//网络请求
            objectProjectAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    ProjectDetailsActivity.startProjectDetails(activity,data.get(position).getNew_id());
                }
            });
        }





    }

    @Override
    protected void createPresenter() {
        presenter = new SearchpagePImpl();
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


    @Override
    public void retClassifyDetail(ClassifyIndexBean bean) {
        data.clear();
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        data.addAll(bean.getData());
        objectProjectAdapter.notifyDataSetChanged();

    }

    @Override
    public void retClassifyDetailNew(ClassifyDetailBean bean) { } //废弃
}
