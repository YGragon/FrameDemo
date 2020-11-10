package com.example.lib_common.service.user_center;

import java.lang.System;

/**
 * 用户中心服务
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/lib_common/service/user_center/IAccountService;", "", "getAccountId", "", "isLogin", "", "lib_common_release"})
public abstract interface IAccountService {
    
    /**
     * 是否已经登录
     *
     * @return
     */
    public abstract boolean isLogin();
    
    /**
     * 获取登录用户的 AccountId
     *
     * @return
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getAccountId();
}