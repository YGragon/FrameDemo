package com.example.lib_common.utils.rxbus.bus;

import java.lang.System;

/**
 * * Created by Aller on 2020/10/11.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0017J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0017J\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0010J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/lib_common/utils/rxbus/bus/RxBusReceiver;", "T", "Lcom/example/lib_common/utils/rxbus/observer/RxResourceObserver;", "Lio/reactivex/disposables/Disposable;", "()V", "filter", "", "clearIfNeed", "", "dispose", "onComplete", "onError", "e", "", "onNext", "t", "(Ljava/lang/Object;)V", "receive", "data", "setCurFilter", "lib_common_debug"})
public abstract class RxBusReceiver<T extends java.lang.Object> extends com.example.lib_common.utils.rxbus.observer.RxResourceObserver<T> implements io.reactivex.disposables.Disposable {
    private java.lang.String filter;
    
    @java.lang.Override()
    public void onNext(T t) {
    }
    
    @androidx.annotation.CallSuper()
    @java.lang.Override()
    public void onError(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable e) {
    }
    
    @androidx.annotation.CallSuper()
    @java.lang.Override()
    public void onComplete() {
    }
    
    public final void setCurFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String filter) {
    }
    
    public abstract void receive(T data);
    
    private final void clearIfNeed() {
    }
    
    @java.lang.Override()
    public void dispose() {
    }
    
    public RxBusReceiver() {
        super();
    }
}