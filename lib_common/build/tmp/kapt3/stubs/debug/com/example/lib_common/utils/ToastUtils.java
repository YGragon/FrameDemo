package com.example.lib_common.utils;

import java.lang.System;

/**
 * Toast 工具类
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/lib_common/utils/ToastUtils;", "", "()V", "TOAST", "Landroid/widget/Toast;", "show", "", "context", "Landroid/content/Context;", "resourceID", "", "duration", "text", "", "lib_common_debug"})
public final class ToastUtils {
    private static android.widget.Toast TOAST;
    public static final com.example.lib_common.utils.ToastUtils INSTANCE = null;
    
    public final void show(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int resourceID) {
    }
    
    public final void show(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void show(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int resourceID, int duration) {
    }
    
    public final void show(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String text, int duration) {
    }
    
    private ToastUtils() {
        super();
    }
}