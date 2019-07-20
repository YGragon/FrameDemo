package com.longyi.module_usercenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils
import com.example.lib_common.utils.base.BaseActivity
import com.example.lib_common.utils.constant.RouterPath
import com.example.lib_common.utils.event.LoginEvent
import kotlinx.android.synthetic.main.activity_user_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


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
