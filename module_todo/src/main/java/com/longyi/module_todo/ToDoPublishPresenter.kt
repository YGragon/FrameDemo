package com.longyi.module_todo

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.example.lib_common.model.UserControl

/**
 * TODO发布页面 处理层
 */
class ToDoPublishPresenter : BasePresenter<ToDoPublishContract.View>(), ToDoPublishContract.Presenter {

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