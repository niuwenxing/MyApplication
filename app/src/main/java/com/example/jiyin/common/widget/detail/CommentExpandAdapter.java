package com.example.jiyin.common.widget.detail;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.jiyin.R;
import com.example.jiyin.home.Activity.sonview.base.VideoDetailBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Moos
 * E-mail: moosphon@gmail.com
 * Date:  18/4/20.
 * Desc: 评论与回复列表的适配器
 */

public class CommentExpandAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "CommentExpandAdapter";
    private List<VideoDetailBean.DataBean.StoriesBean> commentBeanList;
    private List<ReplyDetailBean> replyBeanList;
    private Context context;
    private int pageIndex = 1;
    private ItemIdClickListener itemClickListener;
    public CommentExpandAdapter(Context context, List<VideoDetailBean.DataBean.StoriesBean> commentBeanList) {
        this.context = context;
        this.commentBeanList = commentBeanList;
    }

    @Override
    public int getGroupCount() {
        return commentBeanList.size();
    }

    @Override
    public int getChildrenCount(int i) {
//        if(commentBeanList.get(i).getReplyList() == null){
            return 0;
//        }else {
//            return commentBeanList.get(i).getReplyList().size()>0 ? commentBeanList.get(i).getReplyList().size():0;
//        }

    }

    @Override
    public Object getGroup(int i) {
        return commentBeanList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return "";
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return getCombinedChildId(groupPosition, childPosition);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
    boolean isLike = false;
    int num;
    @Override
    public View getGroupView(final int groupPosition, boolean isExpand, View convertView, ViewGroup viewGroup) {
        final GroupHolder groupHolder;
        //num = Integer.valueOf(commentBeanList.get(groupPosition).getZan());
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_item_layout, viewGroup, false);
            groupHolder = new GroupHolder(convertView);
            convertView.setTag(groupHolder);
        }else {
            groupHolder = (GroupHolder) convertView.getTag();
        }
        Glide.with(context).load(commentBeanList.get(groupPosition).getAvatar())
                .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE).error(R.mipmap.ic_launcher).centerCrop())
                .into(groupHolder.logo);
        groupHolder.tv_name.setText(commentBeanList.get(groupPosition).getUsername());



//        groupHolder.tv_content.setText(commentBeanList.get(groupPosition).getContent());
//        groupHolder.tv_time.setText(commentBeanList.get(groupPosition).getTime());
        //是否点赞
