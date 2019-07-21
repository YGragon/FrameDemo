package com.example.framedemo.ui.home.presenter

import com.example.framedemo.ui.home.contract.HomeContract
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.example.lib_common.utils.LogUtils

/**
 * 首页 Presenter
 */
class HomePresenter : BasePresenter<HomeContract.View>(),HomeContract.Presenter{
    override fun getBanners() {
        val disposable = RetrofitManager.service.getBanners()
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                mRootView?.showBanners(res.data)
            }, { throwable ->
                mRootView?.showError(throwable.message.toString())
            })
        addSubscription(disposable)
    }

}