package com.example.jiyin.home.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.common.widget.SlideRecyclerView;
import com.example.jiyin.home.Activity.sonview.activity.ChatActivity;
import com.example.jiyin.home.fragment.adapter.SlideRecyAdapter;
import com.example.jiyin.home.presenter.Impl.NewsPreImpl;
import com.example.jiyin.home.presenter.view.NewsView;
import com.example.jiyin.interactive.ContactsActivity;
import com.example.rootlib.utils.StatusBarUtil;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 消息
 */

public class NewsFragment extends JiYingFragment<NewsView, NewsPreImpl> implements NewsView {
    @BindView(R.id.img_contacts_btn)
    ImageView imgContactsBtn;
    @BindView(R.id.newtbar)
    RelativeLayout newtbar;
    @BindView(R.id.imageNews)
    ImageView imageNews;
    @BindView(R.id.rl_NewsFans_btn)
    RelativeLayout rlNewsFansBtn;
    @BindView(R.id.imageNewsFabulous)
    ImageView imageNewsFabulous;
    @BindView(R.id.rl_NewsFabulous_btn)
    RelativeLayout rlNewsFabulousBtn;
    @BindView(R.id.imagecomment)
    ImageView imagecomment;
    @BindView(R.id.rl_Newscomment_btn)
    RelativeLayout rlNewscommentBtn;
    @BindView(R.id.imageOfficial)
    ImageView imageOfficial;
    @BindView(R.id.rl_NewsJiYingOfficial_btn)
    RelativeLayout rlNewsJiYingOfficialBtn;
    @BindView(R.id.oneview)
    LinearLayout oneview;
    @BindView(R.id.status_bar_view)
    View view;
    @BindView(R.id.ry_Chatlist)
    SlideRecyclerView ryChatlist;

    @Override
    protected int attachLayoutRes() {
        return R.layout.newsfragment_layout;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new NewsPreImpl();
    }

    @Override
    protected void init() {

        Log.i("jian","asbfojsabofhbosahfbjhabpfjaspfb");

        ImmersionBar.setStatusBarView(this, view);
        ryChatlist.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        List<Integer> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }

        SlideRecyAdapter<Integer> slideRecyAdapter = new SlideRecyAdapter(activity, objects);
        ryChatlist.setAdapter(slideRecyAdapter);
        ryChatlist.setNestedScrollingEnabled(false);
        slideRecyAdapter.setOnDeleteClickListener(new SlideRecyAdapter.OnDeleteClickLister() {
            @Override
            public void onDeleteClick(View view, int position) {
                objects.remove(position);
                slideRecyAdapter.notifyDataSetChanged();
                ryChatlist.closeMenu();
            }
        });
        slideRecyAdapter.setOnClickListener(new SlideRecyAdapter.OnClickLister() {
            @Override
            public void onClick(View view, int position) {
                startActivity(new Intent(getContext(), ChatActivity.class));
            }
        });

//        InventoryAdapter.OnDeleteClickLister() {
//            @Override
//            public void onDeleteClick(View view, int position) {
//                mInventories.remove(position);
//                mInventoryAdapter.notifyDataSetChanged();
//                recycler_view_list.closeMenu();
//            }
//        }
    }

    @Override
    public void onReload() {//重载

    }

    @Override
    public void onLoadFinished() {

    }

    @Override
    public void onLoadAll() {

    }


    @OnClick({R.id.img_contacts_btn, R.id.rl_NewsFans_btn, R.id.rl_NewsFabulous_btn, R.id.rl_Newscomment_btn, R.id.rl_NewsJiYingOfficial_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_contacts_btn:
                startActivity(new Intent(getContext(), ContactsActivity.class));
                break;
            case R.id.rl_NewsFans_btn:
                break;
            case R.id.rl_NewsFabulous_btn:
                break;
            case R.id.rl_Newscomment_btn:
                break;
            case R.id.rl_NewsJiYingOfficial_btn:
                break;
        }
    }
}
