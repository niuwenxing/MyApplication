package com.example.jiyin.home.Activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jiyin.R;
import java.util.List;


public class SearchpageAdpter extends RecyclerView.Adapter<SearchpageAdpter.SearchpageView> {

    private Context context;
    private List list;

    public SearchpageAdpter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SearchpageView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
        return new SearchpageView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchpageView holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public class SearchpageView extends RecyclerView.ViewHolder {

        private final ImageView ivImagesearch;
        private final TextView tvTextsearch;
        private final TextView tvCulturebelongs;
        private final TextView tvCulturedescribe;
        private final TextView tvBtnMore;

        public SearchpageView(@NonNull View itemView) {
            super(itemView);
            ivImagesearch = itemView.findViewById(R.id.iv_imagesearch);
            tvTextsearch = itemView.findViewById(R.id.tv_textsearch);
            tvCulturebelongs = itemView.findViewById(R.id.tv_Culturebelongs);
            tvCulturedescribe = itemView.findViewById(R.id.tv_Culturedescribe);
            tvBtnMore = itemView.findViewById(R.id.tv_btnMore);
        }
    }
}
