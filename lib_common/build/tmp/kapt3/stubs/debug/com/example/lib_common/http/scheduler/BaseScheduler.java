package com.example.lib_common.http.scheduler;

import java.lang.System;

/**
 * * 线程调度基类
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u0006B\u0017\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/lib_common/http/scheduler/BaseScheduler;", "T", "Lio/reactivex/ObservableTransformer;", "Lio/reactivex/SingleTransformer;", "Lio/reactivex/MaybeTransformer;", "Lio/reactivex/CompletableTransformer;", "Lio/reactivex/FlowableTransformer;", "subscribeOnScheduler", "Lio/reactivex/Scheduler;", "observeOnScheduler", "(Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "apply", "Lio/reactivex/CompletableSource;", "upstream", "Lio/reactivex/Completable;", "Lorg/reactivestreams/Publisher;", "Lio/reactivex/Flowable;", "Lio/reactivex/MaybeSource;", "Lio/reactivex/Maybe;", "Lio/reactivex/ObservableSource;", "Lio/reactivex/Observable;", "Lio/reactivex/SingleSource;", "Lio/reactivex/Single;", "lib_common_debug"})
public abstract class BaseScheduler<T extends java.lang.Object> implements io.reactivex.ObservableTransformer<T, T>, io.reactivex.SingleTransformer<T, T>, io.reactivex.MaybeTransformer<T, T>, io.reactivex.CompletableTransformer, io.reactivex.FlowableTransformer<T, T> {
    private final io.reactivex.Scheduler subscribeOnScheduler = null;
    private final io.reactivex.Scheduler observeOnScheduler = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.CompletableSource apply(@org.jetbrains.annotations.NotNull()
    io.reactivex.Completable upstream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.reactivestreams.Publisher<T> apply(@org.jetbrains.annotations.NotNull()
    io.reactivex.Flowable<T> upstream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.MaybeSource<T> apply(@org.jetbrains.annotations.NotNull()
    io.reactivex.Maybe<T> upstream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.ObservableSource<T> apply(@org.jetbrains.annotations.NotNull()
    io.reactivex.Observable<T> upstream) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.SingleSource<T> apply(@org.jetbrains.annotations.NotNull()
    io.reactivex.Single<T> upstream) {
        return null;
    }
    
    protected BaseScheduler(@org.jetbrains.annotations.NotNull()
    io.reactivex.Scheduler subscribeOnScheduler, @org.jetbrains.annotations.NotNull()
    io.reactivex.Scheduler observeOnScheduler) {
        super();
    }
}