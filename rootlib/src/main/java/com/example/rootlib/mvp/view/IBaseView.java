package com.example.rootlib.mvp.view;

import android.content.DialogInterface;
import android.content.Intent;

import com.example.rootlib.widget.common.ThrowLayout;

public interface IBaseView {

    /**
     * 切换输入法键盘是否打开
     */
    void toggleSoftInput();

    /**
     * 显示loading框
     */
    void showProgress();

    /**
     * 隐藏loading框
     */
    void hideProgress();

    /**
     * toast提示
     */
    void toast(CharSequence c);

    /**
     * toast提示
     */
    void toast(int id);

    /**
     * toast提示
     */
    void toastLong(CharSequence c);

    /**
     * toast提示
     */
    void toastLong(int id);

    /**
     * 返回
     */
    void baseFinish();

    /**
     * 返回
     */
    void baseFinish(int resultCode);

    /**
     * 返回
     */
    void baseFinish(int resultCode, Intent data);

    /**
     * 调节背景透明度
     */
//    void backgroundAlpha(float bgAlpha);

    /**
     * 显示空数据布局
     */
    void showNullMessageLayout(ThrowLayout.OnRetryListener listener);

    /**
     * 显示网络异常布局
     * @param listener
     */
    void showNetErrorLayout(ThrowLayout.OnRetryListener listener);


    /**
     * 显示系统异常布局
     * @param errMsg
     * @param listener
     */
    void showSysErrLayout(String errMsg,ThrowLayout.OnRetryListener listener);


    /**
     * 显示对话框网络异常布局
     * @param positiveOnClickListener
     * @param nagetiveOnClickListener
     */
//    void dialogShowNetError(DialogInterface.OnClickListener positiveOnClickListener, DialogInterface.OnClickListener nagetiveOnClickListener);

    /**
     * 显示对话框系统异常布局
     * @param errMsg
     * @param positiveOnClickListener
     * @param nagetiveOnClickListener
     */
//    void dialogShowSystemError(String errMsg,DialogInterface.OnClickListener positiveOnClickListener,DialogInterface.OnClickListener nagetiveOnClickListener);

    /**
     * 使用对话框显示通知
     *
     * @param title   标题
     * @param content 通知内容
     * @param btnTxt 按钮文本
     */
//    void dialogShowMessage(int resId,String title, String content, String btnTxt);

    /**
     * 使用对话框显示通知
     *
     * @param title    标题
     * @param content  通知内容
     * @param btnTxt   按钮文本
     * @param positionId 文本位置
     */
//    void dialogShowMessage(int resId,String title, String content, String btnTxt, int positionId);

    /**
     * 使用对话框显示通知
     *
     * @param titleId    标题
     * @param msgId      通知内容
     * @param btnTextId  按钮文本
     * @param positionId 文本位置
     * @param canCancel  屏蔽back键
     * @param canTouchOutside  点击dialog外部是否消失
     */
//    void dialogShowMessage(int resId,String titleId, String msgId, String btnTextId, int positionId,
//                           DialogInterface.OnClickListener positiveOnClickListener,
//                           boolean canCancel, boolean canTouchOutside);

    /**
     * 使用对话框显示提醒，需要点击确定或取消选择
     * @param resId                   图片资源，小于0时不显示
     * @param title                   标题
     * @param msg                     提醒内容
     * @param positiveText            取消按钮文本
     * @param cancelText              确定按钮文本
     * @param positiveOnClickListener 确定按钮监听器
     * @param cancelOnClickListener   取消按钮监听器
     */
//    CommonNoticeDialog dialogShowRemind(int resId,String title, String msg,
//                                        String positiveText, String cancelText,
//                                        DialogInterface.OnClickListener positiveOnClickListener,
//                                        DialogInterface.OnClickListener cancelOnClickListener);

    /**
     * 使用对话框显示提醒，需要点击确定或取消选择
     * @param resId                   图片资源，小于0时不显示
     * @param title                   标题
     * @param msg                     提醒内容
     * @param positiveText            取消按钮文本
     * @param cancelText              确定按钮文本
     * @param positiveOnClickListener 确定按钮监听器
     * @param cancelOnClickListener   取消按钮监听器
     * @param positionId              文本位置
     * @param canCancel               点击返回键是否消失
     * @param canTouchOutside         点击外围和返回键是否消息
     * @return CommonNoticeDialog
     */
//    CommonNoticeDialog dialogShowRemind(int resId,String title, String msg,
//                                        String positiveText, String cancelText,
//                                        DialogInterface.OnClickListener positiveOnClickListener,
//                                        DialogInterface.OnClickListener cancelOnClickListener,
//                                        int positionId, boolean canCancel, boolean canTouchOutside);

    /**
     * 检验登录，未登录跳转登录
     * @return 返回是否登录
     */
    boolean checkLogin();


    /**
     * 检验登录，未登录跳转登录
     * @param requestCode 是否要求返回值
     * @return 返回是否登录
     */
    boolean checkLogin(int requestCode);
    /**
     * 隐藏所有的异常布局
     * -空数据
     * -系统异常
     * -网络异常
     */
    void hideExpectionPages();
}
