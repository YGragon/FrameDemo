package com.example.lib_common.base

/**
 * MVP 基础接口 Presenter
 */
interface IPresenter<in V: IBaseView> {

    fun attachView(mRootView: V)

    fun detachView()

}