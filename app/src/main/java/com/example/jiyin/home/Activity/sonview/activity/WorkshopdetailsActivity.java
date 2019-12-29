package com.example.jiyin.home.Activity.sonview.activity;


import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.MLImageView;
import com.example.jiyin.common.widget.NineGVIew.ImageInfo;

import com.example.jiyin.common.widget.NineGVIew.NineGridView;
import com.example.jiyin.common.widget.NineGVIew.preview.NineGridViewClickAdapter;
import com.example.jiyin.common.widget.detail.CommentExpandableListView;
import com.example.jiyin.common.widget.detail.CommentQuanZiAdapter;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.homeview.base.UserCircleUpBean;
import com.example.jiyin.home.Activity.presenter.impl.WorkshopImpl;
import com.example.jiyin.home.Activity.presenter.view.WorkshopView;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.Activity.sonview.base.UsercircleDetailBean;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.GlideImage;
import com.example.jiyin.utils.GlideImageLoader;
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
 * 圈子个人详情
 */

public class WorkshopdetailsActivity extends JiYingActivity<WorkshopView, WorkshopImpl> implements WorkshopView {

    @BindView(R.id.throw_layout)
    ThrowLayout throwLayout;
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
    @BindView(R.id.aasd)
    View aasd;
    @BindView(R.id.iv_imgHead)
    MLImageView ivImgHead;
    @BindView(R.id.tv_userName)
    TextView tvUserName;
    @BindView(R.id.tv_circleTime)
    TextView tvCircleTime;
    @BindView(R.id.circleFollow_btn)
    TextView circleFollowBtn;
    @BindView(R.id.linecolor)
    View linecolor;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.nineGrida)
    NineGridView nineGrid;
    @BindView(R.id.video_player)
    JzvdStd videoPlayer;
    @BindView(R.id.rl_contextView)
    ConstraintLayout rlContextView;
    @BindView(R.id.tv_Circleheat)
    TextView tvCircleheat;
    @BindView(R.id.tv_Circle_type)
    TextView tvCircleType;
    @BindView(R.id.typeView)
    RelativeLayout typeView;
    @BindView(R.id.iv_Likes_img)
    ImageView ivLikesImg;
    @BindView(R.id.tv_Likes_str)
    TextView tvLikesStr;
    @BindView(R.id.iv_comment_img)
    ImageView ivCommentImg;
    @BindView(R.id.tv_comment_str)
    TextView tvCommentStr;
    @BindView(R.id.iv_share_img)
    ImageView ivShareImg;
    @BindView(R.id.tv_share_str)
    TextView tvShareStr;
    @BindView(R.id.dianzan)
    LinearLayout dianzan;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.textView22)
    TextView textView22;
    @BindView(R.id.exQuanZiListView)
    CommentExpandableListView exQuanZiListView;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    private int circleid;
    private ArrayList<ImageInfo> imageInfo;
    private CommentQuanZiAdapter commentQuanZiAdapter;
    private List<UsercircleDetailBean.DataBean.DiscussBean> discuss=new ArrayList<>();
    private int circle_id;
    private EditText etComment;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_workshopdetails;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter=new WorkshopImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setText("详情");

        circleid = getIntent().getIntExtra(ConstantUtil.KEY_CODE, BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);


        //评论 列表
        commentQuanZiAdapter = new CommentQuanZiAdapter(activity,discuss);
        for(int i = 0; i<discuss.size(); i++){
            exQuanZiListView.expandGroup(i);
        }
        exQuanZiListView.setGroupIndicator(null);
        exQuanZiListView.setAdapter(commentQuanZiAdapter);


        presenter.UsercircleDetail(circleid);
    }



    @Override
    public void returnLabel(List<CirclelabelBean.DataBean> data) {
    }//废弃

    @Override
    public void ReturnCircle(CircleListBean bean) {
    }//废弃

    @Override
    public void retUsercircleUp(UserCircleUpBean bean, boolean zan) {
    }//废弃

    @Override
    public void retUserfollow(UserCircleUpBean bean) {
    }//废弃

    @Override
    public void retUsercircleShare(UserCircleUpBean bean) {
    }//废弃

    /**
     * 圈子个人详情 返回
     * @param bean
     */
    @Override
    public void retUsercircleDetail(UsercircleDetailBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        UsercircleDetailBean.DataBean data = bean.getData();
        circle_id = data.getCircle_id();
//       0图片1 视频
        if(data.getCircle_type()==0?true:false){
            if (!CollectionUtil.isEmpty(data.getFiles())) {
                nineGrid.setVisibility(View.VISIBLE);
                ArrayList<ImageInfo>  imageInfo = new ArrayList<>();
                for (UsercircleDetailBean.DataBean.FilesBean file : data.getFiles()) {
                    ImageInfo info = new ImageInfo();
                    info.setThumbnailUrl(BaseConfig.ROOT_IMAGES_API+file.getFile());
                    info.setBigImageUrl(BaseConfig.ROOT_IMAGES_API+file.getFile());
                    imageInfo.add(info);
                }
                NineGridView.setImageLoader(new GlideImage());
                NineGridViewClickAdapter nineGridViewClickAdapter = new NineGridViewClickAdapter(WorkshopdetailsActivity.this, imageInfo);
                nineGrid.setAdapter(nineGridViewClickAdapter);

            }
        }else{
            linearLayout.setVisibility(View.VISIBLE);
            Glide.with(activity).load(BaseConfig.ROOT_IMAGES_API + data.getPath()).into(videoPlayer.thumbImageView);
            videoPlayer.setUp(BaseConfig.ROOT_IMAGES_API + data.getPath(), "", JzvdStd.SCREEN_NORMAL);//视频

        }
        //用户头像
        GlideImageLoader.loadLogh(activity,BaseConfig.ROOT_IMAGES_API+data.getAvatar(),ivImgHead);
        //用户昵称
        tvUserName.setText(data.getUsername());
        //发布事件
        tvCircleTime.setText(data.getTime());
        //设置关注
        if(data.getFollow()==1?true:false){
            circleFollowBtn.setVisibility(View.INVISIBLE);
        }else{
            circleFollowBtn.setVisibility(View.VISIBLE);
        }
        //设置内容
        tvContent.setText(Html.fromHtml(data.getCircle_title()));
        //设置标签
        tvCircleType.setText(data.getIfication_title());
        //设置热度
        tvCircleheat.setText(activity.getString(R.string.reduStr)+data.getCircle_hot());
        //设置点赞
        if (data.getUp()==1?true:false){
            ivLikesImg.setSelected(true);
            ivLikesImg.setEnabled(false);
        }else{
            ivLikesImg.setSelected(false);
            ivLikesImg.setEnabled(true);
        }
        //设置点赞数
        tvLikesStr.setText(data.getCircle_up()+"");
        //设置评论数
        tvCommentStr.setText(data.getComment()+"");
        //设置分享数
        tvShareStr.setText(data.getCircle_share()+"");
        discuss.clear();

        discuss.addAll(data.getDiscuss());
        for(int i = 0; i<discuss.size(); i++){
            exQuanZiListView.expandGroup(i);
        }
        commentQuanZiAdapter.notifyDataSetChanged();


    }

    @Override
    public void retNetErr(String err) {
        toast(err+"");
    }

    @Override
    public void retUserReply(UserReplyBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }else{
            toast(bean.getMsg());
            presenter.UsercircleDetail(circleid);//刷新接口
            if (etComment != null) {
                etComment.setText("");
            }
        }

    }

    @Override
    public void retMinemyUprelease(CircleListBean bean) { }//废弃

    @Override
    public void retUserCircleDel(UserReplyBean bean) { }//废弃

    @OnClick({R.id.gobank_btn, R.id.circleFollow_btn, R.id.iv_Likes_img,R.id.iv_comment_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.circleFollow_btn:
                break;
            case R.id.iv_Likes_img:

                break;
            case R.id.iv_comment_img:
                showSendcommentOn(circle_id);
                break;
        }
    }

    /**
     * 评论
     */
    private Dialog dialog;
    private void showSendcommentOn(int ID) {
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
                    presenter.getUserReply(circle_id,0,0,etComment.getText().toString());
                }else{
                    Toast.makeText(WorkshopdetailsActivity.this, "请填写评论内容", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
        //Change these two variables back
        Jzvd.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE;
        Jzvd.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
