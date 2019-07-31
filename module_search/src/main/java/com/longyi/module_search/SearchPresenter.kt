package com.longyi.module_search

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils

/**
 * 搜索
 */
class SearchPresenter : BasePresenter<SearchContract.View>(),SearchContract.Presenter{

    override fun getHotKeys() {
        // 首页传递过来

    }

    override fun getHistorys() {
        // 从数据库中获取
    }

    override fun getSearchResult(page:Int,key_word:String) {
        // 从服务器获取
        val disposable = RetrofitManager.service.getSearchs(page,key_word)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                if (res.data != null){
                    // 获取到结果
                }

            }, { throwable ->
                val errorMsg = ExceptionHandle.handleException(throwable)
                mRootView?.showError(errorMsg)
            })
        addSubscription(disposable)
    }
}