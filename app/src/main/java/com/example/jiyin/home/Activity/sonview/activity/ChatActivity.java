package com.example.jiyin.home.Activity.sonview.activity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.homeview.base.ReleaseBean;
import com.example.jiyin.home.Activity.sonview.base.MessagecommentDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessagefollowDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessagenewDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessageupDosBean;
import com.example.jiyin.home.fragment.adapter.BaseRecyclerAdapter;
import com.example.jiyin.home.fragment.adapter.SmartViewHolder;
import com.example.jiyin.home.presenter.Impl.NewsPreImpl;
import com.example.jiyin.home.presenter.view.NewsView;
import com.example.rootlib.utils.DynamicTimeFormat;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.impl.ScrollBoundaryDeciderAdapter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 聊天界面
 */

public class ChatActivity extends JiYingActivity<NewsView, NewsPreImpl> implements NewsView {


    @BindView(R.id.gobank_btn)
    ImageView gobankBtn;
    @BindView(R.id.tv_searchTextTitle)
    TextView tvSearchTextTitle;
    private Collection<Message> messages;
    private TextView send_comment;
    private EditText et_comment;

    final User user = new User() {{
        avatarId = R.mipmap.touxiang;
    }};

    final User mine = new User() {{
        isMe = true;
        avatarId = R.mipmap.touxiang;
    }};
    private MessageAdapter adapter;
    private RefreshLayout refreshLayout;
    private RecyclerView listView;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_chat;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
    }

    private void initListener() {
        send_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Collection<Message> messagess = Arrays.asList(
                        new Message() {{
                            this.User = mine;
                            this.Time = new Date(System.currentTimeMillis());
                            this.Message = et_comment.getText().toString();
                        }}
                );
//                messages=messagess;
                adapter.insertsend(messagess);
//                adapter.notifyListDataSetChanged();
//                adapter.notifyDataSetChanged();
                et_comment.setText(null);
                listView.smoothScrollToPosition(adapter.getItemCount() - 1);
            }
        });

    }

    private void initView() {
        send_comment = findViewById(R.id.send_comment);
        et_comment = findViewById(R.id.et_comment);


        View arrow = findViewById(ClassicsFooter.ID_IMAGE_ARROW);
        arrow.setScaleY(-1);//必须设置

        messages = initData();
        adapter = new MessageAdapter(messages, 0);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setScaleY(-1);//必须设置

        final RefreshLayout refreshLayout = findViewById(R.id.refreshLayout);
        final ClassicsFooter footer = findViewById(R.id.footer);

        refreshLayout.setEnableRefresh(false);//必须关闭
        refreshLayout.setEnableAutoLoadMore(true);//必须关闭
        refreshLayout.setEnableNestedScroll(false);//必须关闭
        refreshLayout.setEnableScrollContentWhenLoaded(true);//必须关闭
        refreshLayout.getLayout().setScaleY(-1);//必须设置
        refreshLayout.setScrollBoundaryDecider(new ScrollBoundaryDeciderAdapter() {
            @Override
            public boolean canLoadMore(View content) {
                return super.canRefresh(content);//必须替换
            }
        });

        //监听加载，而不是监听 刷新
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @SuppressLint("NewApi")
                    @Override
                    public void run() {//获取更多的信息
//                        adapter.insert(messages);
                        refreshLayout.finishLoadMore();
                    }
                }, 2000);
            }
        });

    }


    private Collection<Message> initData() {

        return Arrays.asList(
                new Message() {{
                    this.User = user;
                    this.Time = new Date(System.currentTimeMillis() - 3600 * 1000 * 3);
                    this.Message = "你好，我们目前在招的投资项目" +
                            "乐品校是基于校园的一款服务类" +
                            "APP";
                }},
                new Message() {{
                    this.User = mine;
                    this.Time = new Date(System.currentTimeMillis() - 3600 * 1000 * 3 + 5000);
                    this.Message = "我们可以和您这边合作么？";
                }},
                new Message() {{
                    this.User = user;
                    this.Time = new Date(System.currentTimeMillis() - 3600 * 1000 * 3 + 10000);
                    this.Message = "您这边是想在哪些方面合作呢？" +
                            "我们可以做广告类的投资";
                }},
                new Message() {{
                    this.User = mine;
                    this.Time = new Date(System.currentTimeMillis() - 3600 * 1000 * 3 + 15000);
                    this.Message = "您这边有联系方式么电话";
                }}
        );

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

    @Override
    public void retMessagefollowDos(MessagefollowDosBean bean) { }

    @Override
    public void retMessageupDos(MessageupDosBean bean) { }

    @Override
    public void retMessageCommentDos(MessagecommentDosBean bean) { }

    @Override
    public void retMessagenewDos(MessagenewDosBean bean) { }

    @Override
    public void retMessagehConcern(ReleaseBean bean) { }

    static class User {
        int avatarId;
        boolean isMe;
    }

    static class Message {
        Date Time;
        User User;
        int Image;
        String Message;

    }

    class MessageAdapter<T> extends BaseRecyclerAdapter<Message> {

        DynamicTimeFormat format = new DynamicTimeFormat();

        public MessageAdapter(Collection<Message> messages, int layoutId) {
            super(messages, R.layout.item_practice_instant);
        }

        @Override
        protected void onBindViewHolder(SmartViewHolder holder, Message message, int index) {
            onItemBindingTime(holder, message, index);
            if (message.User == null) {
                onItemBindingSystem(holder, message);
            } else if (message.User.isMe) {
                onItemBindingMine(holder, message);
            } else {
                onItemBindingOther(holder, message);
            }

        }


        /**
         * 展示对方的消息
         */
        private void onItemBindingOther(SmartViewHolder holder, Message message) {
            holder.gone(R.id.chatting_right);
            holder.gone(R.id.chatting_tv_sysmsg);
            holder.visible(R.id.chatting_left);
            holder.image(R.id.chatting_liv_avatar, message.User.avatarId);

            if (message.Image == 0) {
                holder.gone(R.id.chatting_liv_img);
                holder.text(R.id.chatting_ltv_txt, message.Message).visible(R.id.chatting_ltv_txt);
            } else {
                holder.gone(R.id.chatting_ltv_txt);
                holder.image(R.id.chatting_liv_img, message.Image).visible(R.id.chatting_liv_img);
            }
        }


        /**
         * 展示自己的消息
         *
         * @param holder
         * @param message
         */
        private void onItemBindingMine(SmartViewHolder holder, Message message) {
            holder.gone(R.id.chatting_left);
            holder.gone(R.id.chatting_tv_sysmsg);
            holder.visible(R.id.chatting_right);

            holder.image(R.id.chatting_riv_avatar, message.User.avatarId);

            if (message.Image == 0) {
                holder.gone(R.id.chatting_riv_img);
                holder.text(R.id.chatting_rtv_txt, message.Message).visible(R.id.chatting_rtv_txt);
            } else {
                holder.gone(R.id.chatting_rtv_txt);
                holder.image(R.id.chatting_riv_img, message.Image).visible(R.id.chatting_riv_img);
            }
        }

        /**
         * 展示系统消息
         */
        private void onItemBindingSystem(SmartViewHolder holder, Message message) {
            holder.gone(R.id.chatting_left);
            holder.gone(R.id.chatting_right);
            holder.gone(R.id.chatting_tv_sendtime);
            holder.visible(R.id.chatting_tv_sysmsg).text(R.id.chatting_tv_sysmsg, message.Message);

        }

        /**
         * 展示时间
         */
        private void onItemBindingTime(SmartViewHolder holder, Message model, int index) {
            Message prev = null;
            if (index > 0) {
                prev = get(index - 1);
                if (prev.User == null) {
                    if (index > 1) {
                        prev = get(index - 2);
                    } else {
                        prev = null;
                    }
                }
            }
            if (prev != null && (model.Time.getTime() - prev.Time.getTime() < 5 * 60 * 1000)) {
                holder.gone(R.id.chatting_tv_sendtime);
            } else {
                holder.visible(R.id.chatting_tv_sendtime);
                holder.text(R.id.chatting_tv_sendtime, format.format(model.Time));
            }
        }
    }
}
