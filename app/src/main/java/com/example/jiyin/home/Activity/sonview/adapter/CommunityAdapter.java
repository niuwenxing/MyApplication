package com.example.jiyin.home.Activity.sonview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.home.Activity.sonview.activity.CommunityActivity;

import java.util.List;

public class CommunityAdapter<T> extends RecyclerView.Adapter<CommunityAdapter.CommunityView> {

    Context context;
    List<T> objects;
    public CommunityAdapter(Context context, List<T> objects) {
        this.context=context;
        this.objects=objects;

    }

    @NonNull
    @Override
    public CommunityAdapter.CommunityView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View from = LayoutInflater.from(parent.getContext()).inflate(R.layout.communitylist_item,parent,false);
        return new CommunityView(from);
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityAdapter.CommunityView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return objects.size()+5;
    }

    public class CommunityView extends RecyclerView.ViewHolder {

        private final TextView tvCommunityTitile;
        private final TextView tvCommiunityContext;
        private final ImageView ivImageLeft;
        private final ImageView ivImageRight;

        public CommunityView(@NonNull View itemView) {
            super(itemView);
            tvCommunityTitile = itemView.findViewById(R.id.tv_communityTitile);
            tvCommiunityContext=itemView.findViewById(R.id.tv_commiunityContext);
            ivImageLeft=itemView.findViewById(R.id.iv_imageLeft);
            ivImageRight=itemView.findViewById(R.id.iv_imageRight);

        }
    }
}
