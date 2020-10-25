package com.longyi.module_usercenter.ui.login

import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.db.AppDataBase
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.runRxLambda
import com.example.lib_common.model.UserControl
import com.example.lib_common.utils.PreferenceUtils

/**
 * 注册页面 处理层
 */
class LoginPresenter : BasePresenter<LoginContract.View>(), LoginContract.Presenter {
    override fun postLoginInfo(user_name: String, password: String) {
        runRxLambda(RetrofitManager.service.login(user_name,password),{
            mRootView?.showLoginSuccess(it.data.username+" 登录成功")
            UserControl.setUser(it.data)
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            mRootView?.showLoginError(errorMsg)
        },{
            addSubscription(it)
        })
    }
}