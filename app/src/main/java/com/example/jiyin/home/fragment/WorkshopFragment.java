package com.example.jiyin.home.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.home.Activity.adapter.AbsRecycleAdapter;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.homeview.base.UserCircleUpBean;
import com.example.jiyin.home.Activity.presenter.impl.WorkshopImpl;
import com.example.jiyin.home.Activity.presenter.view.WorkshopView;
import com.example.jiyin.home.Activity.sonview.activity.WorkPoldetailsActivity;
import com.example.jiyin.home.Activity.sonview.activity.WorkshopdetailsActivity;
import com.example.jiyin.home.Activity.sonview.base.MinecircleBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.Activity.sonview.base.UsercircleDetailBean;
import com.example.jiyin.home.fragment.adapter.CircleAdapter;
import com.example.jiyin.home.fragment.adapter.WorkShopASAdapter;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.utils.CollectionUtil;
import com.example.rootlib.utils.LogUtils;
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
 * 圈子首页
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
    private int CirclelabeType=0,pages=1;
    private WorkShopASAdapter workShopAdapter;
    private List<CircleListBean.DataBean> data=new ArrayList<>();//列表

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
        //标签数据集
        circleAdapter = new CircleAdapter(getContext());
        circleAdapter.setData(dataList);
        circleAdapter.setChoiceMode(AbsRecycleAdapter.CHOICE_MODE_SINGLE);//适配器模式
        mLabeltable.setAdapter(circleAdapter);
        mLabeltable.addItemDecoration(
                new SpaceItemDecoration((int)getActivity().getResources().getDimension(R.dimen.dp_7),
                (int)getActivity().getResources().getDimension(R.dimen.dp_10)));
        initView();
        //列表数据
        workShopAdapter = new WorkShopASAdapter(data);//点击事件内部处理
        mCirclelist.setAdapter(workShopAdapter);
        workShopAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(activity,WorkshopdetailsActivity.class)
                    .putExtra(ConstantUtil.KEY_CODE,data.get(position).getCircle_id())
                );
            }
        });

        //点赞
        workShopAdapter.setOnclick(new WorkShopASAdapter.Mtvbaidu() {
            @Override
            public void onclick(@NonNull int circleid, Boolean zan) {
                presenter.UsercircleUp(circleid,zan);
            }
        });
        //关注
        workShopAdapter.setOnclick(new WorkShopASAdapter.Myguanzu() {
            @Override
            public void onclick(@NonNull int follow_uid) {
                presenter.Userfollow(follow_uid);
            }
        });
        //分享
        workShopAdapter.setOnclick(new WorkShopASAdapter.Myfengxian() {
            @Override
            public void onclick(@NonNull int circle_id) {
                presenter.UsercircleShare(circle_id);
            }
        });



    }

    private void initView() {
        circleAdapter.setOnItemClickListener(new AbsRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                CirclelabeType=position;
                //加载标签数据
                if (pages!=1) {
                    pages=1;
                }
                initData(pages,dataList.get(position).getIfication_id());
            }
        });
        refreshLayout();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!CollectionUtil.isEmpty(dataList)) {
//            initData(pages,dataList.get(CirclelabeType).getIfication_id());
        }

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
                        initData(pages,dataList.get(CirclelabeType).getIfication_id());
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
        data.clear();
        data.addAll(bean.getData());
        LogUtils.d("Wai1"+data.size());
        workShopAdapter.notifyDataSetChanged();

    }
    //圈子点赞
    @Override
    public void retUsercircleUp(UserCircleUpBean bean, boolean zan) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg().toString());
            workShopAdapter.notifyDataSetChanged();
            return;
        }
        if (zan) {
            toast(bean.getMsg());
        }else{
            toast("已取消");
        }
    }

    /**
     * 圈子关注
     * @param bean
     */
    @Override
    public void retUserfollow(UserCircleUpBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            workShopAdapter.notifyDataSetChanged();
            return;
        }
        toast(bean.getMsg());
    }

    /**
     * 圈子分享
     * @param bean
     */
    @Override
    public void retUsercircleShare(UserCircleUpBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            workShopAdapter.notifyDataSetChanged();
            return;
        }
        toast(bean.getMsg());
    }

    @Override
    public void retUsercircleDetail(UsercircleDetailBean bean) { }//废弃

    @Override
    public void retNetErr(String err) {
        toast(err);
    }

    @Override
    public void retUserReply(UserReplyBean bean) {  }//废弃

    @Override
    public void retMinemyUprelease(CircleListBean bean) { }//废弃

    @Override
    public void retUserCircleDel(UserReplyBean bean,int pos) {


    }//废弃

    @Override
    public void retMinecircle(MinecircleBean.DataBean data) { }

    @OnClick(R.id.img_xiaoxi_btn)
    public void onViewClicked() {

    }

}