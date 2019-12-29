package com.example.jiyin.home.Activity.sonview.activity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.adapter.AbsRecycleAdapter;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.sonview.base.AgencyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.VideoDetailBean;
import com.example.jiyin.home.Activity.sonview.base.VideoindexBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.TopViewImpl;
import com.example.jiyin.home.Activity.sonview.sonview.TopView;
import com.example.rootlib.widget.common.ThrowLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Top
 * 视屏列表页
 */

public class TopActivity extends JiYingActivity<TopView, TopViewImpl> implements TopView{

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
    @BindView(R.id.topLabelHlist)
    RecyclerView topLabelHlist;
    @BindView(R.id.throw_layout)
    ThrowLayout throwLayout;
    @BindView(R.id.headerview)
    ClassicsHeader headerview;
    @BindView(R.id.topVlist)
    RecyclerView topVlist;
    @BindView(R.id.topfooterview)
    ClassicsFooter topfooterview;


    private int pages=1;
    private int postion=0;
    private int ificationId=0;
    private String name="";

    private List<VideoindexBean.DataBean.IficationBean> ificationList =new ArrayList<>();
    private List<VideoindexBean.DataBean.VideoBean> videoList = new ArrayList<>();
    private IfIcationAdapter ifIcationAdapter;
    private com.example.jiyin.home.Activity.sonview.activity.videoListAdapter videoListAdapter;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_top;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new TopViewImpl();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("Top");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        topLabelHlist.setLayoutManager(linearLayoutManager);
        //标签数据
        ifIcationAdapter = new IfIcationAdapter(this);
        ifIcationAdapter.setData(ificationList);
        ifIcationAdapter.setChoiceMode(AbsRecycleAdapter.CHOICE_MODE_SINGLE);//适配器模式
        topLabelHlist.setAdapter(ifIcationAdapter);
        topLabelHlist.addItemDecoration(
                new SpaceItemDecoration((int)getResources().getDimension(R.dimen.dp_7),
                        (int)getResources().getDimension(R.dimen.dp_7)));

        //列表数据
        videoListAdapter = new videoListAdapter(videoList);
        topVlist.setAdapter(videoListAdapter);
        initView();


        videoListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                TopVideoDetailsActivity.startTopVideo(TopActivity.this,videoList.get(position).getVideo_id(),
//                        videoList.get(position).getVideo_path());
                Intent intent = new Intent(TopActivity.this, TopVideoDetailsActivity.class);
                intent.putExtra("videoId", videoList.get(position).getVideo_id());
                intent.putExtra("video_path", videoList.get(position).getVideo_path());
                startActivity(intent);
            }
        });



    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.getVideoindex(pages,ificationId,name);

    }

    private void initView() {
           ifIcationAdapter.setOnItemClickListener(new AbsRecycleAdapter.OnItemClickListener() {
               @Override
               public void onItemClick(int position, View v) {
                   postion=position;
                   if (pages!=0) {
                       pages=0;
                   }name="";
                   presenter.getVideoindex(pages,ificationList.get(position).getIfication_id(),name);
               }
           });
           //列表点击数据
        videoListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                TopVideoDetailsActivity.startTopVideo(TopActivity.this,videoList.get(position).getVideo_id(),
                        videoList.get(position).getVideo_path());
            }
        });

    }

    @OnClick(R.id.gobank_btn)
    public void onViewClicked() {
        finish();
    }

    //首页数据
    @Override
    public void retVideoindex(VideoindexBean bean) {
        ificationList.clear();
        videoList.clear();
        if (bean.getCode()==-1) {
            toast(""+bean.getMsg());
            return;
        }
        ificationList.addAll(bean.getData().getIfication());
        videoList.addAll(bean.getData().getVideo());
        ificationList.add(0,new VideoindexBean.DataBean.IficationBean(0,"全部"));
        ifIcationAdapter.setData(ificationList);
        ifIcationAdapter.notifyDataSetChanged();
        ifIcationAdapter.setItemChecked(postion,true);
        videoListAdapter.setNewData(videoList);
        
    }

    @Override
    public void retVideoDetailData(VideoDetailBean bean) { } //废弃

    @Override
    public void retAgencydetail(AgencyDetailBean bean) { }//废弃
}
