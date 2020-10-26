package com.longyi.module_usercenter.provider

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.model.UserControl
import com.example.lib_common.service.user_center.ILoginService

/**
 * 服务的实现
 */
@Route(path = "/provider/ILoginService", name = "Login Service")
class LoginServiceImpl: ILoginService {
    override fun isLogin(): Boolean {
        return UserControl.isLogin()
    }

    override fun init(context: Context?) {
        Log.e("LoginServiceImpl","初始化")
    }
}