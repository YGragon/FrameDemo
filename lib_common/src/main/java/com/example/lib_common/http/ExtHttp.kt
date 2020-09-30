package com.example.lib_common.http

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *  使用 kotlin 高阶函数及扩展函数封装的网络请求
 */

fun <T> runRx(observable: Observable<T>, observer: Observer<T>) =
    observable
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(observer)

fun <T> runRxLambda(observable: Observable<T>,
                    next: (T) -> Unit,
                    error: (e: Throwable) -> Unit,
                    subscribe: (d: Disposable) -> Unit,
                    completed: () -> Unit = { Log.e("completed", "completed") }) {

    runRx(observable,object :Observer<T>{
        override fun onComplete() { completed() }

        // 返回Disposable，用于在合适时机取消订阅，否则会出现内存泄漏问题
        override fun onSubscribe(d: Disposable) { subscribe(d) }

        override fun onNext(t: T) { next(t) }

        override fun onError(e: Throwable) { error(e) }
    })
}