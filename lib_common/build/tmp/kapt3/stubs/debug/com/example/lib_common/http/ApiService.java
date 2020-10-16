package com.example.lib_common.http;

import java.lang.System;

/**
 * api 接口
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'JP\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u0007H\'J\u001e\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00040\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0007H\'J\u001a\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00040\u0003H\'J\u001e\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00040\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0007H\'J\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u0007H\'J\u001a\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00130\u00040\u0003H\'J(\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00040\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010\u001e\u001a\u00020\nH\'JF\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00040\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010!\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\"\u001a\u00020\u0007H\'J(\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00040\u00032\b\b\u0001\u0010%\u001a\u00020\n2\b\b\u0001\u0010&\u001a\u00020\nH\'J\u0014\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00040\u0003H\'JF\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u0007H\'J2\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00040\u00032\b\b\u0001\u0010%\u001a\u00020\n2\b\b\u0001\u0010&\u001a\u00020\n2\b\b\u0001\u0010+\u001a\u00020\nH\'J(\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010!\u001a\u00020\u0007H\'J\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010.\u001a\u00020/H\'\u00a8\u00060"}, d2 = {"Lcom/example/lib_common/http/ApiService;", "", "deleteTodo", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/example/lib_common/http/response/BaseResponse;", "Lcom/example/lib_common/model/TodoBean;", "id", "", "editTodo", "title", "", "content", "date", "type", "priority", "getArticles", "Lcom/example/lib_common/model/ArticleResult;", "page", "getBanners", "", "Lcom/example/lib_common/model/Banner;", "getCollects", "Lcom/example/lib_common/model/CollectBean;", "getGankPhotos", "Lcom/example/lib_common/model/GankPhoto;", "count", "getHotkey", "Lcom/example/lib_common/model/Hotkey;", "getSearchs", "Lcom/example/lib_common/model/SearchList;", "key_word", "getTodoList", "Lcom/example/lib_common/model/TodoList;", "status", "orderby", "login", "Lcom/example/lib_common/model/User;", "username", "password", "logout", "Lokhttp3/ResponseBody;", "publishTodo", "register", "repassword", "updateStatusTodo", "upload", "param", "Lokhttp3/MultipartBody$Part;", "lib_common_debug"})
public abstract interface ApiService {
    
    /**
     * 注册
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "user/register")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<okhttp3.ResponseBody>> register(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "username")
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "password")
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "repassword")
    java.lang.String repassword);
    
    /**
     * 登录
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "user/login")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<com.example.lib_common.model.User>> login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "username")
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "password")
    java.lang.String password);
    
    /**
     * 退出登录
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "user/logout/json")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<okhttp3.ResponseBody>> logout();
    
    /**
     * 获取 banner 列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "banner/json")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<java.util.List<com.example.lib_common.model.Banner>>> getBanners();
    
    /**
     * 获取 收藏 列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "lg/collect/list/{page}/json")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<com.example.lib_common.model.CollectBean>> getCollects(@retrofit2.http.Path(value = "page")
    int page);
    
    /**
     * 获取 首页文章 列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "article/list/{page}/json")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<com.example.lib_common.model.ArticleResult>> getArticles(@retrofit2.http.Path(value = "page")
    int page);
    
    /**
     * 获取 搜索热词 列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "hotkey/json")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<java.util.List<com.example.lib_common.model.Hotkey>>> getHotkey();
    
    /**
     * 获取 搜索 列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "article/query/{page}/json")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<com.example.lib_common.model.SearchList>> getSearchs(@retrofit2.http.Path(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "k")
    java.lang.String key_word);
    
    /**
     * 获取 干货图片 列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "api/v2/data/category/Girl/type/Girl/page/{page}/count/{count}")
    @retrofit2.http.Headers(value = {"base_url:gank"})
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.model.GankPhoto> getGankPhotos(@retrofit2.http.Path(value = "count")
    int count, @retrofit2.http.Path(value = "page")
    int page);
    
    /**
     * 发布TODO
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "lg/todo/add/json")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<com.example.lib_common.model.TodoBean>> publishTodo(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "title")
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "content")
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "date")
    java.lang.String date, @retrofit2.http.Query(value = "type")
    int type, @retrofit2.http.Query(value = "priority")
    int priority);
    
    /**
     * 更新TODO
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "lg/todo/update/{id}/json")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<com.example.lib_common.model.TodoBean>> editTodo(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "title")
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "content")
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "date")
    java.lang.String date, @retrofit2.http.Query(value = "type")
    int type, @retrofit2.http.Query(value = "priority")
    int priority);
    
    /**
     * 删除TODO
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "lg/todo/delete/{id}/json")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<com.example.lib_common.model.TodoBean>> deleteTodo(@retrofit2.http.Path(value = "id")
    int id);
    
    /**
     * 仅更新完成状态Todo
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "lg/todo/done/{id}/json")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<com.example.lib_common.model.TodoBean>> updateStatusTodo(@retrofit2.http.Path(value = "id")
    int id, @retrofit2.http.Query(value = "status")
    int status);
    
    /**
     * 获取 TODO列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "lg/todo/v2/list/{page}/json")
    public abstract io.reactivex.rxjava3.core.Observable<com.example.lib_common.http.response.BaseResponse<com.example.lib_common.model.TodoList>> getTodoList(@retrofit2.http.Path(value = "page")
    int page, @retrofit2.http.Query(value = "status")
    int status, @retrofit2.http.Query(value = "type")
    int type, @retrofit2.http.Query(value = "priority")
    int priority, @retrofit2.http.Query(value = "orderby")
    int orderby);
    
    /**
     * 文件上传
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "upload")
    @retrofit2.http.Multipart()
    public abstract io.reactivex.rxjava3.core.Observable<okhttp3.ResponseBody> upload(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part param);
}