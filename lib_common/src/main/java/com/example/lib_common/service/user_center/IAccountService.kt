package com.example.lib_common.service.user_center

import android.os.Bundle
import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


/**
 * 用户中心服务
 */
interface IAccountService {
    /**
     * 是否已经登录
     *
     * @return
     */
    fun isLogin(): Boolean

    /**
     * 获取登录用户的 AccountId
     *
     * @return
     */
    fun getAccountId(): String?

}