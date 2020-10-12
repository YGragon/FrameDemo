package com.example.lib_common.utils.rxbus.bus;

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
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001J$\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eJ$\u0010\t\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eJ\u001e\u0010\t\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0002J$\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eJ$\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eJ\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/example/lib_common/utils/rxbus/bus/RxBus;", "", "()V", "post", "", "tag", "", "event", "postSticky", "receive", "fragment", "Landroidx/fragment/app/Fragment;", "filter", "receiver", "Lcom/example/lib_common/utils/rxbus/bus/RxBusReceiver;", "activity", "Landroidx/fragment/app/FragmentActivity;", "Lio/reactivex/disposables/Disposable;", "receiveSticky", "setDispose", "Lcom/example/lib_common/utils/rxbus/lifecycle/HolderLifeFragment;", "disposable", "lib_common_debug"})
public final class RxBus {
    public static final com.example.lib_common.utils.rxbus.bus.RxBus INSTANCE = null;
    
    /**
     * * @param tag
     *     * @param event
     *     * 发送普通事件
     */
    public final void post(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.Object event) {
    }
    
    /**
     * * 普通接收
     *     * @param filter
     *     * @param receiver
     *     * @return
     */
    private final io.reactivex.disposables.Disposable receive(java.lang.String filter, com.example.lib_common.utils.rxbus.bus.RxBusReceiver<java.lang.Object> receiver) {
        return null;
    }
    
    /**
     * * 发送粘性事件
     *     * @param tag
     *     * @param event
     */
    public final void postSticky(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.Object event) {
    }
    
    /**
     * * 需要手动取消 dispose 否则容易内存泄露
     *     * @param filter
     *     * @param receiver
     *     * @return
     */
    private final io.reactivex.disposables.Disposable receiveSticky(java.lang.String filter, com.example.lib_common.utils.rxbus.bus.RxBusReceiver<java.lang.Object> receiver) {
        return null;
    }
    
    /**
     * * 接受普通事件
     *     * 自动取消注册
     *     * @param fragment
     *     * @param filter
     *     * @param receiver
     */
    public final void receive(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    java.lang.String filter, @org.jetbrains.annotations.NotNull()
    com.example.lib_common.utils.rxbus.bus.RxBusReceiver<java.lang.Object> receiver) {
    }
    
    /**
     * * 接受普通事件
     *     * 自动取消注册
     *     * @param activity
     *     * @param filter
     *     * @param receiver
     */
    public final void receive(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String filter, @org.jetbrains.annotations.NotNull()
    com.example.lib_common.utils.rxbus.bus.RxBusReceiver<java.lang.Object> receiver) {
    }
    
    /**
     * * 接受粘性事件
     *     * 自动取消注册
     *     * @param fragment
     *     * @param filter
     *     * @param receiver
     */
    public final void receiveSticky(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    java.lang.String filter, @org.jetbrains.annotations.NotNull()
    com.example.lib_common.utils.rxbus.bus.RxBusReceiver<java.lang.Object> receiver) {
    }
    
    /**
     * *
     *     * @param activity
     *     * @param filter
     *     * @param receiver
     */
    public final void receiveSticky(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String filter, @org.jetbrains.annotations.NotNull()
    com.example.lib_common.utils.rxbus.bus.RxBusReceiver<java.lang.Object> receiver) {
    }
    
    private final void setDispose(com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment fragment, io.reactivex.disposables.Disposable disposable) {
    }
    
    private RxBus() {
        super();
    }
}