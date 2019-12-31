package com.example.jiyin.home.Activity.sonview.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.widget.detail.CommentExpandableListView;
import com.example.jiyin.home.Activity.sonview.base.NewIndexBean;
import com.example.jiyin.home.Activity.sonview.base.NewdetailBean;
import com.example.jiyin.home.Activity.sonview.base.Toutiao;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.Activity.sonview.sonimpl.HeadlinesImpl;
import com.example.jiyin.home.Activity.sonview.sonview.HeadlinesView;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.utils.StringUtil;
import com.example.rootlib.widget.common.ThrowLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 头条详情页
 */

public class HeadlinesDetailsActivity extends JiYingActivity<HeadlinesView, HeadlinesImpl> implements HeadlinesView {

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
    @BindView(R.id.webviewwhity)
    WebView webviewwhity;
    @BindView(R.id.expandableListView)
    CommentExpandableListView expandableListView;
    @BindView(R.id.tv_comment_btn)
    TextView tvCommentBtn;
    @BindView(R.id.cb_headlineCheck_btn)
    TextView cbHeadlineCheckBtn;

    private int page;
    private int newId;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_headlines_details;
    }

    public static void startheadActivity(Context context, int new_id) {
        context.startActivity(new Intent(context, HeadlinesDetailsActivity.class)
                .putExtra(ConstantUtil.KEY_CODE, new_id)
        );
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new HeadlinesImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchView.setVisibility(View.GONE);
        searechNewsBtn.setVisibility(View.INVISIBLE);
        tvSearchTextTitle.setVisibility(View.VISIBLE);
        tvSearchTextTitle.setText("详情");
        newId = getIntent().getIntExtra(ConstantUtil.KEY_CODE, BaseConfig.SERVER_ERR_LOGIN_OBSOLETE);

        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getNewDetail(page, newId);


    }

    private void initView() {

    }

    @Override
    public void retNewIndex(NewIndexBean bean) {
    } //废弃

    /**
     * 头条详情 数据返回
     *
     * @param bean
     */
    @Override
    public void retNewDetail(NewdetailBean bean) {
        if (bean.getCode() == -1) {
            toast(bean.getMsg());
            return;
        }
        tvSearchTextTitle.setText(bean.getData().getNew_title());


    }

    @Override
    public void retNewdetails(Toutiao bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
            return;
        }else {
            toast(bean.getMsg());
        }

    }

    @OnClick({R.id.gobank_btn, R.id.searech_news_btn,R.id.tv_comment_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gobank_btn:
                finish();
                break;
            case R.id.searech_news_btn:
                break;
            case R.id.tv_comment_btn:
                showSendcommentOn(newId);
                break;
        }
    }

    /**
     * 评论
     */
    private Dialog dialog;
    private EditText etComment;
    private void showSendcommentOn(int newId) {
        if(dialog!=null){
            dialog.show();
            show(etComment);
        }else{
            dialog = new Dialog(this,R.style.ActionQuanZiDialogStyle);
            View view = LayoutInflater.from(this).inflate(R.layout.sendcomment,null);
            dialog.setContentView(view);
            etComment = view.findViewById(R.id.et_comment);
            view.findViewById(R.id.send_comment_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!StringUtil.isEmpty(etComment.getText().toString().trim())) {
                        // TODO: 2019/12/29 头条评论
//                        presenter.getNewdetail(newId,etComment.getText().toString());
                    }else{
                        Toast.makeText(activity, "请填写评论内容", Toast.LENGTH_SHORT).show();
                    }
                }
            });
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
            show(etComment);

        }



    }
    //文本弹起输入框
    public void show(final View view){
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.requestFocus();
                InputMethodManager manager = ((InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE));
                if (manager != null) manager.showSoftInput(view, 0);
            }
        }, 100);
    }
}
