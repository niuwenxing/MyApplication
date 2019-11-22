package com.example.jiyin.home.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.presenter.impl.WorkshopImpl;
import com.example.jiyin.home.Activity.presenter.view.WorkshopView;
import com.google.android.material.tabs.TabLayout;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * 圈子
 */

public class WorkshopFragment extends JiYingFragment<WorkshopView, WorkshopImpl> implements WorkshopView,View.OnClickListener {

    @BindView(R.id.tb_WorkshopTitle)
    TabLayout tbWorkshopTitle;
    @BindView(R.id.vp_WorkshopView)
    ViewPager vpWorkshopView;
    @BindView(R.id.status_bar_view)
    View view;
    @BindView(R.id.img_xiaoxi_btn)
    ImageView imgXiaoxi_btn;

    private List<CirclelabelBean.DataBean> qdata ;

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
    protected void createPresenter() {
        super.createPresenter();
        presenter = new WorkshopImpl();
    }

    @Override
    protected void init() {

        imgXiaoxi_btn.setOnClickListener(this);
        ImmersionBar.setStatusBarView(this, view);
        presenter.getCircle();

        qdata =new ArrayList<>();

        tbWorkshopTitle.setupWithViewPager(vpWorkshopView);
        vpWorkshopView.setOffscreenPageLimit(2);
        mAdapter = new MyPagerAdapter(getFragmentManager(),qdata);

        vpWorkshopView.setAdapter(mAdapter);
    }



    @Override
    public void onClick(View v) {

    }

    /**
     * 返回标签数据集
     * @param data
     */
    @Override
    public void returnLabel(List<CirclelabelBean.DataBean> data) {
        qdata.clear();qdata.addAll(data);
        qdata.add(0,new CirclelabelBean.DataBean(001,"关注"));
        qdata.add(0,new CirclelabelBean.DataBean(0,"全部"));

        mAdapter.updateData(qdata);


    }

    @Override
    public void ReturnCircle(CircleListBean bean) {}

    private class MyPagerAdapter extends FragmentPagerAdapter {
        /**
         * fragments容器
         */
        Map<String, Fragment> fragments;
        private FragmentTransaction mCurTransaction = null;

        private FragmentManager fragmentManager = null;

        private List<CirclelabelBean.DataBean> datas = new ArrayList<>();

        public MyPagerAdapter(@NonNull FragmentManager fm,List<CirclelabelBean.DataBean> awd) {
            super(fm);
            fragmentManager = fm;
            fragments = new HashMap<>();
            datas.clear();
            datas.addAll(awd);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position < 0 || position > (datas.size())) {
                return null;
            } else {
                return new WorkshopCardFragment();
            }
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return PagerAdapter.POSITION_NONE;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            Fragment f= (WorkshopCardFragment)super.instantiateItem(container, position);
            Bundle titleBundle = new Bundle();
            titleBundle.putInt("type", datas.get(position).getIfication_id());
            f.setArguments(titleBundle);
            return f;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            super.destroyItem(container, position, object);
            if(mCurTransaction == null){
                mCurTransaction = fragmentManager.beginTransaction();
            }
            mCurTransaction.remove((Fragment) object);
        }

        @Override
        public long getItemId(int position) {
            return datas.get(position).getIfication_id();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return datas.get(position).getIfication_title();
        }
        public void updateData(List<CirclelabelBean.DataBean> datatitle){
            if (mCurTransaction!=null) {
                mCurTransaction = fragmentManager.beginTransaction();
            }
            datas.clear();
            datas.addAll(datatitle);
            notifyDataSetChanged();
        }

    }

}

/**
 *
 * Fragment instance = WorkshopCardFragment.getInstance(position + "");
 *                  int type = datas.get(titles.get(position));
 *                Bundle titleBundle = new Bundle();
 *                titleBundle.putInt("type",qdata.get(position).getIfication_id());
 *                instance.setArguments(titleBundle);
 *                return instance;
 */