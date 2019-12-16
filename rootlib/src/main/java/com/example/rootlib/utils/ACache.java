/**
 * Copyright (c) 2012-2013, Michael Yang 杨福海 (www.yangfuhai.com).
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.rootlib.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Michael Yang（www.yangfuhai.com） update at 2013.08.07
 */
public class ACache {
    /**
     * 小时(单位)
     */
    public static final int TIME_HOUR = 60 * 60;
    /**
     * 天(单位)
     */
    public static final int TIME_DAY = TIME_HOUR * 24;
    /**
     * 50 mb(容量)
     */
    private static final int MAX_SIZE = 1000 * 1000 * 50;
    /**
     * 不限制存放数据的数量
     */
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    /**
     * 缓存map
     */
    private static Map<String, ACache> mInstanceMap = new HashMap<String, ACache>();
    /**
     * 缓存管理
     */
    private ACacheManager mCache;

    /**
     * 初始化方法
     *
     * @param ctx 上下文
     * @return
     */
    public static ACache get(Context ctx) {
        return get(ctx, "ACache");
    }

    /**
     * 初始化方法
     *
     * @param ctx       上下文
     * @param cacheName 缓存名称 默认为ACache
     * @return Acache
     */
    public static ACache get(Context ctx, String cacheName) {
        File f = new File(ctx.getCacheDir(), cacheName);
        return get(f, MAX_SIZE, MAX_COUNT);
    }

    /**
     * 初始化方法
     *
     * @param cacheDir 文件路径
     * @return Acache
     */
    public static ACache get(File cacheDir) {
        return get(cacheDir, MAX_SIZE, MAX_COUNT);
    }


    /**
     * 初始化方法
     *
     * @param ctx       上下文
     * @param max_zise  容量
     * @param max_count 数量
     * @return Acache
     */
    public static ACache get(Context ctx, long max_zise, int max_count) {
        File f = new File(ctx.getCacheDir(), "ACache");
        return get(f, max_zise, max_count);
    }

    /**
     * 初始化方法
     * <p/>
     * 初始化,设置文件路径大小容量等.
     * <p/>
     *
     * @param cacheDir  文件Dir
     * @param max_zise  容量
     * @param max_count 数量
     * @return
     */
    public static ACache get(File cacheDir, long max_zise, int max_count) {
        ACache manager = mInstanceMap.get(cacheDir.getAbsoluteFile() + myPid());
        if (manager == null) {
            manager = new ACache(cacheDir, max_zise, max_count);
            mInstanceMap.put(cacheDir.getAbsolutePath() + myPid(), manager);
        }
        return manager;
    }

    /**
     * 获取pid
     *
     * @return
     */
    private static String myPid() {
        return "_" + android.os.Process.myPid();
    }

    /**
     * 构造方法
     *
     * @param cacheDir  文件路径
     * @param max_size  容量
     * @param max_count 数量
     */
    private ACache(File cacheDir, long max_size, int max_count) {
        if (!cacheDir.exists() && !cacheDir.mkdirs()) {
            throw new RuntimeException("can't make dirs in "
                    + cacheDir.getAbsolutePath());
        }
        mCache = new ACacheManager(cacheDir, max_size, max_count);
    }

    /**
     * 存储int类型数据
     *
     * @param key   key值
     * @param value value值
     */
    public void putInt(String key, int value) {
        put(key, String.valueOf(value));
    }

    /**
     * 存储long类型数据
     *
     * @param key   key值
     * @param value value值
     */
    public void putLong(String key, long value) {
        put(key, String.valueOf(value));
    }

    /**
     * 存储boolean类型数据
     *
     * @param key   key值
     * @param value value值
     */
    public void putBoolean(String key, boolean value) {
        put(key, String.valueOf(value));
    }

    /**
     * 存储浮点类型数据
     *
     * @param key   key值
     * @param value value值
     */
    public void putDouble(String key, double value) {
        put(key, String.valueOf(value));
    }

