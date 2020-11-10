package com.example.lib_common.http.interceptor;

import java.lang.System;

/**
 * 解决 AS log 日志换行问题
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/lib_common/http/interceptor/LogCatStrategy;", "Lcom/orhanobut/logger/LogStrategy;", "()V", "last", "", "log", "", "priority", "tag", "", "message", "randomKey", "lib_common_release"})
public final class LogCatStrategy implements com.orhanobut.logger.LogStrategy {
    private int last;
    
    @java.lang.Override()
    public void log(int priority, @org.jetbrains.annotations.Nullable()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final java.lang.String randomKey() {
        return null;
    }
    
    public LogCatStrategy() {
        super();
    }
}