package com.example.jiyin.home;



import com.example.jiyin.common.net.manager.HttpManager;
import com.example.jiyin.interactive.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

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
//        Map<String, RequestBody> params = new HashMap<>();
//        List<MultipartBody.Part> parts = new ArrayList<>();
//        Map<String, Object> map = new HashMap<>();
//        for (LocalMedia imgStr : selectList) {
//            File file = new File(imgStr.getPath());
//            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//            facePart = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
//            parts.add(facePart);
//            params.put("image", RequestBody.create(MediaType.parse("text/plain"), "image"));
//            map.put("image",imgStr.getPath());
//            params.put("image\";filename=\""+file.getName(),requestFile);
//        }
//
//        List<MultipartBody.Part> parts = generateFilesform(map);

//        return HttpManager.getInstance().rep(UserService.class).getimgarr(params);
        Map<String, RequestBody> params = new HashMap<>();
        List<MultipartBody.Part>   parts = new ArrayList<>();
        for (LocalMedia imgStr : selectList) {
            File file = new File(imgStr.getPath());
//            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);
            facePart = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
            parts.add(facePart);

        }
        RequestBody i = RequestBody.create(MediaType.parse("multipart/form-data"), "image");
//        params.put("image\"; filename=\""+file.getName(),i);

        return HttpManager.getInstance().rep(UserService.class).getimgarr(params,parts);
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
}