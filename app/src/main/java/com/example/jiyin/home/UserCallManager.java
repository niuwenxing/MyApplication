package com.example.jiyin.home;




import com.example.jiyin.common.net.manager.HttpManager;
import com.example.jiyin.interactive.UserService;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.PreferenceUtil;
import com.example.rootlib.utils.CollectionUtil;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by guolei on 2017/11/24.
 * 网络访问句柄管理
 */

public class UserCallManager {


    private static MultipartBody.Part body;

    /**
     * 登陆
     * @param phone
     * @param psd
     * @return
     */
    public static Call getlogin(String phone, String psd) {
        HashMap<String, String> map=new  HashMap<>();
        map.put("tel",phone);
        map.put("pass",psd);

        return HttpManager.getInstance().rep(UserService.class).getlogin(map);
    }

    /**
     * 忘记密码
     * @param phone
     * @param code
     * @param psd
     * @return
     */
    public static Call getRetrieve(String phone, String code, String psd) {
        HashMap<String, String> map=new  HashMap<>();
        map.put("tel",phone);
        map.put("code",psd);
        map.put("pass",psd);
        map.put("password",psd);

        return HttpManager.getInstance().rep(UserService.class).getUserRetrieve(map);
    }

    /**
     * 获取验证码
     * @param phone
     * @return
     */
    public static Call getCodedata(String phone) {
        HashMap<String, String> map=new  HashMap<>();
        map.put("tel",phone);
        return HttpManager.getInstance().rep(UserService.class).getcode(map);
    }

    /**
     * 注册
     * @param phone
     * @param code
     * @param psd
     * @return
     */
    public static Call getRegister(String phone, String code, String psd) {
        HashMap<String, String> map=new  HashMap<>();
        map.put("tel",phone);
        map.put("code",code);
        map.put("pass",psd);
        map.put("password",psd);

        return HttpManager.getInstance().rep(UserService.class).register(map);
    }

    /**
     * 圈子标签
     * @return
     */
    public static Call getCircle() {

        return HttpManager.getInstance().rep(UserService.class).circle();
    }

    /**
     * 上传视频
     * @return//        Map<String, RequestBody> params = new HashMap<>();
     */
    public static Call upimages(List<LocalMedia> selectList) {
        Map<String, Object> map = new HashMap<>();
        for (LocalMedia localMedia : selectList) {
            map.put("image",localMedia.getPath());
        }
        List<MultipartBody.Part> parts = generateFilesform(map);
        return HttpManager.getInstance().rep(UserService.class).Upimage(parts);
    }

    public static List<MultipartBody.Part> generateFilesform(Map<String, Object> map) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("image","文件路径");
//        map.put("image1","文件路径1");
//        map.put("image2","文件路径2");

//        Logger.e(TAG, "#表单构造#" + map + "\n");
        List<MultipartBody.Part> forms = new ArrayList<MultipartBody.Part>();
//        Logger.e("http", "=========文件表单开始=========");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            File file = new File(value.toString());
            if (file != null && file.length() > 0) {
                RequestBody requestBody = RequestBody.create( MediaType.parse("application/octet-stream"), file);
                MultipartBody.Part part = MultipartBody.Part.createFormData(key, file.getName(), requestBody);
                forms.add(part);
            } else {
                MultipartBody.Part part = MultipartBody.Part.createFormData(key, value + "");
                forms.add(part);
            }
//            Logger.e(TAG, "[" + key + "]=[" + value + "]\n");
        }
//        Logger.e("http", "=========文件表单结束=========");
        return forms;

    }

    /**
     * 发布圈子
     * @param circle_title Upimage
     * @param ification_id
     * @param circle_type
     * @param data
     * @return
     */
    public static Call uprelease(String circle_title, int ification_id, int circle_type, List<String> data) {
        HashMap<String, String> params=new  HashMap<>();
        params.put("token", PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,""));
        params.put("circle_title",circle_title);
        params.put("ification_id",String.valueOf(ification_id));
        params.put("circle_type",String.valueOf(circle_type));

        if (circle_type==1) {
            if (!CollectionUtil.isEmpty(data)) {
                params.put("path",data.get(0).toString());
                data.clear();
            }
        }

        return HttpManager.getInstance().rep(UserService.class).getUpRelease(params,data);
    }

