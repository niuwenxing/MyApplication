package com.example.jiyin.interactive;

import com.example.jiyin.common.net.beas.BaseResponseModel;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.homeview.base.LoginData;
import com.example.jiyin.home.Activity.homeview.base.RegisterBase;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Call 类
 */

public interface UserService {

    /**
     * 登录
     */
    @POST("Auth/regCode")
    @FormUrlEncoded
    Call<BaseResponseModel<RegisterBase>> register(@FieldMap Map<String, String> map);


    /**
     * 获取验证码
     * @param finalRequestMap
     * @return
     */
    @POST("Auth/send")
    @FormUrlEncoded
    Call<BaseResponseModel<CodeBase>> getcode(@FieldMap Map<String, String> finalRequestMap);


    /**
     * 忘记密码
     * @param finalRequestMap
     * @return
     */
    @POST("Auth/modifyPass")
    @FormUrlEncoded
    Call<BaseResponseModel<CodeBase>> getUserRetrieve(@FieldMap Map<String, String> finalRequestMap);

    /**
     * 登陆
     * @param finalRequestMap
     * @return
     */

    @POST("Auth/loginCode")
    @FormUrlEncoded
    Call<BaseResponseModel<LoginData>> getlogin(@FieldMap Map<String, String> finalRequestMap);

}
