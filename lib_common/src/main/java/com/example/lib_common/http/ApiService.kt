package com.example.lib_common.http

import com.example.lib_common.http.response.BaseResponse
import com.example.lib_common.model.*
import io.reactivex.rxjava3.core.Observable
import okhttp3.MultipartBody
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
     * 退出登录
     */
    @GET("user/logout/json")
    fun logout(): Observable<BaseResponse<ResponseBody>>

    /**
     * 获取 banner 列表
     */
    @GET("banner/json")
    fun getBanners(): Observable<BaseResponse<MutableList<Banner>>>

    /**
     * 获取 收藏 列表
     */
    @GET("lg/collect/list/{page}/json")
    fun getCollects(@Path("page") page:Int): Observable<BaseResponse<CollectBean>>

    /**
     * 收藏站内文章
     */
    @POST("lg/collect/{id}/json")
    fun regionCollect(@Path("id") id:Int): Observable<BaseResponse<ResponseBody>>

    /**
     * 取消收藏站内文章
     */
    @POST("lg/uncollect_originId/{id}/json")
    fun regionUnCollect(@Path("id") id:Int): Observable<BaseResponse<ResponseBody>>
    
    /**
     * 获取 首页文章 列表
     */
    @GET("article/list/{page}/json")
    fun getArticles(@Path("page") page:Int): Observable<BaseResponse<ArticleResult>>

    /**
     * 获取 搜索热词 列表
     */
    @GET("hotkey/json")
    fun getHotkey():Observable<BaseResponse<MutableList<Hotkey>>>

    /**
     * 获取 搜索 列表
     */
    @POST("article/query/{page}/json")
    fun getSearchs(@Path("page") page:Int,@Query("k") key_word:String):Observable<BaseResponse<SearchList>>

    /**
     * 获取 干货图片 列表
     */
    @Headers("base_url:gank")//添加注解，更换baseUrl
    @GET("api/v2/data/category/Girl/type/Girl/page/{page}/count/{count}")
    fun getGankPhotos(@Path("count")count:Int,@Path("page")page:Int):Observable<GankPhoto>


    /**
     * 发布TODO
     */
    @POST("lg/todo/add/json")
    fun publishTodo(@Query("title") title:String,
                    @Query("content") content:String,
                    @Query("date") date:String,
                    @Query("type") type:Int,
                    @Query("priority") priority:Int
    ):Observable<BaseResponse<TodoBean>>

    /**
     * 更新TODO
     */
    @POST("lg/todo/update/{id}/json")
    fun editTodo(@Path("id") id:Int,
                    @Query("title") title:String,
                    @Query("content") content:String,
                    @Query("date") date:String,
                    @Query("type") type:Int,
                    @Query("priority") priority:Int
    ):Observable<BaseResponse<TodoBean>>

    /**
     * 删除TODO
     */
    @POST("lg/todo/delete/{id}/json")
    fun deleteTodo(@Path("id") id:Int):Observable<BaseResponse<TodoBean>>

    /**
     * 仅更新完成状态Todo
     */
    @POST("lg/todo/done/{id}/json")
    fun updateStatusTodo(@Path("id") id:Int,
                   @Query("status") status:Int):Observable<BaseResponse<TodoBean>>

    /**
     * 获取 TODO列表
     */
    @GET("lg/todo/v2/list/{page}/json")
    fun getTodoList(@Path("page") page:Int,
                    @Query("status") status:Int,//1-完成；0未完成; 默认全部展示
//                    @Query("type") type:Int,//创建时传入的类型, 默认全部展示
//                    @Query("priority") priority:Int,//创建时传入的优先级；默认全部展示
                    @Query("orderby") orderby:Int//1:完成日期顺序；2.完成日期逆序；3.创建日期顺序；4.创建日期逆序(默认)
                    ):Observable<BaseResponse<TodoList>>
    /**
     * 文件上传
     */
    @Multipart
    @POST("upload")
    fun upload(@Part param: MultipartBody.Part): Observable<ResponseBody>
}