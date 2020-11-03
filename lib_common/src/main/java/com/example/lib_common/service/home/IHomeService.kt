package com.example.lib_common.service.home

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * 暴露服务给其他组件使用
 */
interface IHomeService:IProvider {
    fun getFreshCount():Int
}