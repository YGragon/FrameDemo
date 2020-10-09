package com.example.lib_common.http;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a\u0086\u0001\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\t2#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\t2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012\u001a\u0090\u0001\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\t2#\b\u0002\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\t2#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\t2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012\u001a0\u0010\u0016\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\u00a8\u0006\u0017"}, d2 = {"runRx", "", "T", "observable", "Lio/reactivex/rxjava3/core/Observable;", "observer", "Lio/reactivex/rxjava3/core/Observer;", "runRxLambda", "next", "Lkotlin/Function1;", "error", "", "Lkotlin/ParameterName;", "name", "subscribe", "Lio/reactivex/rxjava3/disposables/Disposable;", "d", "completed", "Lkotlin/Function0;", "runRxLambdaViewModel", "provider", "Lautodispose2/ScopeProvider;", "runRxViewModel", "lib_common_debug"})
public final class ExtHttpKt {
    
    /**
     * *  使用 kotlin 高阶函数及扩展函数封装的网络请求
     */
    public static final <T extends java.lang.Object>void runRx(@org.jetbrains.annotations.NotNull()
    io.reactivex.rxjava3.core.Observable<T> observable, @org.jetbrains.annotations.NotNull()
    io.reactivex.rxjava3.core.Observer<T> observer) {
    }
    
    public static final <T extends java.lang.Object>void runRxLambda(@org.jetbrains.annotations.NotNull()
    io.reactivex.rxjava3.core.Observable<T> observable, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> next, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> error, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super io.reactivex.rxjava3.disposables.Disposable, kotlin.Unit> subscribe, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> completed) {
    }
    
    public static final <T extends java.lang.Object>void runRxViewModel(@org.jetbrains.annotations.NotNull()
    autodispose2.ScopeProvider provider, @org.jetbrains.annotations.NotNull()
    io.reactivex.rxjava3.core.Observable<T> observable, @org.jetbrains.annotations.NotNull()
    io.reactivex.rxjava3.core.Observer<T> observer) {
    }
    
    public static final <T extends java.lang.Object>void runRxLambdaViewModel(@org.jetbrains.annotations.NotNull()
    autodispose2.ScopeProvider provider, @org.jetbrains.annotations.NotNull()
    io.reactivex.rxjava3.core.Observable<T> observable, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> next, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> error, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super io.reactivex.rxjava3.disposables.Disposable, kotlin.Unit> subscribe, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> completed) {
    }
}