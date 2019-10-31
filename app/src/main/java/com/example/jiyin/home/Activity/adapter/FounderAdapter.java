package com.example.jiyin.home.Activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;

import java.util.List;

public class FounderAdapter<T> extends RecyclerView.Adapter<FounderAdapter.FounderView> {

    private Context mContext;
    private List<T> mList;

    public FounderAdapter(Context context, List<T> list){
        this.mContext=context;
        this.mList=list;
    }

    @NonNull
    @Override
    public FounderAdapter.FounderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchdetailed_item, parent, false);
        return new FounderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FounderAdapter.FounderView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class FounderView extends RecyclerView.ViewHolder {

        private final TextView tvFounderName;
        private final TextView tvInitiation;
        private final ImageView imgPortrait;
        private final TextView tvSynopsis;
        private final TextView tvLearnmore_btn;

        public FounderView(@NonNull View itemView) {
            super(itemView);
            tvFounderName = itemView.findViewById(R.id.tv_FounderName);
            tvInitiation = itemView.findViewById(R.id.tv_Initiation);
            imgPortrait = itemView.findViewById(R.id.img_portrait);
            tvSynopsis = itemView.findViewById(R.id.tv_synopsis);
            tvLearnmore_btn = itemView.findViewById(R.id.tv_Learnmore_btn);

        }
    }
}
