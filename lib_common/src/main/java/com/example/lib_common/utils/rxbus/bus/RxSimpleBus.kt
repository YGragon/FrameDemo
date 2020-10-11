package com.example.lib_common.utils.rxbus.bus

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.util.concurrent.ConcurrentHashMap

/**
 * Created by Aller on 2020/10/11.
 */
object RxSimpleBus {
    private var normalBus: Subject<Any> = PublishSubject.create<Any>().toSerialized()
    private var stickyBus: Subject<Any> = PublishSubject.create<Any>().toSerialized()
    private val cache = ConcurrentHashMap<String, Any>()

    // 1. 发送：普通事件、粘性事件
    fun sendMessage(rxMsg: RxBusMessage) {
        normalBus.onNext(rxMsg)
    }

    fun sendStickyMessage(rxMsg: RxBusMessage?) {
        if (rxMsg?.msg == null) {
            return
        }
        cache[rxMsg.type] = rxMsg
    }

    // 2. 接收事件：普通事件、粘性事件
    fun receiveMessageFrom(filter: String, receiver: RxBusReceiver<Any>): Disposable {
        return toObservable(normalBus, filter).subscribeWith(receiver)
    }

    fun receiveStickyMessage(filter: String, receiver: RxBusReceiver<Any>): Disposable {
        val disposable =toObservable(stickyBus, filter)
            .subscribeWith(receiver)

        val value = cache[filter]
        if (value != null) {
            stickyBus.onNext(value)
        }
        return disposable
    }

    private fun toObservable(sub: Subject<Any>, filter: String): Observable<Any> {
        return sub.map { o -> o as RxBusMessage }
            .filter { rxBusMessage -> rxBusMessage.type == filter }
            .map { rxBusMessage -> rxBusMessage.msg }
    }

    private fun hasObservable(): Boolean {
        return normalBus.hasObservers()
    }

    fun clearCurMessage(filter: String) {
        cache.remove(filter)
    }
}