package com.example.lib_common.manager

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * 路由管理类
 */
object ARouterManager {

    fun init(application: Application){
        // 初始化 ARouter
        ARouter.init(application)
    }

    fun toActivity(routerPath:String){
        ARouter.getInstance().build(routerPath).navigation()
    }

    fun toParamsActivity(key:String, value:String,routerPath:String){
        ARouter.getInstance().build(routerPath).withObject(key,value).navigation()
    }
}