package com.example.lib_common.service.user_center

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * 暴露服务给其他组件使用
 */
interface ILoginService:IProvider {
    fun isLogin():Boolean
}