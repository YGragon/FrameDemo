package com.example.lib_common.http;

import java.lang.System;

/**
 * * 错误异常
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/lib_common/http/ApiException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "throwable", "", "code", "", "(Ljava/lang/Throwable;I)V", "message", "", "(Ljava/lang/String;)V", "Ljava/lang/Integer;", "lib_common_debug"})
public final class ApiException extends java.lang.RuntimeException {
    private java.lang.Integer code;
    
    public ApiException(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable, int code) {
        super();
    }
    
    public ApiException(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        super();
    }
}