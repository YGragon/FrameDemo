package com.example.lib_common.utils;

import java.lang.System;

/**
 * * 使用 RxJava 封装的事件总线
 * * 使用：
 * * 1. 注册，在 onCreate 方法
 * * RxBus.observe<String>()
 * * .subscribe { t: String? ->
 * * Log.e(TAG,"接收的数据：$t")
 * * }
 * * .registerInBus(this)
 * *
 * * 2. 发送
 * * RxBus.send("123")
 * *
 * * 3. 注销，在 onDestroy 方法
 * * RxBus.unRegister(this)
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u0001H\u0086\bJ\u001d\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u00a2\u0006\u0002\b\u001aJ\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0001J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0001R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R;\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b`\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00010\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/example/lib_common/utils/RxBus;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "disposablesMap", "Ljava/util/HashMap;", "Lio/reactivex/disposables/CompositeDisposable;", "Lkotlin/collections/HashMap;", "getDisposablesMap", "()Ljava/util/HashMap;", "disposablesMap$delegate", "Lkotlin/Lazy;", "rxBus", "Lio/reactivex/subjects/Subject;", "getRxBus", "()Lio/reactivex/subjects/Subject;", "observe", "Lio/reactivex/Observable;", "T", "register", "", "disposable", "composite", "Lio/reactivex/disposables/Disposable;", "register$lib_common_debug", "send", "event", "unRegister", "lib_common_debug"})
public final class RxBus {
    private static final java.lang.String TAG = null;
    
    /**
     * * 用于保存RxBus事件的所有订阅，并在需要时正确的取消订阅。
     */
    private static final kotlin.Lazy disposablesMap$delegate = null;
    
    /**
     * * 避免直接使用此属性，因为它仅在内联函数中使用而暴露
     *     * PublishSubject：接收到订阅之后的所有数据
     *     * ReplaySubject：接收到所有的数据，包括订阅之前的所有数据和订阅之后的所有数据。
     *     * BehaviorSubject：接收到订阅前的最后一条数据和订阅后的所有数据。
     *     * AsyncSubject：不管在什么位置订阅，都只接收到最后一条数据
     */
    @org.jetbrains.annotations.NotNull()
    private static final io.reactivex.subjects.Subject<java.lang.Object> rxBus = null;
    public static final com.example.lib_common.utils.RxBus INSTANCE = null;
    
    /**
     * * 用于保存RxBus事件的所有订阅，并在需要时正确的取消订阅。
     */
    private final java.util.HashMap<java.lang.Object, io.reactivex.disposables.CompositeDisposable> getDisposablesMap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.Subject<java.lang.Object> getRxBus() {
        return null;
    }
    
    /**
     * * 向RxBus发送一个事件，这个事件可以来自任意一个线程
     */
    public final void send(@org.jetbrains.annotations.NotNull()
    java.lang.Object event) {
    }
    
    /**
     * * 订阅特定类型T的事件。可以从任何线程调用
     */
    private final <T extends java.lang.Object>io.reactivex.Observable<T> observe() {
        return null;
    }
    
    /**
     * * 从RxBus事件中取消注册订阅者
     *     * 调用订阅的取消订阅方法
     */
    public final void unRegister(@org.jetbrains.annotations.NotNull()
    java.lang.Object disposable) {
    }
    
    /**
     * * internal修饰符 只有在相同模块中才能使用
     */
    public final void register$lib_common_debug(@org.jetbrains.annotations.NotNull()
    java.lang.Object disposable, @org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable composite) {
    }
    
    private RxBus() {
        super();
    }
}