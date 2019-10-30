package com.example.jiyin.home.Activity;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.Impl.SearchpagePImpl;
import com.example.jiyin.home.Activity.adapter.SearchpageAdpter;
import com.example.jiyin.home.Activity.view.SearchpageView;
import com.example.rootlib.widget.common.ThrowLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

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

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_searchpage;
    }

    @Override
    protected void createPresenter() {
        presenter = new SearchpagePImpl();
    }

    @Override
    protected void init() {
        super.init();
        ButterKnife.bind(this);
        List objects = new ArrayList<>();

        presenter.getData();



        searchList.setLayoutManager(new LinearLayoutManager(this));
        searchpageAdpter = new SearchpageAdpter(this, objects);
        searchList.setAdapter(searchpageAdpter);
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

                    searchpageAdpter.notifyDataSetChanged();
                    // 在这里写搜索的操作,一般都是网络请求数据
                    return true;
                }
                return false;
            }
        });
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

    }
}
