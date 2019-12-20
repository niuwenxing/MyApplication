package com.example.jiyin.home.fragment.adapter;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.base.IndexindexBean;
import com.example.jiyin.utils.GlideImageLoader;

import java.util.List;

public class TopModularAdapter  extends BaseQuickAdapter<IndexindexBean.DataBean.VideoBean, BaseViewHolder> {

    public TopModularAdapter(@Nullable List<IndexindexBean.DataBean.VideoBean> data) {
        super(R.layout.home_toplist_item, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, IndexindexBean.DataBean.VideoBean item) {
//        GlideImageLoader.load(mContext, BaseConfig.ROOT_IMAGES_API+item.getVideo_path(),(ImageView)helper.getView(R.id.img_toplist_img));
        Glide.with(mContext).load(BaseConfig.ROOT_IMAGES_API+item.getVideo_path()).into((ImageView)helper.getView(R.id.img_toplist_img));
        helper.setText(R.id.tv_projecttitle,item.getVideo_title());
        helper.setText(R.id.tv_topcontent,item.getVideo_label());
        helper.setText(R.id.tv_topNumber,mContext.getResources().getString(R.string.reduStr)+item.getVideo_num()+"");
        ImageView view = helper.getView(R.id.img_toplist_img);
    }

}