//        if(commentBeanList.get(groupPosition).getIfzan().equals("1")){
//            groupHolder.iv_like.setImageResource(R.mipmap.ic_launcher);
//        }else {
//            groupHolder.iv_like.setImageResource(R.mipmap.ic_launcher);
//        }
//        groupHolder.comment_item_like_num.setText(commentBeanList.get(groupPosition).getZan());
        groupHolder.iv_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(commentBeanList.get(groupPosition).getIfzan().equals("1")){
//                    //groupHolder.iv_like.setImageResource(R.mipmap.zan);
//                    commentBeanList.get(groupPosition).setIfzan("0");
//                    commentBeanList.get(groupPosition).setZan(Integer.valueOf(commentBeanList.get(groupPosition).getZan())-1+"");
//
//                }else {
//                    //groupHolder.iv_like.setImageResource(R.mipmap.weidianzan);
//                    commentBeanList.get(groupPosition).setIfzan("1");
//                    commentBeanList.get(groupPosition).setZan(Integer.valueOf(commentBeanList.get(groupPosition).getZan())+1+"");
//                }
//                itemClickListener.onclick(view,commentBeanList.get(groupPosition).getCid()+"");
            }
        });

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {
        final ChildHolder childHolder;
        //switch (commentBeanList.get(groupPosition).getReplyList().get(childPosition).getItem_type()){
            //case "1":
               // if(commentBeanList.get(groupPosition).getReplyList().get(childPosition-1).getItem_type().equals("1")){
                    if(convertView == null){
                        convertView = LayoutInflater.from(context).inflate(R.layout.comment_reply_item_layout,viewGroup, false);
                        childHolder = new ChildHolder(convertView);
                        convertView.setTag(childHolder);
                    }
                    else {
                        childHolder = (ChildHolder) convertView.getTag();
                    }
               // }
                /*
                else {
                    convertView = LayoutInflater.from(context).inflate(R.layout.comment_reply_item_layout,viewGroup, false);
                    childHolder = new ChildHolder(convertView);
                    convertView.setTag(childHolder);
                    //childHolder = (ChildHolder) convertView.getTag();
                }
                 */

//                String replyUser = commentBeanList.get(groupPosition).getReplyList().get(childPosition).getUsername();
//                if(!TextUtils.isEmpty(replyUser)){
//                    childHolder.tv_name.setText(replyUser + ":");
//                }else {
//                    childHolder.tv_name.setText(""+":");
//                }
//                if(childPosition == 0&&childPosition+1==getChildrenCount(groupPosition)){
//                    childHolder.bg.setBackground(context.getDrawable(R.drawable.remake_bg_top_bottom));
//                }else if(childPosition==0){
//                    childHolder.bg.setBackground(context.getDrawable(R.drawable.remake_bg_top));
//                }else if(childPosition>0&&childPosition<getChildrenCount(groupPosition)-1){
//                    childHolder.bg.setBackground(context.getDrawable(R.drawable.remake_bg_mid));
//                }else {
//                    childHolder.bg.setBackground(context.getDrawable(R.drawable.remake_bg_bottom));
//                }
//                childHolder.tv_content.setText(commentBeanList.get(groupPosition).getReplyList().get(childPosition).getContent());
               // break;
            //case "2":
                /*
                if(commentBeanList.get(groupPosition).getReplyList().get(childPosition-1).getItem_type().equals("1")){
                    if(convertView == null){
                        convertView = LayoutInflater.from(context).inflate(R.layout.comment_reply_eather_item_layout,viewGroup, false);
                        childHolder = new ChildHolder(convertView);
                        convertView.setTag(childHolder);
                    }
                    else {
                        childHolder = (ChildHolder) convertView.getTag();
                    }
                }else {
                    convertView = LayoutInflater.from(context).inflate(R.layout.comment_reply_item_layout,viewGroup, false);
                    childHolder = new ChildHolder(convertView);
                    convertView.setTag(childHolder);
                    //childHolder = (ChildHolder) convertView.getTag();
                }

                //String replyUser = commentBeanList.get(groupPosition).getReplyList().get(childPosition).getNickName();
                if(!TextUtils.isEmpty(replyUser)){
                    childHolder.tv_name.setText(replyUser + ":");
                }else {
                    childHolder.tv_name.setText("无名"+":");
                }
                if(childPosition == 0&&childPosition+1==getChildrenCount(groupPosition)){
                    childHolder.bg.setBackground(context.getDrawable(R.drawable.remake_bg_top_bottom));
                }else if(childPosition==0){
                    childHolder.bg.setBackground(context.getDrawable(R.drawable.remake_bg_top));
                }else if(childPosition>0&&childPosition<getChildrenCount(groupPosition)-1){
                    childHolder.bg.setBackground(context.getDrawable(R.drawable.remake_bg_mid));
                }else {
                    childHolder.bg.setBackground(context.getDrawable(R.drawable.remake_bg_bottom));
                }
                childHolder.tv_content.setText(commentBeanList.get(groupPosition).getReplyList().get(childPosition).getContent());
                break;
                 */
       // }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    private class GroupHolder{
        private ImageView logo;
        private TextView tv_name, tv_content, tv_time,comment_item_like_num;
        private ImageView iv_like;
        public GroupHolder(View view) {
            logo = (ImageView) view.findViewById(R.id.comment_item_logo);
            tv_content = (TextView) view.findViewById(R.id.comment_item_content);
            tv_name = (TextView) view.findViewById(R.id.comment_item_userName);
            tv_time = (TextView) view.findViewById(R.id.time);
            iv_like = (ImageView) view.findViewById(R.id.comment_item_like);
            comment_item_like_num = (TextView) view.findViewById(R.id.comment_item_like_num);
        }
    }

    private class ChildHolder{
        private TextView tv_name, tv_content;
        private LinearLayout bg;
        public ChildHolder(View view) {
            tv_name = (TextView) view.findViewById(R.id.reply_item_user);
            tv_content = (TextView) view.findViewById(R.id.reply_item_content);
            bg = (LinearLayout) view.findViewById(R.id.bg);
        }
    }


    /**
     * by moos on 2018/04/20
     * func:评论成功后插入一条数据
     * @param commentDetailBean 新的评论数据
     */
    public void addTheCommentData(VideoDetailBean.DataBean.StoriesBean commentDetailBean){
        if(commentDetailBean!=null){
            commentBeanList.add(commentDetailBean);
            notifyDataSetChanged();
        }else {
            throw new IllegalArgumentException("评论数据为空!");
        }

    }

    /**
     * by moos on 2018/04/20
     * func:回复成功后插入一条数据
     * @param replyDetailBean 新的回复数据
     */
    public void addTheReplyData(ReplyDetailBean replyDetailBean, int groupPosition){
        if(replyDetailBean!=null){
            Log.e(TAG, "addTheReplyData: >>>>该刷新回复列表了:"+replyDetailBean.toString() );
//            if(commentBeanList.get(groupPosition).getReplyList() != null ){
//                commentBeanList.get(groupPosition).getReplyList().add(replyDetailBean);
//            }else {
//                List<ReplyDetailBean> replyList = new ArrayList<>();
//                replyList.add(replyDetailBean);
//                commentBeanList.get(groupPosition).setReplyList(replyList);
//            }
            notifyDataSetChanged();
        }else {
            throw new IllegalArgumentException("回复数据为空!");
        }

    }

    /**
     * by moos on 2018/04/20
     * func:添加和展示所有回复
     * @param replyBeanList 所有回复数据
     * @param groupPosition 当前的评论
     */
    private void addReplyList(List<ReplyDetailBean> replyBeanList, int groupPosition){
//        if(commentBeanList.get(groupPosition).getReplyList() != null ){
//            commentBeanList.get(groupPosition).getReplyList().clear();
//            commentBeanList.get(groupPosition).getReplyList().addAll(replyBeanList);
//        }else {
//
//            commentBeanList.get(groupPosition).setReplyList(replyBeanList);
//        }

        notifyDataSetChanged();
    }
    public void setOnClick(ItemIdClickListener mylistener){
        itemClickListener = mylistener;
    }
}
