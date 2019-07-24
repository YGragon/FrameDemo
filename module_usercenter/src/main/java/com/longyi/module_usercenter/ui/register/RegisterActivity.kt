package com.longyi.module_usercenter.ui.register

import androidx.appcompat.widget.Toolbar
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.utils.ToastUtils
import com.jaeger.library.StatusBarUtil
import com.longyi.module_usercenter.R
import kotlinx.android.synthetic.main.activity_register.*

/**
 * 注册页面
 */
@Route(path = RouterPath.UserCenter.REGISTER,name = "注册页面")
class RegisterActivity : BaseActivity() ,RegisterContract.View{

    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { RegisterPresenter() }
    init {
        mPresenter.attachView(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initView() {
        // TODO 需要做判空
        btn_register.setOnClickListener {
            mPresenter.postRegisterInfo(et_register_username.text.toString(),et_register_password.text.toString(),et_register_password.text.toString())
        }
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "注册"
        //设置为ActionBar
        setSupportActionBar(toolbar)
        //显示那个箭头
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

    }

    override fun setStatusBar() {
        fake_status_bar.setBackgroundColor(resources.getColor(R.color.colorAccent))
        StatusBarUtil.setTranslucentForImageView(this,null)

    }

    override fun initData() {
    }

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context,errorMsg)
    }

    override fun showRegisterSuccess(successMsg: String) {
        ToastUtils.show(BaseApplication.context,successMsg)
        finish()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

}
