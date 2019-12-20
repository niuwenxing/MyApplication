package com.example.jiyin.home.Activity.homeview;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.adapter.FounderAdapter;
import com.example.jiyin.home.Activity.adapter.SearchpageAdpter;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.presenter.impl.CheckPresenterImpl;
import com.example.jiyin.home.Activity.presenter.view.CheckView;
import com.example.jiyin.home.Activity.sonview.base.FounderfounderBean;
import com.example.jiyin.home.Activity.view.ImagePreviewActivity;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.GlideImageBannerLoader;
import com.example.rootlib.widget.common.ThrowLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 查 页面
 */
public class CheckActivity extends JiYingActivity<CheckView, CheckPresenterImpl> implements CheckView {

    @BindView(R.id.gobank_btn)
    ImageView gobankBtn;
    @BindView(R.id.searchText)
    EditText searchText;
    @BindView(R.id.searech_news_btn)
    ImageView searechNewsBtn;
    @BindView(R.id.add_btn)
    TextView addBtn;
    @BindView(R.id.throw_layout)
    ThrowLayout throwLayout;
    @BindView(R.id.iv_topimage_btn)
    Banner ivTopimageBtn;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.tv_checkTitle)
    TextView tvCheckTitle;
    @BindView(R.id.tv_chechViewmore_btn)
    TextView tvChechViewmoreBtn;
    @BindView(R.id.titleBarNo)
    RelativeLayout titleBarNo;
    @BindView(R.id.ry_checkFounderList)
    RecyclerView ryCheckFounderList;
    @BindView(R.id.Moreline)
    View Moreline;
    @BindView(R.id.tv_checkTitleMore)
    TextView tvCheckTitleMore;
    @BindView(R.id.tv_chechViewmoreMore_btn)
    TextView tvChechViewmoreMoreBtn;
    @BindView(R.id.titleBarMore)
    RelativeLayout titleBarMore;
    @BindView(R.id.ry_checkMoreList)
    RecyclerView ryCheckMoreList;
    @BindView(R.id.checkScrollView)
    ScrollView checkScrollView;

    private SearchpageAdpter searchpageAdpter;
    private List<FounderfounderBean.DataBean.BannerBean> bannerList=new ArrayList<>();
    private List<FounderfounderBean.DataBean.RecommendBean> recommend=new ArrayList<>();
    private List<FounderfounderBean.DataBean.FounderBean> founder=new ArrayList<>();
    private FounderAdapter objectFounderAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_check;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new CheckPresenterImpl();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchText.setFocusable(false);
        searchText.setFocusableInTouchMode(false);

        LinearLayoutManager FounderLayoutManager = new LinearLayoutManager(this);
        LinearLayoutManager MoreLayoutManager = new LinearLayoutManager(this);
        FounderLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        ryCheckFounderList.setLayoutManager(FounderLayoutManager);
        ryCheckFounderList.setNestedScrollingEnabled(false);

        ryCheckFounderList.addItemDecoration(new SpaceItemDecoration((int) getResources().getDimension(R.dimen.dp_10),0));
        MoreLayoutManager.setOrientation(RecyclerView.VERTICAL);
        ryCheckMoreList.setLayoutManager(MoreLayoutManager);
        ryCheckMoreList.setNestedScrollingEnabled(false);

        List<Object> objects = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            objects.add("1");
        }

        objectFounderAdapter = new FounderAdapter( recommend);
        ryCheckFounderList.setAdapter(objectFounderAdapter);


        searchpageAdpter = new SearchpageAdpter(founder);
        ryCheckMoreList.setAdapter(searchpageAdpter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getFounderfounder();
    }

    //轮播
    private void showbanner(List<FounderfounderBean.DataBean.BannerBean> banners){
        List<String> imgs = new ArrayList<>();
        for(int i = 0;i<banners.size();i++){
            imgs.add(BaseConfig.ROOT_IMAGES_API+banners.get(i).getBanner_path());
        }
        //button = (Button) view.findViewById(R.id.button);
        //设置样式,默认为:Banner.NOT_INDICATOR(不显示指示器和标题)
        //可选样式如下:
        //1. Banner.CIRCLE_INDICATOR    显示圆形指示器
        //2. Banner.NUM_INDICATOR   显示数字指示器
        //3. Banner.NUM_INDICATOR_TITLE 显示数字指示器和标题
        //4. Banner.CIRCLE_INDICATOR_TITLE  显示圆形指示器和标题
        ivTopimageBtn.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置轮播样式（没有标题默认为右边,有标题时默认左边）
        //可选样式:
        //Banner.LEFT   指示器居左
        //Banner.CENTER 指示器居中
        //Banner.RIGHT  指示器居右
        ivTopimageBtn.setIndicatorGravity(BannerConfig.CENTER);
        //banner.setDelayTime()
        //设置轮播要显示的标题和图片对应（如果不传默认不显示标题）
        //banner.setBannerTitle(titles);

        //设置是否自动轮播（不设置则默认自动）
        ivTopimageBtn.isAutoPlay(true);

        //设置轮播图片间隔时间（不设置默认为2000）
        ivTopimageBtn.setDelayTime(4000);
        //设置图片资源:可选图片网址/资源文件，默认用Glide加载,也可自定义图片的加载框架
        //所有设置参数方法都放在此方法之前执行
        //banner.setImages(images);
        ivTopimageBtn.setImageLoader(new GlideImageBannerLoader());
        ivTopimageBtn.setImages(imgs);
        ivTopimageBtn.start();
        //设置点击事件，下标是从0开始  setOnBannerClickListener 下标是1 开始
        ivTopimageBtn.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                //轮播点击事件
//                Intent intent = new Intent(getActivity(), WebViewWithBarActivity.class);
//                intent.putExtra("url","http://app.quanquanerapp.com/web/activity_one.html?banner_id="+banners.get(position).getBanner_id());
//                intent.putExtra("title","");
//                startActivity(intent);
                //Toast.makeText(getContext(),""+position,Toast.LENGTH_LONG).show();
            }
        });
    }

    @OnClick({R.id.gobank_btn, R.id.searchText, R.id.searech_news_btn, R.id.iv_topimage_btn, R.id.tv_chechViewmore_btn, R.id.tv_chechViewmoreMore_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searchText://搜索页面
                Intent intentSearchpage = new Intent(this, SearchpageActivity.class);
                intentSearchpage.putExtra(ConstantUtil.KEY_CODE,ConstantUtil.KEY_MORE_CODE);
                startActivity(intentSearchpage);
                break;
            case R.id.searech_news_btn:

                break;
            case R.id.iv_topimage_btn:

                break;
            case R.id.tv_chechViewmore_btn:

                break;
            case R.id.tv_chechViewmoreMore_btn:

                break;
        }
    }

    @Override
    public void retFounderfounder(FounderfounderBean bean) {
        bannerList.clear();
        recommend.clear();
        founder.clear();

        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        FounderfounderBean.DataBean data = bean.getData();
        bannerList.addAll(data.getBanner());//轮播
        recommend.addAll(data.getRecommend());//推荐
        founder.addAll(data.getFounder()) ;//列表

        showbanner(bannerList);
        objectFounderAdapter.notifyDataSetChanged();
        searchpageAdpter.notifyDataSetChanged();
    }
}
