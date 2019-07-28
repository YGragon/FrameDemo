package com.longyi.module_usercenter.ui.login

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.example.lib_common.model.UserControl

/**
 * 注册页面 处理层
 */
class LoginPresenter : BasePresenter<LoginContract.View>(), LoginContract.Presenter {

    override fun postLoginInfo(user_name: String, password: String) {

        val disposable = RetrofitManager.service.login(user_name,password)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                mRootView?.showLoginSuccess(res.data.username+" 登录成功")
                UserControl.setUser(res.data)
            }, { throwable ->
                val errorMsg = ExceptionHandle.handleException(throwable)
                mRootView?.showError(errorMsg)
            })
        addSubscription(disposable)
    }
}