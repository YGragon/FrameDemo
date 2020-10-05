package com.longyi.module_gank.big_image

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.runRxLambda
import com.example.lib_common.http.scheduler.SchedulerUtils

/**
 * 干货福利
 */
class BigImagePresenter : BasePresenter<BigImageContract.View>(),BigImageContract.Presenter{
    override fun getGankPhoto(count: Int, page: Int) {
        // 从服务器获取
        runRxLambda(RetrofitManager.service.getGankPhotos(count,page),{
            if (it.results.isEmpty()){
                // 显示空页面
                mRootView?.showGankEmptyResult()
            }else{
                mRootView?.showGankPhotoResult(it.results)
            }
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            mRootView?.showError(errorMsg)
        },{
            addSubscription(it)
        })
    }

}