package com.example.jiyin.home.Activity.sonview.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.adapter.AbsRecycleAdapter;
import com.example.jiyin.home.Activity.adapter.RecyclerViewSpacesItemDecoration;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.sonview.base.PositionDetailBean;
import com.example.jiyin.home.Activity.sonview.base.PositionEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIficationBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIndexBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.OccupationalImpl;
import com.example.jiyin.home.Activity.sonview.sonview.OccupationalVeiw;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.utils.CollectionUtil;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 职呼 筛选页面
 */

public class ScreenActivity extends JiYingActivity<OccupationalVeiw, OccupationalImpl> implements OccupationalVeiw {

    @BindView(R.id.position_type_recy)
    RecyclerView positionTypeRecy;
    @BindView(R.id.student_type_recy)
    RecyclerView studentTypeRecy;
    @BindView(R.id.position2_type_recy)
    RecyclerView position2TypeRecy;
    private HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();

    private List<PositionIficationBean.DataBean.GdocBean> gdoc=new ArrayList<>();//岗位类型
    private List<PositionIficationBean.DataBean.XdocBean> xdoc=new ArrayList<>();//学生类型
    private List<PositionIficationBean.DataBean.ZdocBean> zdoc=new ArrayList<>();//职务类型
    private GdocAdapter gdocadapter;
    private XdocAdapter xdocadapter;
    private ZdocAdapter zdocadapter;

