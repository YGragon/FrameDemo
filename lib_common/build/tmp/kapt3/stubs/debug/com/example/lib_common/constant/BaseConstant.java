package com.example.lib_common.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/example/lib_common/constant/BaseConstant;", "", "()V", "CAMERA_REQUEST_CODE", "", "getCAMERA_REQUEST_CODE", "()I", "EXIT_ACTION", "", "getEXIT_ACTION", "()Ljava/lang/String;", "IS_LOGIN_KEY", "getIS_LOGIN_KEY", "IS_LOGIN_TRUE", "", "getIS_LOGIN_TRUE", "()Z", "TODO_TYPE_FUN", "getTODO_TYPE_FUN", "TODO_TYPE_LIFE", "getTODO_TYPE_LIFE", "TODO_TYPE_WORK", "getTODO_TYPE_WORK", "USER_NAME", "getUSER_NAME", "filePath", "getFilePath", "setFilePath", "(Ljava/lang/String;)V", "lib_common_debug"})
public final class BaseConstant {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String EXIT_ACTION = "action.exit";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String filePath;
    private static final int CAMERA_REQUEST_CODE = 1000;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String IS_LOGIN_KEY = "is_login";
    private static final boolean IS_LOGIN_TRUE = true;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String USER_NAME = "user_name";
    private static final int TODO_TYPE_WORK = 1;
    private static final int TODO_TYPE_LIFE = 2;
    private static final int TODO_TYPE_FUN = 3;
    public static final com.example.lib_common.constant.BaseConstant INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEXIT_ACTION() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilePath() {
        return null;
    }
    
    public final void setFilePath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getCAMERA_REQUEST_CODE() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIS_LOGIN_KEY() {
        return null;
    }
    
    public final boolean getIS_LOGIN_TRUE() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUSER_NAME() {
        return null;
    }
    
    public final int getTODO_TYPE_WORK() {
        return 0;
    }
    
    public final int getTODO_TYPE_LIFE() {
        return 0;
    }
    
    public final int getTODO_TYPE_FUN() {
        return 0;
    }
    
    private BaseConstant() {
        super();
    }
}