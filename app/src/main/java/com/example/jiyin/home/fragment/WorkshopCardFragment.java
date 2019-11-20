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
import com.example.jiyin.home.Activity.view.ImagePreviewActivity;
import com.example.jiyin.home.fragment.adapter.WorkShopAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * 圈子 子页面
 */
public class WorkshopCardFragment extends JiYingFragment {

    @BindView(R.id.fragment_circle)
    RecyclerView mfragment_circle;
    private String mTitle;
    //圈子类型
    private int mType;
    private int itemPosition;
    private Bundle   mReenterState;


    private int _firstItemPosition = -1, _lastItemPosition;
    private View fistView, lastView;
    private WorkShopAdapter workShopAdapter;

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
    protected void init() {
        mType = getArguments().getInt("type", 0);
        LinearLayoutManager MoreLayoutManager = new LinearLayoutManager(getContext());
        mfragment_circle.setLayoutManager(MoreLayoutManager);
        List o=new ArrayList<>();
        workShopAdapter = new WorkShopAdapter(activity, o);
        mfragment_circle.setAdapter(workShopAdapter);
        ScrollListener(mfragment_circle);
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
                if (gcView != null && gcView.findViewById(R.id.jz_JZVideo) != null) {
                    JZVideoPlayerStandard  video = activity.findViewById(R.id.jz_JZVideo);
                    video.releaseAllVideos();

                }
            }

        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mReenterState = new Bundle(data.getExtras());
        int startingPosition = mReenterState.getInt(ImagePreviewActivity.P.CURRENT_ITEM_POSITION);
        if (startingPosition != itemPosition) {//如果不是同一个item就滚动到指定的item
            mfragment_circle.scrollToPosition(itemPosition);
        }
        postponeEnterTransition();
        mfragment_circle.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                mfragment_circle.getViewTreeObserver().removeOnPreDrawListener(this);
                mfragment_circle.requestLayout();
                startPostponedEnterTransition();
                return true;
            }
        });
    }


    @Override
    public void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }


}