    /**
     * 获取int类型缓存数据
     * <p/>
     *
     * @param key        key值
     * @param defaultVal 默认值
     */
    public int getInt(String key, int defaultVal) {
        try {
            return Integer.parseInt(get(key));
        } catch (NumberFormatException e) {
            if (ApplicationConfig.DEVELOP_DEBUG_MODE) {
                e.printStackTrace();
            }
            return defaultVal;
        }
    }

    /**
     * 获取long类型缓存数据
     * <p/>
     *
     * @param key        key值
     * @param defaultVal 默认值
     */
    public long getLong(String key, long defaultVal) {
        try {
            return Long.parseLong(get(key));
        } catch (NumberFormatException e) {
            if (ApplicationConfig.DEVELOP_DEBUG_MODE) {
                e.printStackTrace();
            }
            return defaultVal;
        }
    }

    /**
     * 获取boolean类型缓存数据
     * <p/>
     *
     * @param key        key值
     * @param defaultVal 默认值
     */
    public boolean getBoolean(String key, boolean defaultVal) {
        try {
            return Boolean.parseBoolean(get(key));
        } catch (NumberFormatException e) {
            if (ApplicationConfig.DEVELOP_DEBUG_MODE) {
                e.printStackTrace();
            }
            return defaultVal;
        }
    }

    /**
     * 获取double类型缓存数据
     * <p/>
     *
     * @param key        key值
     * @param defaultVal 默认值
     */
    public double getDouble(String key, double defaultVal) {
        try {
            return Double.parseDouble(get(key));
        } catch (NumberFormatException e) {
            if (ApplicationConfig.DEVELOP_DEBUG_MODE) {
                e.printStackTrace();
            }
            return defaultVal;
        }
    }

