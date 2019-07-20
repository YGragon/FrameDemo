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
import android.widget.Toolbar
import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper
import com.example.lib_common.R
import com.example.lib_common.utils.constant.BaseConstant


/**
 * Activity 基类
 */
abstract class BaseActivity : AppCompatActivity() ,BGASwipeBackHelper.Delegate{
    protected var mSwipeBackHelper: BGASwipeBackHelper? = null
    protected var mToolbar: Toolbar? = null

    private val exitReceiver = ExitReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        initSwipeBackFinish()
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

    /**
     * 初始化滑动返回。在 super.onCreate(savedInstanceState) 之前调用该方法
     */
    private fun initSwipeBackFinish() {
        mSwipeBackHelper = BGASwipeBackHelper(this, this)

        // 「必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回」
        // 下面几项可以不配置，这里只是为了讲述接口用法。

        // 设置滑动返回是否可用。默认值为 true
        mSwipeBackHelper?.setSwipeBackEnable(true)
        // 设置是否仅仅跟踪左侧边缘的滑动返回。默认值为 true
        mSwipeBackHelper?.setIsOnlyTrackingLeftEdge(true)
        // 设置是否是微信滑动返回样式。默认值为 true
        mSwipeBackHelper?.setIsWeChatStyle(true)
        // 设置阴影资源 id。默认值为 R.drawable.bga_sbl_shadow
        mSwipeBackHelper?.setShadowResId(R.drawable.bga_sbl_shadow)
        // 设置是否显示滑动返回的阴影效果。默认值为 true
        mSwipeBackHelper?.setIsNeedShowShadow(true)
        // 设置阴影区域的透明度是否根据滑动的距离渐变。默认值为 true
        mSwipeBackHelper?.setIsShadowAlphaGradient(true)
        // 设置触发释放后自动滑动返回的阈值，默认值为 0.3f
        mSwipeBackHelper?.setSwipeBackThreshold(0.3f)
        // 设置底部导航条是否悬浮在内容上，默认值为 false
        mSwipeBackHelper?.setIsNavigationBarOverlap(false)
    }

    /**
     * 是否支持滑动返回。这里在父类中默认返回 true 来支持滑动返回，如果某个界面不想支持滑动返回则重写该方法返回 false 即可
     *
     * @return
     */
    override fun isSupportSwipeBack(): Boolean {
        return true
    }

    /**
     * 正在滑动返回
     *
     * @param slideOffset 从 0 到 1
     */
    override fun onSwipeBackLayoutSlide(slideOffset: Float) {}

    /**
     * 没达到滑动返回的阈值，取消滑动返回动作，回到默认状态
     */
    override fun onSwipeBackLayoutCancel() {}

    /**
     * 滑动返回执行完毕，销毁当前 Activity
     */
    override fun onSwipeBackLayoutExecuted() {
        mSwipeBackHelper?.swipeBackward()
    }
    override fun onBackPressed() {
        // 正在滑动返回的时候取消返回按钮事件
        if (mSwipeBackHelper?.isSliding()!!) {
            return
        }
        mSwipeBackHelper?.backward()
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
