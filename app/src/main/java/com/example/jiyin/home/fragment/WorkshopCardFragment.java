package com.example.jiyin.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.presenter.impl.WorkshopImpl;
import com.example.jiyin.home.Activity.presenter.view.WorkshopView;
import com.example.jiyin.home.Activity.view.ImagePreviewActivity;
import com.example.jiyin.home.fragment.adapter.WorkShopAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.jzvd.JzvdStd;

/**
 * 圈子 子页面
 */
public class WorkshopCardFragment extends JiYingFragment<WorkshopView, WorkshopImpl> implements WorkshopView {

//    @BindView(R.id.fragment_circle)
//    RecyclerView mfragment_circle;

    @BindView(R.id.refreshLayout)
    RefreshLayout refreshLayout;

    @BindView(R.id.footer)
    ClassicsFooter footer;


    private String mTitle;
    //圈子类型
    private int mType;
    private int itemPosition;
    private Bundle   mReenterState;


    private int _firstItemPosition = -1, _lastItemPosition;
    private View fistView, lastView;
    private WorkShopAdapter workShopAdapter;

    private List o=new ArrayList<>();
    private int pages=0;


    //
    //recyclerView = this.findViewById(R.id.recyclerView);
    //        refreshLayout = this.findViewById(R.id.refreshLayout);
//


    public static Fragment getInstance(String title) {
        WorkshopCardFragment sf = new WorkshopCardFragment();
        sf.mTitle = title;
        return sf;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.workshopcard_layout;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter=new WorkshopImpl();
    }

    @Override
    protected void init() {
        initView();
        initData(pages);

    }
    //实例化数据
    private void initData(int pages) {
        presenter.circle(pages,mType);
    }

    //实例化view
    private void initView() {
//        mType = getArguments().getInt("type", 0);
        workShopAdapter = new WorkShopAdapter(activity, o);
//        mfragment_circle.setAdapter(workShopAdapter);
//        ScrollListener(mfragment_circle);//滑动监听
        refreshLayout();

    }

    // 刷新逻辑
    private void refreshLayout() {
        if(refreshLayout!=null){
            refreshLayout.autoRefresh();
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
                    },1000);}
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

//        footer.setNoMoreData(false); //设置加载更多
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (workShopAdapter!=null) {
                workShopAdapter.notifyDataSetChanged();
            }
        }else{

        }
    }

    //滑动监听
    private void ScrollListener(RecyclerView mfragment_circle) {
        mfragment_circle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                //判断是当前layoutManager是否为LinearLayoutManager
                // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                    //获取最后一个可见view的位置
                    int lastItemPosition = linearManager.findLastVisibleItemPosition();
                    //获取第一个可见view的位置
                    int firstItemPosition = linearManager.findFirstVisibleItemPosition();
                    //获取可见view的总数
                    int visibleItemCount = linearManager.getChildCount();

                    if (_firstItemPosition < firstItemPosition) {
                        _firstItemPosition = firstItemPosition;
                        _lastItemPosition = lastItemPosition;
                        GCView(fistView);
                        fistView = recyclerView.getChildAt(0);
                        lastView = recyclerView.getChildAt(visibleItemCount - 1);
                    } else if (_lastItemPosition > lastItemPosition) {
                        _firstItemPosition = firstItemPosition;
                        _lastItemPosition = lastItemPosition;
                        GCView(lastView);
                        fistView = recyclerView.getChildAt(0);
                        lastView = recyclerView.getChildAt(visibleItemCount - 1);
                    }
                }
            }
            /**
             *回收播放器
             */
            public void GCView(View gcView) {
//                if (gcView != null && gcView.findViewById(R.id.jz_JZVideo) != null) {
//                    JzvdStd video = activity.findViewById(R.id.jz_JZVideo);
//                    video.releaseAllVideos();
//
//                }
            }

        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mReenterState = new Bundle(data.getExtras());
        int startingPosition = mReenterState.getInt(ImagePreviewActivity.P.CURRENT_ITEM_POSITION);
        if (startingPosition != itemPosition) {//如果不是同一个item就滚动到指定的item
//            mfragment_circle.scrollToPosition(itemPosition); }
            postponeEnterTransition();
//        mfragment_circle.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
//            @Override
//            public boolean onPreDraw() {
//                mfragment_circle.getViewTreeObserver().removeOnPreDrawListener(this);
//                mfragment_circle.requestLayout();
//                startPostponedEnterTransition();
//                return true;
//            }
//        });
        }
    }

//    @Override
//    public void returnLabel(List<CirclelabelBean.DataBean> data) {
//
//    }
//
//    @Override
//    public void ReturnCircle(CircleListBean bean) {
//
//    }


//    @Override
//    public void onPause() {
//        super.onPause();
//        JZVideoPlayer.releaseAllVideos();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
//
    @Override
    public void returnLabel(List<CirclelabelBean.DataBean> data) {}

    @Override
    public void ReturnCircle(CircleListBean bean) {

    }
    }


