package com.example.framedemo.ui.mine.presenter

import com.example.framedemo.ui.mine.contract.MineContract
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils

/**
 * Mine Presenter 处理
 */
class MinePresenter : BasePresenter<MineContract.View>(), MineContract.Presenter {


    override fun getUserInfo() {


    }

    override fun loginOut() {
        val disposable = RetrofitManager.service.logout()
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                if (res.errorCode == 0) {
                    mRootView?.showLoginOutSuccess()
                }else{
                    mRootView?.showError(res.errorMsg)
                }
            }, { throwable ->
                val errorMsg = ExceptionHandle.handleException(throwable)
                mRootView?.showError(errorMsg)
            })
        addSubscription(disposable)

    }
}