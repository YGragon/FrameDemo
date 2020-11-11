package com.example.lib_common.utils;

import java.lang.System;

/**
 * activity 管理工具类
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0007H\u0007J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\fJ\u0006\u0010\r\u001a\u00020\u0007J\'\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u00052\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\f\u00a2\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/lib_common/utils/ActivityManager;", "", "()V", "activityStack", "Ljava/util/Stack;", "Landroidx/appcompat/app/AppCompatActivity;", "addActivity", "", "activity", "appExit", "finishActivity", "clazz", "Ljava/lang/Class;", "finishAllActivity", "getActivity", "A", "(Ljava/lang/Class;)Landroidx/appcompat/app/AppCompatActivity;", "peekActivity", "removeActivity", "Companion", "lib_common_debug"})
public final class ActivityManager {
    
    /**
     * 保存 Activity 对象的堆栈
     */
    private final java.util.Stack<androidx.appcompat.app.AppCompatActivity> activityStack = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy instance$delegate = null;
    public static final com.example.lib_common.utils.ActivityManager.Companion Companion = null;
    
    /**
     * 添加 Activity 到堆栈
     *
     * @param activity Activity 对象
     */
    public final void addActivity(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity activity) {
    }
    
    /**
     * 将 Activity 从堆栈移除
     *
     * @param activity Activity 对象
     */
    public final void removeActivity(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity activity) {
    }
    
    /**
     * 结束指定 Activity
     *
     * @param activity Activity 对象
     */
    public final void finishActivity(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AppCompatActivity activity) {
    }
    
    /**
     * 结束指定 Activity
     *
     * @param cls Activity 类对象
     */
    public final void finishActivity(@org.jetbrains.annotations.NotNull()
    java.lang.Class<? extends androidx.appcompat.app.AppCompatActivity> clazz) {
    }
    
    /**
     * 获取栈顶的 Activity
     *
     * @return 栈顶的 Activity 对象
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.appcompat.app.AppCompatActivity peekActivity() {
        return null;
    }
    
    /**
     * 根据类，获取 Activity 对象
     *
     * @param clazz Activity 类
     * @param <T> Activity 类型
     *
     * @return Activity对象
     */
    @org.jetbrains.annotations.Nullable()
    public final <A extends androidx.appcompat.app.AppCompatActivity>A getActivity(@org.jetbrains.annotations.NotNull()
    java.lang.Class<? extends androidx.appcompat.app.AppCompatActivity> clazz) {
        return null;
    }
    
    /**
     * 结束所有Activity
     */
    public final void finishAllActivity() {
    }
    
    /**
     * 退出应用程序
     */
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public final void appExit() {
    }
    
    public ActivityManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/example/lib_common/utils/ActivityManager$Companion;", "", "()V", "instance", "Lcom/example/lib_common/utils/ActivityManager;", "getInstance", "()Lcom/example/lib_common/utils/ActivityManager;", "instance$delegate", "Lkotlin/Lazy;", "lib_common_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.lib_common.utils.ActivityManager getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}