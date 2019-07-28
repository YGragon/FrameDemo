package com.example.lib_common.base

import android.app.Application
import android.content.Context
import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.BuildConfig
import com.tencent.bugly.Bugly
import com.tencent.bugly.beta.Beta
import com.tencent.bugly.crashreport.CrashReport
import kotlin.properties.Delegates

/**
 * Created by Aller on 2019/7/20.
 */
abstract class BaseApplication:Application() {
    companion object {
        private val TAG = "BaseApplication"
        var context: Context by Delegates.notNull()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        // 初始化 ARouter
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)
        // Bugly 崩溃上传和升级
        Beta.autoCheckUpgrade = true
        // TODO 更换 bugly 中的 app_id
        Bugly.init(this, "app_id", true)
        // 侧滑返回
        BGASwipeBackHelper.init(this, null)
    }

    private fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }

    // 初始化数据
    abstract fun initData()
}