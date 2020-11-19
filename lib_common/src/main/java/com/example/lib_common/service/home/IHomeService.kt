package com.example.lib_common.service.home

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider
import com.example.lib_common.model.ImageData

/**
 * 暴露服务给其他组件使用
 */
interface IHomeService:IProvider {
    // 给 app 模块调用
    fun getFreshCount():Int
    // 给个人中心模块调用
    fun getImageDatas():MutableList<ImageData>
}