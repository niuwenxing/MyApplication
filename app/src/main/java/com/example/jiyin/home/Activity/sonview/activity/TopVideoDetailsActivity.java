package com.example.jiyin.home.Activity.sonview.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.StandardGSYNewVideoPlayer;
import com.example.jiyin.common.widget.detail.CommentDetailBean;
import com.example.jiyin.common.widget.detail.CommentExpandAdapter;
import com.example.jiyin.common.widget.detail.CommentExpandableListView;
import com.example.jiyin.common.widget.detail.ItemIdClickListener;
import com.example.jiyin.common.widget.detail.ReplyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.VideoDetailBean;
import com.example.jiyin.home.Activity.sonview.base.VideoindexBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.TopViewImpl;
import com.example.jiyin.home.Activity.sonview.sonview.TopView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.jzvd.JzvdStd;

/**
 * Top 详情
 */

public class TopVideoDetailsActivity extends JiYingActivity<TopView, TopViewImpl> implements TopView {


    @BindView(R.id.video_player)
    StandardGSYNewVideoPlayer videoPlayer;
    @BindView(R.id.Video_title)
    TextView VideoTitle;
    private int page = 1; //默认页数

    private CommentExpandableListView expandableListView;
    private CommentExpandAdapter adapter;
    private List<CommentDetailBean> commentsList = new ArrayList<>();
    private int videoId;

    private int video_id;
    private String video_title;
    private String video_label;
    private String video_content;
    private int heat_num;
    private int video_num;
    //评论
    private List<VideoDetailBean.DataBean.StoriesBean> storiesList = new ArrayList<>();
    private String video_path;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_top_video_details;
    }

    public static void startTopVideo(Context context, int video_id, String path) {
        context.startActivity(new Intent(context, TopVideoDetailsActivity.class)
                .putExtra("videoId", video_id)
                .putExtra("video_path", path)
        );
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new TopViewImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        videoId = getIntent().getIntExtra("videoId", BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);
        video_path = getIntent().getStringExtra("video_path");


        presenter.getVideoDetail(page, videoId);

        initView();
        initData();
    }

    @Override
    public void retVideoindex(VideoindexBean bean) {
    }//废弃

    //Top  详情
    @Override
    public void retVideoDetailData(VideoDetailBean bean) {
        storiesList.clear();
        if (bean.getCode() == -1) {
            toast(bean.getMsg());
            return;
        }
        VideoDetailBean.DataBean data = bean.getData();

        video_id = data.getVideo_id();//id
        video_title = data.getVideo_title();//标题
        video_label = data.getVideo_label(); //标签
        video_content = data.getVideo_content();//内容
        heat_num = data.getHeat_num();//热度
        video_num = data.getVideo_num();//播放量

//        videoPlayer.setUp(BaseConfig.ROOT_IMAGES_API+video_path,video_title);

        videoPlayer.setUp(BaseConfig.ROOT_IMAGES_API+video_path,true,video_title);


        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        try {
            Glide.with(activity).load(BaseConfig.ROOT_IMAGES_API+video_path).into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
        videoPlayer.setThumbImageView(imageView);

        storiesList.addAll(data.getStories());


    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            CommentDetailBean commentDetailBean = new CommentDetailBean();
            commentDetailBean.setCid(i);
            commentDetailBean.setAvatar("");
            commentDetailBean.setUsername("张" + i);
            commentDetailBean.setContent("896asd4asd 4 as68dasd54 ");
            commentDetailBean.setZan(i + "2");
            commentDetailBean.setTime("2019-12-4");
            List<ReplyDetailBean> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                ReplyDetailBean replyDetailBean = new ReplyDetailBean();
                replyDetailBean.setUsername("李" + j);
                replyDetailBean.setContent("笑死我了");
                list.add(replyDetailBean);
            }
            commentDetailBean.setReplyList(list);
            commentsList.add(commentDetailBean);
        }
        initExpandableListView();
    }


    private void initView() {
        expandableListView = findViewById(R.id.expandableListView);
    }

    private void initExpandableListView() {
        expandableListView.setGroupIndicator(null);
        //默认展开所有回复
        adapter = new CommentExpandAdapter(this, commentsList);
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
        for (int i = 0; i < commentsList.size(); i++) {
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
}
