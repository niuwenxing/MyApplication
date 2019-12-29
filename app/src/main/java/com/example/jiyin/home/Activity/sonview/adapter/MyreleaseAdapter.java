package com.example.jiyin.home.Activity.sonview.adapter;


import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.NineGVIew.ImageInfo;
import com.example.jiyin.common.widget.NineGVIew.NineGridView;
import com.example.jiyin.common.widget.NineGVIew.preview.NineGridViewClickAdapter;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.sonview.activity.WorkPoldetailsActivity;
import com.example.jiyin.home.fragment.adapter.WorkShopASAdapter;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.GlideImage;
import com.example.jiyin.utils.GlideImageLoader;
import com.example.rootlib.utils.CollectionUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的发布
 */

public class MyreleaseAdapter extends BaseMultiItemQuickAdapter<CircleListBean.DataBean, BaseViewHolder> {

    public MyreleaseAdapter(List<CircleListBean.DataBean> data) {
        super(data);
        addItemType(0, R.layout.myrelease_img);
        addItemType(1, R.layout.myrelease_voide);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CircleListBean.DataBean item) {
        Gson gson = new Gson();
//        Log.d("KOKO",gson.toJson(item));
        switch (helper.getItemViewType()) {
            case 0:
                helper.setText(R.id.tv_userName,item.getUsername()+"");//名称
                helper.getView(R.id.iv_imgHead).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(new Intent(mContext, WorkPoldetailsActivity.class)
                                .putExtra(ConstantUtil.KEY_CODE,item.getCircle_id())
                        );
                    }
                });

                //头像
//                Glide.with(mContext).load(BaseConfig.ROOT_IMAGES_API+item.getAvatar()).into((ImageView)helper.getView(R.id.iv_imgHead));
                GlideImageLoader.loadLogh(mContext,BaseConfig.ROOT_IMAGES_API+item.getAvatar(),(ImageView)helper.getView(R.id.iv_imgHead));
                helper.setText(R.id.tv_circleTime,item.getTime());//发布时间
                helper.setText(R.id.tv_content, Html.fromHtml(item.getCircle_title()));//发布文本
                if (!CollectionUtil.isEmpty(item.getFiles())) {
                    ArrayList<ImageInfo> imageInfo = new ArrayList<>();
                    for (CircleListBean.DataBean.FilesBean file : item.getFiles()) {
                        ImageInfo info = new ImageInfo();
                        info.setThumbnailUrl(BaseConfig.ROOT_IMAGES_API+file.getFile());
                        info.setBigImageUrl(BaseConfig.ROOT_IMAGES_API+file.getFile());
                        imageInfo.add(info);
                    }
                    NineGridView view = helper.getView(R.id.nineGrid);
                    NineGridView.setImageLoader(new GlideImage());
                    view.setAdapter(new NineGridViewClickAdapter(mContext, imageInfo));
                }
                //九宫格end
                //标签
                helper.setText(R.id.tv_Circle_type,item.getIfication_title());
                //热度
                helper.setText(R.id.tv_Circleheat,mContext.getResources().getString(R.string.reduStr)+item.getCircle_hot());
                //点赞
                ImageView viewImage = helper.getView(R.id.iv_Likes_img);
                viewImage.setSelected(item.getUp()==1?true:false);
                viewImage.setEnabled(item.getUp()==1?false:true);
//                helper.addOnClickListener(R.id.iv_comment_img);//评论
                viewImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewImage.setSelected(!viewImage.isSelected());
                        if (viewImage.isSelected()) {
                            item.setCircle_up(item.getCircle_up()+1);
                            helper.setText(R.id.tv_Likes_str,item.getCircle_up()+"");
                            viewImage.setEnabled(false);
                        }else{
                            item.setCircle_up(item.getCircle_up()-1);
                            helper.setText(R.id.tv_Likes_str,item.getCircle_up()+"");
                        }
                        if (myItemClick != null) {
                            myItemClick.onclick(item.getCircle_id(),viewImage.isSelected());
                        }

                    }
                });
                //分享
                helper.getView(R.id.iv_share_img).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (myfengxian != null) {
                            myfengxian.onclick(item.getCircle_id());
                        }

                    }
                });

                helper.setText(R.id.tv_Likes_str,item.getCircle_up()+"");
                helper.setText(R.id.tv_comment_str,item.getComment()+"");
                helper.setText(R.id.tv_share_str,item.getCircle_share()+"");
                //菜单
                helper.getView(R.id.circl_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (myguanzua != null) {
                            myguanzua.onclick(item.getCircle_id(),helper.getView(R.id.circl_btn));
                        }

                    }
                });

                break;
            case 1:
                helper.setText(R.id.tv_userName,item.getUsername());//名称
                //头像
