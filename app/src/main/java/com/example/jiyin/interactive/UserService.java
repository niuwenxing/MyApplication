package com.example.jiyin.interactive;


import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.homeview.base.ImageBase;
import com.example.jiyin.home.Activity.homeview.base.LoginData;
import com.example.jiyin.home.Activity.homeview.base.RegisterBase;
import com.example.jiyin.home.Activity.homeview.base.ReleaseBean;
import com.example.jiyin.home.Activity.sonview.activity.WorkSurfaceActivity;
import com.example.jiyin.home.Activity.sonview.base.ClassifyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.ClassifyIndexBean;
import com.example.jiyin.home.Activity.sonview.base.FounderfounderBean;
import com.example.jiyin.home.Activity.sonview.base.IndexindexBean;
import com.example.jiyin.home.Activity.sonview.base.NewIndexBean;
import com.example.jiyin.home.Activity.sonview.base.NewdetailBean;
import com.example.jiyin.home.Activity.sonview.base.OfflineTrainingBean;
import com.example.jiyin.home.Activity.sonview.base.PositionDetailBean;
import com.example.jiyin.home.Activity.sonview.base.PositionEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIficationBean;
import com.example.jiyin.home.Activity.sonview.base.PositionIndexBean;
import com.example.jiyin.home.Activity.sonview.base.ProduceDetailBean;
import com.example.jiyin.home.Activity.sonview.base.ProduceIndexBean;
import com.example.jiyin.home.Activity.sonview.base.ScreationBean;
import com.example.jiyin.home.Activity.sonview.base.ScreationBeans;
import com.example.jiyin.home.Activity.sonview.base.ScreationEnrollBean;
import com.example.jiyin.home.Activity.sonview.base.StudyAgencyIndexBean;
import com.example.jiyin.home.Activity.sonview.base.UnderDetailBean;
import com.example.jiyin.home.Activity.sonview.base.VideoDetailBean;
import com.example.jiyin.home.Activity.sonview.base.VideoindexBean;
import com.example.jiyin.home.Activity.sonview.base.WorkDetailsBase;
import com.example.jiyin.home.Activity.sonview.base.WorkProjectbase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopLabelBase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopMainBase;
import com.example.jiyin.home.Activity.sonview.base.ZtimeIndexBean;
import com.example.jiyin.home.Activity.sonview.base.ZtimedetailBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

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

    /**
     * 获取线下培训详情
     * @param params
     * @return
     */
    @POST("Agency/underDetail")
    @FormUrlEncoded
    Call<UnderDetailBean> getUnderDetail(@FieldMap HashMap<String, String> params);

    /**
     * 获取Top视频列表
     * @param params
     * @return
     */
    @POST("Video/index")
    @FormUrlEncoded
    Call<VideoindexBean> getVideoindex(@FieldMap HashMap<String, String> params);

    /**
     * 获取首页数据
     * @return
     */
    @POST("Index/index")
    Call<IndexindexBean> getIndexindex();

    /**
     * 造物季首页
     * @param params
     * @return
     */
    @POST("Screation/index")
    @FormUrlEncoded
    Call<ScreationBeans> getScreation(@FieldMap Map<String,String> params);


    /**
     * 造物集详情
     * @param params
     * @return
     */
    @POST("Screation/detail")
    @FormUrlEncoded
    Call<ScreationBean> getScreationDetails(@FieldMap  HashMap<String, String> params);


    /**
     * 造物集 申请
     * @param params
     * @return
     */
    @POST("Screation/enroll")
    @FormUrlEncoded
    Call<ScreationEnrollBean> getScreationEnrolls(@FieldMap  HashMap<String, String> params);


    /**
     * 职呼 首页
     * @param params
     * @return
     */
    @POST("position/index")
    @FormUrlEncoded
    Call<PositionIndexBean> getPositionIndex(@FieldMap  HashMap<String, String> params);

    /**
     * 职呼 筛选菜单
     * @return
     */
    @POST("position/ification")
    Call<PositionIficationBean> getPositionIfications();

    /**
     * 职呼 详情
     * @param params
     * @return
     */
    @POST("position/detail")
    @FormUrlEncoded
    Call<PositionDetailBean> getPositionDetail(@FieldMap  HashMap<String, String> params);

    /**
     * 职呼 申请
     * @param params
     * @return
     */
    @POST("position/enroll")
    @FormUrlEncoded
    Call<PositionEnrollBean> getPositionEnroll(@FieldMap HashMap<String, String> params);

    /**
     * 琢璞时间 首页
     * @param params
     * @return
     */
    @POST("Ztime/index")
    @FormUrlEncoded
    Call<ZtimeIndexBean> getZtimeIndex(@FieldMap  HashMap<String, String> params);

    /**
     * 琢璞时间 详情
     * @param params
     * @return
     */
    @POST("Ztime/detail")
    @FormUrlEncoded
    Call<ZtimedetailBean> getZtimedetail(@FieldMap  HashMap<String, String> params);

    /**
     * 琢璞时间 申请
     * @param params
     * @return
     */
    @POST("Ztime/enroll")
    @FormUrlEncoded
    Call<PositionEnrollBean> Ztimeenroll(@FieldMap HashMap<String, String> params);

    /**
     * top voide
     * @param params
     * @return
     */
    @POST("Video/detail")
    @FormUrlEncoded
    Call<VideoDetailBean> getVideoDetail(@FieldMap HashMap<String, String> params);

    /**
     *玑瑛出品 列表
     * @param params
     * @return
     */
    @POST("Produce/index")
    @FormUrlEncoded
    Call<ProduceIndexBean> getProduceIndex(@FieldMap HashMap<String, String> params);

    /**
     * 玑瑛出品详情
     * @param params
     * @return
     */
    @POST("Produce/detail")
    @FormUrlEncoded
    Call<ProduceDetailBean> getProduceDetail(@FieldMap HashMap<String, String> params);

    /**
     * 头条
     * @param params
     * @return
     */
    @POST("New/index")
    @FormUrlEncoded
    Call<NewIndexBean> getNewIndex(@FieldMap HashMap<String, String> params);

    /**
     * 头条详情
     * @param params
     * @return
     */
    @POST("New/detail")
    @FormUrlEncoded
    Call<NewdetailBean> getNewDetail(@FieldMap HashMap<String, String> params);

    /**
     * 项目列表
     * @param params
     * @return
     */
    @POST("Classify/index")
    @FormUrlEncoded
    Call<ClassifyIndexBean> getClassifyDetail(@FieldMap HashMap<String, String> params);

    /**
     * 项目详情
     * @param params
     * @return
     */
    @POST("Classify/detail")
    @FormUrlEncoded
    Call<ClassifyDetailBean> getClassifyDetailNew(@FieldMap HashMap<String, String> params);

    /**
     * 红人
     * @return
     */
    @POST("founder/founder")
    Call<FounderfounderBean> getFounderfounder();
}

