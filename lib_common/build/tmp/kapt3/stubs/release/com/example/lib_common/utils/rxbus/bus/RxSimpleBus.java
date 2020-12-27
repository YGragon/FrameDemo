package com.example.lib_common.utils.rxbus.bus;

import java.lang.System;

/**
 * Created by Aller on 2020/10/11.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\b\u0010\f\u001a\u00020\rH\u0002J\u001c\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011J\u001c\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/lib_common/utils/rxbus/bus/RxSimpleBus;", "", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "normalBus", "Lio/reactivex/subjects/Subject;", "stickyBus", "clearCurMessage", "", "filter", "hasObservable", "", "receiveMessageFrom", "Lio/reactivex/disposables/Disposable;", "receiver", "Lcom/example/lib_common/utils/rxbus/bus/RxBusReceiver;", "receiveStickyMessage", "sendMessage", "rxMsg", "Lcom/example/lib_common/utils/rxbus/bus/RxBusMessage;", "sendStickyMessage", "toObservable", "Lio/reactivex/Observable;", "sub", "lib_common_release"})
public final class RxSimpleBus {
    private static io.reactivex.subjects.Subject<java.lang.Object> normalBus;
    private static io.reactivex.subjects.Subject<java.lang.Object> stickyBus;
    private static final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> cache = null;
    public static final com.example.lib_common.utils.rxbus.bus.RxSimpleBus INSTANCE = null;
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull()
    com.example.lib_common.utils.rxbus.bus.RxBusMessage rxMsg) {
    }
    
    public final void sendStickyMessage(@org.jetbrains.annotations.Nullable()
    com.example.lib_common.utils.rxbus.bus.RxBusMessage rxMsg) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.disposables.Disposable receiveMessageFrom(@org.jetbrains.annotations.NotNull()
    java.lang.String filter, @org.jetbrains.annotations.NotNull()
    com.example.lib_common.utils.rxbus.bus.RxBusReceiver<java.lang.Object> receiver) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.disposables.Disposable receiveStickyMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String filter, @org.jetbrains.annotations.NotNull()
    com.example.lib_common.utils.rxbus.bus.RxBusReceiver<java.lang.Object> receiver) {
        return null;
    }
    
    private final io.reactivex.Observable<java.lang.Object> toObservable(io.reactivex.subjects.Subject<java.lang.Object> sub, java.lang.String filter) {
        return null;
    }
    
    private final boolean hasObservable() {
        return false;
    }
    
    public final void clearCurMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String filter) {
    }
    
    private RxSimpleBus() {
        super();
    }
}