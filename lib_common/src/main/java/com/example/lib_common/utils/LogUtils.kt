package com.example.lib_common.utils

import com.orhanobut.logger.Logger

object LogUtils {

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