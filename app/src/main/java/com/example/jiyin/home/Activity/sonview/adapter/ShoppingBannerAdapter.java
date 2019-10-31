package com.example.jiyin.home.Activity.sonview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.widget.banner.BannerLayout;

import java.util.List;

public class ShoppingBannerAdapter<T> extends RecyclerView.Adapter<ShoppingBannerAdapter.BannerView> {
    private Context context;
    private List<T> urlList;
    private BannerLayout.OnBannerItemClickListener onBannerItemClickListener;

    public ShoppingBannerAdapter(Context context, List<T> urlList) {
        this.context = context;
        this.urlList = urlList;
    }

    public void setOnBannerItemClickListener(BannerLayout.OnBannerItemClickListener onBannerItemClickListener) {
        this.onBannerItemClickListener = onBannerItemClickListener;
    }

    @NonNull
    @Override
    public ShoppingBannerAdapter.BannerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BannerView(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingBannerAdapter.BannerView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return urlList.size()+5;
    }

    public class BannerView extends RecyclerView.ViewHolder {


        public BannerView(@NonNull View itemView) {
            super(itemView);

        }
    }
}
