package com.longyi.module_home.provider

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.service.home.IHomeService
import com.longyi.module_home.data.HomeDataSource

/**
 * 服务的实现
 */
@Route(path = "/home_provider/IHomeService", name = "Home Service")
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
        return freshCount
    }

    override fun init(context: Context?) {}

}