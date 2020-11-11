package com.example.lib_common.http.exception;

import java.lang.System;

/**
 * 异常处理
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/example/lib_common/http/exception/ExceptionHandle;", "", "()V", "Companion", "lib_common_debug"})
public final class ExceptionHandle {
    private static int errorCode;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String errorMsg;
    public static final com.example.lib_common.http.exception.ExceptionHandle.Companion Companion = null;
    
    public ExceptionHandle() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/example/lib_common/http/exception/ExceptionHandle$Companion;", "", "()V", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "handleException", "e", "", "lib_common_debug"})
    public static final class Companion {
        
        public final int getErrorCode() {
            return 0;
        }
        
        public final void setErrorCode(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getErrorMsg() {
            return null;
        }
        
        public final void setErrorMsg(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String handleException(@org.jetbrains.annotations.NotNull()
        java.lang.Throwable e) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}