    private int gificationId=0;
    private int xificationId=0;
    private int zificationId=0;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_screen;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new OccupationalImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.RIGHT_DECORATION,
                (int)getResources().getDimension(R.dimen.dp_12));
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION,
                (int)getResources().getDimension(R.dimen.dp_10));
        positionTypeRecy.setLayoutManager(new GridLayoutManager(this,3));
        studentTypeRecy.setLayoutManager(new GridLayoutManager(this,3));
        position2TypeRecy.addItemDecoration(new RecyclerViewSpacesItemDecoration(stringIntegerHashMap));
        position2TypeRecy.setLayoutManager(new FlexboxLayoutManager(this));

        gdocadapter = new GdocAdapter( );
        xdocadapter = new XdocAdapter( );
        zdocadapter = new ZdocAdapter();
        gdocadapter.setData(gdoc);
        xdocadapter.setData(xdoc);
        zdocadapter.setData(zdoc);
        positionTypeRecy.setAdapter(gdocadapter);
        studentTypeRecy.setAdapter(xdocadapter);
        position2TypeRecy.setAdapter(zdocadapter);

        //默认选中 第一个
         gdocadapter.setChoiceMode(AbsRecycleAdapter.CHOICE_MODE_SINGLE);
         xdocadapter.setChoiceMode(AbsRecycleAdapter.CHOICE_MODE_SINGLE);
         zdocadapter.setChoiceMode(AbsRecycleAdapter.CHOICE_MODE_SINGLE);

        presenter.getPositionIfication();

        initView();

    }


    private void initView() {
        gdocadapter.setOnItemClickListener(new AbsRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                gificationId=gdoc.get(position).getIfication_id();
            }
        });
        xdocadapter.setOnItemClickListener(new AbsRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                xificationId=xdoc.get(position).getIfication_id();
            }
        });
        zdocadapter.setOnItemClickListener(new AbsRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                zificationId=zdoc.get(position).getIfication_id();
            }
        });

    }

    @Override
    public void retPositionIndex(PositionIndexBean bean) { }//废弃

    /**
     * 筛选数据返回
     * @param bean
     */
    @Override
    public void retPositionIfication(PositionIficationBean bean) {
        gdoc.clear();
        xdoc.clear();
        zdoc.clear();
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        gdoc.addAll(bean.getData().getGdoc());//岗位类型
        xdoc.addAll(bean.getData().getXdoc());//学生类型
        zdoc.addAll(bean.getData().getZdoc());//职务类型
        gdocadapter.setData(bean.getData().getGdoc());
        xdocadapter.setData(bean.getData().getXdoc());
        zdocadapter.setData(bean.getData().getZdoc());

        gdocadapter.notifyDataSetChanged();
        xdocadapter.notifyDataSetChanged();
        zdocadapter.notifyDataSetChanged();

        if (!CollectionUtil.isEmpty(bean.getData().getGdoc())) {
            gificationId=bean.getData().getGdoc().get(0).getIfication_id();
        }
        if (!CollectionUtil.isEmpty(bean.getData().getXdoc())) {
            xificationId=bean.getData().getXdoc().get(0).getIfication_id();
        }
        if (!CollectionUtil.isEmpty(bean.getData().getZdoc())) {
            zificationId=bean.getData().getZdoc().get(0).getIfication_id();
        }

        gdocadapter.setItemChecked(0,true);
        xdocadapter.setItemChecked(0,true);
        zdocadapter.setItemChecked(0,true);

    }

    @Override
    public void retPositionDetail(PositionDetailBean bean) { }//废弃

    @Override
    public void retPositionEnroll(PositionEnrollBean bean) { }//废弃

    @OnClick({R.id.imageView5_btn, R.id.textView29_btn, R.id.textView30_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView5_btn:
                finish();
                break;
            case R.id.textView29_btn://重置
                gificationId=0;
                xificationId=0;
                zificationId=0;
                gdocadapter.setItemChecked(0,true);
                xdocadapter.setItemChecked(0,true);
                zdocadapter.setItemChecked(0,true);
                break;
            case R.id.textView30_btn://确认
                Intent intent = new Intent();
                intent.putExtra(ConstantUtil.GIFICATIONID,gificationId);
                intent.putExtra(ConstantUtil.XIFICATIONID,xificationId);
                intent.putExtra(ConstantUtil.ZIFICATIONID,zificationId);
                setResult(0x0023,intent);
                finish();
                break;
        }
    }

    public class GdocAdapter extends AbsRecycleAdapter<PositionIficationBean.DataBean.GdocBean>{

        @Override
        public int getLayoutId(int viewType) {
            return R.layout.item_position_type;
        }

        @Override
        public void convert(VH holder, PositionIficationBean.DataBean.GdocBean data, int position) {
            holder.setText(R.id.tv_title,data.getIfication_title());
            holder.setTextColor(R.id.tv_title,data.isChecked()?
                    getResources().getColor(R.color.colorSearch):
                    getResources().getColor(R.color.color343434));
            holder.setBackgroundResource(R.id.tv_title,data.isChecked()?
                    R.drawable.label_select:
                    R.drawable.label_unselect);

        }
    }
    public class XdocAdapter extends AbsRecycleAdapter<PositionIficationBean.DataBean.XdocBean>{

        @Override
        public int getLayoutId(int viewType) {
            return R.layout.item_position_type;
        }

        @Override
        public void convert(VH holder, PositionIficationBean.DataBean.XdocBean data, int position) {
            holder.setText(R.id.tv_title,data.getIfication_title());
            holder.setTextColor(R.id.tv_title,data.isChecked()?
                    getResources().getColor(R.color.colorSearch):
                    getResources().getColor(R.color.color343434));
            holder.setBackgroundResource(R.id.tv_title,data.isChecked()?
                    R.drawable.label_select:
                    R.drawable.label_unselect);

        }
    }
    public class ZdocAdapter extends AbsRecycleAdapter<PositionIficationBean.DataBean.ZdocBean>{

        @Override
        public int getLayoutId(int viewType) {
            return R.layout.item_position_type_liu;
        }

        @Override
        public void convert(VH holder, PositionIficationBean.DataBean.ZdocBean data, int position) {
            holder.setText(R.id.tv_title,data.getIfication_title());
            holder.setTextColor(R.id.tv_title,data.isChecked()?
                    getResources().getColor(R.color.colorSearch):
                    getResources().getColor(R.color.color343434));
            holder.setBackgroundResource(R.id.tv_title,data.isChecked()?
                    R.drawable.label_select:
                    R.drawable.label_unselect);

        }
    }

}
