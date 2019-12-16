package com.example.jiyin.home.fragment;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.azoft.carousellayoutmanager.DefaultChildSelectionListener;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.MLImageView;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.homeview.CheckActivity;
import com.example.jiyin.home.Activity.homeview.SearchpageActivity;
import com.example.jiyin.home.Activity.sonview.activity.CallOccupationalActivity;
import com.example.jiyin.home.Activity.sonview.activity.CarveouttimeActivity;
import com.example.jiyin.home.Activity.sonview.activity.CommunityActivity;
import com.example.jiyin.home.Activity.sonview.activity.CreationcollectionActivity;
import com.example.jiyin.home.Activity.sonview.activity.HeadlinesActivity;
import com.example.jiyin.home.Activity.sonview.activity.ShoppingActivity;
import com.example.jiyin.home.Activity.sonview.activity.StudyAgencyActivity;
import com.example.jiyin.home.Activity.sonview.activity.TopActivity;
import com.example.jiyin.home.Activity.sonview.activity.WorkshopActivity;
import com.example.jiyin.home.Activity.sonview.base.IndexindexBean;
import com.example.jiyin.home.fragment.adapter.CoverFlowAdapter;
import com.example.jiyin.home.fragment.adapter.TopModularAdapter;
import com.example.jiyin.home.fragment.view.HomeView;
import com.example.jiyin.home.presenter.Impl.HomePresenterImpl;
import com.example.jiyin.interactive.ContactsActivity;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

public class NewHomeFregment extends JiYingFragment<HomeView, HomePresenterImpl> implements HomeView {

    public static final String NOSAK = NewHomeFregment.class.getName();

    @BindView(R.id.tv_homeTitle)
    TextView tvHomeTitle;
    @BindView(R.id.rl_searchbar_btn)
    RelativeLayout rlSearchbar_btn;
    @BindView(R.id.tv_homeTitles)
    TextView tvHomeTitles;
    @BindView(R.id.tv_hoemLocation)
    TextView tvHoemLocation;
    @BindView(R.id.imgsearch)
    ImageView imgsearch;
    @BindView(R.id.tv_searchhint)
    TextView tvSearchhint;
    @BindView(R.id.news)
    TextView news;
    @BindView(R.id.tv_news_btn)
    TextView tvNewsBtn;
    @BindView(R.id.tv_check_btn)
    TextView tvCheckBtn;
    @BindView(R.id.fl_menu_one_btn)
    FrameLayout flMenuOneBtn;
    @BindView(R.id.tv_stroll_btn)
    TextView tvStrollBtn;
    @BindView(R.id.fl_menu_two_btn)
    FrameLayout flMenuTwoBtn;
    @BindView(R.id.tv_throw_btn)
    TextView tvThrowBtn;
    @BindView(R.id.fl_menu_three_btn)
    FrameLayout flMenuThreeBtn;
    @BindView(R.id.tv_browse_btn)
    TextView tvBrowseBtn;
    @BindView(R.id.fl_menu_four_btn)
    FrameLayout flMenuFourBtn;
    @BindView(R.id.tv_look_btn)
    TextView tvLookBtn;

    @BindView(R.id.ly_searchbar)
    LinearLayout lySearchbar;
    @BindView(R.id.home_bananrlist)
    RecyclerView homeBananrlist;
    @BindView(R.id.tv_tvTop)
    TextView tvTvTop;

