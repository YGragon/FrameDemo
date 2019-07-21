package com.example.lib_common.http

import com.example.lib_common.model.Banner
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * api 接口
 */
interface ApiService {
    /**
     * 获取 banner 列表
     */
    @GET("banner/json")
    fun getBanners(): Observable<BaseResponse<MutableList<Banner>>>

}