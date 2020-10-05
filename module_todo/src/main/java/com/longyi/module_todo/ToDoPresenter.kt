package com.longyi.module_todo

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.runRxLambda
import com.example.lib_common.http.scheduler.SchedulerUtils

/**
 * TODO发布页面 处理层
 */
class ToDoPresenter : BasePresenter<ToDoContract.View>(), ToDoContract.Presenter {
    override fun postDeleteToDoInfo(id: Int) {
        runRxLambda(RetrofitManager.service.deleteTodo(id),{
            mRootView?.showLoginSuccess("删除成功")
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            mRootView?.showError(errorMsg)
        },{
            addSubscription(it)
        })
    }

    override fun postUpdateStatusToDoInfo(id: Int, status: Int) {
        runRxLambda(RetrofitManager.service.updateStatusTodo(id,status),{
            mRootView?.showLoginSuccess("更新状态成功")
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            mRootView?.showError(errorMsg)
        },{
            addSubscription(it)
        })
    }

    override fun postEditToDoInfo(id: Int, title: String, content: String, date: String, type: Int, priority: Int) {
        runRxLambda(RetrofitManager.service.editTodo(id, title,content,date,type,priority),{
            mRootView?.showLoginSuccess("更新成功")
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            mRootView?.showError(errorMsg)
        },{
            addSubscription(it)
        })
    }

    override fun postToDoInfo(title:String, content:String, date:String, type:Int, priority:Int) {
        runRxLambda(RetrofitManager.service.publishTodo(title,content,date,type,priority),{
            mRootView?.showLoginSuccess("创建成功")
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            mRootView?.showError(errorMsg)
        },{
            addSubscription(it)
        })
    }
}