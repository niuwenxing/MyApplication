package com.example.jiyin.home.fragment.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jiyin.R;
import com.example.jiyin.common.widget.jiugong.NineGridTestLayout;
import com.example.jiyin.common.widget.jiugong.OnItemPictureClickListener;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.view.ImagePreviewActivity;
import com.example.rootlib.view.ForceClickImageView;
import com.example.rootlib.view.photo.PhotoBrowseInfo;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;
import razerdp.github.com.widget.PhotoContents;
import razerdp.github.com.widget.adapter.PhotoContentsBaseAdapter;

public class WorkShopAdapter extends RecyclerView.Adapter<WorkShopAdapter.WorkShopView>  {

    private List<CircleListBean.DataBean> listdata=new ArrayList<>();
    private Context activity;

    private OnItemPictureClickListener listener;
    private InnerContainerAdapter innerContainerAdapter;
    private List<String> urlList;

    public WorkShopAdapter(Context activity,List<CircleListBean.DataBean> data) {
        this.activity=activity;
        this.listdata=data;

    }

    @NonNull
    @Override
    public WorkShopAdapter.WorkShopView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WorkShopView(LayoutInflater.from(parent.getContext()).inflate(R.layout.circle_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull WorkShopAdapter.WorkShopView holder, int position) {
        holder.tvcontent.setText("");
        urlList = new ArrayList<>();
//        urlList.add("http://cuimg.zuyushop.com/cuxiaoPic/201511/2015110010091817554.jpg");
        urlList.add("http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/03/ChMkJlbKx2qIGStWAAePuU7wk_cAALHzQF9mKIAB4_R763.jpg");
//        urlList.add("http://img1.imgtn.bdimg.com/it/u=3356331771,2093090619&fm=214&gp=0.jpg");
//        urlList.add("http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/03/ChMkJlbKx2qIGStWAAePuU7wk_cAALHzQF9mKIAB4_R763.jpg");

        holder.jzVideoPlayerStandard.setUp("https://gslb.miaopai.com/stream/P4DnrjGZ7PzC2LfQK9k2cAKEIw39GiixIBpIHA__.mp4",
                JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,"");

        Glide.with(activity).load("https://gslb.miaopai.com/stream/P4DnrjGZ7PzC2LfQK9k2cAKEIw39GiixIBpIHA__.mp4").into(holder.jzVideoPlayerStandard.thumbImageView);

        innerContainerAdapter = new InnerContainerAdapter(activity, urlList);
        holder.circle_image_container.setAdapter(innerContainerAdapter);

        if (holder.circle_image_container.getmOnItemClickListener()==null) {
            holder.circle_image_container.setmOnItemClickListener(new PhotoContents.OnItemClickListener() {
                @Override
                public void onItemClick(ImageView view, int position) {
                    Intent intent = new Intent(activity, ImagePreviewActivity.class);
                    intent.putStringArrayListExtra("imageList", (ArrayList<String>) urlList);
                    intent.putExtra(ImagePreviewActivity.P.START_ITEM_POSITION, position);
                    intent.putExtra(ImagePreviewActivity.P.START_IAMGE_POSITION, position);
                    activity.startActivity(intent);
                    //禁用动画
                    ((Activity) activity).overridePendingTransition(0, 0);

                }
            }); }
    }

    //跟新的数据
    public void setNewsDate(List<CircleListBean.DataBean> data){
        listdata.clear();
        listdata.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    public class WorkShopView extends RecyclerView.ViewHolder {

        private final TextView tvSharestr;
        private final TextView tvCommentstr;
        private final TextView tvLikesstr;
        private final TextView tvcontent;
        private final TextView circleFollow;
        private final ImageView ivImgHead;
        private final JZVideoPlayerStandard jzVideoPlayerStandard;
        private final PhotoContents circle_image_container;


        public WorkShopView(@NonNull View itemView) {
            super(itemView);
            jzVideoPlayerStandard = itemView.findViewById(R.id.jz_JZVideo);

            ivImgHead = itemView.findViewById(R.id.iv_imgHead);

            circleFollow = itemView.findViewById(R.id.circleFollow_btn);
            tvcontent = itemView.findViewById(R.id.tv_content);

            tvLikesstr = itemView.findViewById(R.id.tv_Likes_str);
            tvCommentstr = itemView.findViewById(R.id.tv_comment_str);
            tvSharestr = itemView.findViewById(R.id.tv_share_str);

            circle_image_container = itemView.findViewById(R.id.circle_image_container); //九宫图

        }
    }


    /**
     * 多图视图
     * */
    private class InnerContainerAdapter extends PhotoContentsBaseAdapter {
        private Context context;
        private List<String> datas;
        InnerContainerAdapter(Context context, List<String> urlList){
            this.context=context;
            this.datas=new ArrayList<>();
            this.datas.addAll(urlList);
        }
        @Override
        public ImageView onCreateView(ImageView convertView, ViewGroup parent, int position) {
            if (convertView==null) {
                convertView=new ForceClickImageView(activity);
                convertView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            return convertView;
        }
        @Override
        public void onBindData(int position, ImageView convertView) {
            Glide.with(activity).load(datas.get(position)).into(convertView);
        }
        @Override
        public int getCount() { return datas.size(); }
    }




}
