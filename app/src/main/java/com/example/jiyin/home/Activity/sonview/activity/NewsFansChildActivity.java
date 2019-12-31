package com.example.jiyin.home.Activity.sonview.activity;


import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.home.Activity.homeview.base.ReleaseBean;
import com.example.jiyin.home.Activity.sonview.base.MessagecommentDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessagefollowDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessagenewDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessageupDosBean;
import com.example.jiyin.home.presenter.Impl.NewsPreImpl;
import com.example.jiyin.home.presenter.view.NewsView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.GlideImageLoader;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 消息子页面
 */

public class NewsFansChildActivity extends JiYingActivity<NewsView, NewsPreImpl> implements NewsView {

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
    @BindView(R.id.newsfanschild_list)
    RecyclerView newsfanschildList;
    private String activityTtpe;

    private List<MessagefollowDosBean.DataBean> data=new ArrayList<>();//粉丝
    private List<MessageupDosBean.DataBean> data1=new ArrayList<>();
    private List<MessagecommentDosBean.DataBean> data2=new ArrayList<>();
    private List<MessagenewDosBean.DataBean> data3=new ArrayList<>();
    private MessagefollowDosAdapter messagefollowDosAdapter;
    private MessageupDosAdapter messageupDosAdapter;
    private MessageCommentDosAdapter messageCommentDosAdapter;
    private MessagenewDosAdapter messagenewDosAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_news_fans_child;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new NewsPreImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        searechNewsBtn.setVisibility(View.INVISIBLE);




