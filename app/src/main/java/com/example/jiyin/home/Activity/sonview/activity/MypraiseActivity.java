package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.sonview.base.MineAplyDosBean;
import com.example.jiyin.home.Activity.sonview.base.UserInfoBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.fragment.adapter.WorkShopASAdapter;
import com.example.jiyin.home.presenter.Impl.MypageImpl;
import com.example.jiyin.home.presenter.view.MypageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的赞
 */
public class MypraiseActivity extends JiYingActivity<MypageView, MypageImpl> implements MypageView {

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
    @BindView(R.id.recy_list)
    RecyclerView recyList;

    private int page=1;
    private WorkShopASAdapter workShopAdapter;
    private List<CircleListBean.DataBean> data=new ArrayList<>();

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_mypraise;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new MypageImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setText("我的赞");

        //点击事件内部处理
        workShopAdapter = new WorkShopASAdapter(data);
        recyList.setAdapter(workShopAdapter);

        presenter.getMinemyUp(page);


    }

    @Override
    public void retUserInfo(UserInfoBean bean) {
    }

    @Override
    public void err(String str) {
        toast(str);
    }

    @Override
    public void retUserAvatarEdit(UserReplyBean bean) {
    }

    @Override
    public void retNameSetName(UserReplyBean bean) {
    }

    @Override
    public void Code(CodeBase bean) {
    }

    @Override
    public void retUserTelEdit(UserReplyBean bean) {
    }

    @Override
    public void retUserPassEdit(UserReplyBean bean) {
    }

    @Override
    public void retMineApplyDos(MineAplyDosBean bean) {
    }

    /**
     * 我的赞返回的数据
     * @param bean
     */
    @Override
    public void retMinemyUp(CircleListBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        this.data.clear();
        this.data.addAll(bean.getData());
        workShopAdapter.notifyDataSetChanged();


    }

    @OnClick(R.id.gobank_btn)
    public void onViewClicked() {
        finish();
    }
}
