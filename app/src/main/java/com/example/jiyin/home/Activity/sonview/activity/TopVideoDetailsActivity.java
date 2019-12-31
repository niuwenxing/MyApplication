package com.example.jiyin.home.Activity.sonview.activity;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.danikula.videocache.HttpProxyCacheServer;
import com.example.jiyin.BaseApplication;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivityASS;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.detail.CommentDetailBean;
import com.example.jiyin.common.widget.detail.CommentExpandAdapter;
import com.example.jiyin.common.widget.detail.CommentExpandableListView;
import com.example.jiyin.common.widget.detail.ItemIdClickListener;
import com.example.jiyin.home.Activity.sonview.base.AgencyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.Toutiao;
import com.example.jiyin.home.Activity.sonview.base.VideoDetailBean;
import com.example.jiyin.home.Activity.sonview.base.VideoindexBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.TopViewImpl;
import com.example.jiyin.home.Activity.sonview.sonview.TopView;
import com.example.rootlib.utils.CollectionUtil;
import com.example.rootlib.utils.StringUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * Top详情
 */

//public class TopVideoDetailsActivity extends JiYingActivity<TopView, TopViewImpl> implements TopView {
public class TopVideoDetailsActivity extends JiYingActivityASS<TopView, TopViewImpl> implements TopView {


    @BindView(R.id.video_player)
    JzvdStd videoPlayer;
    @BindView(R.id.Video_title)
    TextView VideoTitle;

    @BindView(R.id.tv_Degreeofheat_str)
    TextView tvDegreeofheatStr;
    @BindView(R.id.tv_Label_str)
    TextView tvLabelStr;
    @BindView(R.id.tv_videoContent_str)
    TextView tvVideoContentStr;
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
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.textView20)
    TextView textView20;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.textView22)
    TextView textView22;
    @BindView(R.id.expandableListView)
    CommentExpandableListView expandableListView;

    @BindView(R.id.tv_comment_btn)
    TextView tvCommentBtn;
    @BindView(R.id.cb_headlineCheck_btn)
    TextView cbHeadlineCheckBtn;


    private int page = 1; //默认页数

    private CommentExpandAdapter adapter;
    private List<CommentDetailBean> commentsList = new ArrayList<>();
    private int videoId;

    private int video_id;
    private String video_title;
    private String video_label;
    private String video_content = "";
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
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("圈子");

        videoId = getIntent().getIntExtra("videoId", BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);
        video_path = getIntent().getStringExtra("video_path");
        //请求
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

        cbHeadlineCheckBtn.setEnabled(data.getUp()==1?false:true);

        if (!CollectionUtil.isEmpty(data.getStories())) {
            storiesList.addAll(data.getStories());
        }

        tvSearchTextTitle.setText(video_title);

        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        try {
            Glide.with(activity).load(BaseConfig.ROOT_IMAGES_API + video_path).into(videoPlayer.thumbImageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpProxyCacheServer proxy = BaseApplication.getProxy(activity);
        String proxyUrl = proxy.getProxyUrl(BaseConfig.ROOT_IMAGES_API + video_path);
        videoPlayer.setUp(proxyUrl, video_title, JzvdStd.SCREEN_NORMAL);//视频
        VideoTitle.setText(video_title);//标题
        tvDegreeofheatStr.setText(getString(R.string.reduStr) + heat_num);
        tvLabelStr.setText(video_label);
        if (!StringUtil.isEmpty(video_content)) {
            tvVideoContentStr.setText(Html.fromHtml(video_content));
        }

        initExpandableListView();
    }

    @Override
    public void retAgencydetail(AgencyDetailBean bean) {
    }//废弃

    @Override
    public void retAgencycomment(Toutiao bean) {
        if (bean.getCode() == -1) {
            toast(bean.getMsg());
            return;
        } else {
            toast(bean.getMsg());
            //请求
//            presenter.getVideoDetail(page, videoId);

        }
    }

    @Override
    public void retAgencyUp(Toutiao bean) {
    }

    /**
     * top 点赞返回
     * @param bean
     */
    @Override
    public void retVideovideoUp(Toutiao bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }else{
            toast(bean.getMsg());
            cbHeadlineCheckBtn.setEnabled(false );
        }
    }

    /**
     * 视频评论返回
     * @param bean
     */
    @Override
    public void retVideocomment(Toutiao bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }else{
            toast(bean.getMsg());
            presenter.getVideoDetail(page, videoId);
            etComment.setText("");

        }
    }

    /**
     * 评论点赞 返回
     * @param bean
     */
    @Override
    public void retVideoup(Toutiao bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }else{
            toast(bean.getMsg());
            presenter.getVideoDetail(page, videoId);
        }
    }


    private void initData() {
    }


    private void initView() {
        expandableListView = findViewById(R.id.expandableListView);


    }

    private void initExpandableListView() {
        expandableListView.setGroupIndicator(null);
        //默认展开所有回复
        adapter = new CommentExpandAdapter(this, storiesList);
        adapter.setOnClick(new ItemIdClickListener() {
            @Override
            public void onclick(View v, String id) {
                switch (v.getId()) {
                    case R.id.comment_item_like:
                        presenter.getVideoup(id);
//                        adapter.notifyDataSetChanged();
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
//        adapter.notifyDataSetChanged();
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

    @OnClick()
    public void onViewClicked() {
        finish();
    }

    @OnClick({R.id.gobank_btn,R.id.tv_comment_btn, R.id.cb_headlineCheck_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.tv_comment_btn:
                showDiaconment(video_id);
                break;
            case R.id.cb_headlineCheck_btn:
                presenter.getVideovideoUp(video_id);

                break;
        }
    }

    /**
     * top视频 评论
     * @param video_id
     */
    private Dialog dialog;
    private EditText etComment;
    private void showDiaconment(int video_id) {
        if(dialog!=null){
            dialog.show();
            show(etComment);
        }else{
            dialog = new Dialog(this,R.style.ActionQuanZiDialogStyle);
            View view = LayoutInflater.from(this).inflate(R.layout.sendcomment,null);
            dialog.setContentView(view);
            etComment = view.findViewById(R.id.et_comment);
            view.findViewById(R.id.send_comment_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!StringUtil.isEmpty(etComment.getText().toString().trim())) {
                        // TODO: 2019/12/29 头条评论
                        presenter.Videocomment(video_id,etComment.getText().toString());
                    }else{
                        Toast.makeText(activity, "请填写评论内容", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            Window dialogwindow = dialog.getWindow();
            if (dialogwindow == null) {
                return;
            }
            dialogwindow.setGravity(Gravity.BOTTOM);
            WindowManager.LayoutParams lp = dialogwindow.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialogwindow.setAttributes(lp);
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();
            show(etComment);

        }



    }
    //文本弹起输入框
    public void show(final View view){
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.requestFocus();
                InputMethodManager manager = ((InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE));
                if (manager != null) manager.showSoftInput(view, 0);
            }
        }, 100);
    }


}
