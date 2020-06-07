package com.longyi.module_android_jetpack.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * ViewModel 基类
 */
open class BaseViewModel : ViewModel() {
    override fun onCleared() {
        super.onCleared()
        Log.e("CommonViewModel","onCleared")
    }
}