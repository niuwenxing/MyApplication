package com.example.jiyin.home.fragment;

import android.content.Intent;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.azoft.carousellayoutmanager.DefaultChildSelectionListener;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.homeview.CheckActivity;
import com.example.jiyin.home.Activity.homeview.SearchpageActivity;
import com.example.jiyin.home.Activity.sonview.activity.CommunityActivity;
import com.example.jiyin.home.Activity.sonview.activity.HeadlinesActivity;
import com.example.jiyin.home.Activity.sonview.activity.ShoppingActivity;
import com.example.jiyin.home.fragment.adapter.CoverFlowAdapter;
import com.example.jiyin.home.fragment.adapter.TopModularAdapter;
import com.example.jiyin.home.fragment.view.HomeView;
import com.example.jiyin.home.presenter.Impl.HomePresenterImpl;
import com.example.jiyin.interactive.ContactsActivity;
import com.example.jiyin.utils.ConstantUtil;

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
    @BindView(R.id.view_workshop)
    RelativeLayout viewWorkshop;
    @BindView(R.id.b1)
    TextView b1;
    @BindView(R.id.b2)
    TextView b2;
    @BindView(R.id.workshops)
    RelativeLayout workshops;
    @BindView(R.id.bb1)
    TextView bb1;
    @BindView(R.id.bb2)
    TextView bb2;
    @BindView(R.id.collection)
    RelativeLayout collection;
    @BindView(R.id.view_abb)
    RelativeLayout viewAbb;
    private View layoutFragment;

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



        SpannableStringBuilder HomeTitle = new SpannableStringBuilder(tvHomeTitle.getText());
        HomeTitle.setSpan(new TypefaceSpan("PingFangSC-Semibold"), 0, tvHomeTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        HomeTitle.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.white)), 0, tvHomeTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvHomeTitle.setText(HomeTitle);

        SpannableStringBuilder homeTitles = new SpannableStringBuilder(tvHomeTitles.getText());
        homeTitles.setSpan(new TypefaceSpan("Arial-BoldMT"), 0, tvHomeTitles.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvHomeTitles.setText(homeTitles);

        SpannableStringBuilder tvTop = new SpannableStringBuilder(tvTvTop.getText());
        tvTop.setSpan(new TypefaceSpan("San-Francisco-Text-Heavy"), 0, tvTvTop.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvTvTop.setText(tvTop);


        CarouselLayoutManager layoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, true);
        RecyclerView recyclerView = layoutFragment.findViewById(R.id.home_bananrlist);
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        recyclerView.addOnScrollListener(new CenterScrollListener());

        List objects = new ArrayList<>();
        objects.add("1");
        objects.add("1");
        objects.add("1");
        objects.add("1");
        objects.add("1");

        CoverFlowAdapter mCoverFlowAdapter = new CoverFlowAdapter(objects, getContext());

        recyclerView.setLayoutManager(new CoverFlowAdapter.MyLayoutManager(getContext()));
        initRecyclerView(recyclerView, layoutManager, mCoverFlowAdapter);
        recyclerView.setAdapter(mCoverFlowAdapter);
        recyclerView.smoothScrollToPosition(1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        homeTopList.setLayoutManager(linearLayoutManager);
        TopModularAdapter<Object> topModularAdapter = new TopModularAdapter(getContext(),objects);
        homeTopList.addItemDecoration(new SpaceItemDecoration((int) getResources().getDimension(R.dimen.dp_10), 0));
        homeTopList.setAdapter(topModularAdapter);

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
            R.id.fl_menu_two_btn, R.id.fl_menu_three_btn, R.id.fl_menu_four_btn, R.id.tv_look_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_searchbar_btn://搜索
                Intent intentSearchpage = new Intent(getContext(), SearchpageActivity.class);
                intentSearchpage.putExtra(ConstantUtil.KEY_CODE,ConstantUtil.KEY_MORE_CODE);
                startActivity(intentSearchpage);
                break;
            case R.id.tv_news_btn://头条
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

        }
    }
}
/***
 *   startActivity(new Intent(getContext(), ContactsActivity.class)); //联系人
 */
