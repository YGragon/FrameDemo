package com.example.lib_common.utils.rxbus.bus

import androidx.annotation.CallSuper
import com.example.lib_common.utils.rxbus.observer.RxResourceObserver
import io.reactivex.disposables.Disposable

/**
 * Created by Aller on 2020/10/11.
 */
abstract class RxBusReceiver<T> : RxResourceObserver<T>(), Disposable {
    private var filter: String? = null

    override fun onNext(t: T) {
        try {
            receive(t)

        } catch (e: Exception) {

        }

    }

    @CallSuper
    override fun onError(e: Throwable) {
        clearIfNeed()
    }

    @CallSuper
    override fun onComplete() {
        clearIfNeed()
    }

    fun setCurFilter(filter: String) {
        this.filter = filter
    }

    abstract fun receive(data: T)
    private fun clearIfNeed() {
        if (filter != null) {
            RxSimpleBus.clearCurMessage(filter!!)
        }
    }

    override fun dispose() {
        super.dispose()
        clearIfNeed()
    }
}