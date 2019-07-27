package com.example.lib_common.http.interceptor

import okhttp3.Interceptor
import com.alibaba.android.arouter.launcher.ARouter.logger
import com.example.lib_common.utils.LogUtils
import okhttp3.Response
import java.io.IOException


/**
 * 日志输出 Interceptor
 */
class LoggingInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val t1 = System.nanoTime()
        LogUtils.ii("TAG",String.format(
            "Sending request %s on %s%n%s",
            request.url, chain.connection(), request.headers
        ))


        val response = chain.proceed(request)

        val t2 = System.nanoTime()
        LogUtils.ii("TAG", String.format(
                "Received response for %s in %.1fms%n%s",
            response.request.url, (t2 - t1) / 1e6, response.headers
        ))

        return response
    }
}