package com.example.orlistarlib.util;

import android.content.Context;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class ScreenUtil {
    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        //基于资源名臣的字符串找到资源所对应的ID
        int resid = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        //resid>0，获取成功
        if (resid > 0) {
            return context.getResources().getDimensionPixelSize(resid);
        }
        return -1;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
