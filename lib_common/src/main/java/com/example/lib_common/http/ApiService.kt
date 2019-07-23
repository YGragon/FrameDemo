package com.example.lib_common.http

import com.example.lib_common.model.Banner
import com.example.lib_common.model.User
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * api 接口
 */
interface ApiService {
    /**
     * 注册
     */
    @POST("user/register")
    fun register(): Observable<BaseResponse<ResponseBody>>

    /**
     * 登录
     */
    @POST("user/login")
    fun login(): Observable<BaseResponse<User>>

    /**
     * 获取 banner 列表
     */
    @GET("banner/json")
    fun getBanners(): Observable<BaseResponse<MutableList<Banner>>>
}