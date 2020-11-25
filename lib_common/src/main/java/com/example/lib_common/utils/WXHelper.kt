package com.example.lib_common.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent

/**
 * 判断 微信是否安装
 */
object WXHelper {
    private const val WECHAT_APP_PACKAGE = "com.tencent.mm"
    private const val WECHAT_LAUNCHER_UI_CLASS = "com.tencent.mm.ui.LauncherUI"
    private const val WECHAT_OPEN_SCANER_NAME = "LauncherUI.From.Scaner.Shortcut"

    fun openScanner(context: Context) {
        // 检查微信是否安装
        if (AppUtils.isAppExist(context, WECHAT_APP_PACKAGE)) {
            // 正在打开微信扫一扫
            val intent = Intent(Intent.ACTION_VIEW).apply {
                component = ComponentName(WECHAT_APP_PACKAGE, WECHAT_LAUNCHER_UI_CLASS)
                putExtra(WECHAT_OPEN_SCANER_NAME, true)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            context.startActivity(intent)
        } else {
            // 未安装
        }
    }
}