    @BindView(R.id.home_top)
    LinearLayout homeTop;
    @BindView(R.id.home_topList)
    RecyclerView homeTopList;
    @BindView(R.id.hoem_zhuoPuTitle)
    TextView hoemZhuoPuTitle;
    @BindView(R.id.img_zhoupu_img)
    ImageView imgZhoupuImg;
    @BindView(R.id.a1)
    TextView a1;
    @BindView(R.id.a2)
    TextView a2;
    @BindView(R.id.a3)
    TextView a3;
    @BindView(R.id.view_workshop)
    RelativeLayout viewWorkshop;
    @BindView(R.id.b1)
    TextView b1;
    @BindView(R.id.b2)
    TextView b2;
    @BindView(R.id.b3)
    TextView b3;
    @BindView(R.id.workshops)
    RelativeLayout workshops;
    @BindView(R.id.workshops_img)
    MLImageView workshopsImg;
    @BindView(R.id.bb1)
    TextView bb1;
    @BindView(R.id.bb2)
    TextView bb2;
    @BindView(R.id.bb3)
    TextView bb3;
    @BindView(R.id.collection)
    RelativeLayout collection;
    @BindView(R.id.view_abb)
    RelativeLayout viewAbb;
    @BindView(R.id.a1_personnel)
    TextView a1Personnel;
    @BindView(R.id.a2_personnel)
    TextView a2Personnel;
    @BindView(R.id.a1_Carvetime)
    TextView a1Carvetime;
    @BindView(R.id.a2_Carvetime)
    TextView a2Carvetime;
    @BindView(R.id.a3_Carvetime)
    TextView a3Carvetime;
    @BindView(R.id.a3_personnel)
    TextView a3personnel;
    @BindView(R.id.img_Occupational_btn)
    MLImageView img_Occupational_btn;
    @BindView(R.id.ml_Creationcollection_btn)
    MLImageView mlCreationcollection_btn;
    @BindView(R.id.img_carvetime)
    MLImageView imgCarvetime;
    @BindView(R.id.tv_ProduceTitie)
    TextView tvProduceTitie;
    @BindView(R.id.tv_ProduceContext)
    TextView tvProduceContext;
    @BindView(R.id.img_Produceimage_btn)
    MLImageView imgProduceimage;

    //top 更多
    @BindView(R.id.tv_topHedo_btn)
    TextView tvTopHedo_btn;
    private View layoutFragment;
    //新闻ID
    private int new_id= BaseConfig.SERVER_ERR_LOGIN_OBSOLETE;

    //轮播数据
    private List<IndexindexBean.DataBean.ProjectBean> project=new ArrayList<>();
    //top 数据集
    private List<IndexindexBean.DataBean.VideoBean> videolist=new ArrayList<>();

    private CoverFlowAdapter mCoverFlowAdapter;
    private TopModularAdapter topModularAdapter;
    private IndexindexBean.DataBean.AdvertBean advert;

    @Override
    protected int attachLayoutRes() {
        return R.layout.homefragment_layout;
    }

    @Override
    protected void init() {
        layoutFragment = getLayoutFragment();
//        tvHomeTitle = layoutFragment.findViewById(R.id.tv_homeTitle);
//        tvtop = layoutFragment.findViewById(R.id.tv_tvTop);
//        tvHomeTitles = layoutFragment.findViewById(R.id.tv_homeTitles);
        AssetManager mgr = getContext().getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "fonts/SOURCEHANSANSCN.otf");
        a1.setTypeface(tf);
        bb1.setTypeface(tf);
        b1.setTypeface(tf);
        a1Personnel.setTypeface(tf);
        a1Carvetime.setTypeface(tf);
//        tvHomeTitles.setTypeface(tf);



        //首页轮播
        CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = layoutFragment.findViewById(R.id.home_bananrlist);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        recyclerView.addOnScrollListener(new CenterScrollListener());

        mCoverFlowAdapter = new CoverFlowAdapter(project, getContext());
        recyclerView.setLayoutManager(new CoverFlowAdapter.MyLayoutManager(getContext()));
        initRecyclerView(recyclerView, layoutManager, mCoverFlowAdapter);
        recyclerView.setAdapter(mCoverFlowAdapter);
        recyclerView.smoothScrollToPosition(1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        homeTopList.setLayoutManager(linearLayoutManager);
        //top
        topModularAdapter = new TopModularAdapter(videolist);
        homeTopList.addItemDecoration(new SpaceItemDecoration((int) getResources().getDimension(R.dimen.dp_10), 0));
        homeTopList.setAdapter(topModularAdapter);


    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getIndexindex();//获取首页数据
    }


