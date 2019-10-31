package com.example.jiyin.home.Activity.sonview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;

import java.util.List;

public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.CommodityView> {
    private Context context;
    private List list;

    public CommodityAdapter(Context context, List list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public CommodityAdapter.CommodityView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.products_item, parent, false);
        return new CommodityView(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CommodityAdapter.CommodityView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size()+5;
    }

    public class CommodityView extends RecyclerView.ViewHolder {

        private final ImageView imgProducts;
        private final TextView tvProductsIntroduce;
        private final TextView tvProductsPrice;

        public CommodityView(@NonNull View itemView) {
            super(itemView);
            imgProducts = itemView.findViewById(R.id.img_products);
            tvProductsIntroduce = itemView.findViewById(R.id.tv_ProductsIntroduce);
            tvProductsPrice = itemView.findViewById(R.id.tv_ProductsPrice);

        }
    }
}
