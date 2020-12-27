package com.example.lib_common.utils;

import java.lang.System;

/**
 * Glide 加载工具类
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/example/lib_common/utils/GlideUtils;", "", "()V", "showCircleImage", "", "context", "Landroid/content/Context;", "mImageView", "Landroid/widget/ImageView;", "url", "", "placeholder", "", "error", "showImageView", "lib_common_release"})
public final class GlideUtils {
    public static final com.example.lib_common.utils.GlideUtils INSTANCE = null;
    
    /**
     * 显示图片
     */
    public final void showImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView mImageView, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    /**
     * 显示图片-placeholder 自定义占位图
     */
    private final void showImageView(android.content.Context context, android.widget.ImageView mImageView, java.lang.String url, int placeholder) {
    }
    
    /**
     * 显示图片-placeholder 自定义占位图 -error自定义异常占位图
     */
    private final void showImageView(android.content.Context context, android.widget.ImageView mImageView, java.lang.String url, int placeholder, int error) {
    }
    
    /**
     * 显示圆形图片
     */
    public final void showCircleImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView mImageView, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    /**
     * 显示圆形图片-placeholder 自定义占位图
     */
    private final void showCircleImage(android.content.Context context, android.widget.ImageView mImageView, java.lang.String url, int placeholder) {
    }
    
    /**
     * 显示圆形图片-placeholder 自定义占位图 -error自定义异常占位图
     */
    private final void showCircleImage(android.content.Context context, android.widget.ImageView mImageView, java.lang.String url, int placeholder, int error) {
    }
    
    private GlideUtils() {
        super();
    }
}