//                Glide.with(mContext).load(BaseConfig.ROOT_IMAGES_API+item.getAvatar()).into((ImageView)helper.getView(R.id.iv_imgHead));
                GlideImageLoader.loadLogh(mContext,BaseConfig.ROOT_IMAGES_API+item.getAvatar(),(ImageView)helper.getView(R.id.iv_imgHead));
                helper.getView(R.id.iv_imgHead).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(new Intent(mContext, WorkPoldetailsActivity.class)
                                .putExtra(ConstantUtil.KEY_CODE,item.getCircle_id())
                        );
                    }
                });
                helper.setText(R.id.tv_circleTime,item.getTime());//发布时间
                helper.setText(R.id.tv_content, Html.fromHtml(item.getCircle_title()));//发布文本
                //视屏
//                Glide.with(mContext).load(BaseConfig.ROOT_IMAGES_API+item.getPath()).into((ImageView)helper.getView(R.id.image_voideFirst));
                GlideImageLoader.loadLogh(mContext,BaseConfig.ROOT_IMAGES_API+item.getPath(),(ImageView)helper.getView(R.id.image_voideFirst));
                //标签
                helper.setText(R.id.tv_Circle_type,item.getIfication_title());
                //热度
                helper.setText(R.id.tv_Circleheat,mContext.getResources().getString(R.string.reduStr)+item.getCircle_hot());
                //点赞
                ImageView viewImages = helper.getView(R.id.iv_Likes_img);
                viewImages.setSelected(item.getUp()==1?true:false);
                viewImages.setEnabled(item.getUp()==1?false:true);
//                helper.addOnClickListener(R.id.iv_comment_img);//评论
                viewImages.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewImages.setSelected(!viewImages.isSelected());
                        if (viewImages.isSelected()) {
                            item.setCircle_up(item.getCircle_up()+1);
                            helper.setText(R.id.tv_Likes_str,item.getCircle_up()+"");
                            viewImages.setEnabled(false);
                        }else{
                            item.setCircle_up(item.getCircle_up()-1);
                            helper.setText(R.id.tv_Likes_str,item.getCircle_up()+"");
                        }
                        if (myItemClick != null) {
                            myItemClick.onclick(item.getCircle_id(),viewImages.isSelected());
                        }
                    }
                });
                helper.setText(R.id.tv_Likes_str,item.getCircle_up()+"");
                helper.setText(R.id.tv_comment_str,item.getComment()+"");
                helper.setText(R.id.tv_share_str,item.getCircle_share()+"");
                //菜单
                helper.getView(R.id.circl_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (myguanzua != null) {
                            myguanzua.onclick(item.getCircle_id(), (View)helper.getView(R.id.circl_btn));
                        }

                    }
                });
                //分享
                helper.getView(R.id.iv_share_img).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (myfengxian != null) {
                            myfengxian.onclick(item.getCircle_id());
                        }

                    }
                });

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + helper.getItemViewType());
        }
    }

    public  interface Mtvbaidu{ void onclick(@NonNull int circleid, Boolean zan);}
    public  interface Myguanzu{ void onclick(@NonNull int follow_uid,View view);}
    public  interface Myfengxian{ void onclick(@NonNull int circle_id);}
    private Mtvbaidu myItemClick;
    private Myguanzu myguanzua;
    private Myfengxian myfengxian;
    public  void setOnclick(Mtvbaidu mtvbaidu){ myItemClick=mtvbaidu; }
    public  void setOnclick(Myguanzu myguanzu) { myguanzua=myguanzu; }
    public  void setOnclick(Myfengxian myfengxiana) { myfengxian=myfengxiana; }

}
