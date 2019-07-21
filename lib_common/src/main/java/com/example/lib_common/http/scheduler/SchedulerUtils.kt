package com.example.lib_common.http.scheduler

/**
 * 线程调度工具类
 */
object SchedulerUtils {
    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }
}