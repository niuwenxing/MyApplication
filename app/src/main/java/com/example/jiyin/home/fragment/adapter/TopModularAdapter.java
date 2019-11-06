package com.example.jiyin.home.fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.home.Activity.sonview.activity.ProduceActivity;

import java.util.List;

public class TopModularAdapter<T> extends RecyclerView.Adapter<TopModularAdapter.TopModularView> {

    private  Context context;
    private  List<T> objects;

    public TopModularAdapter(Context context, List<T> objects) {
        this.context=context;
        this.objects=objects;
    }

    @NonNull
    @Override
    public TopModularAdapter.TopModularView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TopModularView(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_toplist_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull TopModularAdapter.TopModularView holder, int position) {
        holder.rlTopItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProduceActivity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return objects.size()+5;
    }

    public class TopModularView extends RecyclerView.ViewHolder {

        private final ImageView imgToplistimg;
        private final TextView tvTopNumber;
        private final TextView tvProjecttitle;
        private final TextView tvTopcontent;
        private final RelativeLayout rlTopItemView;

        public TopModularView(@NonNull View itemView) {
            super(itemView);

            imgToplistimg = itemView.findViewById(R.id.img_toplist_img);
            tvTopNumber=itemView.findViewById(R.id.tv_topNumber);
            tvProjecttitle=itemView.findViewById(R.id.tv_projecttitle);
            tvTopcontent=itemView.findViewById(R.id.tv_topcontent);
            rlTopItemView=itemView.findViewById(R.id.rl_TopItemView);


        }
    }
}
