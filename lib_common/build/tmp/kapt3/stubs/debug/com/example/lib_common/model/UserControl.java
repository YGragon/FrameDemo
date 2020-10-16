package com.example.lib_common.model;

import java.lang.System;

/**
 * 用户控制中心
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/lib_common/model/UserControl;", "", "()V", "user", "Lcom/example/lib_common/model/User;", "getUser", "isLogin", "", "setUser", "", "userInfo", "lib_common_debug"})
public final class UserControl {
    private static com.example.lib_common.model.User user;
    public static final com.example.lib_common.model.UserControl INSTANCE = null;
    
    public final boolean isLogin() {
        return false;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    com.example.lib_common.model.User userInfo) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.lib_common.model.User getUser() {
        return null;
    }
    
    private UserControl() {
        super();
    }
}