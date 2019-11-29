package com.example.jiyin.home.fragment;


import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.home.Activity.adapter.AbsRecycleAdapter;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.presenter.impl.WorkshopImpl;
import com.example.jiyin.home.Activity.presenter.view.WorkshopView;
import com.example.jiyin.home.fragment.adapter.CircleAdapter;
import com.example.jiyin.home.fragment.adapter.WorkShopAdapter;
import com.example.rootlib.widget.common.ThrowLayout;
import com.gyf.immersionbar.ImmersionBar;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 圈子
 */

public class WorkshopFragment extends JiYingFragment<WorkshopView, WorkshopImpl> implements WorkshopView {

    @BindView(R.id.status_bar_view)
    View statusBarView;
    @BindView(R.id.img_xiaoxi_btn)
    ImageView imgXiaoxiBtn;
    @BindView(R.id.newtbar)
    RelativeLayout newtbar;
    @BindView(R.id.throw_layout)
    ThrowLayout throwLayout;
    @BindView(R.id.mLabeltable)
    RecyclerView mLabeltable;
    @BindView(R.id.mCirclelist)
    RecyclerView mCirclelist;


    //刷新
    @BindView(R.id.refreshLayout)
    RefreshLayout refreshLayout;

    @BindView(R.id.footer)
    ClassicsFooter footer;


    private CircleAdapter circleAdapter;
    private List<CirclelabelBean.DataBean> dataList=new ArrayList<>();//标签数据集
    private List<CircleListBean.DataBean> listdata=new ArrayList<>();//列表 数据集
    private int CirclelabeType=0,pages=0;
    private WorkShopAdapter workShopAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.workshopfragment_layout;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new WorkshopImpl();
    }

    @Override
    protected void init() {
        ImmersionBar.setStatusBarView(this, statusBarView);
        //获取圈子标签
        presenter.getCircle();
        //标签布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mLabeltable.setNestedScrollingEnabled(false);
        mLabeltable.setLayoutManager(linearLayoutManager);
        circleAdapter = new CircleAdapter(getContext());
        circleAdapter.setData(dataList);
        circleAdapter.setChoiceMode(AbsRecycleAdapter.CHOICE_MODE_SINGLE);//适配器模式
        mLabeltable.setAdapter(circleAdapter);
        mLabeltable.addItemDecoration(
                new SpaceItemDecoration((int)getActivity().getResources().getDimension(R.dimen.dp_7),
                (int)getActivity().getResources().getDimension(R.dimen.dp_10)));
        initView();
        workShopAdapter = new WorkShopAdapter(activity,listdata);//点击事件内部处理
        mCirclelist.setAdapter(workShopAdapter);

    }

    private void initView() {
        circleAdapter.setOnItemClickListener(new AbsRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                CirclelabeType=position;
                //加载标签数据
                if (pages!=0) {
                    pages=0;
                }
                initData(pages,dataList.get(position).getIfication_id());
            }
        });
        refreshLayout();
    }
    //刷新系统
    private void refreshLayout() {
        if(refreshLayout==null)return;
        refreshLayout.setEnableLoadMoreWhenContentNotFull(false);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //刷新
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        refreshLayout.finishRefresh();
                    }
                },1000);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                //加载

                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        refreshLayout.finishLoadMore();
                    }
                },1000);
            }
        });

    }

    /**
     * 返回标签数据集
     *
     * @param data
     */
    @Override
    public void returnLabel(List<CirclelabelBean.DataBean> data) {
        this.dataList=data;
        data.add(0,new CirclelabelBean.DataBean("关注",001));
        data.add(0,new CirclelabelBean.DataBean("全部",000));
        circleAdapter.setData(data);
        circleAdapter.notifyDataSetChanged();
        circleAdapter.setItemChecked(CirclelabeType,true);//默认选择第一个
        initData(0,000);

    }

    /**    列表数据
     * @param pages 页数
     * @param mType 数据类型
     */
    private void initData(int pages ,int mType) {
        presenter.circle(pages,mType);
    }

    @Override
    public void ReturnCircle(CircleListBean bean) {
        workShopAdapter.setNewsDate(bean.getData());

    }


    @OnClick(R.id.img_xiaoxi_btn)
    public void onViewClicked() {

    }

}