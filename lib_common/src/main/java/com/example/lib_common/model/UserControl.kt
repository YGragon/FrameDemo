package com.example.lib_common.model

import com.example.lib_common.constant.BaseConstant
import com.example.lib_common.utils.PreferenceUtils

/**
 * 用户控制中心
 */
object UserControl {


    // 用于信息
    private lateinit var user:User

    fun isLogin(): Boolean {
        return PreferenceUtils.getBoolean(BaseConstant.IS_LOGIN_KEY, false)
    }



    fun setUser(userInfo:User) {
        this.user = userInfo
    }
    fun getUser(): User {
        return user
    }

}