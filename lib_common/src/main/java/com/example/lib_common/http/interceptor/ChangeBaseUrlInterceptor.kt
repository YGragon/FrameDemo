package com.example.lib_common.http.interceptor


import com.example.lib_common.http.UrlConstant
import com.example.lib_common.utils.LogUtils
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.Interceptor
import okhttp3.Response

/**
 * 多个 BaseURL 拦截器
 */
class ChangeBaseUrlInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        //获取request
        val request = chain.request()
        //获取request的创建者builder
        val builder = request.newBuilder()
        //从request中获取headers，通过给定的键url_name
        val headers = request.headers("base_url")
        if (headers.isNotEmpty()) {
            //如果有这个header，先将配置的header删除，因此header仅用作app和okhttp之间使用
            builder.removeHeader("base_url")
            //匹配获得新的BaseUrl
            val value = headers[0]
            val newBaseUrl = if ("gank" == value) {
                UrlConstant.GANK_URL.toHttpUrlOrNull()!!
            } else{
                //还是原来的地址
                UrlConstant.BASE_URL.toHttpUrlOrNull()!!
            }
            //从request中获取原有的HttpUrl实例oldHttpUrl
            val url = request.url
            //重建新的HttpUrl，修改需要修改的url部分
            val httpUrl = url.newBuilder()
                .scheme(newBaseUrl.scheme)
                .host(newBaseUrl.host)
                .port(newBaseUrl.port)
                .build()
            //重建这个request，通过builder.url(newFullUrl).build()
            //然后返回一个response至此结束修改
            return chain.proceed(builder.url(httpUrl).build())
        } else {
            return chain.proceed(request)
        }
    }
}