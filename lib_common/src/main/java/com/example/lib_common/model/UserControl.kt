package com.example.lib_common.model

/**
 * 用户控制中心
 */
object UserControl {

    // 是否有用户信息
    private var isHasUserInfo = false
    // 用于信息
    private lateinit var user:User

    fun isLogin(): Boolean {
        return isHasUserInfo
    }

    fun setLogin(loggedIn: Boolean) {
        this.isHasUserInfo = loggedIn
    }

    fun setUser(userInfo:User) {
        this.user = userInfo
    }
    fun getUser(): User {
        return user
    }

}