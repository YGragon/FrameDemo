package com.example.lib_common.utils.rx

import autodispose2.AutoDispose
import androidx.lifecycle.LifecycleOwner
import autodispose2.AutoDisposeConverter
import autodispose2.ScopeProvider
import io.reactivex.rxjava3.core.CompletableSource


/**
 * rx 生命周期管理类
 */
object RxLifecycleUtils {

    fun <T> bindLifecycle(lifecycleOwner: LifecycleOwner): AutoDisposeConverter<T> {
        return AutoDispose.autoDisposable(ScopeProvider.UNBOUND.requestScope())
    }
}