package com.longyi.module_usercenter.ui.register

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils

/**
 * 注册页面 处理层
 */
class RegisterPresenter : BasePresenter<RegisterContract.View>(),RegisterContract.Presenter {
    override fun postRegisterInfo(user_name: String, password: String, repassword: String) {

        val disposable = RetrofitManager.service.register(user_name,password,repassword)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                mRootView?.showRegisterSuccess("注册成功")
            }, { throwable ->
                val errorMsg = ExceptionHandle.handleException(throwable)
                mRootView?.showError(errorMsg)
            })
        addSubscription(disposable)

    }
}