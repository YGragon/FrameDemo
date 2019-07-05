package com.example.lib_common.utils

import android.content.Context
import android.widget.Toast

/**
 * Toast 工具类
 */
object ToastUtils {
    private var TOAST: Toast?=null

    fun show(context: Context, resourceID:Int){
        show(context, resourceID, Toast.LENGTH_SHORT)
    }

    fun show(context:Context,text:String){
        show(context, text, Toast.LENGTH_SHORT)
    }

    fun show(context:Context,resourceID:Int,duration:Int){
        val text = context.resources.getString(resourceID)
        show(context, text, duration)
    }

    fun show(context: Context, text:String, duration: Int){
        if(TOAST == null){
            TOAST = Toast.makeText(context, text, duration)
        }else{
            TOAST?.cancel()
            TOAST = Toast.makeText(context, text, duration)
        }
        TOAST?.show()
    }
}