package com.example.framedemo.ui.course.presenter

import com.example.framedemo.ui.mine.contract.TodoContract
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils

/**
 * TodoPresenter
 */
class TodoPresenter:BasePresenter<TodoContract.View>(),TodoContract.Presenter {
    override fun getFinishList(page: Int, status: Int, type: Int, priority: Int, orderby: Int) {


    }

    override fun getUnFinishList(page:Int,status:Int,type:Int,priority:Int,orderby:Int) {
        val disposable = RetrofitManager.service.getTodoList(page,status,type,priority,orderby)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                mRootView?.showUnFinishList(res.data.curPage,res.data.pageCount,res.data.datas)
            }, { throwable ->
                mRootView?.showError(throwable.message.toString())
            })
        addSubscription(disposable)

    }
}