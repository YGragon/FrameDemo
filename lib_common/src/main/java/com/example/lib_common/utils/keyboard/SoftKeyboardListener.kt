package com.example.lib_common.utils.keyboard

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Rect
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager


/**
 * 软键盘监听
 */
class SoftKeyboardListener(activity: Activity) {
    private val rootView: View = activity.window.decorView//activity的根视图
    private var rootViewVisibleHeight: Int = 0//纪录根视图的显示高度
    private var onSoftKeyBoardChangeListener: OnSoftKeyBoardChangeListener? = null

    init {
        //获取activity的根视图

        //监听视图树中全局布局发生改变或者视图树中的某个视图的可视状态发生改变
        rootView.viewTreeObserver.addOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener {
            //获取当前根视图在屏幕上显示的大小
            val r = Rect()
            rootView.getWindowVisibleDisplayFrame(r)

            val visibleHeight = r.height()
            println("" + visibleHeight)
            if (rootViewVisibleHeight == 0) {
                rootViewVisibleHeight = visibleHeight
                return@OnGlobalLayoutListener
            }

            //根视图显示高度没有变化，可以看作软键盘显示／隐藏状态没有改变
            if (rootViewVisibleHeight == visibleHeight) {
                return@OnGlobalLayoutListener
            }

            //根视图显示高度变小超过200，可以看作软键盘显示了
            if (rootViewVisibleHeight - visibleHeight > 200) {
                if (onSoftKeyBoardChangeListener != null) {
                    onSoftKeyBoardChangeListener!!.keyBoardShow(rootViewVisibleHeight - visibleHeight)
                }
                rootViewVisibleHeight = visibleHeight
                return@OnGlobalLayoutListener
            }

            //根视图显示高度变大超过200，可以看作软键盘隐藏了
            if (visibleHeight - rootViewVisibleHeight > 200) {
                if (onSoftKeyBoardChangeListener != null) {
                    onSoftKeyBoardChangeListener!!.keyBoardHide(visibleHeight - rootViewVisibleHeight)
                }
                rootViewVisibleHeight = visibleHeight
                return@OnGlobalLayoutListener
            }
        })
    }

    private fun setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener: OnSoftKeyBoardChangeListener) {
        this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener
    }

    interface OnSoftKeyBoardChangeListener {
        fun keyBoardShow(height: Int)

        fun keyBoardHide(height: Int)
    }

}