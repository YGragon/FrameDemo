package com.example.lib_common.service_empty

import com.example.lib_common.service.user_center.IAccountService
import android.os.Bundle
import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


/**
 * 空服务实现
 */
class EmptyAccountService : IAccountService {
    override fun isLogin(): Boolean {
        return false
    }

    override fun getAccountId(): String? {
        return null
    }

}