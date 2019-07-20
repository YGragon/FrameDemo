package com.example.lib_common.utils.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.example.lib_common.utils.AppManager
import android.view.KeyEvent.KEYCODE_BACK
import com.example.lib_common.utils.constant.BaseConstant


/**
 * Activity 基类
 */
abstract class BaseActivity : AppCompatActivity() {

    private val exitReceiver = ExitReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getLayoutId() != 0) {
            setContentView(getLayoutId())
        }
        initView()
        initData()

        initBroadcast()
        AppManager.instance.addActivity(this)
    }

    abstract fun getLayoutId():Int
    abstract fun initView()
    abstract fun initData()


    /**
     * 退出 App 的广播
     */
    private fun initBroadcast() {
        val filter = IntentFilter()
        filter.addAction(BaseConstant.EXIT_ACTION)
        registerReceiver(exitReceiver, filter)
    }



    override fun onDestroy() {
        AppManager.instance.removeActivity(this)
        unregisterReceiver(exitReceiver)
        super.onDestroy()

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        // 点击手机上的返回键，返回上一层
        if (keyCode == KEYCODE_BACK) {
            // 移除Activity
            AppManager.instance.removeActivity(this)
            this.finish()
        }
        return super.onKeyDown(keyCode, event)
    }

    /**
     * 接收到全局广播，关闭全部 activity
     */
    internal inner class ExitReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
//            this@BaseActivity.finish()
            AppManager.instance.finishAllActivity()
        }

    }
}
