package com.example.lib_common.service

import com.example.lib_common.service.user_center.IAccountService
import com.example.lib_common.service_empty.EmptyAccountService



/**
 * 服务工厂类：用于组件和组件之间通讯
 */
class ServiceFactory {
    private var mAccountService: IAccountService? = null

    /**
     * 通过静态内部类方式实现 ServiceFactory 的单例
     */
    companion object {
        fun getInstance() = ServiceFactory()
    }


    /**
     * 接收 Login 组件实现的 Service 实例
     */
    fun setAccountService(accountService: IAccountService) {
        this.mAccountService = accountService
    }

    /**
     * 返回 Login 组件的 Service 实例
     */
    fun getAccountService(): IAccountService {
        if (mAccountService == null) {
            mAccountService = EmptyAccountService()
        }
        return mAccountService as IAccountService
    }
}