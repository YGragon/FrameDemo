package com.example.lib_common.http;

import java.lang.System;

/**
 * * api 接口
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00040\u0003H\'J\u001e\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J\u001a\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\u00040\u0003H\'J(\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\'J(\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00040\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u00122\b\b\u0001\u0010\u0016\u001a\u00020\u0012H\'J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00040\u0003H\'J2\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00040\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u00122\b\b\u0001\u0010\u0016\u001a\u00020\u00122\b\b\u0001\u0010\u001a\u001a\u00020\u0012H\'\u00a8\u0006\u001b"}, d2 = {"Lcom/example/lib_common/http/ApiService;", "", "getArticles", "Lio/reactivex/Observable;", "Lcom/example/lib_common/http/BaseResponse;", "Lcom/example/lib_common/model/ArticleResult;", "page", "", "getBanners", "", "Lcom/example/lib_common/model/Banner;", "getCollects", "Lcom/example/lib_common/model/CollectBean;", "getHotkey", "Lcom/example/lib_common/model/Hotkey;", "getSearchs", "Lcom/example/lib_common/model/SearchList;", "key_word", "", "login", "Lcom/example/lib_common/model/User;", "username", "password", "logout", "Lokhttp3/ResponseBody;", "register", "repassword", "lib_common_debug"})
public abstract interface ApiService {
    
    /**
     * * 注册
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "user/register")
    public abstract io.reactivex.Observable<com.example.lib_common.http.BaseResponse<okhttp3.ResponseBody>> register(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "username")
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "password")
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "repassword")
    java.lang.String repassword);
    
    /**
     * * 登录
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "user/login")
    public abstract io.reactivex.Observable<com.example.lib_common.http.BaseResponse<com.example.lib_common.model.User>> login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "username")
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "password")
    java.lang.String password);
    
    /**
     * * 退出登录
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "user/logout/json")
    public abstract io.reactivex.Observable<com.example.lib_common.http.BaseResponse<okhttp3.ResponseBody>> logout();
    
    /**
     * * 获取 banner 列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "banner/json")
    public abstract io.reactivex.Observable<com.example.lib_common.http.BaseResponse<java.util.List<com.example.lib_common.model.Banner>>> getBanners();
    
    /**
     * * 获取 收藏 列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "lg/collect/list/{page}/json")
    public abstract io.reactivex.Observable<com.example.lib_common.http.BaseResponse<com.example.lib_common.model.CollectBean>> getCollects(@retrofit2.http.Path(value = "page")
    int page);
    
    /**
     * * 获取 首页文章 列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "article/list/{page}/json")
    public abstract io.reactivex.Observable<com.example.lib_common.http.BaseResponse<com.example.lib_common.model.ArticleResult>> getArticles(@retrofit2.http.Path(value = "page")
    int page);
    
    /**
     * * 获取 搜索热词 列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "hotkey/json")
    public abstract io.reactivex.Observable<com.example.lib_common.http.BaseResponse<java.util.List<com.example.lib_common.model.Hotkey>>> getHotkey();
    
    /**
     * * 获取 搜索 列表
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "article/query/{page}/json")
    public abstract io.reactivex.Observable<com.example.lib_common.http.BaseResponse<com.example.lib_common.model.SearchList>> getSearchs(@retrofit2.http.Path(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "k")
    java.lang.String key_word);
}