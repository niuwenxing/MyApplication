package com.example.jiyin.home.Activity.sonview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.banner.BannerLayout;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.homeview.SearchpageActivity;
import com.example.jiyin.home.Activity.sonview.adapter.CommunityAdapter;
import com.example.jiyin.home.Activity.sonview.adapter.ShoppingBannerAdapter;
import com.example.jiyin.home.Activity.sonview.base.CommunityindexBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.CommunityImpl;
import com.example.jiyin.home.Activity.sonview.sonview.CommunityView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.GlideImageBannerLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 社区页面
 */

public class CommunityActivity extends JiYingActivity<CommunityView, CommunityImpl> implements CommunityView, BannerLayout.OnBannerItemClickListener {

    @BindView(R.id.gobank_btn)
    ImageView gobankBtn;
    @BindView(R.id.searchText)
    EditText searchText;
    @BindView(R.id.searchView)
    LinearLayout searchView;
    @BindView(R.id.tv_searchTextTitle)
    TextView tvSearchTextTitle;
    @BindView(R.id.searech_news_btn)
    ImageView searechNewsBtn;
    @BindView(R.id.searech_Shopping_btn)
    ImageView searechShoppingBtn;
    @BindView(R.id.add_btn)
    TextView addBtn;
    @BindView(R.id.bl_CommunityBanner)
    Banner blCommunityBanner;
    @BindView(R.id.CommunityList)
    RecyclerView CommunityList;

    private int page=1;
    private String name="";
    private List<CommunityindexBean.DataBean.BannerBean> banner=new ArrayList<>();
    private List<CommunityindexBean.DataBean.ListBean> list=new ArrayList<>();
    private CommunityAdapter communityAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_community;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new CommunityImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchText.setFocusable(false);
        searchText.setFocusableInTouchMode(false);

        presenter.Communityindex(name,page);

        communityAdapter = new CommunityAdapter(list);
        CommunityList.setAdapter(communityAdapter);

        communityAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                int community_id = list.get(position).getCommunity_id();
                startActivity(new Intent(activity, WebVIewActivity.class)
                        .putExtra(ConstantUtil.KEY_CODE,"shequ")
                        .putExtra("community_id",community_id)
                );
            }
        });


    }

    @OnClick({R.id.gobank_btn, R.id.searchText, R.id.searchView, R.id.tv_searchTextTitle, R.id.searech_news_btn, R.id.searech_Shopping_btn, R.id.bl_CommunityBanner, R.id.CommunityList})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searchText://搜索页面
                Intent intentSearchpage = new Intent(this, SearchpageActivity.class);
                intentSearchpage.putExtra(ConstantUtil.KEY_CODE,ConstantUtil.KEY_COMMUNITY);
                startActivity(intentSearchpage);
                break;
            case R.id.searchView:
                break;
            case R.id.tv_searchTextTitle:
                break;
            case R.id.searech_news_btn:
                break;
            case R.id.searech_Shopping_btn:
                break;
            case R.id.bl_CommunityBanner:
                break;
            case R.id.CommunityList:
                break;
        }
    }

    //banner 事件监听
    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void retCommunityindex(CommunityindexBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        CommunityindexBean.DataBean data = bean.getData();

        //轮播数据
        banner.clear();
        banner.addAll(data.getBanner());
        showbanner(banner);
        //列表数据
        list.clear();
        list.addAll(data.getList());
        communityAdapter.notifyDataSetChanged();

    }

    /**
     * 轮播
     * @param banners
     */
    private void showbanner(List<CommunityindexBean.DataBean.BannerBean> banners) {
        List<String> imgs = new ArrayList<>();
        for(int i = 0;i<banners.size();i++){
            imgs.add(BaseConfig.ROOT_IMAGES_API+banners.get(i).getBanner_path());
        }
        blCommunityBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        blCommunityBanner.setIndicatorGravity(BannerConfig.CENTER);
        blCommunityBanner.isAutoPlay(true);

        //设置轮播图片间隔时间（不设置默认为2000）
        blCommunityBanner.setDelayTime(4000);
        //设置图片资源:可选图片网址/资源文件，默认用Glide加载,也可自定义图片的加载框架
        //所有设置参数方法都放在此方法之前执行
        //banner.setImages(images);
        blCommunityBanner.setImageLoader(new GlideImageBannerLoader());
        blCommunityBanner.setImages(imgs);
        blCommunityBanner.start();
        //设置点击事件，下标是从0开始  setOnBannerClickListener 下标是1 开始
        blCommunityBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                //轮播点击事件
                //Toast.makeText(getContext(),""+position,Toast.LENGTH_LONG).show();
            }
        });

    }


}
