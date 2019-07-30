package com.example.lib_common.utils

import android.util.Log
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.BaseConstant
import java.text.SimpleDateFormat
import java.util.*

class LogUtils {
    companion object {

        //是否打印log
        private var debug: Boolean = BaseApplication.isDebug()
        private val TAG = "ERP_LOG"
        private val TOP_BORDER = "********************************************************************************************************************************************"
        private var LEFT_BORDER = "*"
        private val BOTTOM_BORDER = "********************************************************************************************************************************************"


        /**
         * log
         */
        fun v(tag: String, msg: String) = debug.log(tag, msg, Log.VERBOSE)
        fun d(tag: String, msg: String) = debug.log(tag, msg, Log.DEBUG)
        fun i(tag: String, msg: String) = debug.log(tag, msg, Log.INFO)
        fun w(tag: String, msg: String) = debug.log(tag, msg, Log.WARN)
        fun e(tag: String, msg: String) = debug.log(tag, msg, Log.ERROR)

        /**
         * 排版log
         */
        fun vv(tag: String, msg: String) = debug.debugLog(tag, msg, Log.VERBOSE)
        fun dd(tag: String, msg: String) = debug.debugLog(tag, msg, Log.DEBUG)
        fun ii(tag: String, msg: String) = debug.debugLog(tag, msg, Log.INFO)
        fun ww(tag: String, msg: String) = debug.debugLog(tag, msg, Log.WARN)
        fun ee(tag: String, msg: String) = debug.debugLog(tag, msg, Log.ERROR)

        private fun Boolean.log(tag: String, msg: String, type: Int) {
            if (!this) {
                return
            }
            val newMsg = "$tag:$msg"
            when (type) {
                Log.VERBOSE -> Log.v(TAG, newMsg)
                Log.DEBUG -> Log.d(TAG, newMsg)
                Log.INFO -> Log.i(TAG, newMsg)
                Log.WARN -> Log.w(TAG, newMsg)
                Log.ERROR -> Log.e(TAG, newMsg)
            }

        }

        private fun Boolean.debugLog(tag: String, msg: String, type: Int) {
            if (!this) {
                return
            }
            val newMsg = msgFormat(msg, tag)
            when (type) {
                Log.VERBOSE -> Log.v(TAG, newMsg)
                Log.DEBUG -> Log.d(TAG, newMsg)
                Log.INFO -> Log.i(TAG, newMsg)
                Log.WARN -> Log.w(TAG, newMsg)
                Log.ERROR -> Log.e(TAG, newMsg)
            }

        }

        private fun msgFormat(msg: String, tag: String): String {
            val bytes: ByteArray = msg.toByteArray()
            val length = bytes.size
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
            if (length >  100 ) {
                LEFT_BORDER = ""
            }
            var newMsg = " \n$TOP_BORDER\n$LEFT_BORDER TAG: $tag\t TIME: ${sdf.format(Date())}"
            newMsg += "\n$LEFT_BORDER MSG: $msg"
            newMsg += "\n$BOTTOM_BORDER"
            return newMsg

        }

    }
}