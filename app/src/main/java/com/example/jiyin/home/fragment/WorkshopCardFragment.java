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
import com.example.jiyin.home.Activity.homeview.base.UserCircleUpBean;
import com.example.jiyin.home.Activity.presenter.impl.WorkshopImpl;
import com.example.jiyin.home.Activity.presenter.view.WorkshopView;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.Activity.sonview.base.UsercircleDetailBean;
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
    public void ReturnCircle(CircleListBean bean) { }

    @Override
    public void retUsercircleUp(UserCircleUpBean bean,boolean a) {  }//废弃

    @Override
    public void retUserfollow(UserCircleUpBean bean) {  } //废弃

    @Override
    public void retUsercircleShare(UserCircleUpBean bean) { }//废弃

    @Override
    public void retUsercircleDetail(UsercircleDetailBean bean) { }//废弃

    @Override
    public void retNetErr(String err) {
        toast(err);
    }

    @Override
    public void retUserReply(UserReplyBean bean) { } //废弃

    @Override
    public void retMinemyUprelease(CircleListBean bean) { }//废弃

    @Override
    public void retUserCircleDel(UserReplyBean bean) { }//废弃
}


