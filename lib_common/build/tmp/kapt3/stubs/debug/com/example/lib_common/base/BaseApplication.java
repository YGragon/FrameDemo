package com.example.lib_common.base;

import java.lang.System;

/**
 * * Created by Aller on 2019/7/20.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/example/lib_common/base/BaseApplication;", "Landroid/app/Application;", "()V", "initData", "", "onCreate", "Companion", "lib_common_debug"})
public abstract class BaseApplication extends android.app.Application {
    private static final java.lang.String TAG = "BaseApplication";
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.properties.ReadWriteProperty context$delegate = null;
    public static final com.example.lib_common.base.BaseApplication.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public abstract void initData();
    
    public BaseApplication() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/example/lib_common/base/BaseApplication$Companion;", "", "()V", "TAG", "", "<set-?>", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context$delegate", "Lkotlin/properties/ReadWriteProperty;", "isDebug", "", "lib_common_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        private final void setContext(android.content.Context p0) {
        }
        
        public final boolean isDebug() {
            return false;
        }
        
        private Companion() {
            super();
        }
    }
}