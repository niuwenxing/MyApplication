package com.example.jiyin.home.Activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;

import java.util.List;

public class ProjectAdapter<T> extends RecyclerView.Adapter<ProjectAdapter.ProjectView> {

    private Context context;
    List<T> list;

    public ProjectAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ProjectAdapter.ProjectView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item, parent, false);
        return new ProjectView(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.ProjectView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size()+5;
    }

    class ProjectView extends RecyclerView.ViewHolder{
        public ProjectView(@NonNull View itemView) {
            super(itemView);

        }
    }

}
