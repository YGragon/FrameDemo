package com.example.lib_common.utils.rxbus.observer;

import java.lang.System;

/**
 * 接收数据源的观察者
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u000bH\u0017J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0004J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\tH\u0016J\u0014\u0010\u0015\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002J*\u0010\u0017\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0019\u001a\u00020\t2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/lib_common/utils/rxbus/observer/RxResourceObserver;", "T", "Lio/reactivex/Observer;", "Lio/reactivex/rxjava3/disposables/Disposable;", "()V", "resources", "Lio/reactivex/internal/disposables/ListCompositeDisposable;", "s", "Ljava/util/concurrent/atomic/AtomicReference;", "Lio/reactivex/disposables/Disposable;", "add", "", "resource", "composeMessage", "", "consumer", "dispose", "isDisposed", "", "onStart", "onSubscribe", "reportDoubleSubscription", "Ljava/lang/Class;", "setOnce", "upstream", "next", "observer", "lib_common_debug"})
public abstract class RxResourceObserver<T extends java.lang.Object> implements io.reactivex.Observer<T>, io.reactivex.rxjava3.disposables.Disposable {
    
    /**
     * The active subscription.
     */
    private final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> s = null;
    
    /**
     * The resource composite, can never be null.
     */
    private final io.reactivex.internal.disposables.ListCompositeDisposable resources = null;
    
    /**
     * Adds a resource to this ResourceObserver.
     *
     * @param resource the resource to add
     *
     * @throws NullPointerException if resource is null
     */
    public final void add(@org.jetbrains.annotations.NotNull()
    @androidx.annotation.NonNull()
    io.reactivex.disposables.Disposable resource) {
    }
    
    @java.lang.Override()
    public void onSubscribe(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable s) {
    }
    
    private final boolean setOnce(java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> upstream, io.reactivex.disposables.Disposable next, java.lang.Class<?> observer) {
        return false;
    }
    
    private final void reportDoubleSubscription(java.lang.Class<?> consumer) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String composeMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String consumer) {
        return null;
    }
    
    /**
     * Called once the upstream sets a Subscription on this ResourceObserver.
     *
     *
     * You can perform initialization at this moment. The default
     * implementation does nothing.
     */
    protected final void onStart() {
    }
    
    /**
     * Cancels the main disposable (if any) and disposes the resources associated with
     * this ResourceObserver (if any).
     *
     *
     * This method can be called before the upstream calls onSubscribe at which
     * case the main Disposable will be immediately disposed.
     */
    @androidx.annotation.CallSuper()
    @java.lang.Override()
    public void dispose() {
    }
    
    /**
     * Returns true if this ResourceObserver has been disposed/cancelled.
     * @return true if this ResourceObserver has been disposed/cancelled
     */
    @java.lang.Override()
    public boolean isDisposed() {
        return false;
    }
    
    public RxResourceObserver() {
        super();
    }
}