package com.longyi.lib_base_item.utils

import android.content.Context
import android.content.res.Resources

/**
 * 使用扩展函数
 * 示例：
 *  18.dip2px()
 */

fun Int.dip2px(): Float {
    return (0.5f + this * Resources.getSystem().displayMetrics.density)
}

fun Int.px2dip(): Float {
    return (0.5f + this / Resources.getSystem().displayMetrics.density)
}

fun Int.sp2px(): Float {
    return (0.5f + this * Resources.getSystem().displayMetrics.scaledDensity)
}