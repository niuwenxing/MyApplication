package com.example.jiyin.common.utils;


//import org.greenrobot.eventbus.EventBus;

import org.greenrobot.eventbus.EventBus;

/**
 * @version 1.0
 */

public class EventBusUtil {

    /**
     * token过时
     */
    public static final int EVENT_TOKEN_INVALIDATE = 0x3001;
    /**
     * 退出app
     */
    public static final int EVENT_EXIT_APP = 0x3002;
    /**
     * 退出登录
     */
    public static final int EVENT_EXIT_LOGIN = 0x3003;
    /**
     * 定位成功
     */
    public static final int EVENT_NEW_LOCATION = 0x3004;
    /**
     * 有新版本的app
     */
    public static final int EVENT_HAS_NEW_VERSION = 0x3005;
    /**
     * 刷新消息通知
     */
    public static final int EVENT_MESSAGE_UNREAD_FRESH = 0x4001;
    /**
     * 加载城市列表完成
     */
    public static final int EVENT_MESSAGE_CITYS_FINISH = 0x4002;
    /**
     * 重新加载城市列表
     */
    public static final int EVENT_MESSAGE_CITYS_REFRESH = 0x4003;
    /**
     * 更新用户信息
     */
    public static final int EVENT_USER_INFO_FRESH = 0x4004;
    /**
     * 更新商品价格高低信息
     */
    public static final int EVENT_SHOP_LIST_FRESH = 0x4005;
    /**
     * 更新个人中心信息
     */
    public static final int EVENT_PERSON_CENTER = 0x4006;
    /**
     * 选中首页tab
     */
    public static final int EVENT_HOME_TAB_SEL = 0x4007;

    /**
     * 更新商品订单列表
     */
    public static final int EVENT_SHOP_ORDER_LIST_FRESH = 0x4008;

    /**
     * 更新预约订单中心列表
     */
    public static final int EVENT_ORDER_CENTER_LIST_FRESH = 0x4009;


    /**
     * 优惠卷刷新
     */
    public static final int EVENT_MINE_YOUHUIJUAN = 0x40010;

    /**
     * 关注通知页面统一刷新
     */
    public static final int EVENT_MINE_GUANZHU = 0x40011;

    /**
     * 更新购物车页面
     */
    public static final int EVENT_MINE_GOODSCAR = 0x40012;

    /**
     * 更新个人主页动态信息
     */
    public static final int EVENT_PERSON_MAIN = 0x40013;


    /**
     * 更新教练课程管理页面信息
     */
    public static final int EVENT_COACH_WORK_MAIN = 0x40014;

    /**
     * 更新余额页面， 关闭充值页面
     */
    public static final int EVENT_CHANGE_BANLANCE = 0x40015;

    /**
     * ；刷新直播发布后状态数据
     */
    public static final int EVENT_REFRESH_LIVE = 0x40018;

    /**
     * 更新球队详情信息
     */
    public static final int EVENT_REFRESH_TEAM_DETAIL = 0x40019;

    /**
     * 球队首页刷新
     */
    public static final int EVENT_REFRESH_TEAM_HOME = 0x40020;

    /**
     * 球队编辑个人信息刷新
     */
    public static final int EVENT_REFRESH_TEAM_PERSONINFO = 0x40021;

    /**
     * 更新是否设置密码
     */
    public static final int EVENT_CHANGE_ISTEAMSETTING = 0x40022;

    /**
     * 优惠券更新
     */
    public static final int EVENT_CHANGE_ISYOUHUIJUAN = 0x40023;
    /**
     * 获取推送，通知首页刷新数据
     */
    public static final int EVENT_ACTIVE_BORADCAST = 0x40024;

    /**
     * 登录
     */
    public static final int EVENT_LOGIN = 0x40025;

    /**
     * 注册
     *
     * @param context
     */
    public static void register(Object context) {
        if (!EventBus.getDefault().isRegistered(context)) {
            EventBus.getDefault().register(context);
        }
    }

    /**
     * 接触注册
     *
     * @param context
     */
    public static void unregister(Object context) {
        if (EventBus.getDefault().isRegistered(context)) {
            EventBus.getDefault().unregister(context);
        }
    }

    /**
     * 发送消息
     *
     * @param object
     */
    public static void post(Object object) {
        EventBus.getDefault().post(object);
    }

    /**
     * 发送粘性消息
     *
     * @param object
     */
    public static void postSticky(Object object) {
        EventBus.getDefault().postSticky(object);
    }

    /**
     * 删除粘性消息
     *
     * @param object
     */
    public static void removeSticky(Object object) {
        EventBus.getDefault().removeStickyEvent(object);
    }
}
