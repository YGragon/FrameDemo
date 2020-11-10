package com.example.lib_common.utils;

import java.lang.System;

/**
 * 网络监测工具
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/example/lib_common/utils/NetworkUtil;", "", "()V", "Companion", "lib_common_release"})
public final class NetworkUtil {
    private static int NET_CNNT_BAIDU_OK;
    private static int NET_CNNT_BAIDU_TIMEOUT;
    private static int NET_NOT_PREPARE;
    private static int NET_ERROR;
    private static final int TIMEOUT = 0;
    public static final com.example.lib_common.utils.NetworkUtil.Companion Companion = null;
    
    public NetworkUtil() {
        super();
    }
    
    /**
     * check NetworkAvailable
     *
     * @param context
     * @return
     */
    public static final boolean isNetworkAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * 得到ip地址
     *
     * @return
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getLocalIpAddress() {
        return null;
    }
    
    /**
     * ping "http://www.baidu.com"
     *
     * @return
     */
    private static final boolean pingNetWork() {
        return false;
    }
    
    /**
     * check is3G
     *
     * @param context
     * @return boolean
     */
    public static final boolean is3G(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * isWifi
     *
     * @param context
     * @return boolean
     */
    public static final boolean isWifi(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * is2G
     *
     * @param context
     * @return boolean
     */
    public static final boolean is2G(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * is wifi on
     */
    public static final boolean isWifiEnabled(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u001d\u001a\u00020\u0016H\u0003R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/lib_common/utils/NetworkUtil$Companion;", "", "()V", "NET_CNNT_BAIDU_OK", "", "getNET_CNNT_BAIDU_OK", "()I", "setNET_CNNT_BAIDU_OK", "(I)V", "NET_CNNT_BAIDU_TIMEOUT", "getNET_CNNT_BAIDU_TIMEOUT", "setNET_CNNT_BAIDU_TIMEOUT", "NET_ERROR", "getNET_ERROR", "setNET_ERROR", "NET_NOT_PREPARE", "getNET_NOT_PREPARE", "setNET_NOT_PREPARE", "TIMEOUT", "getLocalIpAddress", "", "is2G", "", "context", "Landroid/content/Context;", "is3G", "isNetworkAvailable", "isWifi", "isWifiEnabled", "pingNetWork", "lib_common_release"})
    public static final class Companion {
        
        public final int getNET_CNNT_BAIDU_OK() {
            return 0;
        }
        
        public final void setNET_CNNT_BAIDU_OK(int p0) {
        }
        
        public final int getNET_CNNT_BAIDU_TIMEOUT() {
            return 0;
        }
        
        public final void setNET_CNNT_BAIDU_TIMEOUT(int p0) {
        }
        
        public final int getNET_NOT_PREPARE() {
            return 0;
        }
        
        public final void setNET_NOT_PREPARE(int p0) {
        }
        
        public final int getNET_ERROR() {
            return 0;
        }
        
        public final void setNET_ERROR(int p0) {
        }
        
        /**
         * check NetworkAvailable
         *
         * @param context
         * @return
         */
        public final boolean isNetworkAvailable(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return false;
        }
        
        /**
         * 得到ip地址
         *
         * @return
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLocalIpAddress() {
            return null;
        }
        
        /**
         * ping "http://www.baidu.com"
         *
         * @return
         */
        private final boolean pingNetWork() {
            return false;
        }
        
        /**
         * check is3G
         *
         * @param context
         * @return boolean
         */
        public final boolean is3G(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return false;
        }
        
        /**
         * isWifi
         *
         * @param context
         * @return boolean
         */
        public final boolean isWifi(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return false;
        }
        
        /**
         * is2G
         *
         * @param context
         * @return boolean
         */
        public final boolean is2G(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return false;
        }
        
        /**
         * is wifi on
         */
        public final boolean isWifiEnabled(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return false;
        }
        
        private Companion() {
            super();
        }
    }
}