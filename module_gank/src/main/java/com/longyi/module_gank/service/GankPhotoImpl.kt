package com.longyi.module_gank.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.exception.ExceptionHandle
import com.example.lib_common.http.runRxLambda
import com.example.lib_common.service.gank.IGankPhotoCallBack
import com.example.lib_common.service.gank.IGankService
import java.lang.Exception

/**
 * 提供接口给 我的 组件中顶部图片使用
 */
@Route(path = "/gank/IGankService", name = "Gank Service")
class GankPhotoImpl:IGankService {

    override fun init(context: Context?) {}

    override fun getHeaderPhoto(iGankPhotoCallBack: IGankPhotoCallBack) {
        // 从服务器获取
        runRxLambda(RetrofitManager.service.getGankPhotos(1,0),{
            try {
                iGankPhotoCallBack.success(it.data[0].url)
            }catch (e:Exception){
                iGankPhotoCallBack.fail("请求顶部图片失败")
            }
        },{
            val errorMsg = ExceptionHandle.handleException(it)
            iGankPhotoCallBack.fail(errorMsg)
        },{
            // TODO 可能会有内存泄露
        })
    }
}