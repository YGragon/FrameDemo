package com.longyi.module_usercenter.ui.register

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.runRxLambda
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.example.lib_common.model.UserControl

/**
 * 注册页面 处理层
 */
class RegisterPresenter : BasePresenter<RegisterContract.View>(),RegisterContract.Presenter {
    override fun postRegisterInfo(user_name: String, password: String, repassword: String) {
        runRxLambda(RetrofitManager.service.register(user_name,password,repassword),{
            mRootView?.showRegisterSuccess(" 注册成功")
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            mRootView?.showError(errorMsg)
        },{
            addSubscription(it)
        })

    }
}