package com.example.lib_common.utils


import java.text.ParsePosition
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

    /**
     * Timestamp to String
     * @param Timestamp
     * @return String
     */
    fun transToString(time:Long):String{
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time)
    }

    /**
     * String to Timestamp
     * @param String
     * @return Timestamp
     */

    fun transToTimeStamp(date:String):Long{
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date, ParsePosition(0)).time
    }
}