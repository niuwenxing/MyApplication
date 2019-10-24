package com.example.jiyin.home.fragment;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.TextView;

import com.example.jiyin.common.activity.JiYingFragment;
import com.example.jiyin.home.fragment.view.HomeView;
import com.example.jiyin.home.presenter.Impl.HomePresenterImpl;
import com.example.myapplication.R;

import butterknife.BindView;

public class NewHomeFregment extends JiYingFragment<HomeView, HomePresenterImpl> implements HomeView {

    public static final String NOSAK = NewHomeFregment.class.getName();


    TextView tvHomeTitle;
    private View layoutFragment;

    @Override
    protected int attachLayoutRes() {
        return R.layout.homefragment_layout;
    }


    @Override
    protected void init() {
        layoutFragment = getLayoutFragment();
        tvHomeTitle = layoutFragment.findViewById(R.id.tv_homeTitle);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tvHomeTitle.getText());
        spannableStringBuilder.setSpan(new TypefaceSpan("PingFangSC-Semibold"),0,tvHomeTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.white)),0,tvHomeTitle.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvHomeTitle.setText(spannableStringBuilder);
    }






    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new HomePresenterImpl();
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
}
