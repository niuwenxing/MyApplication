package com.example.jiyin.interactive;


import com.example.jiyin.common.net.manager.HttpManager;

import retrofit2.Call;

/**
 * 网络访问句柄管理
 */

public class UserCallManager {

    public static Call getRegister(String phone, String code, String psd) {
        JiYingRequestModel params = new JiYingRequestModel();
        params.putMap("tel",phone);
        params.putMap("code",code);
        params.putMap("pass",psd);
        params.putMap("password",psd);
        return HttpManager.getInstance().req(UserService.class).register(params.getFinalRequestMap());
    }

    public static Call getCode(String phone) {
        JiYingRequestModel params = new JiYingRequestModel();
        params.putMap("tel",phone);
        return HttpManager.getInstance().req(UserService.class).getcode(params.getFinalRequestMap());
    }

    public static Call getUserRetrieve(String phone, String code, String psd) {
        JiYingRequestModel params = new JiYingRequestModel();
        params.putMap("tel",phone);
        params.putMap("code",code);
        params.putMap("pass",psd);
        params.putMap("password",psd);

        return HttpManager.getInstance().req(UserService.class).getUserRetrieve(params.getFinalRequestMap());
    }

    /**
     * 登录
     * @param phone
     * @param psd
     * @return
     */
    public static Call getlogin(String phone, String psd) {
        JiYingRequestModel params = new JiYingRequestModel();
        params.putMap("tel",phone);
        params.putMap("pass",psd);
        return HttpManager.getInstance().req(UserService.class).getlogin(params.getFinalRequestMap());
    }



  /*  public static Call getRegister(){
        JiYingRequestModel params = new JiYingRequestModel();
        params
    }*/


}
