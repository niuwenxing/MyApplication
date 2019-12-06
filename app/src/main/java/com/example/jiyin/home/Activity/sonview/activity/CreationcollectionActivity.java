package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.sonview.adapter.NewestAdapter;
import com.example.jiyin.home.Activity.sonview.sonimpl.CreationcollImpl;
import com.example.jiyin.home.Activity.sonview.sonview.CreationcollView;
import com.example.rootlib.widget.common.ThrowLayout;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 造物集
 */

public class CreationcollectionActivity extends JiYingActivity<CreationcollView, CreationcollImpl> implements CreationcollView, RadioGroup.OnCheckedChangeListener {

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
    @BindView(R.id.iv_CreationImage)
    ImageView ivCreationImage;
    @BindView(R.id.tv_CreationTextHtml)
    TextView tvCreationTextHtml;
    @BindView(R.id.rb_NewestClass_bt)
    RadioButton rbNewestClassBt;
    @BindView(R.id.rb_Pastperiod_btn)
    RadioButton rbPastperiodBtn;
    @BindView(R.id.rg_StudyGroup)
    RadioGroup rgStudyGroup;
    @BindView(R.id.rv_Creationlist)
    RecyclerView rvCreationlist;

    private int page=1;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_creationcollection;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("造物集");
        rgStudyGroup.setOnCheckedChangeListener(this);

        presenter.getScreationIndex(page);
        //
//        NewestAdapter newestAdapter = new NewestAdapter();


    }

    @OnClick({R.id.gobank_btn, R.id.iv_CreationImage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.iv_CreationImage:

                break;
        }
    }

    //点击时间
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId==R.id.rb_NewestClass_bt) {

        }
        if (checkedId==R.id.rb_Pastperiod_btn) {

        }
    }
}
