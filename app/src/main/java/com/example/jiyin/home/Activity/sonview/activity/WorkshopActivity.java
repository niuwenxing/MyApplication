package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.adapter.AbsRecycleAdapter;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.sonview.adapter.WorkshopAdapter;
import com.example.jiyin.home.Activity.sonview.adapter.WorkshopListAdapter;
import com.example.jiyin.home.Activity.sonview.base.WorkDetailsBase;
import com.example.jiyin.home.Activity.sonview.base.WorkProjectbase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopLabelBase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopMainBase;
import com.example.jiyin.home.Activity.sonview.sonimpl.WorkRoomImpl;
import com.example.jiyin.home.Activity.sonview.sonview.WorkRoomView;
import com.example.jiyin.home.fragment.adapter.BaseRecyclerViewAdapter;
import com.example.jiyin.home.fragment.adapter.CircleAdapter;
import com.example.jiyin.home.fragment.adapter.RecyclerViewHolder;
import com.example.jiyin.utils.GlideImageLoader;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <>
 * 工作坊页面
 * </>
 */


public class WorkshopActivity extends JiYingActivity<WorkRoomView, WorkRoomImpl> implements WorkRoomView {

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

    @BindView(R.id.textHtml)
    TextView mTextHtml;
    @BindView(R.id.lableimage)
    ImageView mLableimage;


    //横向列表
    @BindView(R.id.mRoomLabel)
    RecyclerView mRoomLabel;
    //纵向列表
    @BindView(R.id.mRoomList)
    RecyclerView mRoomList;

    private int pages=0;//页数
    private int ification_id=0;  //默认全部
    private int positions=0;//位置


    private List<WorkshopLabelBase.DataBean> data1=new ArrayList<>();//标签数据集
    private WorkshopAdapter circleAdapter;
    List<WorkshopMainBase.DataBean.WorkshopBean> workshopListdata =new ArrayList<>();//列表数据集
    private WorkshopListAdapter workshopListAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_workshop;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter=new WorkRoomImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("工作坊");
        presenter.workshoplabel();//获取标签

        //标签列表
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRoomLabel.setLayoutManager(linearLayoutManager);
        mRoomList.setNestedScrollingEnabled(false);
        LinearLayoutManager linearmRoomList = new LinearLayoutManager(this);
        linearmRoomList.setOrientation(LinearLayoutManager.VERTICAL);
        mRoomList.setLayoutManager(linearmRoomList);
        circleAdapter = new WorkshopAdapter(this);
        circleAdapter.setData(data1);
        mRoomLabel.setAdapter(circleAdapter);
        circleAdapter.setChoiceMode(AbsRecycleAdapter.CHOICE_MODE_SINGLE);//适配器模式
        mRoomLabel.addItemDecoration(
                new SpaceItemDecoration((int)getResources().getDimension(R.dimen.dp_7),
                        (int)getResources().getDimension(R.dimen.dp_7)));
        //列表的数据
        workshopListAdapter = new WorkshopListAdapter(workshopListdata);

        mRoomList.setAdapter(workshopListAdapter);


        initView();


    }

    private void initView() {
        circleAdapter.setOnItemClickListener(new AbsRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                positions=position;
                ification_id=data1.get(position).getIfication_id();

                if (pages!=0) {
                    pages=0;
                }
                initData(pages,ification_id);
            }
        });
        onChildClickfot();
    }


    /**
     * 点击事件
     * 工作坊详情
     */
    private void onChildClickfot() {
        workshopListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WorkDetailsActivity.startActivity(workshopListdata.get(position).getWork_id(),WorkshopActivity.this);
            }
        });
    }

    //请求
    private void initData(int pages, int ification_id) {
        presenter.globaldata(pages,ification_id);
    }


    @OnClick({R.id.gobank_btn,R.id.searech_news_btn})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn://消息

                break;

        }

    }

    /**
     * @param data 返回数据
     */
    @Override
    public void returnDatalabel(WorkshopLabelBase data) {
        if (data.getCode()==-1) {
            toast(""+data.getMsg());
            return;
        }
        this.data1.clear();
        this.data1=data.getData();
        circleAdapter.setData(data1);
        circleAdapter.notifyDataSetChanged();
        presenter.globaldata(pages,ification_id);//发起请求
        circleAdapter.setItemChecked(positions,true);//默认选择第一个
    }

    /**
     * 首页数据
     * @param bean
     */
    @Override
    public void retWorkShopMainData(WorkshopMainBase bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg().toString());
            return;
        }
//        GlideImageLoader.load(this, BaseConfig.ROOT_IMAGES_API+bean.getData().getMaintain().getMaintain_path(),mLableimage);
        Glide.with(this).load(BaseConfig.ROOT_IMAGES_API+"/upload/default/20191028/9a88a60cc598683752a6fb1adfd593b5.jpg").into(mLableimage);
        mTextHtml.setText(Html.fromHtml(bean.getData().getMaintain().getMaintain_text()));
        this.workshopListdata.clear();
        this.workshopListdata.addAll(bean.getData().getWorkshop());
        workshopListAdapter.setNewData(workshopListdata);

    }

    @Override
    public void retDataWorkDetails(WorkDetailsBase bean) {}//废弃

    @Override
    public void retworkShenQ(WorkSurfaceActivity.breakCode bean) { }//废弃

    @Override
    public void onfailure(String message) { } //废弃

    @Override
    public void retStudioLabel(WorkProjectbase bean) { }//废弃


}

