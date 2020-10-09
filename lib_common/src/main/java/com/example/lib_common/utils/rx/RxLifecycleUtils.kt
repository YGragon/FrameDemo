package com.example.lib_common.utils.rx

import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider
import autodispose2.AutoDispose
import androidx.lifecycle.LifecycleOwner
import autodispose2.AutoDisposeConverter



/**
 * Created by Aller on 2020/10/8.
 */

class RxLifecycleUtils private constructor() {

    init {
        throw IllegalStateException("Can't instance the RxLifecycleUtils")
    }

    companion object {

        fun <T> bindLifecycle(lifecycleOwner: LifecycleOwner): AutoDisposeConverter<T> {
            return AutoDispose.autoDisposable(
                AndroidLifecycleScopeProvider.from(lifecycleOwner)
            )
        }
    }
}