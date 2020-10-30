package com.longyi.module_course.course.presenter

import com.longyi.module_course.course.contract.TodoContract
import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.runRxLambda

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