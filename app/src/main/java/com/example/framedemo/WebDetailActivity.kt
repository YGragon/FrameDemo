package com.example.framedemo


import com.example.lib_common.base.BaseActivity
import android.widget.LinearLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.framedemo.R
import com.example.lib_common.constant.ParameterConstant
import com.example.lib_common.constant.RouterPath
import com.just.agentweb.AgentWeb
import kotlinx.android.synthetic.main.activity_web_detail.*

@Route(path = RouterPath.Web.WEB_DETAIL,name = "网页详情")
class WebDetailActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_web_detail
    }

    override fun initView() {
        if (intent.hasExtra(ParameterConstant.Web.webUrl)){
            val webUrl = intent.getStringExtra(ParameterConstant.Web.webUrl)
            AgentWeb.with(this)
                .setAgentWebParent(layout_web_detail as LinearLayout, LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go(webUrl)
        }else{
            finish()
        }

    }

    override fun initData() {
    }



}
