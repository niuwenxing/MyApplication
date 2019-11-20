package com.example.jiyin.home.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.utils.PhoneUtil;
import com.example.rootlib.widget.common.CommonNoticeDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * 索引搜索
 * 搜索结果显示Fragment
 */
public class SearchFragment extends JiYingFragment {
    @BindView(R.id.recy)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_no_result)
    ImageView mTvNoResult;

    private String mQueryText;

    private SearchAdapter mAdapter;
    private List<PhoneUtil.PhoneDto> mDatas;
    @Override
    protected int attachLayoutRes() {
        return R.layout.searchfragment_layout;
    }
    @Override
    protected void init() {}

    public void bindDatas(List<PhoneUtil.PhoneDto> datas){
        this.mDatas = datas;
        mAdapter = new SearchAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);
        if (mQueryText != null) {
            mAdapter.getFilter().filter(mQueryText);
        }
    }


    /**
     * 根据newText 进行查找, 显示
     */
    public void bindQueryText(String newText) {
        if (mDatas == null) {
            mQueryText = newText.toLowerCase();
        } else if (!TextUtils.isEmpty(newText)) {
            mAdapter.getFilter().filter(newText.toLowerCase());
        }
    }

    @OnClick({R.id.recy, R.id.tv_no_result})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.recy:
                break;
            case R.id.tv_no_result:
                break;
        }
    }



    private class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.VH> implements Filterable {
        private List<PhoneUtil.PhoneDto> items = new ArrayList<>();

        public SearchAdapter() {
            items.clear();
            items.addAll(mDatas);
        }

        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            final VH holder = new VH(LayoutInflater.from(getActivity()).inflate(R.layout.item_city, parent, false));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getAdapterPosition();
//                    toast("选择了" + items.get(position).getName());
                    //携带
                    Intent intent = new Intent();
                    intent.putExtra("cityName", items.get(position).getName());
                    getActivity().setResult(RESULT_OK, intent);
                    getActivity().finish();
                }
            });
            return holder;
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {
            holder.tvName.setText(items.get(position).getName());
        }

        @Override
        public Filter getFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    ArrayList<PhoneUtil.PhoneDto> list = new ArrayList<>();
                    for (PhoneUtil.PhoneDto item : mDatas) {//电话或电话
                        if (item.getName().startsWith(constraint.toString()) || item.getTelPhone().contains(constraint)) {
                            list.add(item);
                        }
                    }
                    FilterResults results = new FilterResults();
                    results.count = list.size();
                    results.values = list;
                    return results;
                }

                @Override
                @SuppressWarnings("unchecked")
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    ArrayList<PhoneUtil.PhoneDto> list = (ArrayList<PhoneUtil.PhoneDto>) results.values;
                    items.clear();
                    items.addAll(list);
                    if (results.count == 0) {
                        mTvNoResult.setVisibility(View.VISIBLE);
                    } else {
                        mTvNoResult.setVisibility(View.INVISIBLE);
                    }
                    notifyDataSetChanged();
                }
            };
        }

        class VH extends RecyclerView.ViewHolder {
            private TextView tvName;

            public VH(View itemView) {
                super(itemView);
                tvName = (TextView) itemView.findViewById(R.id.tv_name);
            }
        }
    }

}
