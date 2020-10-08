package com.longyi.module_gank

import com.example.lib_common.base.BasePresenter
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.runRxLambda
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.example.lib_common.utils.LogUtils

/**
 * 干货福利
 */
class GankPhotoPresenter : BasePresenter<GankPhotoContract.View>(),GankPhotoContract.Presenter{


    override fun getGankPhoto(count: Int, page: Int) {
        // 从服务器获取
        runRxLambda(RetrofitManager.service.getGankPhotos(count,page),{
            if (it.data.isEmpty()){
                // 显示空页面
                // mRootView?.showGankEmptyResult()
            }else{
                val results = it.data
                mRootView?.showGankPhotoResult(results)
            }
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            mRootView?.showError(errorMsg)
        },{
            addSubscription(it)
        })
    }
}