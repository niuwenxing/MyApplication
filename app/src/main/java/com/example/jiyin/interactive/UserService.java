package com.example.jiyin.interactive;

import androidx.annotation.NonNull;

import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CirclelabelBean;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.homeview.base.ImageArr;
import com.example.jiyin.home.Activity.homeview.base.LoginData;
import com.example.jiyin.home.Activity.homeview.base.RegisterBase;
import com.example.jiyin.home.Activity.homeview.base.ReleaseBean;

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
     * 上传一张图片
     * @param part
     * @return
     */
    @Multipart
    @POST("Common/uploadImg")
    Call<String> Upimage(@Part MultipartBody.Part part);

    /**
     * 上传图片
     //     * @param map
     //     * @param parts
     * @return
     */

//    @POST("Common/uploadImg")
    @Multipart
    @POST("Common/uploadMultiPic")
    Call<ImageArr> getimgarr(@Part("image[]") List<MultipartBody.Part> parts);
//    Call<ImageArr> getimgarr(@PartMap Map<String, RequestBody> map);






//    @Multipart
//    @POST("{" + PATH + "}")
//    Observable<String> uploadFilesII(@Path(value = PATH, encoded = true) String path, @Part() List<MultipartBody.Part> parts);

    /**
     * 发布圈子
     * @param finalRequestMap
     * @param picturelist
     * @return
     */
    @POST("User/circlesRelease")
    @FormUrlEncoded
    Call<ReleaseBean> getUpRelease(@FieldMap Map<String, String> finalRequestMap,@Field("picture[]") List<String> picturelist);

    @POST("User/circle")
    @FormUrlEncoded
    Call<CircleListBean> circleList(@FieldMap HashMap<String, String> params);
}

