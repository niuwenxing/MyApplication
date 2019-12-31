package com.example.jiyin.home;




import android.text.Html;

import com.example.jiyin.common.config.BaseConfig;
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
        map.put("code",code);
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
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
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
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
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
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("under_id",String.valueOf(under_id));

        return HttpManager.getInstance().rep(UserService.class).getUnderDetail(params);
    }

    /**
     * 获取Top视频列表
     * @param pages
     * @param ificationId
     * @param name
     * @return
     */
    public static Call getVideoindex(int pages, int ificationId, String name) {
        HashMap<String, String> params = new HashMap<>();
        params.put("page",String.valueOf(pages));
        params.put("ification_id",String.valueOf(ificationId));
        params.put("name",String.valueOf(name));

        return HttpManager.getInstance().rep(UserService.class).getVideoindex(params);
    }

    /**
     * 获取首页数据
     * @return
     */
    public static Call getIndexindex() {
        return HttpManager.getInstance().rep(UserService.class).getIndexindex();
    }


    /**
     *
     * @param page
     * @return
     */
    public static Call getScreationIndex(int page) {
        HashMap<String, String> params = new HashMap<>();
        params.put("page",String.valueOf(page));

        return HttpManager.getInstance().rep(UserService.class).getScreation(params);
    }

    /**
     *
     * @param creationId
     * @return
     */
    public static Call getScreation(int creationId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("creation_id",String.valueOf(creationId));
        return HttpManager.getInstance().rep(UserService.class).getScreationDetails(params);
    }

    /**
     * 造物集 申请
     * @param creationId
     * @param toString
     * @param toString1
     * @param toString2
     * @param toString3
     * @param toString4
     * @param isregistereds
     * @param toString5
     * @param toString6
     * @param toString7
     * @param s
     * @return
     */
    public static Call getScreationEnrolls(int creationId, String toString, String toString1, String toString2, String toString3, String toString4, String isregistereds, String toString5, String toString6, String toString7, String s) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("creation_id",String.valueOf(creationId));
        params.put("tname",toString);
        params.put("pnum",toString1);
        params.put("ctime",toString2);
        params.put("ptype",toString3);
        params.put("school",toString4);
        params.put("is_reg",isregistereds);
        params.put("tpeople",toString5);
        params.put("tel",toString6);
        params.put("email",toString7);
        params.put("tcontent",s);



        return HttpManager.getInstance().rep(UserService.class).getScreationEnrolls(params);
    }

    /**
     * 职呼 首页
     * @param page
     * @param gificationId
     * @param xificationId
     * @param zificationId
     * @return
     */
    public static Call getPositionIndexData(int page, int gificationId, int xificationId, int zificationId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("page",String.valueOf(page));
        params.put("gification_id",String.valueOf(gificationId));
        params.put("xification_id",String.valueOf(xificationId));
        params.put("zification_id",String.valueOf(zificationId));


        return HttpManager.getInstance().rep(UserService.class).getPositionIndex(params);
    }

    /**
     * 职呼筛选 菜单数据
     * @return
     */
    public static Call getPositionIfications() {

        return HttpManager.getInstance().rep(UserService.class).getPositionIfications();
    }

    /**
     * 详情
     * PositionDetailBean
     * @param positionId
     * @return
     */
    public static Call getPositionDetailData(int positionId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("position_id",String.valueOf(positionId));
        return HttpManager.getInstance().rep(UserService.class).getPositionDetail(params);
    }

    /**
     * 职呼 申请
     * @param positionId
     * @param toString
     * @param isGender_btn
     * @param toString1
     * @param toString2
     * @param toString3
     * @param toString4
     * @param toString5
     * @param toString6
     * @param toString7
     * @param toString8
     * @param toString9
     * @return
     */
    public static Call getPositionEnrollData(int positionId, String toString, String isGender_btn,
                                             String toString1, String toString2, String toString3,
                                             String toString4, String toString5, String toString6,
                                             String toString7, String toString8, String toString9) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("position_id",String.valueOf(positionId));
        params.put("name",toString);
        params.put("sex",isGender_btn);
        params.put("age",toString1);
        params.put("education",toString2);
        params.put("school",toString3);
        params.put("intention_duty",toString4);
        params.put("tel",toString5);
        params.put("email",toString6);
        params.put("id_card",toString7);
        params.put("resume",toString8);
        params.put("text",toString9);
        return HttpManager.getInstance().rep(UserService.class).getPositionEnroll(params);
    }

    /**
     *
     * @param page
     * @return
     */

    public static Call getZtimeIndex(int page) {
        HashMap<String, String> params = new HashMap<>();
        params.put("page",String.valueOf(page));

        return HttpManager.getInstance().rep(UserService.class).getZtimeIndex(params);
    }

    /**
     * 琢璞 时间详情
     * @param mZid
     * @return
     */
    public static Call getZtimedetail(int mZid) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("zid",String.valueOf(mZid));
        return HttpManager.getInstance().rep(UserService.class).getZtimedetail(params);
    }

    /**
     *  琢璞时间 申请
     * @param mZid
     * @param toString
     * @param toString1
     * @param toString2
     * @param toString3
     * @param toString4
     * @param toString5
     * @param toString6
     * @param trim
     * @param trim1
     * @param toString7
     * @param toString8
     * @param toString9
     * @param toString10
     * @return
     */
    public static Call getZtimeenroll(int mZid, String toString, String toString1, String toString2,
                                      String toString3, String toString4, String toString5,
                                      String toString6, String trim, String trim1, String toString7,
                                      String toString8, String toString9, String toString10) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("zid",String.valueOf(mZid));
        params.put("tname",toString);
        params.put("pnum",toString1);
        params.put("ctime",toString2);
        params.put("ptype",toString3);
        params.put("school",toString4);
        params.put("is_reg",toString5);
        params.put("tpeople",toString6);
        params.put("tel",trim);
        params.put("email",trim1);
        params.put("path",toString7);
        params.put("is_financing",toString8);
        params.put("tcontent",toString9);
        params.put("pcontent",toString10);

        return HttpManager.getInstance().rep(UserService.class).Ztimeenroll(params);
    }

    /**
     * top voide 详情
     * @param page
     * @param videoId
     * @return
     */
    public static Call getVideoDetail(int page, int videoId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("page",String.valueOf(page));
        params.put("video_id",String.valueOf(videoId));
        return HttpManager.getInstance().rep(UserService.class).getVideoDetail(params);
    }

    /**
     * 玑瑛出品列表
     * @param page
     * @param searchStr
     * @return
     */
    public static Call getProduceIndex(int page, String searchStr) {
        HashMap<String, String> params = new HashMap<>();
        params.put("page",String.valueOf(page));
        params.put("name",searchStr);

        return HttpManager.getInstance().rep(UserService.class).getProduceIndex(params);
    }

    /**
     * 玑瑛出品 详情
     * @param produceId
     * @return
     */
    public static Call getProduceDetail(int produceId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("produce_id",String.valueOf(produceId));
        return HttpManager.getInstance().rep(UserService.class).getProduceDetail(params);
    }

    /**
     * 头条 列表
     * @param page
     * @return
     */
    public static Call getNewIndex(int page) {
        HashMap<String, String> params = new HashMap<>();
        params.put("page",String.valueOf(page));


        return HttpManager.getInstance().rep(UserService.class).getNewIndex(params);
    }

    /**
     * 头条详情
     * @param page
     * @param newId
     * @return
     */
    public static Call getNewDetail(int page,int newId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("new_id",String.valueOf(newId));
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("page",String.valueOf(page));
        return HttpManager.getInstance().rep(UserService.class).getNewDetail(params);
    }

    /**
     * 项目列表
     * @param nameStr
     * @param page
     * @return
     */
    public static Call getClassifyDetail(String nameStr, int page) {
        HashMap<String, String> params = new HashMap<>();
        params.put("name",nameStr+"");
        params.put("page",String.valueOf(page));
        return HttpManager.getInstance().rep(UserService.class).getClassifyDetail(params);
    }

    /**
     * 项目详情
     * @param newId
     * @return
     */
    public static Call getClassifyDetailNew(int newId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("new_id",String.valueOf(newId));
        return HttpManager.getInstance().rep(UserService.class).getClassifyDetailNew(params);
    }

    /**
     * 红人
     * @return
     */
    public static Call getFounderfounder() {
        return HttpManager.getInstance().rep(UserService.class).getFounderfounder();
    }

    /**
     * 圈子点赞
     * @param circleid
     * @return
     */
    public static Call getUsercircleUp(int circleid) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("circle_id",String.valueOf(circleid));
        return HttpManager.getInstance().rep(UserService.class).getUsercircleUp(params);
    }

    /**
     * 圈子关注
     * @param follow_uid
     * @return
     */
    public static Call getUserfollow(int follow_uid) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("follow_uid",String.valueOf(follow_uid));

        return HttpManager.getInstance().rep(UserService.class).getUserfollow(params);

    }

    /**
     * 圈子分享
     * @param circle_id
     * @return
     */
    public static Call getUsercircleShare(int circle_id) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("circle_id",String.valueOf(circle_id));
        return HttpManager.getInstance().rep(UserService.class).getUsercircleShare(params);
    }

    /**
     * 圈子个人详情
     * @param circleid
     * @return
     */
    public static Call getUsercircleDetail(int circleid) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("circle_id",String.valueOf(circleid));
        return HttpManager.getInstance().rep(UserService.class).getUsercircleDetail(params);
    }


    /**
     * 圈子评论
     * @param circle_id
     * @param to_uId
     * @param fid
     * @param commentStr UserReplyBean
     * @return
     */
    public static Call getUserReply(int circle_id, int to_uId, int fid, String commentStr) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("circle_id",String.valueOf(circle_id));
        params.put("comment",commentStr);
        params.put("to_uid",String.valueOf(to_uId));
        params.put("fid",String.valueOf(fid));

        return HttpManager.getInstance().rep(UserService.class).getUserReply(params);
    }

    /**
     * 个人中心 数据
     * @return
     */
    public static Call getUserInfo() {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        return HttpManager.getInstance().rep(UserService.class).getUserInfo(params);
    }

    /**
     * 修改头像
     * @param s
     * @return
     */
    public static Call getUserAvatarEdit(String s) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("avatar",s);

        return HttpManager.getInstance().rep(UserService.class).getUserAvatarEdit(params);
    }

    /**
     * 修改昵称
     * @param name
     * @return
     */
    public static Call getUserReplyBean(String name) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("name",name);
        return HttpManager.getInstance().rep(UserService.class).getUserReplyBean(params);
    }

    /**
     * 设置手机号
     * @param phone
     * @param code
     * @return
     */
    public static Call getUserTelEdit(String phone, String code) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("tel",phone);
        params.put("code",code);

        return HttpManager.getInstance().rep(UserService.class).getUserTelEdit(params);
    }

    /**
     * 修改密码
     * @param oldPass
     * @param pass
     * @param password
     * @return
     */
    public static Call getUserPassEdit(String oldPass, String pass, String password) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("oldPass",oldPass);
        params.put("pass",pass);
        params.put("password",password);

        return HttpManager.getInstance().rep(UserService.class).getUserPassEdit(params);
    }

    /**
     * 申请记录
     * @return
     */
    public static Call getMineApplyDos() {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        return HttpManager.getInstance().rep(UserService.class).getMineApplyDos(params);
    }

    /**
     * 我的赞
     * @param page
     * @return
     */
    public static Call gettMinemyUp(int page) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("page",String.valueOf(page));
        return HttpManager.getInstance().rep(UserService.class).getMinemyUp(params);
    }

    /**
     * 我的发布 列表
     * @param page
     * @return
     */
    public static Call getMinemyUp(int page) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("page",String.valueOf(page));
        return HttpManager.getInstance().rep(UserService.class).getMinEmyUp(params);
    }

    /**
     * 圈子删除
     * @param circle_id
     * @return
     */
    public static Call getUserCircleDel(int circle_id) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("id",String.valueOf(circle_id));
        return HttpManager.getInstance().rep(UserService.class).getUserCircleDel(params);
    }

    /**
     * 红人更多
     * @param page
     * @param nameStr
     * @return
     */
    public static Call getFounderList(int page, String nameStr) {
        HashMap<String, String> params = new HashMap<>();
        params.put("page",String.valueOf(page));
        params.put("name",nameStr);
        return HttpManager.getInstance().rep(UserService.class).getFounderList(params);
    }

    /**
     * 研习社 视频详情
     * @param page
     * @param videoId
     * @return
     */
    public static Call getAgencydetail(int page, int videoId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("online_id",String.valueOf(videoId));
        params.put("page",String.valueOf(page));
        return HttpManager.getInstance().rep(UserService.class).getAgencydetail(params);
    }

    /**
     * 头条详情评论
     * @param newId
     * @param toString
     * @return
     */
    public static Call getNewdetail(int newId, String toString) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("new_id",String.valueOf(newId));
        params.put("stories_text",String.valueOf(toString));
        return HttpManager.getInstance().rep(UserService.class).getNewdetail(params);
    }

    /**
     * 粉丝列表
     * @return
     */
    public static Call getMessagefollowDos() {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        return HttpManager.getInstance().rep(UserService.class).getMessagefollowDos(params);
    }

    /**
     * 粉丝列表
     * @return
     */
    public static Call getMessageupDos() {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        return HttpManager.getInstance().rep(UserService.class).getMessageupDos(params);
    }

    /**
     * 评论列表
     * @return
     */
    public static Call getMessageCommentDos() {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        return HttpManager.getInstance().rep(UserService.class).getMessageCommentDos(params);
    }

    /**
     * 官网列表
     * @return
     */
    public static Call getMessagenewDos() {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        return HttpManager.getInstance().rep(UserService.class).getMessagenewDos(params);
    }

    /**
     * 消息 粉丝回关
     * @param follow_uid
     * @return
     */
    public static Call getMessagehConcern(int follow_uid) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("follow_id",String.valueOf(follow_uid));
        return HttpManager.getInstance().rep(UserService.class).getMessagehConcern(params);
    }

    /**
     * 社区首页数据 列表
     * @param name
     * @param page
     * @return
     */
    public static Call getCommunityindex(String name, int page) {
        HashMap<String, String> params = new HashMap<>();
        params.put("name",name);
        params.put("page",String.valueOf(page));

        return HttpManager.getInstance().rep(UserService.class).getCommunityindex(params);
    }

    public static Call getMinecircle(int circleId) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("uid",String.valueOf(circleId));
        return HttpManager.getInstance().rep(UserService.class).getMinecircle(params);
    }

    /**
     * 线下培训报名
     * @param under_id1
     * @param under_money
     * @return
     */
    public static Call getAgencyenroll(int under_id1, int under_money) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("under_id",String.valueOf(under_id1));
        params.put("enroll_money",String.valueOf(under_money));
        return HttpManager.getInstance().rep(UserService.class).getAgencyenroll(params);
    }

    /**
     * 线上课堂 详情评论
     * @param online_id
     * @param trim
     * @return
     */
    public static Call getAgencycomment(int online_id, String trim) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("online_id",String.valueOf(online_id));
        params.put("stories_text",trim);

        return HttpManager.getInstance().rep(UserService.class).getAgencycomment(params);
    }

    /**
     * 线上课堂点赞
     * @param id
     * @return
     */
    public static Call getAgencyUp(String id) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("stories_id",String.valueOf(id));

        return HttpManager.getInstance().rep(UserService.class).getAgencyUp(params);
    }

    /**
     * 视频点赞
     * @param video_id
     * @return
     */
    public static Call getVideovideoUp(int video_id) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("video_id",String.valueOf(video_id));
        return HttpManager.getInstance().rep(UserService.class).getVideovideoUp(params);
    }

    /**
     * 视频评论发表
     * @param video_id
     * @return
     */
    public static Call getVideocomment(int video_id,String comtext) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("stories_text",comtext);
        params.put("video_id",String.valueOf(video_id));
        return HttpManager.getInstance().rep(UserService.class).getVideocomment(params);
    }

    /**
     * 评论点赞
     * @param id
     * @return
     */
    public static Call getVideoup(String id) {
        HashMap<String, String> params = new HashMap<>();
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("stories_id",String.valueOf(id));

        return HttpManager.getInstance().rep(UserService.class).getVideoup(params);
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
        params.put("token",PreferenceUtil.getString(ConstantUtil.KEY_TOKEN,"00"));
        params.put("work_id",String.valueOf(workshop_id));

        return HttpManager.getInstance().rep(UserService.class).getFotmat(params);
    }

}