package com.example.rootlib.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by gray on 2016/7/18.
 */
public class JSONUtil {

    /**
     * 说明：将json字符串转换为对象，需要注意捕获异常
     * <p>
     *
     * @param str   被转换的json字符串
     * @param clazz 转换后的实体类类型
     * @return 转换后的实体类
     */
    public static <T> T jsonToObject(String str, Class<T> clazz) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }

        T t = null;
        try {
            t = JSON.parseObject(str, clazz);
        } catch (JSONException e) {
            LogUtils.e("解析json数据为对象时出错，json=" + str, e);
        }
        return t;
    }

    /**
     * 说明：将json字符串转换为对象，需要注意捕获异常
     *
     * @param str  被转换的json字符串
     * @param type 转换后的实体类类型
     * @return 转换后的实体类
     */
    public static <T> T jsonToObject(String str, Type type) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }

        T t = null;
        try {
            t = JSON.parseObject(str, type);
        } catch (JSONException e) {
            LogUtils.e("解析json数据为对象时出错，json=" + str, e);
        }
        return t;
    }

    /**
     * 说明：将json字符串转换为List对象，需要注意捕获异常
     *
     * @param str   被转换的json字符串
     * @param clazz 转换后的实体类类型
     * @return 转换后的实体类集合
     */
    public static <T> List<T> jsonToListObject(String str, Class<T> clazz) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        List<T> t = null;
        try {
            t = JSON.parseArray(str, clazz);
        } catch (JSONException e) {
            LogUtils.e("解析json数据为对象时出错，json=" + str, e);
        }
        return t;
    }


    /**
     * 说明：将一个对象转换成json格式的字符串
     *
     * @param obj 将要转成json格式字符串的实体类类型
     * @return json格式的字符串
     */
    public static String objectToJSON(Object obj) {
        if (obj == null) {
            return null;
        }
        return JSON.toJSONString(obj);
    }

    /**
     * 说明获取Json字符串中其中一个key的值
     *
     * @param strJson json字符串
     * @param key     json字符串中的某个key
     * @return json字符串中key对应的值
     */
    public static String getOneOfJsonValue(String strJson, String key) {
        if (strJson == null || key == null) {
            return null;
        }
        try {
            JSONObject jsonObject = JSON.parseObject(strJson);
            String value = (String) jsonObject.get(key);
            return value;
        } catch (JSONException e) {
            LogUtils.e("解析json数据为对象时出错，json=" + strJson, e);
        }
        return null;
    }
    /**
     * 说明获取Json字符串中其中一个key的值
     *
     * @param strJson json字符串
     * @param key     json字符串中的某个key
     * @return json字符串中key对应的值
     */
    public static boolean getOneOfJsBooleanValue(String strJson, String key) {
        if (strJson == null || key == null) {
            return false;
        }
        try {
            JSONObject jsonObject = JSON.parseObject(strJson);
            boolean value =(boolean) jsonObject.get(key);
            return value;
        } catch (JSONException e) {
            LogUtils.e("解析json数据为对象时出错，json=" + strJson, e);
        }
        return true;
    }
    /**
     *  对象转map
     * @param object
     * @return
     */
    public static Map<String, Object> object2Map(Object object){
        JSONObject jsonObject = (JSONObject) JSON.toJSON(object);
        Set<Map.Entry<String, Object>> entrySet = jsonObject.entrySet();
        Map<String, Object> map=new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : entrySet) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    //list去重
    public static <T> List<T> listUniqObj(List<T> list){

        if(list!= null && list.size()>0){
            for(int i=0;i<list.size();i++){
                //获取最后一个相同对象的序号
                int j = list.lastIndexOf(list.get(i));
                if(i!=j){
                    list.remove(j);
                    i--;
                }
            }
        }
        return list;
    }

    /**
     * 对象 转map
     * @param obj
     * @return
     */
    public static Map<String, String> obj2Map(Object obj) {

        Map<String, String> map = new HashMap<String, String>();
        // System.out.println(obj.getClass());
        // 获取f对象对应类中的所有属性域
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
           // varName = varName.toLowerCase();//将key置为小写，默认为对象的属性
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o = fields[i].get(obj);
                if (o != null)
                    map.put(varName, o.toString());
                // System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }
}
