package com.longyi.module_share

import android.app.Application
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.service.ServiceFactory
import com.mob.MobSDK


/**
 * 分享 app
 */
class ShareApplication : BaseApplication() {
    private val sTAG:String = ShareApplication::class.java.simpleName
    override fun initData(application: Application) {
        MobSDK.init(this)
        ServiceFactory.getInstance().setAccountService(AccountService())
    }
}