package com.example.jiyin.home.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingFragment;
import com.google.android.material.tabs.TabLayout;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 圈子
 */

public class WorkshopFragment extends JiYingFragment implements View.OnClickListener {

    @BindView(R.id.tb_WorkshopTitle)
    TabLayout tbWorkshopTitle;
    @BindView(R.id.vp_WorkshopView)
    ViewPager vpWorkshopView;
    @BindView(R.id.status_bar_view)
    View view;
    @BindView(R.id.img_xiaoxi_btn)
    ImageView imgXiaoxi_btn;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private final String[] mTitles = {
            "全部", "关注", "电竞类"
            , "投资类", "工艺类", "原创类"
    };
    @Override
    protected int attachLayoutRes() {
        return R.layout.workshopfragment_layout;
    }

    @Override
    protected void init() {
        ImmersionBar.setStatusBarView(this, view);
        imgXiaoxi_btn.setOnClickListener(this);
        for (String title : mTitles) {
            tbWorkshopTitle.addTab(tbWorkshopTitle.newTab().setText(title));
            mFragments.add(WorkshopCardFragment.getInstance(title));
        }

        mAdapter = new MyPagerAdapter(getFragmentManager());
        vpWorkshopView.setAdapter(mAdapter);
        tbWorkshopTitle.setupWithViewPager(vpWorkshopView);

    }

    @Override
    public void onClick(View v) {

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
        @Override
        public Fragment getItem(int position) {

            if (position < 0 || position > (mTitles.length - 1)) {
                return null;
            } else {
                // 创建fragment 圈子
                Fragment instance = WorkshopCardFragment.getInstance(position + "");
//                int type = datas.get(titles.get(position));
                Bundle titleBundle = new Bundle();
                titleBundle.putInt("type",position);
                instance.setArguments(titleBundle);
                return instance;
            }

        }
    }
}
