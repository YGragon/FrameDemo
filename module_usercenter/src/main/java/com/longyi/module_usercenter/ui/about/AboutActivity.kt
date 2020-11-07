package com.longyi.module_usercenter.ui.about

import androidx.appcompat.widget.Toolbar
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.utils.ToastUtils
import com.jaeger.library.StatusBarUtil
import com.longyi.module_usercenter.R
import kotlinx.android.synthetic.main.activity_about.*

@Route(path = RouterPath.UserCenter.ABOUT,name = "关于中心")
class AboutActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_about
    }

    override fun initView() {
        initToolbar()

        card1.setOnClickListener {
            ToastUtils.show(this,"card1")
        }
    }

    override fun initData() {}

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "关于中心"
        toolbar.setBackgroundColor(resources.getColor(R.color.transparent))

        //设置为ActionBar
        setSupportActionBar(toolbar)
        //显示那个箭头
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }


    override fun setStatusBar() {
        StatusBarUtil.setTranslucentForImageView(this, null)
    }
}