package com.example.framedemo.ui.course.presenter

import com.example.framedemo.ui.mine.contract.TodoContract
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.runRxLambda
import com.example.lib_common.http.scheduler.SchedulerUtils

/**
 * TodoPresenter
 */
class TodoPresenter:BasePresenter<TodoContract.View>(),TodoContract.Presenter {
    override fun getFinishList(page: Int, status: Int, type: Int, priority: Int, orderby: Int) {


    }

    override fun getUnFinishList(page:Int,status:Int,type:Int,priority:Int,orderby:Int) {
        runRxLambda(RetrofitManager.service.getTodoList(page,status,type,priority,orderby),{
            if (it.errorCode == 0) {
                mRootView?.showUnFinishList(it.data.curPage,it.data.pageCount,it.data.datas)
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