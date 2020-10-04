package com.example.lib_common.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import org.jetbrains.annotations.NotNull


/**
 * MVP 基础接口 Presenter
 */
interface IPresenter<in V: IBaseView> {

    fun attachView(mRootView: V)

    fun detachView()


//    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
//    fun onCreate(@NotNull owner: LifecycleOwner)
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
//    fun onDestroy(@NotNull owner: LifecycleOwner)
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
//    fun onLifecycleChanged(@NotNull owner: LifecycleOwner, @NotNull event: Lifecycle.Event
//    )
}