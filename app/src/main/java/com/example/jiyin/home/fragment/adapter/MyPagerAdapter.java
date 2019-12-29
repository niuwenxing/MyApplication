package com.example.jiyin.home.fragment.adapter;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.fragment.WorkshopCardFragment;

import java.util.ArrayList;

public class MyPagerAdapter extends OpenPagerAdapter<CirclelabelBean.DataBean> {

    private ArrayList<CirclelabelBean.DataBean> dataFragment=new ArrayList<>();


    public  MyPagerAdapter(FragmentManager fm, ArrayList<CirclelabelBean.DataBean> dataFragments) {
        super(fm);
        dataFragment.clear();
        if(dataFragment!=null)dataFragment.addAll(dataFragments);
    }

    @Override
    public Fragment getItem(int position) {
        return  new WorkshopCardFragment();
    }

    @Override
    protected CirclelabelBean.DataBean getItemData(int position) {
        return dataFragment.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "第一"+position;
//        return dataFragment.get(position).getIfication_title();
    }

    @Override
    protected boolean dataEquals(CirclelabelBean.DataBean oldData, CirclelabelBean.DataBean newData) {
        return oldData.equals(newData);
    }

    @Override
    protected int getDataPosition(CirclelabelBean.DataBean data) {
        return dataFragment.indexOf(data);
    }


    @Override
    public int getCount() {
        return dataFragment.size();
    }

    public void setNewData(ArrayList<CirclelabelBean.DataBean> newData){
        dataFragment.clear();
        dataFragment.addAll(newData);
        notifyDataSetChanged();
    }

    public void addData(CirclelabelBean.DataBean mfragment){
//        if (dataFragment.size()==0) {
//            dataFragment.add(0,mfragment);
//        }
        dataFragment.add(mfragment);
        notifyDataSetChanged();
    }

    public void removeView(int position) {
        if (dataFragment.size()==0) return;
        dataFragment.remove(position);
        notifyDataSetChanged();
    }
}