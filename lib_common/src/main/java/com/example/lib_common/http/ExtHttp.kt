package com.example.lib_common.http

import android.util.Log
import autodispose2.ScopeProvider
import autodispose2.autoDispose
import autodispose2.lifecycle.LifecycleScopeProvider
import com.example.lib_common.base.BaseViewModel
import com.example.lib_common.http.exception.ExceptionHandle
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

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
                    error: (error: Throwable) -> Unit,
                    subscribe: (d: Disposable) -> Unit = { Log.e("runRxLambda", "Disposable") },
                    completed: () -> Unit = { Log.e("runRxLambda", "completed") }) {

    runRx(observable,object :Observer<T>{
        // 返回Disposable，用于在合适时机取消订阅，否则会出现内存泄漏问题
        override fun onSubscribe(d: Disposable) {subscribe(d)}

        override fun onComplete() { completed() }

        override fun onNext(t: T) { next(t) }

        override fun onError(e: Throwable) { error(e) }
    })
}

fun <T> runRxViewModel(provider: ScopeProvider, observable: Observable<T>, observer: Observer<T>) =
    observable
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .autoDispose(provider)
        .subscribe(observer)

fun <T> runRxLambdaViewModel(provider: ScopeProvider, observable: Observable<T>,
                             next: (T) -> Unit,
                             error: (error: Throwable) -> Unit = {
                                val errorStr = ExceptionHandle.handleException(it)
                                Log.e("runRxLambdaViewModel", "error:$errorStr")
                            },
                             subscribe: (d: Disposable) -> Unit = { Log.e("runRxLambdaViewModel", "subscribe") },
                             completed: () -> Unit = { Log.e("runRxLambdaViewModel", "completed") }) {

    runRxViewModel(provider,observable,object :Observer<T>{
        // 返回Disposable，用于在合适时机取消订阅，否则会出现内存泄漏问题
        override fun onSubscribe(d: Disposable) {subscribe(d)}

        override fun onComplete() { completed() }

        override fun onNext(t: T) { next(t) }

        override fun onError(e: Throwable) { error(e) }
    })
}