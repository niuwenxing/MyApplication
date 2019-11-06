package com.example.jiyin.home.Activity.sonview.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.homeview.SearchpageActivity;
import com.example.jiyin.home.Activity.sonview.sonimpl.ProduceImpl;
import com.example.jiyin.home.Activity.sonview.sonview.ProduceView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 玑瑛出品
 */

public class ProduceActivity extends JiYingActivity<ProduceView, ProduceImpl> implements ProduceView {

    @BindView(R.id.gobank_btn)
    ImageView gobankBtn;
    @BindView(R.id.searchText)
    EditText searchText;
    @BindView(R.id.searchView)
    LinearLayout searchView;
    @BindView(R.id.tv_searchTextTitle)
    TextView tvSearchTextTitle;
    @BindView(R.id.searech_news_btn)
    ImageView searechNewsBtn;
    @BindView(R.id.searech_Shopping_btn)
    ImageView searechShoppingBtn;
    @BindView(R.id.add_btn)
    TextView addBtn;
    @BindView(R.id.throw_layout)
    ThrowLayout throwLayout;
    @BindView(R.id.ry_produceList)
    RecyclerView ryProduceList;
    private List<Object> objects;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_produce;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new ProduceImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchText.setFocusable(false);
        searchText.setFocusableInTouchMode(false);
        objects = new ArrayList<>();

        
        ryProduceList.setLayoutManager( new LinearLayoutManager(this));
        ProduceAdapter produceadapter =new ProduceAdapter();
        ryProduceList.setAdapter(produceadapter);




    }

    @OnClick({R.id.gobank_btn, R.id.searchText})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searchText:
                Intent intentSearchpage = new Intent(this, SearchpageActivity.class);
                intentSearchpage.putExtra(ConstantUtil.KEY_CODE,ConstantUtil.KEY_MORE_CODE);
                startActivity(intentSearchpage);
                break;
        }
    }

    //适配器
    public class ProduceAdapter extends RecyclerView.Adapter<ProduceAdapter.ProduceView>{
        @NonNull
        @Override
        public ProduceAdapter.ProduceView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ProduceView(LayoutInflater.from(parent.getContext()).inflate(R.layout.produce_item,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ProduceAdapter.ProduceView holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }

        public class ProduceView extends RecyclerView.ViewHolder {
            public ProduceView(@NonNull View itemView) {
                super(itemView);

            }
        }
    }

}
