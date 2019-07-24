package com.example.lib_common.constant

import android.os.Environment
import java.io.File

object BaseConstant {

    // 是否输出日志
    val isDebug = true

    // 退出 App 消息
    val EXIT_ACTION = "action.exit"

    var filePath = "${Environment.getExternalStorageDirectory()}${File.separator}FrameDemo${File.separator}"
}