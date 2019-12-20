package com.example.jiyin.home.fragment.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

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
import com.example.jiyin.home.Activity.view.ImagePreviewActivity;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.utils.CollectionUtil;
import com.example.rootlib.utils.LogUtils;
import com.example.rootlib.view.ForceClickImageView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import razerdp.github.com.widget.PhotoContents;
import razerdp.github.com.widget.adapter.PhotoContentsBaseAdapter;

public class WorkShopASAdapter extends BaseMultiItemQuickAdapter<CircleListBean.DataBean, BaseViewHolder> {

//    private InnerContainerAdapter innerContainerAdapter;


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public WorkShopASAdapter(List<CircleListBean.DataBean> data) {
        super(data);
        LogUtils.d("Wai2"+data.size());
        addItemType(0, R.layout.circle_item);
        addItemType(1, R.layout.circle_vodieitem);

    }



    @Override
    protected void convert(@NonNull BaseViewHolder helper, CircleListBean.DataBean item) {
        Gson gson = new Gson();
        Log.d("KOKO",gson.toJson(item));
        switch (helper.getItemViewType()) {
            case 0:
                helper.setText(R.id.tv_userName,item.getUsername()+"//"+item.getCircle_id());//名称
                //头像
                Glide.with(mContext).load(BaseConfig.ROOT_IMAGES_API+item.getAvatar()).into((ImageView)helper.getView(R.id.iv_imgHead));
                helper.setText(R.id.tv_circleTime,item.getTime());//发布时间
                helper.setText(R.id.tv_content, Html.fromHtml(""));//发布文本
                //九宫格begin
//                List<CircleListBean.DataBean.FilesBean> files = item.getFiles();
                if (!CollectionUtil.isEmpty(item.getFiles())) {
                    ArrayList<ImageInfo> imageInfo = new ArrayList<>();
                    for (CircleListBean.DataBean.FilesBean file : item.getFiles()) {
                        ImageInfo info = new ImageInfo();
                        info.setThumbnailUrl(BaseConfig.ROOT_IMAGES_API+file.getFile());
                        info.setBigImageUrl(BaseConfig.ROOT_IMAGES_API+file.getFile());
                        imageInfo.add(info);
                    }
                    NineGridView view = helper.getView(R.id.nineGrid);
                    view.setAdapter(new  NineGridViewClickAdapter(mContext, imageInfo));

//                    InnerContainerAdapter  innerContainerAdapter= new InnerContainerAdapter(mContext, item.getFiles());
//                    PhotoContents view = helper.getView(R.id.circle_image_container);
//                    view.setAdapter(innerContainerAdapter);
//                    if (view.getmOnItemClickListener()==null) {
//                        view.setmOnItemClickListener(new PhotoContents.OnItemClickListener() {
//                            @Override
//                            public void onItemClick(ImageView view, int position) {
//                                Gson gson = new Gson();
//                                Log.d("KOKO",gson.toJson(item));
//                                Toast.makeText(mContext, ""+item.getCircle_id(), Toast.LENGTH_SHORT).show();
//                                ArrayList<String> objects = new ArrayList<>();
//                                for (CircleListBean.DataBean.FilesBean file : item.getFiles()) {
//                                    objects.add(BaseConfig.ROOT_IMAGES_API+file.getFile());
//                                }
//                                Intent intent = new Intent(mContext, ImagePreviewActivity.class);
//                                intent.putStringArrayListExtra("imageList", objects);
//                                intent.putExtra(ImagePreviewActivity.P.START_ITEM_POSITION, position);
//                                intent.putExtra(ImagePreviewActivity.P.START_IAMGE_POSITION, position);
//                                mContext.startActivity(intent);
//                                //禁用动画
//                                ((Activity) mContext).overridePendingTransition(0, 0);
//
//                            }
//                        }); }
                }
                //九宫格end
                //标签
                helper.setText(R.id.tv_Circle_type,item.getIfication_title());
                //热度
                helper.setText(R.id.tv_Circleheat,mContext.getResources().getString(R.string.reduStr)+item.getCircle_hot());
                //点赞
                ImageView viewImage = helper.getView(R.id.iv_Likes_img);
                if (item.getCircle_id()==79) {
                    viewImage.setBackgroundColor(mContext.getResources().getColor(R.color.black));
                }else{
                    viewImage.setBackgroundColor(mContext.getResources().getColor(R.color.colorEd7600));
                }


//                helper.addOnClickListener(R.id.iv_Likes_img).addOnClickListener(R.id.iv_comment_img).addOnClickListener(R.id.iv_share_img);
                ImageView views = helper.getView(R.id.iv_Likes_img);
                views.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, ""+item.getCircle_id(), Toast.LENGTH_SHORT).show();
                    }
                });


                helper.setText(R.id.tv_Likes_str,item.getCircle_up()+"");
                helper.setText(R.id.tv_comment_str,item.getComment()+"");
                helper.setText(R.id.tv_share_str,item.getCircle_share()+"");
                break;
            case 1:
                helper.setText(R.id.tv_userName,item.getUsername());//名称
                //头像
                Glide.with(mContext).load(BaseConfig.ROOT_IMAGES_API+item.getAvatar()).into((ImageView)helper.getView(R.id.iv_imgHead));
                helper.setText(R.id.tv_circleTime,item.getTime());//发布时间
                helper.setText(R.id.tv_content, Html.fromHtml(""));//发布文本

                //视屏
                Glide.with(mContext).load(BaseConfig.ROOT_IMAGES_API+item.getPath()).into((ImageView)helper.getView(R.id.image_voideFirst));

                //标签
                helper.setText(R.id.tv_Circle_type,item.getIfication_title());
                //热度
                helper.setText(R.id.tv_Circleheat,mContext.getResources().getString(R.string.reduStr)+item.getCircle_hot());
                //点赞
                ImageView viewImages = helper.getView(R.id.iv_Likes_img);
                viewImages.setSelected(item.getUp()==1?true:false);
                helper.addOnClickListener(R.id.iv_Likes_img).addOnClickListener(R.id.iv_comment_img)
                        .addOnClickListener(R.id.iv_share_img);
                helper.setText(R.id.tv_Likes_str,item.getCircle_up()+"");
                helper.setText(R.id.tv_comment_str,item.getComment()+"");
                helper.setText(R.id.tv_share_str,item.getCircle_share()+"");
                break;
        }
    }


    /**
     * 多图视图
     * */
    private class InnerContainerAdapter extends PhotoContentsBaseAdapter {
        private Context context;
        private List<CircleListBean.DataBean.FilesBean> datas;
        InnerContainerAdapter(Context context, List<CircleListBean.DataBean.FilesBean> urlList){
            this.context=context;
            this.datas=new ArrayList<>();
            this.datas.addAll(urlList);
        }
        @Override
        public ImageView onCreateView(ImageView convertView, ViewGroup parent, int position) {
            if (convertView==null) {
                convertView=new ForceClickImageView(context);
                convertView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            return convertView;
        }
        @Override
        public void onBindData(int position, ImageView convertView) {
            Glide.with(context).load(BaseConfig.ROOT_IMAGES_API+datas.get(position).getFile()).into(convertView);
        }
        @Override
        public int getCount() { return datas.size(); }
    }

}
