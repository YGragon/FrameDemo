package com.example.lib_common.utils


import java.text.SimpleDateFormat
import java.util.*

/**
 * 时间工具类
 */

object DateUtils {
    /**
     * @Description: 获取当前系统时间
     */
    fun getCurrentSystemTime():Long {
        return Calendar.getInstance().timeInMillis
    }

    /**
     * @Description: 格式化时间
     */
    fun getFormatTime(date: Date):String {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        return simpleDateFormat.format(date)
    }
}