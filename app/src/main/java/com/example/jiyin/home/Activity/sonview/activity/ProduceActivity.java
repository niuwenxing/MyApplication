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
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.homeview.SearchpageActivity;
import com.example.jiyin.home.Activity.sonview.base.ProduceDetailBean;
import com.example.jiyin.home.Activity.sonview.base.ProduceIndexBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.ProduceImpl;
import com.example.jiyin.home.Activity.sonview.sonview.ProduceView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.GlideImageLoader;
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


    private int page=1;
    private String searchStr="";
    private List<ProduceIndexBean.DataBean> data=new ArrayList<>();
    private ProduceAdapter produceadapter;

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

        
        ryProduceList.setLayoutManager( new LinearLayoutManager(this));
        produceadapter = new ProduceAdapter(data);
        ryProduceList.setAdapter(produceadapter);

        produceadapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ProduceDetailsActivity.startsActvity(activity,data.get(position).getProduce_id());
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.getProduceIndex(page,searchStr);

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

    /**
     * 玑瑛出品 列表
     * @param bean
     */
    @Override
    public void retProduceIndex(ProduceIndexBean bean) {
        data.clear();
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        data.addAll(bean.getData());
        produceadapter.notifyDataSetChanged();

    }

    @Override
    public void retProduceDetail(ProduceDetailBean bean) {}//废弃

    //适配器
    public class ProduceAdapter extends BaseQuickAdapter<ProduceIndexBean.DataBean, BaseViewHolder> {

        public ProduceAdapter( @Nullable List<ProduceIndexBean.DataBean> data) {
            super(R.layout.produce_item, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, ProduceIndexBean.DataBean item) {
            helper.setText(R.id.tv_produceTitie,item.getProduce_title());
            helper.setText(R.id.tv_produceBrief,item.getProduce_brief());
            helper.setText(R.id.tv_produceTime,getString(R.string.huodongtime)+item.getProduce_stime()+" 至 "+item.getProduce_etime());

            GlideImageLoader.load(activity, BaseConfig.ROOT_IMAGES_API+item.getProduce_path(),(ImageView) helper.getView(R.id.img_produceImage));

        }
    }

}
