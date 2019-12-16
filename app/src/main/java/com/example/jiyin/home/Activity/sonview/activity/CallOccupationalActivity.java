package com.example.jiyin.home.Activity.sonview.activity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.adapter.OccupationalAdapter;
import com.example.jiyin.home.Activity.sonview.base.PositionDetailBean;
import com.example.jiyin.home.Activity.sonview.base.PositionEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIficationBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIndexBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.OccupationalImpl;
import com.example.jiyin.home.Activity.sonview.sonview.OccupationalVeiw;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.GlideImageLoader;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 玑瑛职呼
 */

public class CallOccupationalActivity extends JiYingActivity<OccupationalVeiw, OccupationalImpl> implements OccupationalVeiw {

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
    @BindView(R.id.iv_OccupationalImage)
    ImageView ivOccupationalImage;
    @BindView(R.id.tv_OccupationalTextHtml)
    TextView tvOccupationalTextHtml;
    @BindView(R.id.tv_screen_btn)
    TextView tvScreenBtn;
    @BindView(R.id.rv_OccupationalList)
    RecyclerView rvOccupationalList;

    private int gificationId=0;//岗位
    private int xificationId=0;//学生
    private int zificationId=0;//职务
    private int page=1;

    private List<PositionIndexBean.DataBean.PositionBean> position=new ArrayList<>();
    private OccupationalAdapter occupationalAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_call_occupational;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new OccupationalImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setText("玑瑛职呼");
        presenter.getPositionIndex(page,gificationId,xificationId,zificationId);

        occupationalAdapter = new OccupationalAdapter(position);
        rvOccupationalList.setAdapter(occupationalAdapter);

        initView();
    }

    private void initView() {
        occupationalAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int positions) {
                JobdetailsActivity.startcActivity(CallOccupationalActivity.this,position.get(positions).getPosition_id());
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0x002&&resultCode==0x0023){
            gificationId =data.getIntExtra(ConstantUtil.GIFICATIONID,gificationId);
            xificationId =data.getIntExtra(ConstantUtil.XIFICATIONID,xificationId);
            zificationId =data.getIntExtra(ConstantUtil.ZIFICATIONID,zificationId);
            if (page!=1) {
                page=1;
            }
            presenter.getPositionIndex(page,gificationId,xificationId,zificationId);
        }


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.getPositionIndex(page,gificationId,xificationId,zificationId);
    }

    @OnClick({R.id.gobank_btn, R.id.searech_news_btn, R.id.tv_screen_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn:
                break;
            case R.id.tv_screen_btn://点击筛选
                startActivityForResult(new Intent(CallOccupationalActivity.this, ScreenActivity.class)
                        , 0x002);
                break;
        }
    }

    @Override
    public void retPositionIndex(PositionIndexBean bean) {
        position.clear();
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }

        tvOccupationalTextHtml.setText(Html.fromHtml(bean.getData().getMaintain().getMaintain_text()));
        GlideImageLoader.load(this,
                BaseConfig.ROOT_IMAGES_API+bean.getData().getMaintain().getMaintain_path(),
                ivOccupationalImage);
        position.addAll(bean.getData().getPosition());
        occupationalAdapter.notifyDataSetChanged();
    }

    @Override
    public void retPositionIfication(PositionIficationBean bean) {}//废弃

    @Override
    public void retPositionDetail(PositionDetailBean bean) {}//废弃

    @Override
    public void retPositionEnroll(PositionEnrollBean bean) { }//废弃


}
