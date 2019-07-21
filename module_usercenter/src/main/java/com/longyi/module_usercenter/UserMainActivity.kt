package com.longyi.module_usercenter

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.event.LoginEvent
import kotlinx.android.synthetic.main.activity_user_main.*
import org.greenrobot.eventbus.EventBus


@Route(path = RouterPath.Main.TO_USER_CENTER,name = "用户中心")
class UserMainActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_user_main
    }


    override fun initView() {
        btn_send_event.setOnClickListener {
            EventBus.getDefault().postSticky(LoginEvent("你好！"))
            finish()
        }

    }

    override fun initData() {
    }
}
