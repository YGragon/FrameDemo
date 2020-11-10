package com.longyi.module_todo.presenter

import com.longyi.module_todo.contract.TodoContract
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.runRxLambda
import com.longyi.module_todo.contract.ToDoContract

/**
 * TodoPresenter
 */
class TodoPresenter:BasePresenter<TodoContract.View>(), TodoContract.Presenter {


    override fun getList(page:Int,status:Int,orderby:Int) {
        runRxLambda(RetrofitManager.service.getTodoList(page,status,orderby),{
            if (it.errorCode == 0) {
                mRootView?.showList(it.data.curPage,it.data.pageCount,it.data.datas)
            }else{
                mRootView?.showError(it.errorMsg)
            }
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            mRootView?.showError(errorMsg)
        },{
            addSubscription(it)
        })
    }
}

/**
 * TODO发布页面 处理层
 */
class ToDoPresenter : BasePresenter<ToDoContract.View>(),
    ToDoContract.Presenter {
    override fun postDeleteToDoInfo(id: Int) {
        runRxLambda(
            RetrofitManager.service.deleteTodo(
                id
            ), {
                mRootView?.showSuccess("删除成功")
            }, {
                val errorMsg =
                    ExceptionHandle.handleException(
                        it
                    )
                mRootView?.showError(errorMsg)
            }, {
                addSubscription(it)
            })
    }

    override fun postUpdateStatusToDoInfo(id: Int, status: Int) {
        runRxLambda(
            RetrofitManager.service.updateStatusTodo(
                id,
                status
            ), {
                mRootView?.showSuccess("更新状态成功")
            }, {
                val errorMsg =
                    ExceptionHandle.handleException(
                        it
                    )
                mRootView?.showError(errorMsg)
            }, {
                addSubscription(it)
            })
    }

    override fun postEditToDoInfo(id: Int, title: String, content: String, date: String, type: Int, priority: Int) {
        runRxLambda(
            RetrofitManager.service.editTodo(
                id,
                title,
                content,
                date,
                type,
                priority
            ), {
                mRootView?.showSuccess("更新成功")
            }, {
                val errorMsg =
                    ExceptionHandle.handleException(
                        it
                    )
                mRootView?.showError(errorMsg)
            }, {
                addSubscription(it)
            })
    }

    override fun postToDoInfo(title:String, content:String, date:String, type:Int, priority:Int) {
        runRxLambda(
            RetrofitManager.service.publishTodo(
                title,
                content,
                date,
                type,
                priority
            ), {
                mRootView?.showSuccess("创建成功")
            }, {
                val errorMsg =
                    ExceptionHandle.handleException(
                        it
                    )
                mRootView?.showError(errorMsg)
            }, {
                addSubscription(it)
            })
    }
}