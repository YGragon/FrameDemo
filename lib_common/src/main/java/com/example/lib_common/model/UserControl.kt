package com.example.lib_common.model

import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.BaseConstant
import com.example.lib_common.db.AppDataBase
import com.example.lib_common.utils.PreferenceUtils

/**
 * 用户控制中心
 */
object UserControl {

    val userDao = AppDataBase.instance(BaseApplication.context).getUserDao()


    fun isLogin(): Boolean {
        return PreferenceUtils.getBoolean(BaseConstant.IS_LOGIN_KEY, false)
    }



    fun setUser(userInfo: User) {
        PreferenceUtils.saveValue(BaseConstant.IS_LOGIN_KEY, BaseConstant.IS_LOGIN_TRUE)
        PreferenceUtils.saveValue(BaseConstant.USER_NAME, userInfo.username)
        userDao.insertUser(userInfo)

    }
    fun getUserByName(name:String): User? {
        return userDao.findUserByName(name)
    }

}