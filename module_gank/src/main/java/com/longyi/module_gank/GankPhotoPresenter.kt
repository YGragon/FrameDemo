package com.longyi.module_gank

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils

/**
 * 干货福利
 */
class GankPhotoPresenter : BasePresenter<GankPhotoContract.View>(),GankPhotoContract.Presenter{


    override fun getGankPhoto(count: Int, page: Int) {
        // 从服务器获取
        val disposable = RetrofitManager.service.getGankPhotos(count,page)
            .compose(SchedulerUtils.ioToMain())
            .subscribe({ res ->
                // 获取到结果
                if (res.results.isEmpty()){
                    // 显示空页面
                    mRootView?.showGankEmptyResult()
                }else{
                    mRootView?.showGankPhotoResult(res.results)
                }

            }, { throwable ->
                val errorMsg = ExceptionHandle.handleException(throwable)
                mRootView?.showError(errorMsg)
            })
        addSubscription(disposable)
    }
}