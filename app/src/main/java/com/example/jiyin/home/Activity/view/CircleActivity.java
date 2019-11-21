package com.example.jiyin.home.Activity.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.adapter.AbsRecycleAdapter;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.UserCallManager;
import com.example.rootlib.mvp.view.IBaseView;
import com.example.rootlib.widget.common.ThrowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 圈子标签列表
 */
public class CircleActivity extends JiYingActivity implements IBaseView {

    @BindView(R.id.finsh_btn)
    ImageView finshBtn;
    @BindView(R.id.carType_list)
    RecyclerView carType_list;

    private BrandAdapter carTypeAdapter;

    private String ification_title=null;
    private int ification_id=0x012;
    private Intent intent;
    private CirclelabelBean data =new CirclelabelBean();


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_circle;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        intent = new Intent();
        getCircle();//获取数据
        carType_list.setNestedScrollingEnabled(false);
        carType_list.setLayoutManager(new GridLayoutManager(this, 1));
        carTypeAdapter = new BrandAdapter();
        carType_list.setHasFixedSize(true);
        carTypeAdapter.setChoiceMode(AbsRecycleAdapter.CHOICE_MODE_SINGLE);

        carType_list.setAdapter(carTypeAdapter);
        carTypeAdapter.setOnItemClickListener(new AbsRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                intent.putExtra("id",data.getData().get(position).getIfication_id());
                intent.putExtra("title",data.getData().get(position).getIfication_title());
                setResult(00056,intent);
                finish();

            }
        });

    }

    @OnClick(R.id.finsh_btn)
    public void onViewClicked() {
        setResult(00056,intent);
        finish();
    }

    //适配器
    public class BrandAdapter  extends AbsRecycleAdapter<CirclelabelBean.DataBean> {
        @Override
        public int getLayoutId(int viewType) {
            return R.layout.cartypebutton_ltem;
        }
        @Override
        public void convert(VH holder, CirclelabelBean.DataBean data, int position) {
            holder.setText(R.id.tv_titleStr,data.getIfication_title());
            holder.setViewShow(R.id.img_isched,data.isChecked());
        }
    }



    /**
     * 获取圈子标签
     */
    public void getCircle(){

        BeanNetUnit loginUnit=new BeanNetUnit<CirclelabelBean>()
                .setCall(UserCallManager.getCircle())
                .request(new NetBeanListener<CirclelabelBean>() {
                    @Override
                        public void onSuc(CirclelabelBean bean) {
                            if(bean.getData()!=null){
                                carTypeAdapter.setData(bean.getData());
                                data=bean;
                                carTypeAdapter.notifyDataSetChanged();
                            }
                        }


                    @Override
                    public void onFail(int status, String message) {
                        showSysErrLayout(message, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getCircle();
                            }
                        });
                    }

                    @Override
                    public void onLoadStart() {
                        showProgress();
                    }

                    @Override
                    public void onLoadFinished() {
                        hideProgress();
                    }

                    @Override
                    public void onNetErr() {
                        showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getCircle();
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        showSysErrLayout("msg", new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                getCircle();
                            }
                        });
                    }
                });
    }
}
