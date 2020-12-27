package com.example.lib_common.utils

import android.util.Log
import com.orhanobut.logger.*

/**
 * 日志管理类
 */
object LogUtils {

    fun init(){

        // 输出到控制台
        val logFormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
            .methodCount(0)         // 方法栈打印的个数，默认是2
            .methodOffset(7)        // 设置调用堆栈的函数偏移值，0的话则从打印该Log的函数开始输出堆栈信息，默认是0
            .logStrategy(LogCatStrategy())
            .build()

        val androidLogAdapter = object : AndroidLogAdapter(logFormatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        }
        Logger.addLogAdapter(androidLogAdapter)

        // 输出到文件
        val formatStrategy: FormatStrategy = CsvFormatStrategy.newBuilder()
            .tag("custom")
            .build()
        Logger.addLogAdapter(DiskLogAdapter(formatStrategy))
    }

    fun d(message: String) {
        Logger.d(message)
    }

    fun i(message: String) {
        Logger.i(message)
    }

    fun w(message: String) {
        Logger.w(message)
    }

    fun e(message: String) {
        Logger.e( message)
    }

    fun json(json: String) {
        Logger.json(json)
    }
}

/**
 * 解决 AS log 日志换行问题
 */
class LogCatStrategy: LogStrategy {
    override fun log(priority: Int, tag: String?, message: String) {
        Log.println(priority, randomKey() + tag!!, message)
    }

    private var last: Int = 0

    private fun randomKey(): String {
        var random = (10 * Math.random()).toInt()
        if (random == last) {
            random = (random + 1) % 10
        }
        last = random
        return random.toString()
    }
}