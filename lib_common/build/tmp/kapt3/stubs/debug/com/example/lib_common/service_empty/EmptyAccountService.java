package com.example.lib_common.service_empty;

import java.lang.System;

/**
 * 空服务实现
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/example/lib_common/service_empty/EmptyAccountService;", "Lcom/example/lib_common/service/user_center/IAccountService;", "()V", "getAccountId", "", "isLogin", "", "lib_common_debug"})
public final class EmptyAccountService implements com.example.lib_common.service.user_center.IAccountService {
    
    @java.lang.Override()
    public boolean isLogin() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getAccountId() {
        return null;
    }
    
    public EmptyAccountService() {
        super();
    }
}