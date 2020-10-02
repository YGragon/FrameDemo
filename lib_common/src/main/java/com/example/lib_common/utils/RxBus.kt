package com.example.lib_common.utils

import android.util.Log
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

/**
 * 使用 RxJava 封装的事件总线
 * 使用：
 * 1. 注册，在 onCreate 方法
 * RxBus.observe<String>()
 * .subscribe { t: String? ->
 * Log.e(TAG,"接收的数据：$t")
 * }
 * .registerInBus(this)
 *
 * 2. 发送
 * RxBus.send("123")
 *
 * 3. 注销，在 onDestroy 方法
 * RxBus.unRegister(this)
 */
object RxBus {
    private val TAG = javaClass.simpleName

    /**
     * 用于保存RxBus事件的所有订阅，并在需要时正确的取消订阅。
     */
    private val disposablesMap: HashMap<Any, CompositeDisposable?> by lazy {
        HashMap<Any, CompositeDisposable?>()
    }

    /**
     * 避免直接使用此属性，因为它仅在内联函数中使用而暴露
     * PublishSubject：接收到订阅之后的所有数据
     * ReplaySubject：接收到所有的数据，包括订阅之前的所有数据和订阅之后的所有数据。
     * BehaviorSubject：接收到订阅前的最后一条数据和订阅后的所有数据。
     * AsyncSubject：不管在什么位置订阅，都只接收到最后一条数据
     */
    val rxBus = PublishSubject.create<Any>().toSerialized()


    /**
     * 向RxBus发送一个事件，这个事件可以来自任意一个线程
     */
    fun send(event: Any) {
        rxBus.onNext(event)
    }

    /**
     * 订阅特定类型T的事件。可以从任何线程调用
     */
    inline fun <reified T : Any> observe(): Observable<T> {
        return rxBus.ofType(T::class.java)
    }

    /**
     * 从RxBus事件中取消注册订阅者
     * 调用订阅的取消订阅方法
     */
    fun unRegister(disposable: Any) {
        val compositeDisposable = disposablesMap[disposable]
        if (compositeDisposable == null) {
            Log.e(TAG, "compositeDisposable == null")
        } else {
            compositeDisposable.clear()
            disposablesMap.remove(disposable)
        }
    }

    /**
     * internal修饰符 只有在相同模块中才能使用
     */
    internal fun register(disposable: Any, composite: Disposable) {
        var compositeDisposable = disposablesMap[disposable]
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable.add(composite)
        disposablesMap[disposable] = compositeDisposable
    }
}

/**
 * 注册订阅以便以后正确注销它以避免内存泄漏
 * @param disposable 拥有此订阅的订阅对象
 */
fun Disposable.registerInBus(disposable: Any) {
    RxBus.register(disposable, this)
}