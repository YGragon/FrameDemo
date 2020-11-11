package com.example.lib_common.service;

import java.lang.System;

/**
 * 服务工厂类：用于组件和组件之间通讯
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/lib_common/service/ServiceFactory;", "", "()V", "mAccountService", "Lcom/example/lib_common/service/user_center/IAccountService;", "getAccountService", "setAccountService", "", "accountService", "Companion", "lib_common_debug"})
public final class ServiceFactory {
    private com.example.lib_common.service.user_center.IAccountService mAccountService;
    public static final com.example.lib_common.service.ServiceFactory.Companion Companion = null;
    
    /**
     * 接收 Login 组件实现的 Service 实例
     */
    public final void setAccountService(@org.jetbrains.annotations.NotNull()
    com.example.lib_common.service.user_center.IAccountService accountService) {
    }
    
    /**
     * 返回 Login 组件的 Service 实例
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.lib_common.service.user_center.IAccountService getAccountService() {
        return null;
    }
    
    public ServiceFactory() {
        super();
    }
    
    /**
     * 通过静态内部类方式实现 ServiceFactory 的单例
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/lib_common/service/ServiceFactory$Companion;", "", "()V", "getInstance", "Lcom/example/lib_common/service/ServiceFactory;", "lib_common_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.lib_common.service.ServiceFactory getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}