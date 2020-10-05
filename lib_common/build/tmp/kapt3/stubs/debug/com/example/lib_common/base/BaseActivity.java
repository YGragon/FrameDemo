package com.example.lib_common.base;

import java.lang.System;

/**
 * * Activity 基类
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H&J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u0016H\u0014J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0016J\u001e\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00142\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\u001e\u0010*\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00142\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J-\u0010+\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00142\u000e\u0010,\u001a\n\u0012\u0006\b\u0001\u0012\u00020)0-2\u0006\u0010.\u001a\u00020/H\u0016\u00a2\u0006\u0002\u00100J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u0016H\u0016J\u0010\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020\u0016H\u0016R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u00068"}, d2 = {"Lcom/example/lib_common/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcn/bingoogolapple/swipebacklayout/BGASwipeBackHelper$Delegate;", "Lpub/devrel/easypermissions/EasyPermissions$PermissionCallbacks;", "()V", "exitReceiver", "Lcom/example/lib_common/base/BaseActivity$ExitReceiver;", "mSwipeBackHelper", "Lcn/bingoogolapple/swipebacklayout/BGASwipeBackHelper;", "getMSwipeBackHelper", "()Lcn/bingoogolapple/swipebacklayout/BGASwipeBackHelper;", "setMSwipeBackHelper", "(Lcn/bingoogolapple/swipebacklayout/BGASwipeBackHelper;)V", "mToolbar", "Landroid/widget/Toolbar;", "getMToolbar", "()Landroid/widget/Toolbar;", "setMToolbar", "(Landroid/widget/Toolbar;)V", "getLayoutId", "", "initBroadcast", "", "initData", "initSwipeBackFinish", "initView", "isSupportSwipeBack", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPermissionsDenied", "requestCode", "perms", "", "", "onPermissionsGranted", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSwipeBackLayoutCancel", "onSwipeBackLayoutExecuted", "onSwipeBackLayoutSlide", "slideOffset", "", "setStatusBar", "ExitReceiver", "lib_common_debug"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity implements cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper.Delegate, pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks {
    @org.jetbrains.annotations.Nullable()
    private cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper mSwipeBackHelper;
    @org.jetbrains.annotations.Nullable()
    private android.widget.Toolbar mToolbar;
    private final com.example.lib_common.base.BaseActivity.ExitReceiver exitReceiver = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    protected final cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper getMSwipeBackHelper() {
        return null;
    }
    
    protected final void setMSwipeBackHelper(@org.jetbrains.annotations.Nullable()
    cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.widget.Toolbar getMToolbar() {
        return null;
    }
    
    protected final void setMToolbar(@org.jetbrains.annotations.Nullable()
    android.widget.Toolbar p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public abstract int getLayoutId();
    
    public abstract void initView();
    
    public abstract void initData();
    
    /**
     * * 退出 App 的广播
     */
    private final void initBroadcast() {
    }
    
    /**
     * * 设置状态栏颜色
     */
    public void setStatusBar() {
    }
    
    /**
     * * 初始化滑动返回。在 super.onCreate(savedInstanceState) 之前调用该方法
     */
    private final void initSwipeBackFinish() {
    }
    
    /**
     * * 是否支持滑动返回。这里在父类中默认返回 true 来支持滑动返回，如果某个界面不想支持滑动返回则重写该方法返回 false 即可
     *     *
     *     * @return
     */
    @java.lang.Override()
    public boolean isSupportSwipeBack() {
        return false;
    }
    
    /**
     * * 正在滑动返回
     *     *
     *     * @param slideOffset 从 0 到 1
     */
    @java.lang.Override()
    public void onSwipeBackLayoutSlide(float slideOffset) {
    }
    
    /**
     * * 没达到滑动返回的阈值，取消滑动返回动作，回到默认状态
     */
    @java.lang.Override()
    public void onSwipeBackLayoutCancel() {
    }
    
    /**
     * * 滑动返回执行完毕，销毁当前 Activity
     */
    @java.lang.Override()
    public void onSwipeBackLayoutExecuted() {
    }
    
    /**
     * * 重写要申请权限的Activity或者Fragment的onRequestPermissionsResult()方法，
     *     * 在里面调用EasyPermissions.onRequestPermissionsResult()，实现回调。
     *     *
     *     * @param requestCode  权限请求的识别码
     *     * @param permissions  申请的权限
     *     * @param grantResults 授权结果
     */
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    /**
     * * 当权限被成功申请的时候执行回调
     *     *
     *     * @param requestCode 权限请求的识别码
     *     * @param perms       申请的权限的名字
     */
    @java.lang.Override()
    public void onPermissionsGranted(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> perms) {
    }
    
    /**
     * * 当权限申请失败的时候执行的回调
     *     *
     *     * @param requestCode 权限请求的识别码
     *     * @param perms       申请的权限的名字
     */
    @java.lang.Override()
    public void onPermissionsDenied(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> perms) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.NotNull()
    android.view.KeyEvent event) {
        return false;
    }
    
    public BaseActivity() {
        super();
    }
    
    /**
     * * 接收到全局广播，关闭全部 activity
     */
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/lib_common/base/BaseActivity$ExitReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/example/lib_common/base/BaseActivity;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "lib_common_debug"})
    public final class ExitReceiver extends android.content.BroadcastReceiver {
        
        @java.lang.Override()
        public void onReceive(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.content.Intent intent) {
        }
        
        public ExitReceiver() {
            super();
        }
    }
}