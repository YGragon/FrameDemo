package com.example.lib_common.http.interceptor

import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.http.BaseResponse
import com.example.lib_common.utils.ActivityManager
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

/**
 * 检测是否登录，没有登录则跳转登录页面
 */
class CheckLoginInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var response = chain.proceed(request)
        // 复制一个 response ，因为 OkHttp  response.body().string 只能调用一次
        val mediaType = response.body?.contentType()
        val content = response.body?.string()
        response = response.newBuilder().body(content?.toResponseBody(mediaType)).build()
        val baseResponse = Gson().fromJson(content, BaseResponse::class.java)
        if (baseResponse.errorMsg == "请先登录！" || baseResponse.errorCode == -1001){
            // 跳转登录页面
            ARouter.getInstance()
                .build(RouterPath.UserCenter.LOGIN)
                .withBoolean(ParameterConstant.Login.isCheckLoginParameter,ParameterConstant.Login.isCheckLogin)
                .navigation()
        }
        return response
    }
}