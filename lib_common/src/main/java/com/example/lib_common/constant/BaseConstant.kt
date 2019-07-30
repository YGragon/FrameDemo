package com.example.lib_common.constant

import android.content.Context
import android.os.Environment
import java.io.File

object BaseConstant {

    // 退出 App 消息
    val EXIT_ACTION = "action.exit"

    var filePath = "${Environment.getExternalStorageDirectory()}${File.separator}FrameDemo${File.separator}"

    // 定位权限
    val CAMERA_REQUEST_CODE = 1000

    // sp
    val IS_LOGIN_KEY = "is_login"
    val IS_LOGIN_TRUE = true

    val USER_NAME = "user_name"
}