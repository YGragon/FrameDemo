package com.longyi.module_share

import com.example.lib_common.service.user_center.IAccountService

/**
 * 分享
 */
class AccountService :IAccountService {
    override fun getAccountId(): String? {
        return null
//        return if (AccountUtils.userInfo == null) null else AccountUtils.userInfo.getAccountId()
    }



    override fun isLogin(): Boolean {
        return true
//        return AccountUtils.userInfo != null
    }
}