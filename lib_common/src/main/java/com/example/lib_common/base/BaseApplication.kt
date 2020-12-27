package com.example.lib_common.base

import android.app.Application
import android.content.Context
import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper
import com.example.lib_common.db.AppDataBase
import com.example.lib_common.manager.ARouterManager
import com.example.lib_common.manager.BuglyManager
import com.example.lib_common.utils.LogUtils
import kotlin.properties.Delegates



/**
 * BaseApplication
 */
abstract class BaseApplication:Application() {
    private val sTAG:String = BaseApplication::class.java.simpleName
    companion object {
        var context: Context by Delegates.notNull()
            private set

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        AppDataBase.instance(this)
        // 初始化 ARouter
        ARouterManager.init(this)

        // Bugly 崩溃上传和升级
        BuglyManager.init(this)

        // 侧滑返回
        BGASwipeBackHelper.init(this, null)

        // log 日志初始化
        LogUtils.init()

    }


    // 初始化数据
    abstract fun initData(application: Application)
}