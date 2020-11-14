package com.example.lib_common.manager

import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.constant.RouterPath

/**
 * Created by Aller on 2020/11/14.
 */
object ARouterManager {

    fun toActivity(routerPath:String){
        ARouter.getInstance().build(routerPath).navigation()
    }

    fun toParamsActivity(key:String, value:String,routerPath:String){
        ARouter.getInstance().build(routerPath).withObject(key,value).navigation()
    }
}