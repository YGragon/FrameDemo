package com.longyi.module_usercenter.ui.login

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.appcompat.widget.Toolbar
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.utils.ToastUtils
import com.jaeger.library.StatusBarUtil
import com.longyi.module_usercenter.R
import kotlinx.android.synthetic.main.activity_login.*

@Route(path = RouterPath.UserCenter.LOGIN,name = "登录页面")
class LoginActivity : BaseActivity(), LoginContract.View {

    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { LoginPresenter() }
    init {
        mPresenter.attachView(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        // TODO 做判空
        btn_login.setOnClickListener {
            mPresenter.postLoginInfo(et_login_username.text.toString(),et_login_password.text.toString())
        }
        tv_register.setOnClickListener {
            ARouter.getInstance().build(RouterPath.UserCenter.REGISTER).navigation()
        }
        cb_login_pwd_visible.setOnCheckedChangeListener { _buttonView, isChecked ->
            if (isChecked) {
                et_login_password.transformationMethod = HideReturnsTransformationMethod.getInstance()
                et_login_password.setSelection(et_login_password.text.toString().length)
            } else {
                et_login_password.transformationMethod = PasswordTransformationMethod.getInstance()
                et_login_password.setSelection(et_login_password.text.toString().length)
            }
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "登录"
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

    override fun initData() {}

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context,errorMsg)
    }

    override fun showLoginSuccess(successMsg: String) {
        ToastUtils.show(BaseApplication.context,successMsg)
        finish()
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onDestroy() {
        mPresenter.detachView()
        super.onDestroy()
    }
}
