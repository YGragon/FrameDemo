package com.example.lib_common.base

import android.app.Application
import android.content.Context
import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.BuildConfig
import com.example.lib_common.db.AppDataBase
import com.example.lib_common.http.interceptor.LogCatStrategy
import com.tencent.bugly.Bugly
import com.tencent.bugly.beta.Beta
import kotlin.properties.Delegates
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.orhanobut.logger.FormatStrategy



/**
 * Created by Aller on 2019/7/20.
 */
abstract class BaseApplication:Application() {
    private val sTAG:String = BaseApplication::class.java.simpleName
    companion object {
        var context: Context by Delegates.notNull()
            private set

        fun isDebug(): Boolean {
            return BuildConfig.DEBUG
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        AppDataBase.instance(this)
        // 初始化 ARouter
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)
        // Bugly 崩溃上传和升级
        Beta.autoCheckUpgrade = true
        // TODO 更换 bugly 中的 app_id
        Bugly.init(this, "app_id", false)
        // 侧滑返回
        BGASwipeBackHelper.init(this, null)
        // log 日志初始化
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
            .methodCount(0)         // 方法栈打印的个数，默认是2
            .methodOffset(7)        // 设置调用堆栈的函数偏移值，0的话则从打印该Log的函数开始输出堆栈信息，默认是0
            .logStrategy(LogCatStrategy())
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }


    // 初始化数据
    abstract fun initData(application: Application)
}