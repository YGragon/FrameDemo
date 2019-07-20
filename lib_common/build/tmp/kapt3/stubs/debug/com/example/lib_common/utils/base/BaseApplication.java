package com.example.lib_common.utils.base;

import java.lang.System;

/**
 * * Created by Aller on 2019/7/20.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/example/lib_common/utils/base/BaseApplication;", "Landroid/app/Application;", "()V", "initData", "", "isDebug", "", "onCreate", "lib_common_debug"})
public abstract class BaseApplication extends android.app.Application {
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    private final boolean isDebug() {
        return false;
    }
    
    public abstract void initData();
    
    public BaseApplication() {
        super();
    }
}