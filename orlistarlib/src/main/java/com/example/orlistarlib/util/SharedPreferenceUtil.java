package com.example.orlistarlib.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/12/28 0028.
 * 共享参数的工具类
 */

public class SharedPreferenceUtil {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    /**
     * 初始化共享参数
     *
     * @param context
     */
    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    /**
     * 写入int类型的数据
     */
    public static void setInt(String name, int value) {
        editor.putInt(name, value).commit();
    }

    /**
     * 读取int类型的数据
     *
     * @param name
     * @return
     */
    public static int getInt(String name) {
        return sharedPreferences.getInt(name, -1);
    }

    /**
     * 写入String类型的数据
     */
    public static void setString(String name, String value) {
        editor.putString(name, value).commit();
    }

    /**
     * 读取String类型的数据
     *
     * @param name
     * @return
     */
    public static String getString(String name) {
        return sharedPreferences.getString(name, null);
    }

    /**
     * 写入boolean类型的数据
     *
     * @param name
     * @param value
     */
    public static void setBoolean(String name, boolean value) {
        editor.putBoolean(name, value);
    }

    /**
     * 读取boolean类型的数据
     *
     * @param name
     * @return
     */
    public static boolean getBoolean(String name) {
        return sharedPreferences.getBoolean(name, true);
    }
}
