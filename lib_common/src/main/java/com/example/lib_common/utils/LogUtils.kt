package com.example.lib_common.utils

import android.util.Log
import com.example.lib_common.constant.BaseConstant
import com.orhanobut.logger.Logger
import java.text.SimpleDateFormat
import java.util.*

object LogUtils {

    fun d(message: String) {
        Logger.d(message)
    }

    fun i(message: String) {
        Logger.i(message)
    }

    fun w(message: String, e: Throwable?) {
        val info = e?.toString() ?: "null"
        Logger.w("$message：$info")
    }

    fun e(message: String, e: Throwable) {
        Logger.e(e, message)
    }

    fun json(json: String) {
        Logger.json(json)
    }
}