//    /**
//     * 发布圈子视频
//     * @param circle_title
//     * @param ification_id
//     * @param circle_type
//     * @param data
//     * @return
//     */
//    public static Call upreleaseVoide(String circle_title, int ification_id, int circle_type, String data) {
//        HashMap<String, String> params=new  HashMap<>();
//        params.put("token", PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,""));
//        params.put("circle_title",circle_title);
//        params.put("ification_id",String.valueOf(ification_id));
//        params.put("circle_type",String.valueOf(circle_type));
//        params.put("path",data);
//        List<String> dataa=new ArrayList<>();
//        return HttpManager.getInstance().rep(UserService.class).getUpRelease(params,dataa);
//    }

    /**
     * 圈子列表
     * @param pages
     * @param mType
     * @return
     */
    public static Call getcircleList(int pages, int mType) {
        HashMap<String, String> params=new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,""));
        params.put("page",String.valueOf(pages));
        params.put("ification_id",String.valueOf(mType));
        return HttpManager.getInstance().rep(UserService.class).circleList(params);
    }

    /**
     * <p>
     *     获取工作坊标签
     * </p>
     * @return
     */
    public static Call getWorkroom() {
        return HttpManager.getInstance().rep(UserService.class).getWorkroomtable();
    }


    /**
     * <p>获取工作坊首页数据</p>
     * @param pages
     * @param ification_id
     * @return
     */
    public static Call getWorkshopMainCall(int pages, int ification_id) {
        HashMap<String, String> params=new HashMap<>();
        params.put("page",String.valueOf(pages));
        params.put("ification_id",String.valueOf(ification_id));

        return HttpManager.getInstance().rep(UserService.class).getWorkshopMainData(params);
    }

    public static Call getWorkShenQing(int workId, String etTeamnameEditStr, String etYourschoolEditStr,
                                       String etTeamsizeEditStr, String etEstablishTimeEditStr,
                                       String etProjectTypeEditStr,String isregistereds, String etTeamleaderEditStr,
                                       String etTelephoneEditStr, String etWorkMailboxEditStr,
                                       String etPersonalEditStr) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,""));
        params.put("work_id",String.valueOf(workId));
        params.put("team_name",etTeamnameEditStr);
        params.put("school",etYourschoolEditStr);
        params.put("people_num",etTeamsizeEditStr);
        params.put("establish_time",etEstablishTimeEditStr);
        params.put("project_type",etProjectTypeEditStr);
        params.put("is_reg",isregistereds);
        params.put("team_people",etTeamleaderEditStr);
        params.put("tel",etTelephoneEditStr);
        params.put("email",etWorkMailboxEditStr);
        params.put("text",etPersonalEditStr);

        return HttpManager.getInstance().rep(UserService.class).getWorkShenQing(params);
    }


    //工作坊 项目类型
    public static Call getStudioLabel(int workId) {

        HashMap<String, String> params = new HashMap<>();
        params.put("work_id",String.valueOf(workId));
        return HttpManager.getInstance().rep(UserService.class).getStudioLabel(params);
    }


    /**
     * 研习社 首页数据
     * @param page
     * @return
     */
    public static Call getIndex (int page) {
        HashMap<String, String> params = new HashMap<>();
        params.put("page",String.valueOf(page));
        return HttpManager.getInstance().rep(UserService.class).getIndexData(params);
    }

    /**
     * 获取线下培训
     * @param page
     * @return
     */
    public static Call getOfflineTraining(int page) {
        return HttpManager.getInstance().rep(UserService.class).getOfflineTraining();
    }

    /**
     * 获取线下培训详情
     * @return
     */
    public static Call getUnderDetail(int under_id) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,""));
        params.put("under_id",String.valueOf(under_id));

        return HttpManager.getInstance().rep(UserService.class).getUnderDetail(params);
    }


    private void uploadImages(List<LocalMedia> list){
        //String str = "http://app.quanquanerapp.com/api/Common/uploadMultiPic";
//        String str = BaseConfig.ROOT_SERVER_API+"Common/uploadMultiPic";
//        imagePaths.clear();
//        for(LocalMedia path:list)
//        {
//            imagePaths.add(path.getPath());
//        }
//        MultipartBody.Builder builder = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM);
//        for (int i = 0; i < imagePaths.size(); i++) {
//            builder.addPart(
//                    Headers.of("Content-Disposition", "form-data; name=\"image[]\"; filename=\"" + i + ".png\""),
//                    RequestBody.create(MEDIA_TYPE_PNG, new File(imagePaths.get(i))));
//        }
//        final MultipartBody requestBody = builder.build();
//        final Request request = new Request.Builder()
//                .url(str)
//                .post(requestBody)
//                .build();
//        OkHttpClient mOkHttpClient = new OkHttpClient();
//        mOkHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
//            @Override
//            public void onFailure(okhttp3.Call call, IOException e) {
//                Log.e("","1231313123123123");
//            }
//            @Override
//            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
//                if(response.isSuccessful()) {
//                    String json = response.body().string();
//                    Log.e("成功",json);
//                }
//            }
//        });
    }


    /**
     * 工作坊详细信息
     * @param workshop_id
     * @return
     */
    public static Call getFormation(int workshop_id) {
        HashMap<String, String> params=new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,""));
        params.put("work_id",String.valueOf(workshop_id));

        return HttpManager.getInstance().rep(UserService.class).getFotmat(params);
    }

}