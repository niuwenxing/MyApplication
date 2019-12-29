package com.example.jiyin.home.Activity.sonview.activity;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.danikula.videocache.HttpProxyCacheServer;
import com.example.jiyin.BaseApplication;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivityASS;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.detail.CommentAgencyAdapter;
import com.example.jiyin.common.widget.detail.CommentExpandAdapter;
import com.example.jiyin.common.widget.detail.CommentExpandableListView;
import com.example.jiyin.common.widget.detail.ItemIdClickListener;
import com.example.jiyin.home.Activity.sonview.base.AgencyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.VideoDetailBean;
import com.example.jiyin.home.Activity.sonview.base.VideoindexBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.TopViewImpl;
import com.example.jiyin.home.Activity.sonview.sonview.TopView;
import com.example.rootlib.utils.StringUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class OnlineVideodetailsActivity extends JiYingActivityASS<TopView, TopViewImpl> implements TopView {

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
    @BindView(R.id.throw_layout)
    ThrowLayout throwLayout;
    @BindView(R.id.video_player)
    JzvdStd videoPlayer;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.Video_title)
    TextView VideoTitle;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.tv_Degreeofheat_str)
    TextView tvDegreeofheatStr;
    @BindView(R.id.tv_Label_str)
    TextView tvLabelStr;
    @BindView(R.id.textView20)
    TextView textView20;
    @BindView(R.id.tv_videoContent_str)
    TextView tvVideoContentStr;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.textView22)
    TextView textView22;
    @BindView(R.id.expandableListView)
    CommentExpandableListView expandableListView;
    private int online_id;
    private String online_title;
    private String online_label;
    private int online_hot;
    private String online_text;
    private String online_path;
    private int online_num;
    private List<AgencyDetailBean.DataBean.StoriesBean> stories=new ArrayList<>();
    private CommentAgencyAdapter adapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_online_videodetails;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new TopViewImpl();

    }

    public static void startOnlineVideo(Context context, int video_id, String path) {
        context.startActivity(new Intent(context, OnlineVideodetailsActivity.class)
                .putExtra("online_id", video_id)
                .putExtra("video_path", path)
        );
    }
    private int videoId;
    private String video_path;
    private int page=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("详情");

        videoId = getIntent().getIntExtra("online_id", BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);
        video_path = getIntent().getStringExtra("video_path");


        presenter.Agencydetail(page,videoId);


        initView();
        initData();

    }
    private void initView() {
        expandableListView = findViewById(R.id.expandableListView);
    }

    private void initData() {

    }

    @Override
    public void retVideoindex(VideoindexBean bean) { } //废弃

    @Override
    public void retVideoDetailData(VideoDetailBean bean) { } //废弃

    /**
     * 研习社详情
     * @param bean
     */
    @Override
    public void retAgencydetail(AgencyDetailBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        AgencyDetailBean.DataBean data = bean.getData();

        online_id = data.getOnline_id();//线上课程id
        online_title = data.getOnline_title();//标题
        online_label = data.getOnline_label();//标签
        online_hot = data.getOnline_hot();//热度
        online_text = data.getOnline_text();//介绍
        online_path = data.getOnline_path();//视频路径
        online_num = data.getOnline_num();//播放量
        stories.clear();
        stories.addAll(data.getStories()) ;//评论


        tvSearchTextTitle.setText(online_title);

        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        try {
            Glide.with(activity).load(BaseConfig.ROOT_IMAGES_API + online_path).into(videoPlayer.thumbImageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpProxyCacheServer proxy = BaseApplication.getProxy(activity);
        String proxyUrl = proxy.getProxyUrl(BaseConfig.ROOT_IMAGES_API + online_path);
        videoPlayer.setUp(proxyUrl, online_title, JzvdStd.SCREEN_NORMAL);//视频

        tvDegreeofheatStr.setText(getString(R.string.reduStr) + online_hot);

        tvLabelStr.setText(online_label);
        if (!StringUtil.isEmpty(online_text)) {
            tvVideoContentStr.setText(Html.fromHtml(online_text));
        }
        initExpandableListView();
    }

    private void initExpandableListView() {
        expandableListView.setGroupIndicator(null);
        //默认展开所有回复
        adapter = new CommentAgencyAdapter(this, stories);
        adapter.setOnClick(new ItemIdClickListener() {
            @Override
            public void onclick(View v, String id) {
                switch (v.getId()) {
                    case R.id.comment_item_like:
                        adapter.notifyDataSetChanged();
                        //点赞回调
                        break;
                }
            }
        });
        expandableListView.setAdapter(adapter);
        for (int i = 0; i < stories.size(); i++) {
            expandableListView.expandGroup(i);
        }
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
                boolean isExpanded = expandableListView.isGroupExpanded(groupPosition);
                //showReplyDialog(groupPosition);
                //sendCommentBean.setPid(commentsList.get(groupPosition).getCid()+"");
                //et_comment.setFocusable(true);
                //et_comment.setFocusableInTouchMode(true);
                // et_comment.requestFocus();
//                InputMethodManager inputManager =
//                        (InputMethodManager) et_comment.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                inputManager.showSoftInput(et_comment, 0);
                return true;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                //Toast.makeText(CommunityDetailSingleActivity.this,"点击了回复",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                //toast("展开第"+groupPosition+"个分组");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Jzvd.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        Jzvd.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();

        //Change these two variables back
        Jzvd.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE;
        Jzvd.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.gobank_btn)
    public void onViewClicked() {
        finish();
    }


}
