package com.example.jiyin.home;



import android.util.Log;

import com.example.jiyin.common.config.BaseConfig;
import com.example.jiyin.common.net.manager.HttpManager;
import com.example.jiyin.interactive.JiYingRequestModel;
import com.example.jiyin.interactive.UserService;
import com.example.jiyin.utils.ConstantUtil;
import com.example.jiyin.utils.PreferenceUtil;
import com.example.rootlib.utils.StringUtil;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * Created by guolei on 2017/11/24.
 * 网络访问句柄管理
 */

public class UserCallManager {

    private static MultipartBody.Part facePart;

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
     * 上传图片
     * @return//        Map<String, RequestBody> params = new HashMap<>();
     */
    public static Call upimages(List<LocalMedia> selectList) {
        Map<String, Object> map = new HashMap<>();
        for (LocalMedia imgStr : selectList) {
//            File file = new File(imgStr.getPath());
//            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//            facePart = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
//            parts.add(facePart);
//            params.put("image", RequestBody.create(MediaType.parse("text/plain"), "image"));
            map.put("image",imgStr.getPath());
//            params.put("image\";filename=\""+file.getName(),requestFile);
        }

        List<MultipartBody.Part> parts = generateFilesform(map);
//
        return HttpManager.getInstance().rep(UserService.class).getimgarr(parts);

        /****/
//        Map<String, RequestBody> params = new HashMap<>();
//        List<MultipartBody.Part>   parts = new ArrayList<>();
//        for (LocalMedia imgStr : selectList) {
//            File file = new File(imgStr.getPath());
//            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//            RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);
//            facePart = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
//            parts.add(facePart);
//
//            Log.i("tupian",""+ file.getPath());
//
//
//        }
//        RequestBody i = RequestBody.create(MediaType.parse("multipart/form-data"), "image");
//        params.put("image\"; filename=\""+file.getName(),i);

//        return HttpManager.getInstance().rep(UserService.class).getimgarr(params,parts);
//        List<MultipartBody.Part> photos = new ArrayList();

//        File file1 = new File("/storage/emulated/0/DCIM/Screenshots/Screenshot_2019_1117_183252.png");
//        File file2 = new File("/storage/emulated/0/DCIM/Screenshots/Screenshot_2019_1117_182916.png");
//        OkHttpClient client = new OkHttpClient.Builder()
//                .build();
//        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file1);
//        RequestBody requestBody1 = RequestBody.create(MediaType.parse("image/png"), file2);
//        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
//                .addFormDataPart("image", file1.getName(), requestBody)
//                .addFormDataPart("image", file2.getName(), requestBody1)
//                .build();
//        builder.addFormDataPart()
//        builder.addFormDataPart("image[]",null, requestBody);



//        Request request = new Request.Builder()
//                .url(BaseConfig.ROOT_SERVER_API + "Common/uploadMultiPic")
//                .post(builder.build())
//                .build();
//        okhttp3.Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(okhttp3.Call call, IOException e) {
//                Log.d("string",e.getMessage());
//            }
//
//            @Override
//            public void onResponse(okhttp3.Call call, Response response) throws IOException {
//                String string = response.body().string();
//                Log.d("string",string);
//            }
//        });


//        return null;
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
     * @param circle_title
     * @param ification_id
     * @param circle_type
     * @param data
     * @return
     */
    public static Call uprelease(String circle_title, int ification_id, int circle_type, String data) {
        HashMap<String, String> params=new  HashMap<>();
        params.put("token", PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,""));
        params.put("circle_title",circle_title);
        params.put("ification_id",String.valueOf(ification_id));
        params.put("circle_type",String.valueOf(circle_type));
        if (!StringUtil.isEmpty(data)) {
            params.put("path",data);
        }
        Log.d("网", "uprelease: "+params.toString());
        params.put("picture","");

        return HttpManager.getInstance().rep(UserService.class).getUpRelease(params);
    }

    public static Call getcircleList(int pages, int mType) {
        HashMap<String, String> params=new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,""));
        params.put("page",String.valueOf(pages));
        params.put("ification_id",String.valueOf(mType));
        return HttpManager.getInstance().rep(UserService.class).circleList(params);
    }
}