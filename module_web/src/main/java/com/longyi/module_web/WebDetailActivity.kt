package com.longyi.module_web


import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.webkit.WebView
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dong.marqueelib.MarqueeTextviewNofocus
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.runRxLambdaViewModel
import com.example.lib_common.service.user_center.ILoginService
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils
import com.just.agentweb.AgentWeb
import com.just.agentweb.WebChromeClient
import kotlinx.android.synthetic.main.activity_web_detail.*


@Route(path = RouterPath.Web.WEB_DETAIL, name = "网页详情")
class WebDetailActivity : BaseActivity() {

    //    @JvmField
//    @Autowired(name = ParameterConstant.Web.webUrl)
    var webUrl: String? = null

    //    @JvmField
//    @Autowired(name = ParameterConstant.Web.webID)
    var webID: Int? = null

    //    @JvmField
//    @Autowired(name = ParameterConstant.Web.webCollected)
    var webCollected: Boolean? = false

    private var mAgentWeb: AgentWeb? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_web_detail
    }

    override fun initView() {
        // 使用注解，需在 onCreate 引入
//        ARouter.getInstance().inject(this)
        // 使用 Autowired 会出现第二次进入页面数据为 null, 改用 intent 获取则不会出现
     initToolbar()

        webUrl = intent.getStringExtra(ParameterConstant.Web.webUrl)
        webID = intent.getIntExtra(ParameterConstant.Web.webID, -1)
        webCollected = intent.getBooleanExtra(ParameterConstant.Web.webCollected, false)

        if (webUrl != null) {
            mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(
                    layout_web_detail as FrameLayout,
                    FrameLayout.LayoutParams(-1, -1)
                )
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(webUrl)

            //获取网页的标题
            mAgentWeb?.webCreator?.webView?.webChromeClient = object : WebChromeClient() {
                override fun onReceivedTitle(
                    view: WebView?,
                    title: String
                ) {
                    if (!TextUtils.isEmpty(title)) {
                        // 滚动标题
                        tv_marquee.text = title
                        tv_marquee.init(windowManager)
                        tv_marquee.setScrollDirection(MarqueeTextviewNofocus.RIGHT_TO_LEFT)
                        tv_marquee.setScrollMode(MarqueeTextviewNofocus.SCROLL_FAST)
                    }
                    super.onReceivedTitle(view, title)
                }
            }
        } else {
            finish()
        }

        if (webID == -1) {
            floatActionButton.hide()
        } else {
            floatActionButton.show()

            if (webCollected!!) {
                showCollectIcon()
            } else {
                showUnCollectIcon()
            }

        }

        floatActionButton.setOnClickListener {
            // 是否登录，未登录不可收藏
            val loginService =
                ARouter.getInstance().build("/provider/ILoginService").navigation() as ILoginService
            val login = loginService.isLogin()
            Log.e("WebDetailActivity", "bindLike login:$login")
            if (login) {
                if (webCollected!!) {
                    unLike(webID!!)
                } else {
                    like(webID!!)
                }
            } else {
                ToastUtils.show(this, "你还未登录哟")
            }
        }

    }

    private fun showCollectIcon() {
        webCollected = true
        val colorStateList: ColorStateList? =
            ContextCompat.getColorStateList(applicationContext, R.color.colorAccent)
//                floatActionButton.backgroundTintMode = PorterDuff.Mode.SRC_ATOP
//                floatActionButton.backgroundTintList = colorStateList
        floatActionButton.imageTintList = colorStateList
        floatActionButton.imageTintMode = PorterDuff.Mode.SRC_ATOP
    }

    private fun showUnCollectIcon() {
        webCollected = false
        val colorStateList: ColorStateList? =
            ContextCompat.getColorStateList(applicationContext, R.color.white)
//                floatActionButton.backgroundTintMode = PorterDuff.Mode.SRC
//                floatActionButton.backgroundTintList = colorStateList
        floatActionButton.imageTintList = colorStateList
        floatActionButton.imageTintMode = PorterDuff.Mode.SRC_ATOP
    }


    private fun unLike(id: Int) {
        // runRxLambda 网络请求工具使用
        runRxLambdaViewModel(
            AndroidLifecycleScopeProvider.from(this),
            RetrofitManager.service.regionUnCollect(id), {
                if (it.errorCode == 0) {
                    // 成功
                    showUnCollectIcon()
                    ToastUtils.show(this, "取消收藏成功")
                } else {
                    // 失败
                    ToastUtils.show(this, "取消收藏失败：${it.errorMsg}")
                }
            })
    }

    private fun like(id: Int) {
        // runRxLambda 网络请求工具使用
        runRxLambdaViewModel(
            AndroidLifecycleScopeProvider.from(this),
            RetrofitManager.service.regionCollect(id), {
                if (it.errorCode == 0) {
                    // 成功
                    showCollectIcon()
                    ToastUtils.show(this, "收藏成功")
                } else {
                    // 失败
                    ToastUtils.show(this, "收藏失败：${it.errorMsg}")
                }
            })
    }

    override fun initData() {}

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "网页详情"
        toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))

        //设置为ActionBar
        setSupportActionBar(toolbar)
        //显示那个箭头
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }

    override fun onPause() {
        mAgentWeb?.webLifeCycle?.onPause()
        super.onPause()
    }

    override fun onResume() {
        mAgentWeb?.webLifeCycle?.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        mAgentWeb?.webLifeCycle?.onDestroy()
        super.onDestroy()
    }

}
