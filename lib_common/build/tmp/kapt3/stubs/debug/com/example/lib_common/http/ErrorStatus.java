package com.example.lib_common.http;

import java.lang.System;

/**
 * * 错误码
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/lib_common/http/ErrorStatus;", "", "()V", "API_ERROR", "", "NETWORK_ERROR", "SERVER_ERROR", "SUCCESS", "UNKNOWN_ERROR", "lib_common_debug"})
public final class ErrorStatus {
    
    /**
     * * 响应成功
     */
    public static final int SUCCESS = 0;
    
    /**
     * * 未知错误
     */
    public static final int UNKNOWN_ERROR = 1002;
    
    /**
     * * 服务器内部错误
     */
    public static final int SERVER_ERROR = 1003;
    
    /**
     * * 网络连接超时
     */
    public static final int NETWORK_ERROR = 1004;
    
    /**
     * * API解析异常（或者第三方数据结构更改）等其他异常
     */
    public static final int API_ERROR = 1005;
    public static final com.example.lib_common.http.ErrorStatus INSTANCE = null;
    
    private ErrorStatus() {
        super();
    }
}