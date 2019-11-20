package com.example.jiyin.interactive;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.widget.ClearEditText;
import com.example.jiyin.home.fragment.SearchFragment;
import com.example.jiyin.interactive.Adapter.CityAdapter;
import com.example.jiyin.utils.PhoneUtil;
import com.example.rootlib.utils.Contacts.IndexableAdapter;
import com.example.rootlib.utils.Contacts.IndexableLayout;
import com.github.promeg.pinyinhelper.Pinyin;
import com.github.promeg.tinypinyin.lexicons.android.cncity.CnCityDict;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 联系人 页面
 */

public class ContactsActivity extends JiYingActivity {

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
    @BindView(R.id.indexableLayout)
    IndexableLayout indexableLayout;
    SearchFragment mSearchFragment;
    @BindView(R.id.searchview)
    ClearEditText mSearchView;


    private List<PhoneUtil.PhoneDto> phoneDtos;
    private PhoneUtil phoneUtil;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_contacts;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("联系人");
        searechNewsBtn.setVisibility(View.INVISIBLE);
        check();
        mSearchFragment = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.search_fragment);
        indexableLayout.setLayoutManager(new LinearLayoutManager(this));
//        mSearchFragment.bindDatas(phoneUtil.getPhone());
        mSearchFragment.bindDatas(phoneDtos);
        // 多音字处理
        Pinyin.init(Pinyin.newConfig().with(CnCityDict.getInstance(this)));
        // 快速排序。  排序规则设置为：只按首字母  （默认全拼音排序）  效率很高，是默认的10倍左右。  按需开启～
        indexableLayout.setCompareMode(IndexableLayout.MODE_FAST);

        CityAdapter adapter = new CityAdapter(this);
        indexableLayout.setAdapter(adapter);
//        adapter.setDatas(phoneUtil.getPhone());
        adapter.setDatas(phoneDtos);

        indexableLayout.setOverlayStyle_Center();
        adapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<PhoneUtil.PhoneDto>() {
            @Override
            public void onItemClick(View v, int originalPosition, int currentPosition, PhoneUtil.PhoneDto entity) {
                Toast.makeText(ContactsActivity.this, "" + entity.getName() + "---" + entity.getTelPhone(), Toast.LENGTH_SHORT).show();
            }
        });
        initSearch();

    }

    //初始化搜索
    private void initSearch() {
        getSupportFragmentManager().beginTransaction().hide(mSearchFragment).commit();
        mSearchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence.toString().trim().length() > 0) {
                    if (mSearchFragment.isHidden()) {
                        getSupportFragmentManager().beginTransaction().show(mSearchFragment).commit();
                    }
                } else {
                    if (!mSearchFragment.isHidden()) {
                        getSupportFragmentManager().beginTransaction().hide(mSearchFragment).commit();
                    }
                }
                mSearchFragment.bindQueryText(charSequence.toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void check() {
        //判断是否有权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 201);
        } else {
            initViews();
        }
    }

    private void initViews() {
        phoneUtil = new PhoneUtil(this);
        phoneDtos = phoneUtil.getPhone();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 201) {
            initViews();
        } else {
            return;
        }

    }

    @OnClick(R.id.gobank_btn)
    public void onViewClicked() {
        finish();
    }
}
