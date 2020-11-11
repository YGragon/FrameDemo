package com.example.lib_common.base;

import java.lang.System;

/**
 * Activity 基类
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H&J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0011H\u0014J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006&"}, d2 = {"Lcom/example/lib_common/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcn/bingoogolapple/swipebacklayout/BGASwipeBackHelper$Delegate;", "()V", "exitReceiver", "Lcom/example/lib_common/service/ExitReceiver;", "mSwipeBackHelper", "Lcn/bingoogolapple/swipebacklayout/BGASwipeBackHelper;", "mToolbar", "Landroid/widget/Toolbar;", "getMToolbar", "()Landroid/widget/Toolbar;", "setMToolbar", "(Landroid/widget/Toolbar;)V", "getLayoutId", "", "initBroadcast", "", "initData", "initSwipeBackFinish", "initView", "isSupportSwipeBack", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onSwipeBackLayoutCancel", "onSwipeBackLayoutExecuted", "onSwipeBackLayoutSlide", "slideOffset", "", "setStatusBar", "lib_common_debug"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity implements cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper.Delegate {
    private cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper mSwipeBackHelper;
    @org.jetbrains.annotations.Nullable()
    private android.widget.Toolbar mToolbar;
    private final com.example.lib_common.service.ExitReceiver exitReceiver = null;
    private java.util.HashMap _$_findViewCache;
    
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
     * 退出 App 的广播
     */
    private final void initBroadcast() {
    }
    
    /**
     * 设置状态栏颜色
     */
    public void setStatusBar() {
    }
    
    /**
     * 初始化滑动返回。在 super.onCreate(savedInstanceState) 之前调用该方法
     */
    private final void initSwipeBackFinish() {
    }
    
    /**
     * 是否支持滑动返回。这里在父类中默认返回 true 来支持滑动返回，如果某个界面不想支持滑动返回则重写该方法返回 false 即可
     *
     * @return
     */
    @java.lang.Override()
    public boolean isSupportSwipeBack() {
        return false;
    }
    
    /**
     * 正在滑动返回
     *
     * @param slideOffset 从 0 到 1
     */
    @java.lang.Override()
    public void onSwipeBackLayoutSlide(float slideOffset) {
    }
    
    /**
     * 没达到滑动返回的阈值，取消滑动返回动作，回到默认状态
     */
    @java.lang.Override()
    public void onSwipeBackLayoutCancel() {
    }
    
    /**
     * 滑动返回执行完毕，销毁当前 Activity
     */
    @java.lang.Override()
    public void onSwipeBackLayoutExecuted() {
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
}