    /**
     * 保存 String数据到缓存中
     * <p/>
     * 用于保存String类型的数据,当保存bean或者其他较为复杂的数据时,建议转换为Json存储
     * 涉及到文件读取,可能会抛出IOException
     * <p/>
     *
     * @param key   保存的key
     * @param value 保存的String数据
     */
    public void put(String key, String value) {
        File file = mCache.newFile(key);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file), 1024);
            out.write(SecurityUtils.getSign(SecurityUtils.TYPE_SIGN.DES, ApplicationConfig.ENCRYPTKEY_LOCAL, value));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mCache.put(file);
        }
    }

    /**
     * 保存 String数据到缓存中
     *
     * @param key      保存的key
     * @param value    保存的String数据
     * @param saveTime 保存的时间，单位：秒
     */
    public void put(String key, String value, int saveTime) {
        put(key, DateUtils.newStringWithDateInfo(saveTime, value));
    }

    /**
     * 读取 String数据
     * <p/>
     * 根据存储的key值获取保存的数据
     * 涉及到文件读取,可能会抛出IOException
     * <p/>
     *
     * @param key key值
     * @return String 获取到的数据
     */
    public String get(String key) {
        File file = mCache.get(key);
        if (!file.exists())
            return null;
        boolean removeFile = false;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String readString = "";
            String currentLine;
            while ((currentLine = in.readLine()) != null) {
                readString += currentLine;
            }
            if (!DateUtils.isDue(readString)) {
                return SecurityUtils.getUnSign(SecurityUtils.TYPE_SIGN.DES, ApplicationConfig.ENCRYPTKEY_LOCAL, DateUtils.clearDateInfo(readString));
            } else {
                removeFile = true;
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (removeFile)
                remove(key);
        }
    }


    /**
     * 获取缓存文件
     *
     * @param key key值
     * @return value  缓存的文件
     */
    public File file(String key) {
        File f = mCache.newFile(key);
        if (f.exists())
            return f;
        return null;
    }

    /**
     * 移除某个key
     *
     * @param key key值
     * @return value   是否移除成功
     */
    public boolean remove(String key) {
        return mCache.remove(key);
    }

    /**
     * 清除所有数据
     */
    public void clear() {
        mCache.clear();
    }

    /**
     * @author 杨福海（michael） www.yangfuhai.com
     * @version 1.0
     * @title 缓存管理器
     */
    public class ACacheManager {
        private final AtomicLong cacheSize;
        private final AtomicInteger cacheCount;
        private final long sizeLimit;
        private final int countLimit;
        private final Map<File, Long> lastUsageDates = Collections
                .synchronizedMap(new HashMap<File, Long>());
        protected File cacheDir;

        /**
         * 初始化
         *
         * @param cacheDir
         * @param sizeLimit
         * @param countLimit
         */
        private ACacheManager(File cacheDir, long sizeLimit, int countLimit) {
            this.cacheDir = cacheDir;
            this.sizeLimit = sizeLimit;
            this.countLimit = countLimit;
            cacheSize = new AtomicLong();
            cacheCount = new AtomicInteger();
            calculateCacheSizeAndCacheCount();
        }

        /**
         * 计算 cacheSize和cacheCount
         */
        private void calculateCacheSizeAndCacheCount() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int size = 0;
                    int count = 0;
                    File[] cachedFiles = cacheDir.listFiles();
                    if (cachedFiles != null) {
                        for (File cachedFile : cachedFiles) {
                            size += calculateSize(cachedFile);
                            count += 1;
                            lastUsageDates.put(cachedFile,
                                    cachedFile.lastModified());
                        }
                        cacheSize.set(size);
                        cacheCount.set(count);
                    }
                }
            }).start();
        }

        /**
         * 保存文件
         *
         * @param file 文件
         */
        private void put(File file) {
            int curCacheCount = cacheCount.get();
            while (curCacheCount + 1 > countLimit) {
                long freedSize = removeNext();
                cacheSize.addAndGet(-freedSize);

                curCacheCount = cacheCount.addAndGet(-1);
            }
            cacheCount.addAndGet(1);

            long valueSize = calculateSize(file);
            long curCacheSize = cacheSize.get();
            while (curCacheSize + valueSize > sizeLimit) {
                long freedSize = removeNext();
                curCacheSize = cacheSize.addAndGet(-freedSize);
            }
            cacheSize.addAndGet(valueSize);

            Long currentTime = System.currentTimeMillis();
            file.setLastModified(currentTime);
            lastUsageDates.put(file, currentTime);
        }

        /**
         * 获取文件
         *
         * @param key 获取文件的key
         * @return
         */
        private File get(String key) {
            File file = newFile(key);
            Long currentTime = System.currentTimeMillis();
            file.setLastModified(currentTime);
            lastUsageDates.put(file, currentTime);

            return file;
        }

        /**
         * 创建新的文件
         *
         * @param key
         * @return
         */
        private File newFile(String key) {
            return new File(cacheDir, key.hashCode() + "");
        }

        /**
         * 删除文件
         *
         * @param key
         * @return
         */
        private boolean remove(String key) {
            File image = get(key);
            return image.delete();
        }

        /**
         * 清除
         */
        private void clear() {
            lastUsageDates.clear();
            cacheSize.set(0);
            File[] files = cacheDir.listFiles();
            if (files != null) {
                for (File f : files) {
                    f.delete();
                }
            }
        }

        /**
         * 移除旧的文件
         *
         * @return
         */
        private long removeNext() {
            if (lastUsageDates.isEmpty()) {
                return 0;
            }

            Long oldestUsage = null;
            File mostLongUsedFile = null;
            Set<Entry<File, Long>> entries = lastUsageDates.entrySet();
            synchronized (lastUsageDates) {
                for (Entry<File, Long> entry : entries) {
                    if (mostLongUsedFile == null) {
                        mostLongUsedFile = entry.getKey();
                        oldestUsage = entry.getValue();
                    } else {
                        Long lastValueUsage = entry.getValue();
                        if (lastValueUsage < oldestUsage) {
                            oldestUsage = lastValueUsage;
                            mostLongUsedFile = entry.getKey();
                        }
                    }
                }
            }

            long fileSize = calculateSize(mostLongUsedFile);
            if (mostLongUsedFile.delete()) {
                lastUsageDates.remove(mostLongUsedFile);
            }
            return fileSize;
        }

        /**
         * 计算文件大小
         *
         * @param file 文件
         * @return
         */
        private long calculateSize(File file) {
            return file.length();
        }
    }

    /**
     * @author 杨福海（michael） www.yangfuhai.com
     * @version 1.0
     * @title 时间计算工具类
     */
    private static class DateUtils {

        /**
         * 判断缓存的String数据是否到期
         *
         * @param str
         * @return true：到期了 false：还没有到期
         */
        private static boolean isDue(String str) {
            return isDue(str.getBytes());
        }

        /**
         * 判断缓存的byte数据是否到期
         *
         * @param data
         * @return true：到期了 false：还没有到期
         */
        private static boolean isDue(byte[] data) {
            String[] strs = getDateInfoFromDate(data);
            if (strs != null && strs.length == 2) {
                String saveTimeStr = strs[0];
                while (saveTimeStr.startsWith("0")) {
                    saveTimeStr = saveTimeStr
                            .substring(1, saveTimeStr.length());
                }
                long saveTime = Long.valueOf(saveTimeStr);
                long deleteAfter = Long.valueOf(strs[1]);
                if (System.currentTimeMillis() > saveTime + deleteAfter * 1000) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 包裹数据,设置保存时间用
         *
         * @param second
         * @param strInfo
         * @return
         */
        private static String newStringWithDateInfo(int second, String strInfo) {
            return createDateInfo(second) + strInfo;
        }

        /**
         * 剥离保存时间信息,获取数据
         *
         * @param strInfo
         * @return
         */
        private static String clearDateInfo(String strInfo) {
            if (strInfo != null && hasDateInfo(strInfo.getBytes())) {
                strInfo = strInfo.substring(strInfo.indexOf(mSeparator) + 1,
                        strInfo.length());
            }
            return strInfo;
        }

        /**
         * 判断是否设置保存时间
         *
         * @param data
         * @return
         */
        private static boolean hasDateInfo(byte[] data) {
            return data != null && data.length > 15 && data[13] == '-'
                    && indexOf(data, mSeparator) > 14;
        }

        /**
         * 获取文件保存时间信息  saveDate保存时间,deleteAfter设置的保存时间
         *
         * @param data
         * @return
         */
        private static String[] getDateInfoFromDate(byte[] data) {
            if (hasDateInfo(data)) {
                String saveDate = new String(copyOfRange(data, 0, 13));
                String deleteAfter = new String(copyOfRange(data, 14,
                        indexOf(data, mSeparator)));
                return new String[]{saveDate, deleteAfter};
            }
            return null;
        }

        /**
         * 获取位置
         *
         * @param data
         * @param c
         * @return
         */
        private static int indexOf(byte[] data, char c) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == c) {
                    return i;
                }
            }
            return -1;
        }

        /**
         * 获取数组范围信息
         *
         * @param original
         * @param from
         * @param to
         * @return
         */
        private static byte[] copyOfRange(byte[] original, int from, int to) {
            int newLength = to - from;
            if (newLength < 0)
                throw new IllegalArgumentException(from + " > " + to);
            byte[] copy = new byte[newLength];
            System.arraycopy(original, from, copy, 0,
                    Math.min(original.length - from, newLength));
            return copy;
        }

        /**
         * 分离str,用于拆出时间信息
         */
        private static final char mSeparator = ' ';

        /**
         * 创建包裹时间信息
         *
         * @param second
         * @return
         */
        private static String createDateInfo(int second) {
            String currentTime = System.currentTimeMillis() + "";
            while (currentTime.length() < 13) {
                currentTime = "0" + currentTime;
            }
            return currentTime + "-" + second + mSeparator;
        }


    }

}
