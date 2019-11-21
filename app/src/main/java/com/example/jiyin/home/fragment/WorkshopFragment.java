package com.example.jiyin.home.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
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
import java.util.List;

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

//    private List<CirclelabelBean.DataBean> data =new ArrayList<>();

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void init() {

        imgXiaoxi_btn.setOnClickListener(this);
        ImmersionBar.setStatusBarView(this, view);

        presenter.getCircle();

        Log.i("asdasdasd","a4a8465e41w6fa8496wef65awe6f846ewa5f16a5s4df6es165f1d854as6ef46584d98");
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

        data.add(0,new CirclelabelBean.DataBean(0,"全部"));
        data.add(0,new CirclelabelBean.DataBean(001,"关注"));

        for (CirclelabelBean.DataBean datum : data) {
            tbWorkshopTitle.addTab(tbWorkshopTitle.newTab().setText(datum.getIfication_title()));
            mFragments.add(WorkshopCardFragment.getInstance(""));
        }

        mAdapter = new MyPagerAdapter(getFragmentManager(),data);
        vpWorkshopView.setAdapter(mAdapter);
        tbWorkshopTitle.setupWithViewPager(vpWorkshopView);
    }

    @Override
    public void ReturnCircle(CircleListBean bean) {}

    private class MyPagerAdapter extends FragmentPagerAdapter {
        List<CirclelabelBean.DataBean> dataa;
        public MyPagerAdapter(FragmentManager fm,List<CirclelabelBean.DataBean> data) {
            super(fm);
            this.dataa=data;
        }

        @Override
        public int getCount() {
            return dataa.size();
        }
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mTitles[position];
//        }
        @Override
        public Fragment getItem(int position) {
            if (position < 0 || position > (mTitles.length - 1)) {
                return null;
            } else {
                // 创建fragment 圈子
                Fragment instance = WorkshopCardFragment.getInstance(position + "");
//                int type = datas.get(titles.get(position));
                Bundle titleBundle = new Bundle();
                titleBundle.putInt("type",dataa.get(position).getIfication_id());
                instance.setArguments(titleBundle);
                return instance;
            }
        }
    }

}