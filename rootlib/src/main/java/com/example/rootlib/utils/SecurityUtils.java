package com.example.rootlib.utils;

import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by guolei on 2017/4/24.
 * 安全工具类，包括各种加密
 */

public class SecurityUtils {


    public enum TYPE_SIGN{
        SHA1("HmacSHA1"),
        DES("DESede");

        private String _value;

        TYPE_SIGN(String value){
            this._value = value;
        }

        public String get_value() {
            return _value;
        }

        //用于做int到value的映射
        private static final Map<String, TYPE_SIGN> valueToEnum = new HashMap<String, TYPE_SIGN>();
        static {
            for(TYPE_SIGN blah : values()) {
                valueToEnum.put(blah.get_value(), blah);
            }
        }

        public static TYPE_SIGN valueOf(int symbol) {
            return valueToEnum.get(symbol);
        }
    }

    /**
     * 获取指定加密方式加密后的字符串
     * @param type
     * @param key
     * @param value
     * @return
     */
    public static String getSign(TYPE_SIGN type, String key , String value){
        String result = null;
        byte[] bytes = null;

        if(!StringUtil.isEmpty(value) && type != null){
            switch (type){
                case SHA1:          //SHA1加密
                    try {
                        SecretKey signingKey = new SecretKeySpec(key.getBytes(), type.get_value());
                        // 加密
                        Mac mac = Mac.getInstance(type.get_value());
                        mac.init(signingKey);
                        bytes = mac.doFinal(value.getBytes());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case DES:
                    try {
                        SecretKey deskey = new SecretKeySpec(key.getBytes(), type.get_value());
                        // 加密
                        Cipher c1 = Cipher.getInstance(type.get_value());
                        c1.init(Cipher.ENCRYPT_MODE, deskey);
                        bytes = c1.doFinal(value.getBytes());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }

            if (bytes != null) {
                result = StringUtil.encodeBase64(bytes);
            }
        }

        return result;
    }

    /**
     * 获取指定加密方式解密后的字符串
     * @param type
     * @param key
     * @param value
     * @return
     */
    public static String getUnSign(TYPE_SIGN type, String key , String value){
        String result = null;
        byte[] bytes = null;

        if(!StringUtil.isEmpty(value) && type != null){
            switch (type){
                case SHA1:          // SHA1解密
                    break;
                case DES:           // DES解密
                    try {
                        SecretKey deskey = new SecretKeySpec(key.getBytes(), type.get_value());
                        // 加密
                        Cipher c1 = Cipher.getInstance(type.get_value());
                        c1.init(Cipher.DECRYPT_MODE, deskey);
                        bytes = c1.doFinal(StringUtil.decodeBase64(value));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }

            if (bytes != null) {
                result = new String(bytes);
            }
        }
        return result;
    }
}
