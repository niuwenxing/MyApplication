package com.example.jiyin.home.Activity.sonview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.sonview.activity.StudyAgencyActivity;
import com.example.jiyin.home.Activity.sonview.activity.StudyparticipateActivity;
import com.example.jiyin.home.Activity.sonview.base.OfflineTrainingBean;
import com.example.jiyin.utils.GlideImageLoader;

import java.util.List;


public class OfflinetingAdapter extends RecyclerView.Adapter<OfflinetingAdapter.OfflinetingView> {

    private Context mContext;
    private List<List<OfflineTrainingBean.DataBean.OclassBean>> data;
    public OfflinetingAdapter(Context context, List<List<OfflineTrainingBean.DataBean.OclassBean>> data) {
        this.mContext=context;
        this.data=data;
    }

    @NonNull
    @Override
    public OfflinetingAdapter.OfflinetingView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_studyagency, parent, false);
        return new OfflinetingView(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OfflinetingAdapter.OfflinetingView holder, int position) {
        if (position==0) {
            holder.momentTable.setText("公开课");
        }else{
            holder.momentTable.setText("训练营");
        }
        List<OfflineTrainingBean.DataBean.OclassBean> oclassBeans = data.get(position);
        ClassroomTypeAdapter classroomTypeAdapter = new ClassroomTypeAdapter(oclassBeans);
        holder.momentTableList.setAdapter(classroomTypeAdapter);

//        classroomTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Toast.makeText(mContext, ""+oclassBeans.get(position).getUnder_id()
//                                +oclassBeans.get(position).getUnder_time()+
//                                oclassBeans.get(position).getUnder_title()+
//                                oclassBeans.get(position).getUnder_id()+
//                                oclassBeans.get(position).getUnder_type()
//                        , Toast.LENGTH_SHORT).show();
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class OfflinetingView extends RecyclerView.ViewHolder {

        private final TextView momentTable;
        private final TextView momentTableMore;
        private final RecyclerView momentTableList;

        public OfflinetingView(@NonNull View itemView) {
            super(itemView);
            momentTable = itemView.findViewById(R.id.momentTable);
            momentTableMore = itemView.findViewById(R.id.momentTableMore);
            momentTableList = itemView.findViewById(R.id.momentTableList);
        }
    }

    public class ClassroomTypeAdapter extends BaseQuickAdapter<OfflineTrainingBean.DataBean.OclassBean, BaseViewHolder>{

        public ClassroomTypeAdapter(@Nullable List<OfflineTrainingBean.DataBean.OclassBean> data) {
            super(R.layout.item_studyagency_child,data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, OfflineTrainingBean.DataBean.OclassBean item) {
            helper.setText(R.id.tv_participateCont_str,item.getUnder_title());
            helper.setText(R.id.tv_participateTime,item.getUnder_time());
            helper.setText(R.id.tv_participateCont_str,item.getUnder_title());
            GlideImageLoader.load(mContext, BaseConfig.ROOT_IMAGES_API+item.getUnder_path(), helper.getView(R.id.imageView));
            helper.getView(R.id.bt_participate_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StudyparticipateActivity.staticActivity(mContext,item.getUnder_id(),item.getUnder_type());
                }
            });
        }
    }
}
