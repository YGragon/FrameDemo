package com.longyi.module_android_jetpack.utils;

/**
 *@content:按键延时工具类,用于防止按键连点
 *@time:2019-5-19
 *@build:
 */

public class ButtonDelayUtil {

    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private static long lastClickTime;

    public static boolean isFastClick(){
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            flag = true;
        }
        lastClickTime = curClickTime;
        return flag;
    }

}