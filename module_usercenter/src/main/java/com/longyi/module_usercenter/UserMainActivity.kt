package com.longyi.module_usercenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.utils.base.BaseActivity
import com.example.lib_common.utils.constant.RouterPath

@Route(path = RouterPath.Main.TO_USER_CENTER,name = "用户中心")
class UserMainActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_user_main
    }


    override fun initView() {


    }

    override fun initData() {
    }
}
