package com.example.lib_common.base;

import java.lang.System;

/**
 * * ViewModel 基类
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H\u0014\u00a8\u0006\u0007"}, d2 = {"Lcom/example/lib_common/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "getOwnerView", "Landroidx/lifecycle/LifecycleOwner;", "onCleared", "", "lib_common_debug"})
public abstract class BaseViewModel extends androidx.lifecycle.ViewModel {
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LifecycleOwner getOwnerView();
    
    public BaseViewModel() {
        super();
    }
}