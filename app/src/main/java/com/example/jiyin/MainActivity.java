package com.example.jiyin;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.activity.JiYingFragment;
import com.example.myapplication.R;

public class MainActivity<v,HomePresenterImpl> extends JiYingActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView viewById = findViewById(R.id.text_btn);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("NOTIFY_USER_TABLE");
        registerReceiver(receiver, intentFilter);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("NOTIFY_USER_TABLE");
                sendBroadcast(intent);
            }
        });


//        new BeanNetUnit<>()
//        .setCall(HomeCallManager.getHomeCall("","")).request(new NetBeanListener<>(){
//            @Override
//            public void onLoadStart() {
//            }
//            @Override
//            public void onLoadFinished() {
//            }
//            @Override
//            public void onNetErr() {
//            }
//            @Override
//            public void onSysErr(int httpCode, String msg) {
//            }
//            @Override
//            public void onSuc(Object bean) {
//            }
//            @Override
//            public void onFail(String status, String message) {
//            }
//        });
//


    }

    @Override
    public void setFunctionForFragment(String tag) {

    }

    @Override
    protected void createPresenter() {

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("NOTIFY_USER_TABLE")) {
                Log.d("AGE", "shoudao");
            }
        }
    };

    @Override
    public void toggleSoftInput() {

    }

    @Override
    public void toast(int id) {

    }

    @Override
    public void toastLong(CharSequence c) {

    }

    @Override
    public void toastLong(int id) {

    }

    @Override
    public boolean checkLogin() {
        return false;
    }

    @Override
    public boolean checkLogin(int requestCode) {
        return false;
    }

    @Override
    public void hideExpectionPages() {

    }
}



//class HomeCallManager {
//    public static Call getHomeCall(String city,String activityId){
//        RequestModelBean requestModelBean = new RequestModelBean();
//        requestModelBean.putMap("","");
//
//        return HttpManager.getInstance().req(homeService.class).getHomeData(requestModelBean.getFinalRequestMap());
//    }

//}

//interface homeService{
//    @POST("index")
//    @FormUrlEncoded
//    retrofit2.Call<BaseResponseModel<RequestModelBean>> getHomeData(@FieldMap Map<String, String> map);
//
//}




