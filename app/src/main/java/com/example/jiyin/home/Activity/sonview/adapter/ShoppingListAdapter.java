package com.example.jiyin.home.Activity.sonview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.widget.banner.BannerLayout;
import com.example.jiyin.home.Activity.adapter.SpaceItemDecoration;
import com.example.jiyin.home.Activity.sonview.activity.ShopCategoryActivity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListAdapter<T> extends RecyclerView.Adapter<ShoppingListAdapter.BannerView> {
    private Context context;
    private List<T> urlList;
    private BannerLayout.OnBannerItemClickListener onBannerItemClickListener;

    public ShoppingListAdapter(Context context, List<T> urlList) {
        this.context = context;
        this.urlList = urlList;
    }

    public void setOnBannerItemClickListener(BannerLayout.OnBannerItemClickListener onBannerItemClickListener) {
        this.onBannerItemClickListener = onBannerItemClickListener;
    }

    @NonNull
    @Override
    public ShoppingListAdapter.BannerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BannerView(LayoutInflater.from(parent.getContext()).inflate(R.layout.shoppingcommodity_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListAdapter.BannerView holder, int position) {
        holder.tvCommodityNmae.setText("");
        LinearLayoutManager FounderLayoutManager = new LinearLayoutManager(context);
        FounderLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        holder.ryWipesList.setLayoutManager(FounderLayoutManager);
        List<Object> objects = new ArrayList<>();
        CommodityAdapter commodityAdapter = new CommodityAdapter(context,objects);
        holder.ryWipesList.addItemDecoration(new SpaceItemDecoration((int) context.getResources().getDimension(R.dimen.dp_10),0));
        holder.ryWipesList.setAdapter(commodityAdapter);

        holder.tvWipesMore_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ShopCategoryActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return urlList.size()+5;
    }

    public class BannerView extends RecyclerView.ViewHolder {

        private final TextView tvCommodityNmae;
        private final TextView tvWipesMore_btn;//更多
        private final RecyclerView ryWipesList;//更多

        public BannerView(@NonNull View itemView) {
            super(itemView);
            tvCommodityNmae = itemView.findViewById(R.id.tv_commodityNmae);
            tvWipesMore_btn = itemView.findViewById(R.id.tv_WipesMore_btn);
            ryWipesList = itemView.findViewById(R.id.ry_WipesList);
        }
    }
}
