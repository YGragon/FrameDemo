package com.example.lib_common.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"registerInBus", "", "Lio/reactivex/disposables/Disposable;", "disposable", "", "lib_common_debug"})
public final class RxBusKt {
    
    /**
     * * 注册订阅以便以后正确注销它以避免内存泄漏
     * * @param disposable 拥有此订阅的订阅对象
     */
    public static final void registerInBus(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable $receiver, @org.jetbrains.annotations.NotNull()
    java.lang.Object disposable) {
    }
}