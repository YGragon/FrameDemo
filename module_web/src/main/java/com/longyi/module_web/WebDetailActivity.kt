package com.longyi.module_web


import android.widget.FrameLayout
import com.example.lib_common.base.BaseActivity
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.just.agentweb.AgentWeb
import kotlinx.android.synthetic.main.activity_web_detail.*
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterPath.Web.WEB_DETAIL,name = "网页详情")
class WebDetailActivity : BaseActivity() {

    @JvmField
    @Autowired(name = ParameterConstant.Web.webUrl)
    var webUrl: String?=null

    override fun getLayoutId(): Int {
        return R.layout.activity_web_detail
    }

    override fun initView() {
        // 使用注解，需在 onCreate 引入
        ARouter.getInstance().inject(this)
        initToolbar()

        if (webUrl != null){
            AgentWeb.with(this)
                .setAgentWebParent(layout_web_detail as FrameLayout, FrameLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(webUrl)
        }else{
            finish()
        }

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



}
