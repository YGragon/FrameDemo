package com.longyi.lib_download.file_download

import okhttp3.Interceptor
import okhttp3.Response

/**
 * 下载拦截器
 */
class DownloadInterceptor : Interceptor {

    private lateinit var downloadListener: DownloadListener

    constructor(downloadListener: DownloadListener){
        this.downloadListener = downloadListener

    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        return response.newBuilder().body(
            response.body?.let { DownloadResponseBody(it, downloadListener) }
        )
            .addHeader("Content-Type", "application/json;charset:UTF-8")
            .addHeader("Accept", "application/json")
            .build()

    }
}