    private void initRecyclerView(RecyclerView recyclerView, final CarouselLayoutManager layoutManager, final CoverFlowAdapter adapter) {
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        layoutManager.setMaxVisibleItems(1);
        layoutManager.setItemPrefetchEnabled(true);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new CenterScrollListener());
        DefaultChildSelectionListener.initCenterItemListener(new DefaultChildSelectionListener.OnCenterItemClickListener() {
            @Override
            public void onCenterItemClicked(@NonNull final RecyclerView recyclerView, @NonNull final CarouselLayoutManager carouselLayoutManager, @NonNull final View v) {
                final int position = recyclerView.getChildLayoutPosition(v);
                final String msg = String.format(Locale.US, "Item %1$d was clicked", position);
                Log.d("OOP", "点击了");

            }
        }, recyclerView, layoutManager);
        //滚动监听器
        layoutManager.addOnItemSelectionListener(new CarouselLayoutManager.OnCenterItemSelectionListener() {
            @Override
            public void onCenterItemChanged(final int adapterPosition) {
                if (CarouselLayoutManager.INVALID_POSITION != adapterPosition) {

                }
            }
        });
    }


    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new HomePresenterImpl();
    }

    @Override
    public void onReload() {

    }

    @Override
    public void onLoadFinished() {

    }

    @Override
    public void onLoadAll() {

    }


    @OnClick({R.id.rl_searchbar_btn, R.id.tv_news_btn, R.id.tv_check_btn,R.id.fl_menu_one_btn,
            R.id.fl_menu_two_btn, R.id.fl_menu_three_btn, R.id.fl_menu_four_btn, R.id.tv_look_btn,
            R.id.tv_topHedo_btn,R.id.img_zhoupu_img,R.id.workshops,R.id.workshops_img,R.id.img_Occupational_btn,
            R.id.ml_Creationcollection_btn,R.id.img_carvetime,R.id.img_Produceimage_btn
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_searchbar_btn://搜索
                Intent intentSearchpage = new Intent(getContext(), SearchpageActivity.class);
                intentSearchpage.putExtra(ConstantUtil.KEY_CODE,ConstantUtil.KEY_MORE_CODE);
                startActivity(intentSearchpage);
                break;
            case R.id.tv_news_btn://头条
                tvnewsbtn();
                break;
            case R.id.tv_check_btn://查
                startActivity(new Intent(getContext(), CheckActivity.class));
                break;
            case R.id.fl_menu_two_btn://商场
                startActivity(new Intent(getContext(), ShoppingActivity.class));
                break;
            case R.id.fl_menu_three_btn://投项目
                Intent intentProject = new Intent(getContext(), SearchpageActivity.class);
                intentProject.putExtra(ConstantUtil.KEY_CODE,ConstantUtil.KEY_PROJECT_CODE);
                startActivity(intentProject);
                break;
            case R.id.fl_menu_four_btn://览头条
                Intent intent = new Intent(getContext(), HeadlinesActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_look_btn://看社群
                startActivity(new Intent(getContext(),CommunityActivity.class));
                break;
            case R.id.tv_topHedo_btn:
                startActivity(new Intent(getContext(), TopActivity.class));
                break;
            case R.id.img_zhoupu_img://工作坊
                startActivity(new Intent(getContext(), WorkshopActivity.class));
                break;
            case R.id.workshops_img:
                startActivity(new Intent(getContext(), StudyAgencyActivity.class));
                break;
            case R.id.ml_Creationcollection_btn://造物集
                startActivity(new Intent(getContext(), CreationcollectionActivity.class));
                break;
            case R.id.img_Occupational_btn://职呼
                startActivity(new Intent(getContext(), CallOccupationalActivity.class));
                break;
            case R.id.img_carvetime://琢璞时间
                startActivity(new Intent(getContext(), CarveouttimeActivity.class));
                break;
            case R.id.img_Produceimage_btn://玑瑛出品

                break;
        }
    }

    private void tvnewsbtn() {
        if (new_id==BaseConfig.SERVER_ERR_LOGIN_OBSOLETE){
            return;
        }else{
            // TODO: 2019/12/9 goto 新闻
        }

    }

    //返回 首页数据接口
    @Override
    public void retIndexindex(IndexindexBean bean) {
        // 设置 新闻
        new_id = bean.getData().getNewX().getNew_id();
        tvNewsBtn.setText(bean.getMsg());

        //轮播
        project.clear();
        project.addAll(bean.getData().getProject());
        mCoverFlowAdapter.notifyDataSetChanged();

        //top视频
        videolist.clear();
        videolist.addAll(bean.getData().getVideo());
        topModularAdapter.notifyDataSetChanged();

        //出品
        advert = bean.getData().getAdvert();
        tvProduceTitie.setText(advert.getAdvert_title());
        tvProduceContext.setText(advert.getAdvert_text());
        GlideImageLoader.load(getContext(),BaseConfig.ROOT_IMAGES_API+advert.getAdvert_path(),imgProduceimage);

        //box

        List<IndexindexBean.DataBean.BoxBean> box = bean.getData().getBox();

        if (box.size()!=0) {
            if (box.size()>=1) {
                IndexindexBean.DataBean.BoxBean boxBean = box.get(0);
                a1.setText(boxBean.getBox_title());
                a2.setText(boxBean.getBox_text());
                a3.setText(boxBean.getBox_num()+"参与");
//                GlideImageLoader.load(getContext(),BaseConfig.ROOT_IMAGES_API+boxBean.getBox_path(),imgZhoupuImg);
            }if(box.size()>=2){
                IndexindexBean.DataBean.BoxBean boxBean = box.get(1);
                b1.setText(boxBean.getBox_title());
                b2.setText(boxBean.getBox_text());
                b3.setText(boxBean.getBox_num()+"参与");
//                GlideImageLoader.load(getContext(),BaseConfig.ROOT_IMAGES_API+boxBean.getBox_path(),workshopsImg);


            }if(box.size()>=3){
                IndexindexBean.DataBean.BoxBean boxBean = box.get(2);
                bb1.setText(boxBean.getBox_title());
                bb2.setText(boxBean.getBox_text());
                bb3.setText(boxBean.getBox_num()+"参与");
//                GlideImageLoader.load(getContext(),BaseConfig.ROOT_IMAGES_API+boxBean.getBox_path(),mlCreationcollection_btn);


            }if(box.size()>=4){

                IndexindexBean.DataBean.BoxBean boxBean = box.get(3);
                a1Personnel.setText(boxBean.getBox_title());
                a2Personnel.setText(boxBean.getBox_text());
                a3personnel.setText(boxBean.getBox_num()+"参与");
//                GlideImageLoader.load(getContext(),BaseConfig.ROOT_IMAGES_API+boxBean.getBox_path(),img_Occupational_btn);


            }if(box.size()>=5){
                IndexindexBean.DataBean.BoxBean boxBean = box.get(4);
                a1Carvetime.setText(boxBean.getBox_title());
                a2Carvetime.setText(boxBean.getBox_text());
                a3Carvetime.setText(boxBean.getBox_num()+"参与");
//                GlideImageLoader.load(getContext(),BaseConfig.ROOT_IMAGES_API+boxBean.getBox_path(),imgCarvetime);
            }
        }else{
            viewAbb.setVisibility(View.GONE);
        }
    }
}
/**
 *   startActivity(new Intent(getContext(), ContactsActivity.class)); //联系人
 */
