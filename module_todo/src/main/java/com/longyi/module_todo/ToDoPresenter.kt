package com.longyi.module_todo

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils

/**
 * TODO发布页面 处理层
 */
class ToDoPresenter : BasePresenter<ToDoContract.View>(), ToDoContract.Presenter {
    override fun postDeleteToDoInfo(id: Int) {
        val disposable = RetrofitManager.service.deleteTodo(id)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                mRootView?.showLoginSuccess("删除成功")
            }, { throwable ->
                val errorMsg = ExceptionHandle.handleException(throwable)
                mRootView?.showError(errorMsg)
            })
        addSubscription(disposable)

    }

    override fun postUpdateStatusToDoInfo(id: Int, status: Int) {
        val disposable = RetrofitManager.service.updateStatusTodo(id,status)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                mRootView?.showLoginSuccess("更新状态成功")
            }, { throwable ->
                val errorMsg = ExceptionHandle.handleException(throwable)
                mRootView?.showError(errorMsg)
            })
        addSubscription(disposable)
    }

    override fun postEditToDoInfo(id: Int, title: String, content: String, date: String, type: Int, priority: Int) {
        val disposable = RetrofitManager.service.editTodo(id, title,content,date,type,priority)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                mRootView?.showLoginSuccess("更新成功")
            }, { throwable ->
                val errorMsg = ExceptionHandle.handleException(throwable)
                mRootView?.showError(errorMsg)
            })
        addSubscription(disposable)

    }

    override fun postToDoInfo(title:String, content:String, date:String, type:Int, priority:Int) {
        val disposable = RetrofitManager.service.publishTodo(title,content,date,type,priority)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                mRootView?.showLoginSuccess("创建成功")
            }, { throwable ->
                val errorMsg = ExceptionHandle.handleException(throwable)
                mRootView?.showError(errorMsg)
            })
        addSubscription(disposable)
    }
}