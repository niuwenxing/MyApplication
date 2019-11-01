package com.example.jiyin.home.Activity.sonview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;

import java.util.List;

public class HeadlinesAdapter<T> extends RecyclerView.Adapter<HeadlinesAdapter.HeadlinesView>{

    private Context  context;
    private List<T> list;
    public HeadlinesAdapter(Context context, List<T> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public HeadlinesView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.headlines_item, parent, false);
        return new HeadlinesView(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadlinesAdapter.HeadlinesView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HeadlinesView extends RecyclerView.ViewHolder {
        public HeadlinesView(@NonNull View itemView) {
            super(itemView);

        }
    }
}
