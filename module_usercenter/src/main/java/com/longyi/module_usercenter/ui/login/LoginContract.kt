package com.longyi.module_usercenter.ui.login

import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter

/**
 * 注册
 */
interface LoginContract {
    interface View:IBaseView{
        /**
         * 显示错误信息
         */
        fun showError(errorMsg:String)

        /**
         * 显示 注册成功
         */
        fun showLoginSuccess(successMsg:String)
    }

    interface Presenter: IPresenter<View> {
        /**
         * 提交登录信息
         */
        fun postLoginInfo(user_name:String, password:String)
    }
}