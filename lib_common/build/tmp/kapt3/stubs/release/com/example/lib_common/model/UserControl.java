package com.example.lib_common.model;

import java.lang.System;

/**
 * 用户控制中心
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/example/lib_common/model/UserControl;", "", "()V", "userDao", "Lcom/example/lib_common/db/dao/UserDao;", "getUserDao", "()Lcom/example/lib_common/db/dao/UserDao;", "getUserByName", "Lcom/example/lib_common/model/User;", "name", "", "isLogin", "", "setUser", "", "userInfo", "lib_common_release"})
public final class UserControl {
    @org.jetbrains.annotations.NotNull()
    private static final com.example.lib_common.db.dao.UserDao userDao = null;
    public static final com.example.lib_common.model.UserControl INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.lib_common.db.dao.UserDao getUserDao() {
        return null;
    }
    
    public final boolean isLogin() {
        return false;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    com.example.lib_common.model.User userInfo) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.lib_common.model.User getUserByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    private UserControl() {
        super();
    }
}