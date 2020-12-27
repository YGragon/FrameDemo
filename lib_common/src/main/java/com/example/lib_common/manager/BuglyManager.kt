package com.example.lib_common.manager

import android.app.Application

/**
 * 崩溃上报管理类
 */
object BuglyManager {
    fun init(application: Application){
        // Beta.autoCheckUpgrade = true
        // TODO 更换 bugly 中的 app_id
        // Bugly.init(this, "app_id", false)
    }
}