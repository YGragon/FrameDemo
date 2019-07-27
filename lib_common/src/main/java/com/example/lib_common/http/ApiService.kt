package com.example.lib_common.http

import com.example.lib_common.model.Banner
import com.example.lib_common.model.CollectResult
import com.example.lib_common.model.User
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * api 接口
 */
interface ApiService {
    /**
     * 注册
     */
    @POST("user/register")
    fun register(@Query("username") username:String,
                 @Query("password") password:String,
                 @Query("repassword") repassword:String)
            : Observable<BaseResponse<ResponseBody>>

    /**
     * 登录
     */
    @POST("user/login")
    fun login(@Query("username") username:String,
              @Query("password") password:String): Observable<BaseResponse<User>>

    /**
     * 获取 banner 列表
     */
    @GET("banner/json")
    fun getBanners(): Observable<BaseResponse<MutableList<Banner>>>

    /**
     * 获取 收藏 列表
     */
    @GET("lg/collect/list/{page}/json")
    fun getCollects(@Path("page") page:Int): Observable<BaseResponse<CollectResult>>


}