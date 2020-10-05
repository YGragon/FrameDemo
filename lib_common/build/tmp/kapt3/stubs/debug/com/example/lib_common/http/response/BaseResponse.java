package com.example.lib_common.http.response;

import java.lang.System;

/**
 * * 基本的服务器返回
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\bR\u0013\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/lib_common/http/response/BaseResponse;", "T", "", "errorCode", "", "errorMsg", "", "data", "(ILjava/lang/String;Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "lib_common_debug"})
public final class BaseResponse<T extends java.lang.Object> {
    private final int errorCode = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String errorMsg = null;
    private final T data = null;
    
    public final int getErrorCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getErrorMsg() {
        return null;
    }
    
    public final T getData() {
        return null;
    }
    
    public BaseResponse(int errorCode, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMsg, T data) {
        super();
    }
}