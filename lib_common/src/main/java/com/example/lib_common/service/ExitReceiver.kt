package com.example.lib_common.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.lib_common.utils.ActivityManager

/**
 *  接收到全局广播，关闭全部 activity
 */
class ExitReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        ActivityManager.instance.finishAllActivity()
    }

}