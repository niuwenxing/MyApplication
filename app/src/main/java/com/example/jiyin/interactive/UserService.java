package com.example.jiyin.interactive;

import androidx.annotation.NonNull;

import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.homeview.base.ImageArr;
import com.example.jiyin.home.Activity.homeview.base.ImageBase;
import com.example.jiyin.home.Activity.homeview.base.LoginData;
import com.example.jiyin.home.Activity.homeview.base.RegisterBase;
import com.example.jiyin.home.Activity.homeview.base.ReleaseBean;
import com.example.jiyin.home.Activity.sonview.activity.WorkSurfaceActivity;
import com.example.jiyin.home.Activity.sonview.base.OfflineTrainingBean;
import com.example.jiyin.home.Activity.sonview.base.StudyAgencyIndexBean;
import com.example.jiyin.home.Activity.sonview.base.UnderDetailBean;
import com.example.jiyin.home.Activity.sonview.base.WorkDetailsBase;
import com.example.jiyin.home.Activity.sonview.base.WorkProjectbase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopLabelBase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopMainBase;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Call 类
 */

public interface UserService {

    /**
     * 登录
     */
    @POST("Auth/regCode")
    @FormUrlEncoded
    Call<RegisterBase> register(@FieldMap Map<String, String> map);

    /**
     * 获取验证码
     * @param finalRequestMap
     * @return
     */
    @POST("Auth/send")
    @FormUrlEncoded
    Call<CodeBase> getcode(@FieldMap Map<String, String> finalRequestMap);


    /**
     * 忘记密码
     * @param finalRequestMap
     * @return
     */
    @POST("Auth/modifyPass")
    @FormUrlEncoded
    Call<CodeBase> getUserRetrieve(@FieldMap Map<String, String> finalRequestMap);

    /**
     * 登陆
     * @param finalRequestMap
     * @return
     */

    @POST("Auth/loginCode")
    @FormUrlEncoded
    Call<LoginData> getlogin(@FieldMap Map<String, String> finalRequestMap);


    /**
     * 圈子标签
     * @return
     */
    @POST("Index/circlesLable")
    Call<CirclelabelBean> circle();


    /**
     * 上传一视频
     * @return
     */
    @Multipart
    @POST("Common/uploadImg")
    Call<ImageBase> Upimage(@Part List<MultipartBody.Part> parts);


    /**
     * 发布圈子
     * @param finalRequestMap
     * @param picturelist
     * @return
     */
    @POST("User/circlesRelease")
    @FormUrlEncoded
    Call<ReleaseBean> getUpRelease(@FieldMap Map<String, String> finalRequestMap,@Field("picture[]") List<String> picturelist);


    /**
     * 圈子
     * @param params
     * @return
     */
    @POST("User/circle")
    @FormUrlEncoded
    Call<CircleListBean> circleList(@FieldMap HashMap<String, String> params);


    /**
     * 工作坊标签
     * @return
     */
    @POST("Workshop/ification")
    Call<WorkshopLabelBase> getWorkroomtable();


    /**
     * 工作坊首页数据
     * @param params
     * @return
     */
    @POST("Workshop/index")
    @FormUrlEncoded
    Call<WorkshopMainBase> getWorkshopMainData(@FieldMap HashMap<String, String> params);


    /**
     * 工作坊详情数据
     * @param params
     * @return
     */
    @POST("Workshop/detail")
    @FormUrlEncoded
    Call<WorkDetailsBase> getFotmat(@FieldMap HashMap<String, String> params);


    /**
     * 工作坊 申请提交
     * @param params
     * @return
     */
    @POST("Workshop/enroll")
    @FormUrlEncoded
    Call<WorkSurfaceActivity.breakCode> getWorkShenQing(@FieldMap HashMap<String, String> params);


    /**
     * 工作坊  项目类型
     * @param params
     * @return
     */
    @POST("Workshop/workProject")
    @FormUrlEncoded
    Call<WorkProjectbase> getStudioLabel(@FieldMap  HashMap<String, String> params);


    /**
     * 研习社 首页数据
     * @param params
     * @return
     */
    @POST("Agency/index")
    @FormUrlEncoded
    Call<StudyAgencyIndexBean> getIndexData(@FieldMap HashMap<String, String> params);


    /**
     * 研习社 线下培训
     *
     * @return
     */
    @POST("Agency/under")
    Call<OfflineTrainingBean> getOfflineTraining();


    @POST("Agency/underDetail")
    @FormUrlEncoded
    Call<String> getUnderDetail(@FieldMap HashMap<String, String> params);
}

