package com.longyi.module_usercenter.ui.login

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.example.lib_common.model.UserControl

/**
 * 注册页面 处理层
 */
class LoginPresenter : BasePresenter<LoginContract.View>(), LoginContract.Presenter {

    override fun postLoginInfo(user_name: String, password: String) {

        val disposable = RetrofitManager.service.login()
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                mRootView?.showLoginSuccess(res.data.username+" 登录成功")
                UserControl.setLogin(true)
                UserControl.setUser(res.data)
            }, { throwable ->
                mRootView?.showError(throwable.message.toString())
            })
        addSubscription(disposable)
    }
}