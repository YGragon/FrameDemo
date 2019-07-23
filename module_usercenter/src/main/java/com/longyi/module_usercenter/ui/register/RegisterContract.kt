package com.longyi.module_usercenter.ui.register

import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter

/**
 * 注册
 */
interface RegisterContract {

    interface View:IBaseView{
        /**
         * 显示错误信息
         */
        fun showError(errorMsg:String)

        /**
         * 显示 注册成功
         */
        fun showRegisterSuccess(successMsg:String)
    }

    interface Presenter: IPresenter<View> {
        /**
         * 提交注册信息
         */
        fun postRegisterInfo(user_name:String, password:String, repassword:String)
    }
}