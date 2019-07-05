package com.example.framedemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ToastUtils.show(this,"你好")
        LogUtils.ee("tag","==tag==")
    }
}
