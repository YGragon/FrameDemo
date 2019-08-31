package com.longyi.module_todo

import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter

/**
 * 注册
 */
interface ToDoPublishContract {
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
         * 提交发布的信息信息
         */
        fun postToDoInfo(title:String, content:String, date:String, type:Int, priority:Int)
    }
}