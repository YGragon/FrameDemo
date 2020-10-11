package com.example.lib_common.utils.rxbus.observer

import androidx.annotation.CallSuper
import androidx.annotation.NonNull
import io.reactivex.Observer
import io.reactivex.internal.disposables.DisposableHelper
import io.reactivex.internal.disposables.ListCompositeDisposable
import io.reactivex.internal.functions.ObjectHelper
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.atomic.AtomicReference

/**
 *  接收数据源的观察者
 */
abstract class RxResourceObserver<T> : Observer<T>,Disposable {
    /** The active subscription.  */
    private val s = AtomicReference<io.reactivex.disposables.Disposable>()

    /** The resource composite, can never be null.  */
    private val resources = ListCompositeDisposable()

    /**
     * Adds a resource to this ResourceObserver.
     *
     * @param resource the resource to add
     *
     * @throws NullPointerException if resource is null
     */
    fun add(@NonNull resource: io.reactivex.disposables.Disposable) {
        ObjectHelper.requireNonNull(resource, "resource is null")
        resources.add(resource)
    }

    override fun onSubscribe(s: io.reactivex.disposables.Disposable) {
        if (setOnce(this.s, s, javaClass)) {
            onStart()
        }
    }

    private fun setOnce(
        upstream: AtomicReference<io.reactivex.disposables.Disposable>,
        next: io.reactivex.disposables.Disposable,
        observer: Class<*>
    ): Boolean {
        ObjectHelper.requireNonNull(next, "next is null")
        if (!upstream.compareAndSet(null, next)) {
            next.dispose()
            if (upstream.get() !== DisposableHelper.DISPOSED) {
                reportDoubleSubscription(observer)
            }
            return false
        }
        return true
    }

    private fun reportDoubleSubscription(consumer: Class<*>) {
        RxJavaPlugins.onError(IllegalStateException(composeMessage(consumer.name)))
    }

    fun composeMessage(consumer: String): String {
        return ("It is not allowed to subscribe with a(n) " + consumer + " multiple times. "
                + "Please create a fresh instance of " + consumer + " and subscribe that to the target source instead.")
    }

    /**
     * Called once the upstream sets a Subscription on this ResourceObserver.
     *
     *
     * You can perform initialization at this moment. The default
     * implementation does nothing.
     */
    protected fun onStart() {}

    /**
     * Cancels the main disposable (if any) and disposes the resources associated with
     * this ResourceObserver (if any).
     *
     *
     * This method can be called before the upstream calls onSubscribe at which
     * case the main Disposable will be immediately disposed.
     */
    @CallSuper
    override fun dispose() {
        if (DisposableHelper.dispose(s)) {
            resources.dispose()
        }
    }

    /**
     * Returns true if this ResourceObserver has been disposed/cancelled.
     * @return true if this ResourceObserver has been disposed/cancelled
     */
    override fun isDisposed(): Boolean {
        return DisposableHelper.isDisposed(s.get())
    }

}