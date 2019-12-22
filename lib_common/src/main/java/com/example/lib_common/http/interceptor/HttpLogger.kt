package com.example.lib_common.http.interceptor

import com.example.lib_common.utils.JsonUtils
import com.example.lib_common.utils.LogUtils
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Log 输出
 */
class HttpLogger: HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        var msg = message

        // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
        if ((msg.startsWith("{") && msg.endsWith("}"))
            || (msg.startsWith("[") && msg.endsWith("]"))) {
            msg = JsonUtils.formatJson(JsonUtils.decodeUnicode(msg))
        }
        LogUtils.d(msg)
    }
}