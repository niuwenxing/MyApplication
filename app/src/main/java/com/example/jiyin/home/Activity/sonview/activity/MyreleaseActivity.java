package com.example.jiyin.home.Activity.sonview.activity;


import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.homeview.base.UserCircleUpBean;
import com.example.jiyin.home.Activity.presenter.impl.WorkshopImpl;
import com.example.jiyin.home.Activity.presenter.view.WorkshopView;
import com.example.jiyin.home.Activity.sonview.adapter.MyreleaseAdapter;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.Activity.sonview.base.UsercircleDetailBean;
import com.example.jiyin.home.Activity.view.CirclePopWindow;
import com.example.jiyin.home.fragment.adapter.WorkShopASAdapter;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的发布
 */
public class MyreleaseActivity extends JiYingActivity<WorkshopView, WorkshopImpl> implements WorkshopView {

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
    @BindView(R.id.ry_myrelease_list)
    RecyclerView ryMyreleaseList;
    private int page=1;
    private List<CircleListBean.DataBean> data=new ArrayList<>();
    private MyreleaseAdapter myreleaseAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_myrelease;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new WorkshopImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setText("我的发布");

        myreleaseAdapter = new MyreleaseAdapter(data);
        ryMyreleaseList.setAdapter(myreleaseAdapter);

        presenter.getMinemyUp(page);

        myreleaseAdapter.setOnclick(new MyreleaseAdapter.Myguanzu() {
            @Override
            public void onclick(@NonNull int circle_id,View view) {
                showDiag(circle_id);
            }
        });



    }

    /**
     * 弹窗
     */
    private Dialog dialog;
    private void showDiag(int circle_id) {
        if (dialog == null) {
            dialog = new Dialog(this,R.style.ActionQuanZiDialogStyle);
            View view = LayoutInflater.from(this).inflate(R.layout.dialog_myrelease,null);
            view.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    delete(circle_id);
                }
            });
            view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.setContentView(view);
            //获取当前Activity所在的窗体
            Window dialogwindow = dialog.getWindow();
            if (dialogwindow == null) {
                return;
            }
            dialogwindow.setGravity(Gravity.BOTTOM);
            WindowManager.LayoutParams lp = dialogwindow.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialogwindow.setAttributes(lp);
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();
        }else{
            dialog.show();
        }

    }

    /**
     * 删除圈子
     */
    private void delete(int circle_id) {
        presenter.UserCircleDel(circle_id);
    }

    /**
     * 删除圈子返回
     * @param bean
     */
    @Override
    public void retUserCircleDel(UserReplyBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }else{
            toast(bean.getMsg());
            //删除圈子刷新列表
            presenter.getMinemyUp(page);
        }
    }

    @Override
    public void returnLabel(List<CirclelabelBean.DataBean> data) {
    }//废弃

    @Override
    public void ReturnCircle(CircleListBean bean) {
    }//废弃

    @Override
    public void retUsercircleUp(UserCircleUpBean bean, boolean zan) {
    }//废弃

    @Override
    public void retUserfollow(UserCircleUpBean bean) {
    }//废弃

    @Override
    public void retUsercircleShare(UserCircleUpBean bean) {
    }//废弃

    @Override
    public void retUsercircleDetail(UsercircleDetailBean bean) {
    }//废弃

    @Override
    public void retNetErr(String err) {
    }//废弃

    @Override
    public void retUserReply(UserReplyBean bean) {
    }//废弃

    /**
     * 我的发布
     * @param bean
     */
    @Override
    public void retMinemyUprelease(CircleListBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }
        data.clear();
        data.addAll(bean.getData());
        myreleaseAdapter.notifyDataSetChanged();
    }




    @OnClick({R.id.gobank_btn, R.id.searech_news_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn:

                break;
        }
    }
}
