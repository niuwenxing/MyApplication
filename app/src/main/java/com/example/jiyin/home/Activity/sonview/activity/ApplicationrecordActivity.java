package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.sonview.base.MineAplyDosBean;
import com.example.jiyin.home.Activity.sonview.base.UserInfoBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.presenter.Impl.MypageImpl;
import com.example.jiyin.home.presenter.view.MypageView;
import com.example.jiyin.utils.GlideImageLoader;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 个人中心 申请记录
 */
public class ApplicationrecordActivity extends JiYingActivity<MypageView, MypageImpl> implements MypageView {

    @BindView(R.id.return_btn)
    ImageView returnBtn;
    @BindView(R.id.textView15)
    TextView textView15;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.record_list)
    RecyclerView recordList;
    private List<MineAplyDosBean.DataBean.UnderBean> under=new ArrayList<>();
    private WorkshopsApadter workshopsApadter;
    private List<MineAplyDosBean.DataBean.WorkShopBean> workShop=new ArrayList<>();
    private StudioAdapter studioAdapter;
    private List<MineAplyDosBean.DataBean.PositionBean> position=new ArrayList<>();
    private Occupational occupational;
    private List<MineAplyDosBean.DataBean.TimeBean> time=new ArrayList<>();
    private CarveOutTime carveOutTime;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_applicationrecord;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new MypageImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recordList.addItemDecoration(new SpaceItemDecoration(0, (int) getResources().getDimension(R.dimen.dp_5)));
        //研习社
        workshopsApadter = new WorkshopsApadter(under);
        recordList.setAdapter(workshopsApadter);
        //工作坊
        studioAdapter = new StudioAdapter(workShop);
        //职呼
        occupational = new Occupational(position);
        //琢璞 时间
        carveOutTime = new CarveOutTime(time);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0) {
                    recordList.setAdapter(workshopsApadter);
                }else if(tab.getPosition()==1){
                    recordList.setAdapter(studioAdapter);
                }else if(tab.getPosition()==2){
                    recordList.setAdapter(occupational);
                }else if(tab.getPosition()==3){
                    recordList.setAdapter(carveOutTime);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

        studioAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WorkDetailsActivity.startActivity(workShop.get(position).getWork_id(),activity);
            }
        });
        occupational.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int pion) {
                JobdetailsActivity.startcActivity(activity,position.get(pion).getPosition_id());
            }
        });
        carveOutTime.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CarveouttimeDasActivity.startActivity(activity,time.get(position).getZid());
            }
        });


        presenter.getMineApplyDos();

    }


    @Override
    public void retUserInfo(UserInfoBean bean) {
    } //废弃

    @Override
    public void err(String str) {

    }//废弃

    @Override
    public void retUserAvatarEdit(UserReplyBean bean) {

    }

    @Override
    public void retNameSetName(UserReplyBean bean) {

    }//废弃

    @Override
    public void Code(CodeBase bean) {

    }//废弃

    @Override
    public void retUserTelEdit(UserReplyBean bean) {

    }//废弃

    @Override
    public void retUserPassEdit(UserReplyBean bean) {

    }//废弃

    /**
     * 申请记录返回数据
     * @param bean
     */
    @Override
    public void retMineApplyDos(MineAplyDosBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        MineAplyDosBean.DataBean data = bean.getData();

        under.clear();
        under.addAll(data.getUnder()) ;
        workShop.clear();
        workShop.addAll(data.getWorkShop());
        position.clear();
        position.addAll(data.getPosition()) ;
        time.clear();
        time .addAll(data.getTime());

        workshopsApadter.notifyDataSetChanged();
        studioAdapter.notifyDataSetChanged();
        occupational.notifyDataSetChanged();
        carveOutTime.notifyDataSetChanged();

    }

    @Override
    public void retMinemyUp(CircleListBean bean) { }//废弃

    @OnClick(R.id.return_btn)
    public void onViewClicked() {
        finish();
    }

//研习社
    public class WorkshopsApadter extends BaseQuickAdapter<MineAplyDosBean.DataBean.UnderBean, BaseViewHolder> {
        public WorkshopsApadter( @Nullable List<MineAplyDosBean.DataBean.UnderBean> data) {
            super(R.layout.item_studyagency_child, data);
        }
        @Override
        protected void convert(@NonNull BaseViewHolder helper, MineAplyDosBean.DataBean.UnderBean item) {
            GlideImageLoader.loadLogh(mContext, BaseConfig.ROOT_IMAGES_API+item.getUnder_path(),helper.getView(R.id.imageView));
            helper.setText(R.id.tv_participateCont_str,item.getUnder_title()+"");
            helper.setText(R.id.tv_participateTime,item.getUnder_time()+"");
            Button view = helper.getView(R.id.bt_participate_btn);
            view.setText("查看");
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StudyparticipateActivity.staticActivity(mContext,item.getUnder_id(),0);
                }
            });
        }
    }
//工作坊
    public class StudioAdapter extends BaseQuickAdapter<MineAplyDosBean.DataBean.WorkShopBean,BaseViewHolder>{
        public StudioAdapter( @Nullable List<MineAplyDosBean.DataBean.WorkShopBean> data) {
            super(R.layout.workshop_layout_item, data);
        }
        @Override
        protected void convert(@NonNull BaseViewHolder helper, MineAplyDosBean.DataBean.WorkShopBean item) {
            helper.setText(R.id.workItem_table,item.getWork_title());
            helper.setText(R.id.workItem_time,item.getWork_time());
            helper.setText(R.id.workItem_context,item.getWork_content());
        }
}
//职呼
    public class Occupational extends BaseQuickAdapter<MineAplyDosBean.DataBean.PositionBean,BaseViewHolder>{

        public Occupational( @Nullable List<MineAplyDosBean.DataBean.PositionBean> data) {
            super(R.layout.item_position,data);
        }
        @Override
        protected void convert(@NonNull BaseViewHolder helper, MineAplyDosBean.DataBean.PositionBean item) {
            helper.setText(R.id.tv_Titlezhihu_str,item.getPosition_name()+"");
            helper.setText(R.id.tv_Salaryscale_str,item.getPosition_money()+"K");
            helper.setText(R.id.tv_companyName_str,item.getCname()+"");
            helper.setText(R.id.textView9,item.getPosition_site()+"");
            helper.setText(R.id.tv_Education_str,item.getEducation()+"");
        }
}
//琢璞时间
    public class CarveOutTime extends BaseQuickAdapter<MineAplyDosBean.DataBean.TimeBean,BaseViewHolder>{
        public CarveOutTime( @Nullable List<MineAplyDosBean.DataBean.TimeBean> data) {
            super(R.layout.item_zp_time_week,data);
        }
        @Override
        protected void convert(@NonNull BaseViewHolder helper, MineAplyDosBean.DataBean.TimeBean item) {
            GlideImageLoader.load(mContext, BaseConfig.ROOT_IMAGES_API+item.getZ_path(),(ImageView)helper.getView(R.id.ml_CarveimageView));
            helper.setText(R.id.tv_CarveTextstr,item.getZ_title());
            helper.setText(R.id.tv_CarveBtn,"查看");
            helper.setText(R.id.tv_CarveoutTime,"活动时间："+item.getZ_stime()+" - "+item.getZ_etime());
        }
    }


}
