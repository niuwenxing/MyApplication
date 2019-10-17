package com.example.rootlib.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by penny on 2016/4/18.
 * 吐司工具类，
 */
public class CToast {

    static Toast toast;


    /**
     * 短时间显示Toast
     *
     * @param context 上下文，建议是Application
     * @param message 显示消息
     */
    //加载要出现的layout布局文件，转化成view
    public static void showShort(Context context, CharSequence message) {
        if (toast == null) {
            toast = new Toast(context);
        }
//        View view = LayoutInflater.from(context).inflate(
//                R.layout.view_toast, null);
//        TextView tv = view.findViewById(R.id.tv_toast);
//        tv.setText(message);
        TextView textView = new TextView(context);
        textView.setText(message);
        toast.setView(textView); //给toast设置view
        toast.setGravity(Gravity.CENTER, 0, 0); //给toast设置在父布局中要出现的位置
        toast.setDuration(Toast.LENGTH_SHORT); //
        toast.setDuration(Toast.LENGTH_SHORT);

        toast.show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context 上下文，建议是Application
     * @param message 显示消息
     */
    public static void showLong(Context context, CharSequence message) {
//        if (toast == null) {
//            toast = new Toast(context);
//        }
//        View view = LayoutInflater.from(context).inflate(
//                R.layout.view_toast, null);
//        TextView tv = view.findViewById(R.id.tv_toast);
//        tv.setText(message);
//        toast.setView(view); //给toast设置view
//        toast.setGravity(Gravity.CENTER, 0, 0); //给toast设置在父布局中要出现的位置
//        toast.setDuration(Toast.LENGTH_LONG);
//
//        toast.show();
        Toast.makeText(context, message.toString(), Toast.LENGTH_SHORT).show();

    }
}
