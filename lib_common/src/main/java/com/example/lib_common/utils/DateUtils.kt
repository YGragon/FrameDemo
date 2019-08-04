package com.example.lib_common.utils


import java.util.*

/**
 * 时间工具类
 */

object DateUtils {
    /**
     * @Description: 获取当前系统时间
     */
    fun getCurrentSystemTime():Long {
        return Calendar.getInstance().timeInMillis;
    }
}