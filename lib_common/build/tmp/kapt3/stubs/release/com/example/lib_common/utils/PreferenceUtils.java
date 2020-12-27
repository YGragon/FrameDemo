package com.example.lib_common.utils;

import java.lang.System;

/**
 * SP 工具类
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000eJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0001J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001c"}, d2 = {"Lcom/example/lib_common/utils/PreferenceUtils;", "", "()V", "name", "", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "clear", "", "getBoolean", "", "key", "default", "getFloat", "", "getInt", "", "getLong", "", "getString", "getValue", "remove", "saveValue", "value", "lib_common_release"})
public final class PreferenceUtils {
    private static final java.lang.String name = null;
    private static final kotlin.Lazy prefs$delegate = null;
    public static final com.example.lib_common.utils.PreferenceUtils INSTANCE = null;
    
    private final android.content.SharedPreferences getPrefs() {
        return null;
    }
    
    /**
     * 获取存放数据
     * @return 值
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public final java.lang.Object getValue(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.Object p1_772401952) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getString(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String p1_772401952) {
        return null;
    }
    
    public final int getInt(@org.jetbrains.annotations.NotNull()
    java.lang.String key, int p1_772401952) {
        return 0;
    }
    
    public final long getLong(@org.jetbrains.annotations.NotNull()
    java.lang.String key, long p1_772401952) {
        return 0L;
    }
    
    public final boolean getBoolean(@org.jetbrains.annotations.NotNull()
    java.lang.String key, boolean p1_772401952) {
        return false;
    }
    
    public final float getFloat(@org.jetbrains.annotations.NotNull()
    java.lang.String key, float p1_772401952) {
        return 0.0F;
    }
    
    /**
     * 存放SharedPreferences
     * @param key 键
     * @param value 值
     */
    public final void saveValue(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.Object value) {
    }
    
    /**
     * 清除
     */
    public final void clear() {
    }
    
    /**
     * 删除某Key的值
     */
    public final void remove(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    private PreferenceUtils() {
        super();
    }
}