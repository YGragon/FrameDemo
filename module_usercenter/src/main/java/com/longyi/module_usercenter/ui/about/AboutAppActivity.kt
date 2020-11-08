package com.longyi.module_usercenter.ui.about

import androidx.appcompat.widget.Toolbar
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.constant.RouterPath
import com.jaeger.library.StatusBarUtil
import com.longyi.module_usercenter.R
import kotlinx.android.synthetic.main.activity_about_app.*

@Route(path = RouterPath.UserCenter.ABOUT_APP,name = "关于App")
class AboutAppActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_about_app
    }

    override fun initView() {

        initToolbar()

        imageButton2.setOnClickListener {
            if (motionLayout.progress > 0.5f) {
                motionLayout.transitionToStart()
            } else {
                motionLayout.transitionToEnd()
            }
        }
    }

    override fun initData() {
    }

    override fun setStatusBar() {
        StatusBarUtil.setTranslucentForImageView(this, null)
    }


    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "关于App的所有信息"
        toolbar.setBackgroundColor(resources.getColor(R.color.transparent))

        //设置为ActionBar
        setSupportActionBar(toolbar)
        //显示那个箭头
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }
}