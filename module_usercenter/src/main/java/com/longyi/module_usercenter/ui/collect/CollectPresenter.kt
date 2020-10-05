package com.longyi.module_usercenter.ui.collect

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.runRxLambda
import com.example.lib_common.http.scheduler.SchedulerUtils

/**
 * 注册页面 处理层
 */
class CollectPresenter : BasePresenter<CollectContract.View>(), CollectContract.Presenter {

    override fun getCollects(page: Int) {
        runRxLambda(RetrofitManager.service.getCollects(page),{
            if (it.data != null){
                if (it.data.curPage == it.data.pageCount) {
                    mRootView?.showLoadEnd(it.data.datas)
                } else {
                    mRootView?.showLoadComplete(it.data.datas)
                }
            }
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            mRootView?.showError(errorMsg)
        },{
            addSubscription(it)
        })
    }
}