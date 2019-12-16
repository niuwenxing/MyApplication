package com.example.rootlib.utils;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;

import com.example.rootlib.config.AppConfig;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gray on 2018/04/24.
 * 字符串工具类
 */
public class StringUtil {

    /**
     * 字符判空  null | "" | "null"
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (TextUtils.isEmpty(str) || "null".equals(str) || "".equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取非空字符串，
     *
     * @param str
     * @return str | ""
     */
    public static String getNotNullStr(String str) {
        return isEmpty(str) ? "" : str;
    }

    /**
     * base64加密
     */
    public static String encodeBase64(byte[] val) {
        if(val==null)
            return null;
        else
            return Base64.encode(val);
    }

    /**
     * base64加密
     */
    public static byte[] decodeBase64(String val) {
        if(val==null)
            return null;
        else
            return Base64.decode(val);
    }

    /**
     * 从url解析param的map集合
     *
     * @return
     */
    public static Map<String, String> getURLParamsMap(String url) {
        if (isEmpty(url)) { //为空返回
            return null;
        } else {              //处理
            try {
                Map<String, String> map = new HashMap<>();
                url = getDecodedStr(url);
                //截参数部分 -- key1=value1&key2=value2&……
                String paramStr = url.substring((url.indexOf("?") + 1), url.length());
                //拆分键值数组 -- [key1=value,key2=value2,……]
                String[] paramArr = paramStr.split("&");

                //封装map集合
                if (paramArr != null && paramArr.length > 0) {
                    for (int i = 0; i < paramArr.length; i++) {
                        map.put(paramArr[i].split("=")[0], paramArr[i].split("=").length > 1 ? paramArr[i].split("=")[1] : "");
                    }
                }
                return map;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /**
     * 获取URL转义的字符串
     *
     * @param str
     * @return
     */
    public static String getDecodedStr(String str) {
        if (isEmpty(str)) {
            return str;
        }
        //截取字符
        try {
            return Html.fromHtml(URLDecoder.decode(str, "UTF-8")).toString();
        } catch (UnsupportedEncodingException e) {
            if (AppConfig.DEVELOP_DEBUG_MODE) {
                e.printStackTrace();
            }
            return str;
        }
    }

    /**
     * 预判字符串添加后是否超出大小
     *
     * @param curr   现有
     * @param newStr 准备添加
     * @param total  目标大小
     * @return
     */
    public static boolean willOverLimit(String curr, String newStr, int total) {
        //默认参数
        total = total <= 0 ? 1 : total;
        curr = StringUtil.isEmpty(curr) ? "" : curr;
        newStr = StringUtil.isEmpty(curr) ? "" : newStr;

        if (curr.length() > total) {                    //当前已经超出
            return true;
        } else if ((curr.length() + newStr.length()) > total) {
            return true;
        } else {                                        //当前暂未超出
            return false;
        }
    }

    /**
     * 按照指定长度缩略字符串
     *
     * @param str
     * @param length
     * @return
     */
    public static String getShorterStr(String str, int length) {
        if (isEmpty(str) || length <= 0 || length > str.length()) {
            return str;
        }
        //截取字符
        return str.substring(0, length) + "…";
    }



}
