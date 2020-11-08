package com.longyi.module_usercenter.ui.about

import androidx.appcompat.widget.Toolbar
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.utils.AppUtils
import com.example.lib_common.utils.ToastUtils
import com.jaeger.library.StatusBarUtil
import com.longyi.module_usercenter.R
import kotlinx.android.synthetic.main.activity_about.*


@Route(path = RouterPath.UserCenter.ABOUT,name = "关于中心")
class AboutActivity : BaseActivity(){

    override fun getLayoutId(): Int {
        return R.layout.activity_about
    }

    override fun initView() {
        initToolbar()

        card1.setOnClickListener {
            ARouter.getInstance()
                .build(RouterPath.UserCenter.ABOUT_APP)
                .navigation(this)
        }
        card2.setOnClickListener {
            ARouter.getInstance()
                .build(RouterPath.UserCenter.ABOUT_ME)
                .navigation(this)
        }
    }

    override fun initData() {

        val verName = AppUtils.getVerName(this)
        subtitle3.text = "V:$verName"
    }

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