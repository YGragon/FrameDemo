package com.example.lib_common.utils;

import java.lang.System;

/**
 * 应用工具类
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/example/lib_common/utils/AppUtils;", "", "()V", "Companion", "lib_common_release"})
public final class AppUtils {
    private static final boolean DEBUG = false;
    private static final java.lang.String TAG = null;
    public static final com.example.lib_common.utils.AppUtils.Companion Companion = null;
    
    private AppUtils() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0006J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0006H\u0007J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/example/lib_common/utils/AppUtils$Companion;", "", "()V", "DEBUG", "", "TAG", "", "maxMemory", "", "getMaxMemory", "()J", "sdkVersion", "", "getSdkVersion", "()I", "getDeviceUsableMemory", "context", "Landroid/content/Context;", "getMobileModel", "getSign", "pkgName", "getVerCode", "getVerName", "hexDigest", "paramArrayOfByte", "", "isAppExist", "lib_common_release"})
    public static final class Companion {
        
        /**
         * 得到软件版本号
         *
         * @param context 上下文
         * @return 当前版本Code
         */
        public final int getVerCode(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return 0;
        }
        
        public final long getMaxMemory() {
            return 0L;
        }
        
        /**
         * 得到软件显示版本信息
         *
         * @param context 上下文
         * @return 当前版本信息
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVerName(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        /**
         * 获取应用签名
         *
         * @param context 上下文
         * @param pkgName 包名
         * @return 返回应用的签名
         */
        @org.jetbrains.annotations.Nullable()
        @android.annotation.SuppressLint(value = {"PackageManagerGetSignatures"})
        public final java.lang.String getSign(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String pkgName) {
            return null;
        }
        
        /**
         * 将签名字符串转换成需要的32位签名
         *
         * @param paramArrayOfByte 签名byte数组
         * @return 32位签名字符串
         */
        private final java.lang.String hexDigest(byte[] paramArrayOfByte) {
            return null;
        }
        
        /**
         * 获取设备的可用内存大小
         *
         * @param context 应用上下文对象context
         * @return 当前内存大小
         */
        public final int getDeviceUsableMemory(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMobileModel() {
            return null;
        }
        
        public final int getSdkVersion() {
            return 0;
        }
        
        public final boolean isAppExist(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.Nullable()
        java.lang.String pkgName) {
            return false;
        }
        
        private Companion() {
            super();
        }
    }
}