package com.longyi.module_usercenter.ui.collect

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils

/**
 * 注册页面 处理层
 */
class CollectPresenter : BasePresenter<CollectContract.View>(), CollectContract.Presenter {

    override fun getCollects(page: Int) {
        val disposable = RetrofitManager.service.getCollects(page)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                if (res.data != null){
                        if (res.data.curPage == res.data.pageCount) {
                            mRootView?.showLoadEnd(res.data.datas)
                        } else {
                            mRootView?.showLoadComplete(res.data.datas)
                        }
                }

            }, { throwable ->
                val errorMsg = ExceptionHandle.handleException(throwable)
                mRootView?.showError(errorMsg)
            })
        addSubscription(disposable)
    }
}