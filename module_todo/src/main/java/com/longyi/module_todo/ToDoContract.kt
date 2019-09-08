package com.longyi.module_todo

import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter

/**
 * 注册
 */
interface ToDoContract {
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

        /**
         * 更新TODO内容
         */
        fun postEditToDoInfo(id:Int, title:String, content:String, date:String, type:Int, priority:Int)

        /**
         * 删除TODO内容
         */
        fun postDeleteToDoInfo(id:Int)

        /**
         * 更新TODO Status
         * 完成或者未完成，1 完成 0 未完成
         */
        fun postUpdateStatusToDoInfo(id:Int, status:Int)
    }
}