        initView();
        initData();

    }

    private void initView() {
        messagefollowDosAdapter = new MessagefollowDosAdapter(data);

        messageupDosAdapter = new MessageupDosAdapter(data1);

        messageCommentDosAdapter = new MessageCommentDosAdapter(data2);

        messagenewDosAdapter = new MessagenewDosAdapter(data3);


        activityTtpe = getIntent().getStringExtra(ConstantUtil.KEY_CODE);
        if(activityTtpe.equals(ConstantUtil.FANS)){//粉丝
            tvSearchTextTitle.setText("粉丝");

            newsfanschildList.setAdapter(messagefollowDosAdapter);
            presenter.MessagefollowDos();
        }else if(activityTtpe.equals(ConstantUtil.LIKES)){//点赞
            tvSearchTextTitle.setText("点赞");

            newsfanschildList.setAdapter(messageupDosAdapter);
            presenter.MessageupDos();
        }else if(activityTtpe.equals(ConstantUtil.COMMENT)){//评论
            tvSearchTextTitle.setText("评论");

            newsfanschildList.setAdapter(messageCommentDosAdapter);
            presenter.MessageCommentDos();
        }else if(activityTtpe.equals(ConstantUtil.OFFICIAL)){//官网
            tvSearchTextTitle.setText("官网");

            newsfanschildList.setAdapter(messagenewDosAdapter);
            presenter.MessagenewDos();
        }
    }

    private void initData() {
        messagefollowDosAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.huguan:
                        toast("回关");
                        presenter.MessagehConcern(data.get(position).getFollow_id());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + view.getId());
                }
            }
        });
        //查看详情 玑瑛管网
        messagenewDosAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                data3.get(position).getNew_id();
            }
        });

    }


    @Override
    public void onReload() {
    }

    @Override
    public void onLoadFinished() {
    }

    @Override
    public void onLoadAll() {
    }

    @OnClick(R.id.gobank_btn)
    public void onViewClicked() {
        finish();
    }

    /**
     * 粉丝列表
     * @param bean
     */
    @Override
    public void retMessagefollowDos(MessagefollowDosBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }else{
            data.clear();
            data.addAll(bean.getData());
            messagefollowDosAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 点赞列表
     * @param bean
     */
    @Override
    public void retMessageupDos(MessageupDosBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }else{
            data1.clear();
            data1.addAll(bean.getData());
            messageupDosAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 评论 列表
     * @param bean
     */
    @Override
    public void retMessageCommentDos(MessagecommentDosBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }else{
            data2.clear();
            data2.addAll(bean.getData());
            messageCommentDosAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 官方列表
     * @param bean
     */
    @Override
    public void retMessagenewDos(MessagenewDosBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }else{
            data3.clear();
            data3.addAll(bean.getData());
            messagenewDosAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 粉丝回关
     * @param bean
     */
    @Override
    public void retMessagehConcern(ReleaseBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }else{
            toast(bean.getMsg());
            presenter.MessagefollowDos();
        }
    }

    //粉丝
    public class MessagefollowDosAdapter extends BaseQuickAdapter<MessagefollowDosBean.DataBean, BaseViewHolder> {
        public MessagefollowDosAdapter( @Nullable List<MessagefollowDosBean.DataBean> data) {
            super(R.layout.fans_itemlayout, data);
        }
        @Override
        protected void convert(@NonNull BaseViewHolder helper, MessagefollowDosBean.DataBean item) {
            GlideImageLoader.loadLogh(mContext, BaseConfig.ROOT_IMAGES_API+item.getAvatar(),(ImageView) helper.getView(R.id.ml_heraitImg));
            helper.setText(R.id.tv_fans_name_tips,item.getUsername());
            helper.setText(R.id.tv_fans_time,item.getFollow_time());
            if(item.getFollow_status()==1?true:false){
                helper.setText(R.id.huguan,"互相关注");
                helper.getView(R.id.huguan).setEnabled(false);
            }else{
                helper.setText(R.id.huguan,"+ 关注");
                helper.addOnClickListener(R.id.huguan);
                helper.getView(R.id.huguan).setEnabled(true);
            }
        }
    }
    //点赞
    public class MessageupDosAdapter extends BaseQuickAdapter<MessageupDosBean.DataBean, BaseViewHolder> {
        public MessageupDosAdapter( @Nullable List<MessageupDosBean.DataBean> data) {
            super(R.layout.news_gooditem, data);
        }
        @Override
        protected void convert(@NonNull BaseViewHolder helper, MessageupDosBean.DataBean item) {
            helper.setText(R.id.textView,item.getUsername());
            helper.setText(R.id.textView2,"赞了您的作品");
            helper.setText(R.id.textView4,item.getUp_time());
//            helper.setText(R.id.imageView3,item.)
            GlideImageLoader.loadLogh(mContext,BaseConfig.ROOT_IMAGES_API+item.getAvatar(),(ImageView) helper.getView(R.id.imageView3));
        }
    }
    //评论
    public class MessageCommentDosAdapter extends BaseQuickAdapter<MessagecommentDosBean.DataBean, BaseViewHolder> {

        public MessageCommentDosAdapter( @Nullable List<MessagecommentDosBean.DataBean> data) {
            super(R.layout.news_gooditem, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, MessagecommentDosBean.DataBean item) {
            helper.setText(R.id.textView,item.getUsername());
            helper.setText(R.id.textView2,item.getComment());
            helper.setText(R.id.textView4,item.getComment_time()+"");
//            helper.setText(R.id.imageView3,item.)
            GlideImageLoader.loadLogh(mContext,BaseConfig.ROOT_IMAGES_API+item.getAvatar(),(ImageView) helper.getView(R.id.imageView3));
        }
    }
    //官方列表
    public class MessagenewDosAdapter extends BaseQuickAdapter<MessagenewDosBean.DataBean,BaseViewHolder>{

        public MessagenewDosAdapter( @Nullable List<MessagenewDosBean.DataBean> data) {
            super(R.layout.official_item, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, MessagenewDosBean.DataBean item) {
            helper.setText(R.id.textView10,item.getNew_title());
            helper.setText(R.id.textView11, Html.fromHtml(item.getNew_text()+""));
            helper.setText(R.id.textView12,item.getNew_time());
        }
    }
}
