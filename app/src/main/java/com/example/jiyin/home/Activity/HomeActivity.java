package com.example.jiyin.home.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.presenter.impl.MainPresenterImpl;
import com.example.jiyin.home.Activity.presenter.view.MainView;
import com.example.jiyin.home.fragment.MoreWindow;
import com.example.jiyin.home.fragment.MypageFragment;
import com.example.jiyin.home.fragment.NewHomeFregment;
import com.example.jiyin.home.fragment.NewsFragment;
import com.example.jiyin.home.fragment.Publishpage;
import com.example.jiyin.home.fragment.WorkshopFragment;
import com.gyf.immersionbar.ImmersionBar;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p>
 *     主页页面
 * </p>
 */

public class HomeActivity extends JiYingActivity<MainView, MainPresenterImpl> implements MainView, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.vp_main)
    FrameLayout vpMain;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    private Fragment currentFragment = new Fragment();

    private NewHomeFregment newHomeFregment = new NewHomeFregment() ;
    private WorkshopFragment workshopFragment =new WorkshopFragment() ;
    private NewsFragment newsFragment =new NewsFragment();
    private MypageFragment mypageFragment =new MypageFragment();
    private Publishpage publishpage = new Publishpage();

    private Fragment[]  fragments1;
    private static RadioButton[] RadioButtons;
    private MoreWindow mMoreWindow;
    private View viewById;
    private MoreWindow popWindow;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        ImmersionBar.with(this).navigationBarColor(R.color.colorMenu).init();
        initFragment();


    }

    private void initFragment() {

        fragments1  = new Fragment[]{newHomeFregment, workshopFragment,publishpage, newsFragment,mypageFragment};
        rgMain.setOnCheckedChangeListener(this);
        RadioButtons = new RadioButton[fragments1.length];
        for (int i = 0; i < RadioButtons.length; i++) {
            RadioButtons[i] = (RadioButton) rgMain.getChildAt(i);
        }
        RadioButtons[0].setChecked(true);
        MoreWindow moreWindow = new MoreWindow(this);
        viewById = findViewById(R.id.fabu);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moreWindow.showMoreWindow(v);
            }
        });
    }

    int anInt=0;
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < RadioButtons.length; i++) {
            if (checkedId == RadioButtons[i].getId()) {
                if(i!=2){
                    anInt=i;
                    switchFragment(fragments1[i]).commit();
                }
                switch (i){
                    case 1:
                    case 2:
                    case 3:
                        statusBarhight();
                    break;
                    case 0:
                    case 4:
                        statusBarhightfalse();
                        break;

                }

//
            }
        }
        RadioButtons[anInt].setChecked(true);
    }

    private FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.vp_main, targetFragment, targetFragment.getClass().getName());
        } else {
            if (currentFragment != targetFragment) {
                transaction.hide(currentFragment).show(targetFragment);
            }
        }
        currentFragment = targetFragment;
        return transaction;
    }

    private void statusBarhightfalse() {
        ImmersionBar.with(this).navigationBarColor(R.color.colorMenu).init();
    }
    private void statusBarhight() {
        ImmersionBar.with(this).keyboardEnable(false).statusBarDarkFont(true, 0.2f).navigationBarColor(R.color.colorMenu).init();
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
//                case PictureConfig.CHOOSE_REQUEST:
//                    selectList = PictureSelector.obtainMultipleResult(data);

            }
        }

    }



    @Override
    protected void createPresenter() {
        presenter = new MainPresenterImpl();
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_home;
    }

    /**
     * 接口回调
     *
     * @param tag
     */
    public void setFunctionForFragment(String tag) { }

    public static void statusBarHide(Activity activity) {
        // 代表 5.0 及.以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            return;
        }
        // versionCode > 4.4  and versionCode < 5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}


