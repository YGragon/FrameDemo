package com.longyi.module_home.provider

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.model.ImageData
import com.example.lib_common.service.home.IHomeService
import com.example.lib_common.utils.LogUtils
import com.longyi.module_home.data.HomeDataSource

/**
 * 服务的实现
 */
@Route(path = RouterPath.Home.HOME_SERVICE, name = "Home Service")
class HomeServiceImpl: IHomeService {

    override fun getFreshCount(): Int {
        val articles = HomeDataSource.getArticles()
        var freshCount = 0
        if (articles.isNotEmpty()){
            for (i in articles){
                if (i.fresh){
                    freshCount++
                }
            }
        }
        LogUtils.e("最新的数量：$freshCount")
        return freshCount
    }

    override fun getImageDatas(): MutableList<ImageData> {
        return HomeDataSource.getImageDatas()
    }

    override fun init(context: Context?) {}

}