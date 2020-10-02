package com.example.lib_common.utils

import android.text.Editable
import android.text.TextWatcher

/**
 * TextWatcherManager 封装
 * 可以使用 RxJava 优化
 */
abstract class TextWatcherManager:TextWatcher {
    override fun afterTextChanged(s: Editable?) {
        doOnAfterTextChanged(s)
    }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    abstract fun doOnAfterTextChanged(s: Editable?)
}