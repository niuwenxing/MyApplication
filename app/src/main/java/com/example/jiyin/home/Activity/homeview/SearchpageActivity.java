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

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.adapter.ProjectAdapter;
import com.example.jiyin.home.Activity.presenter.impl.SearchpagePImpl;
import com.example.jiyin.home.Activity.adapter.SearchpageAdpter;
import com.example.jiyin.home.Activity.presenter.view.SearchpageView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.utils.StringUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    private ProjectAdapter<Object> objectProjectAdapter;

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
        List objects = new ArrayList<>();
        //更多
        if (!StringUtil.isEmpty(contextKey)&&contextKey.equals(ConstantUtil.KEY_MORE_CODE)) {
            searchpageAdpter = new SearchpageAdpter(this, objects);
            searchList.setAdapter(searchpageAdpter);
        }
        //项目
        if (!StringUtil.isEmpty(contextKey)&&contextKey.equals(ConstantUtil.KEY_PROJECT_CODE)) {
            objectProjectAdapter = new ProjectAdapter<>(this,objects);
            searchList.setAdapter(objectProjectAdapter);
        }
        //短视屏
        if (!StringUtil.isEmpty(contextKey)&&contextKey.equals(ConstantUtil.KEY_SHORTVIDEO_CODE)) {

        }
        presenter.getData();

        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //点击搜索的时候隐藏软键盘
                    searchText.clearFocus();
                    hideKeyboard(searchText);
                    int length = searchText.getText().toString().length();
                    for (int i = 0; i < length; i++) {
                        objects.add("");
                    }
                    if (StringUtil.isEmpty(contextKey)&&contextKey.equals(ConstantUtil.KEY_MORE_CODE)){
                        searchpageAdpter.notifyDataSetChanged();
                    }
                    if (StringUtil.isEmpty(contextKey)&&contextKey.equals(ConstantUtil.KEY_PROJECT_CODE)) {
                        objectProjectAdapter.notifyDataSetChanged();
                    }

                    // 在这里写搜索的操作,一般都是网络请求数据
                    return true;
                }
                return false;
            }
        });
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
    public void upData(String shuju_yihui) {
        searchpageAdpter.notifyDataSetChanged();
    }
}
