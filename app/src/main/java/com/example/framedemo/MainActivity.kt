package com.example.framedemo

import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils
import com.example.lib_common.utils.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        ToastUtils.show(this,"你好")

    }

    override fun initData() {
        LogUtils.ee("tag","==tag==")
    }
}
