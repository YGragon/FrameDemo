package com.example.lib_common.http.response;

import java.lang.System;

/**
 * 基本 Gank 服务器返回
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/example/lib_common/http/response/BaseGankResponse;", "T", "", "error", "", "results", "(ZLjava/lang/Object;)V", "getError", "()Z", "getResults", "()Ljava/lang/Object;", "Ljava/lang/Object;", "lib_common_release"})
public final class BaseGankResponse<T extends java.lang.Object> {
    private final boolean error = false;
    private final T results = null;
    
    public final boolean getError() {
        return false;
    }
    
    public final T getResults() {
        return null;
    }
    
    public BaseGankResponse(boolean error, T results) {
        super();
    }
}