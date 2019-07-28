package com.example.framedemo.ui.mine


import android.view.View
import com.alibaba.android.arouter.launcher.ARouter

import com.example.framedemo.R
import com.example.framedemo.ui.mine.contract.MineContract
import com.example.framedemo.ui.mine.presenter.MinePresenter
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.BaseConstant
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.event.LoginEvent
import com.example.lib_common.http.ExceptionHandle
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.example.lib_common.model.UserControl
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.PreferenceUtils
import com.example.lib_common.utils.ToastUtils
import kotlinx.android.synthetic.main.fragment_mine.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


/**
 * 用户中心
 *
 */
class MineFragment : BaseFragment(),MineContract.View {

    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { MinePresenter() }
    init {
        mPresenter.attachView(this)
    }

    companion object {
        fun newInstance() = MineFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun initData() {
        tv_login.setOnClickListener {
            if (UserControl.isLogin()){
                val userName = PreferenceUtils.getString(BaseConstant.USER_NAME)
                ToastUtils.show(BaseApplication.context,"当前登录的用户是：$userName")
            }else{
                ARouter.getInstance().build(RouterPath.UserCenter.LOGIN).navigation()
            }
        }

        tv_collect.setOnClickListener {
            ARouter.getInstance().build(RouterPath.UserCenter.COLLECT).navigation()
        }

        tv_login_out.setOnClickListener {
            mPresenter.loginOut()
        }
    }

    override fun initView() {
        checkUserLogin()
    }

    override fun setTvTitleBackgroundColor() {
        tv_title.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
        fake_status_bar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
    }

    private fun checkUserLogin() {
        if (UserControl.isLogin()) {
            val userName = PreferenceUtils.getString(BaseConstant.USER_NAME)
            tv_login.text = "欢迎你，$userName"
            tv_login_out.visibility = View.VISIBLE
        } else {
            tv_login.text = "点击登录"
            tv_login_out.visibility = View.GONE
        }
    }

    override fun fragmentShowToUser() {
        if (isAdded){
            checkUserLogin()

        }
    }

    override fun fragmentHideToUser() {}

    override fun showError(errorMsg: String) {
        ToastUtils.show(BaseApplication.context,errorMsg)
    }

    override fun showUserInfo() {}

    override fun showLoginOutSuccess(){
        PreferenceUtils.remove(BaseConstant.IS_LOGIN_KEY)
        PreferenceUtils.remove(BaseConstant.USER_NAME)
        checkUserLogin()
        ToastUtils.show(BaseApplication.context,"已退出登录")
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun onResume() {
        super.onResume()
        EventBus.getDefault().register(this)
    }

    override fun onPause() {
        super.onPause()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onMessageEvent(event: LoginEvent) {
        checkUserLogin()
    }

}
