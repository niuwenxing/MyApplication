package com.example.rootlib.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by gray on 16/8/31.
 * 集合工具类
 */
public class CollectionUtil {

    /**
     * 判断list是否为空
     *
     * @param data
     * @return
     */
    public static boolean isEmpty(List data) {
        return data == null || data.isEmpty();
    }

    /**
     * 判断map是否为空
     *
     * @param data
     * @return
     */
    public static boolean isEmpty(Map data) {
        return data == null || data.isEmpty();
    }

    /**
     * 判断set是否为空
     *
     * @param data
     * @return
     */
    public static boolean isEmpty(Set data) {
        return data == null || data.isEmpty();
    }

    /**
     * 数组判空
     *
     * @param arr
     * @return
     */
    public static boolean isEmpty(String[] arr) {
        return arr == null || arr.length == 0;
    }
}
