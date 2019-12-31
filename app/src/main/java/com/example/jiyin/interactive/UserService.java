package com.example.jiyin.interactive;


import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.homeview.base.ImageBase;
import com.example.jiyin.home.Activity.homeview.base.LoginData;
import com.example.jiyin.home.Activity.homeview.base.RegisterBase;
import com.example.jiyin.home.Activity.homeview.base.ReleaseBean;
import com.example.jiyin.home.Activity.homeview.base.UserCircleUpBean;
import com.example.jiyin.home.Activity.sonview.activity.WorkSurfaceActivity;
import com.example.jiyin.home.Activity.sonview.base.AgencyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.AuthregCodeBean;
import com.example.jiyin.home.Activity.sonview.base.ClassifyDetailBean;
import com.example.jiyin.home.Activity.sonview.base.ClassifyIndexBean;
import com.example.jiyin.home.Activity.sonview.base.CommunityindexBean;
import com.example.jiyin.home.Activity.sonview.base.FounderListBean;
import com.example.jiyin.home.Activity.sonview.base.FounderfounderBean;
import com.example.jiyin.home.Activity.sonview.base.IndexindexBean;
import com.example.jiyin.home.Activity.sonview.base.MessagecommentDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessagefollowDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessagenewDosBean;
import com.example.jiyin.home.Activity.sonview.base.MessageupDosBean;
import com.example.jiyin.home.Activity.sonview.base.MineAplyDosBean;
import com.example.jiyin.home.Activity.sonview.base.MinecircleBean;
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
import com.example.jiyin.home.Activity.sonview.base.Toutiao;
import com.example.jiyin.home.Activity.sonview.base.UnderDetailBean;
import com.example.jiyin.home.Activity.sonview.base.UserInfoBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.Activity.sonview.base.UsercircleDetailBean;
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
    Call<AuthregCodeBean> register(@FieldMap Map<String, String> map);

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

    /**
     * 圈子点赞
     * @param params
     * @return
     */
    @POST("User/circleUp")
    @FormUrlEncoded
    Call<UserCircleUpBean> getUsercircleUp(@FieldMap HashMap<String, String> params);

    /**
     * 圈子关注
     * @param params
     * @return
     */
    @POST("User/follow")
    @FormUrlEncoded
    Call<UserCircleUpBean> getUserfollow(@FieldMap  HashMap<String, String> params);

    /**
     * 圈子分享
     * @param params
     * @return
     */
    @POST("User/circleShare")
    @FormUrlEncoded
    Call<UserCircleUpBean> getUsercircleShare(@FieldMap  HashMap<String, String> params);

    /**
     * 圈子个人详情
     * @param params
     * @return
     */
    @POST("Mine/circleDetail")
    @FormUrlEncoded
    Call<UsercircleDetailBean> getUsercircleDetail(@FieldMap HashMap<String, String> params);

    /**
     * 圈子详情评论
     * @param params
     * @return
     */
    @POST("User/reply")
    @FormUrlEncoded
    Call<UserReplyBean> getUserReply(@FieldMap HashMap<String, String> params);

    /**
     * 个人中心
     * @param params
     * @return
     */
    @POST("Mine/info")
    @FormUrlEncoded
    Call<UserInfoBean> getUserInfo(@FieldMap HashMap<String, String> params);

    /**
     * 修改头像
     * @param params
     * @return
     */
    @POST("User/avatarEdit")
    @FormUrlEncoded
    Call<UserReplyBean> getUserAvatarEdit(@FieldMap  HashMap<String, String> params);

    /**
     * 修改昵称
     * @param params
     * @return
     */
    @POST("User/nameEdit")
    @FormUrlEncoded
    Call<UserReplyBean> getUserReplyBean(@FieldMap HashMap<String, String> params);

    /**
     * 设置手机号
     * @param params
     * @return
     */
    @POST("User/telEdit")
    @FormUrlEncoded
    Call<UserReplyBean> getUserTelEdit(@FieldMap HashMap<String, String> params);

    /**
     * 修改密码
     * @param params
     * @return
     */
    @POST("User/passEdit")
    @FormUrlEncoded
    Call<UserReplyBean> getUserPassEdit(@FieldMap HashMap<String, String> params);

    /**
     * 申请记录
     * @param params
     * @return
     */
    @POST("Mine/applyDos")
    @FormUrlEncoded
    Call<MineAplyDosBean> getMineApplyDos(@FieldMap HashMap<String, String> params);

    /**
     * 我的赞
     * @param params
     * @return
     */

    @POST("Mine/myUp")
    @FormUrlEncoded
    Call<CircleListBean> getMinemyUp(@FieldMap HashMap<String, String> params);

    /**
     * 我的发布
     * @param params
     * @return
     */
    @POST("Mine/myRelease")
    @FormUrlEncoded
    Call<CircleListBean> getMinEmyUp(@FieldMap HashMap<String, String> params);

    /**
     * 我的发布删除
     * @param params
     * @return
     */
    @POST("User/circleDel")
    @FormUrlEncoded
    Call<UserReplyBean> getUserCircleDel(@FieldMap  HashMap<String, String> params);

    /**
     * 红人更多列表
     * @param params
     * @return
     */
    @POST("founder/founderList")
    @FormUrlEncoded
    Call<FounderListBean> getFounderList(@FieldMap HashMap<String, String> params);

    /**
     * 研习社视频详情
     * @param params
     * @return
     */
    @POST("Agency/detail")
    @FormUrlEncoded
    Call<AgencyDetailBean> getAgencydetail(@FieldMap HashMap<String, String> params);

    /**
     * 头条详情评论
     * @param params
     * @return
     */
    @POST("New/detail")
    @FormUrlEncoded
    Call<UserReplyBean> getNewdetail(@FieldMap HashMap<String, String> params);

    /**
     * 粉丝列表
     * @param params
     * @return
     */
    @POST("Message/followDos")
    @FormUrlEncoded
    Call<MessagefollowDosBean> getMessagefollowDos(@FieldMap  HashMap<String, String> params);


    /**
     * 点赞列表
     * @param params
     * @return
     */
    @POST("Message/upDos")
    @FormUrlEncoded
    Call<MessageupDosBean> getMessageupDos(@FieldMap HashMap<String, String> params);

    /**
     * 评论页面
     * @param params
     * @return
     */
    @POST("Message/commentDos")
    @FormUrlEncoded
    Call<MessagecommentDosBean> getMessageCommentDos(@FieldMap HashMap<String, String> params);


    /**
     * 官方列表
     * @param params
     * @return
     */
    @POST("Message/newDos")
    @FormUrlEncoded
    Call<MessagenewDosBean> getMessagenewDos(@FieldMap HashMap<String, String> params);

    /**
     * 消息回关
     * @param params
     * @return
     */
    @POST("Message/hConcern")
    @FormUrlEncoded
    Call<ReleaseBean> getMessagehConcern(@FieldMap HashMap<String, String> params);

    /**
     * 社区页面
     * @param params
     * @return
     */
    @POST("Community/index")
    @FormUrlEncoded
    Call<CommunityindexBean> getCommunityindex(@FieldMap HashMap<String, String> params);

    /**
     * 圈子个人详情
     * @param params
     * @return
     */
    @POST("Mine/circle")
    @FormUrlEncoded
    Call<MinecircleBean> getMinecircle(@FieldMap HashMap<String, String> params);

    /**
     * 线下培训 报名
     * @param params
     * @return
     */
    @POST("Mine/circle")
    @FormUrlEncoded
    Call<PositionEnrollBean> getAgencyenroll(@FieldMap HashMap<String, String> params);

    /**
     * 线上课堂 评论
     * @param params
     * @return
     */
    @POST("Agency/comment")
    @FormUrlEncoded
    Call<Toutiao> getAgencycomment(@FieldMap HashMap<String, String> params);


    /**
     * 线上课堂 点赞
     * @param params
     * @return
     */
    @POST("Agency/up")
    @FormUrlEncoded
    Call<Toutiao> getAgencyUp(@FieldMap HashMap<String, String> params);

    /**
     * top 视频点赞
     * @param params
     * @return
     */

    @POST("Video/videoUp")
    @FormUrlEncoded
    Call<Toutiao> getVideovideoUp(@FieldMap HashMap<String, String> params);

    /**
     * 视频评论
     * @param params
     * @return
     */
    @POST("Video/comment")
    @FormUrlEncoded
    Call<Toutiao> getVideocomment(@FieldMap HashMap<String, String> params);

    /**
     * 评论点赞
     * @param params
     * @return
     */
    @POST("Video/up")
    @FormUrlEncoded
    Call<Toutiao> getVideoup(@FieldMap  HashMap<String, String> params);
}

