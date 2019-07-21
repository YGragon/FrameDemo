package com.example.framedemo

import com.alibaba.android.arouter.launcher.ARouter
import com.example.framedemo.ui.home.contract.HomeContract
import com.example.framedemo.ui.home.presenter.HomePresenter
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.event.LoginEvent
import com.example.lib_common.http.RetrofitManager
import com.example.lib_common.http.scheduler.SchedulerUtils
import com.example.lib_common.model.Banner
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : BaseActivity(), HomeContract.View {

    /**
     * 懒加载Presenter
     */
    private val mPresenter by lazy { HomePresenter() }
    init {
        mPresenter.attachView(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        ToastUtils.show(this, "你好")

        btn_to_user_center.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Main.TO_USER_CENTER).navigation()
        }

        btn_get_banner.setOnClickListener {
            mPresenter.getBanners()
        }

    }


    override fun initData() {}

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onMessageEvent(event: LoginEvent) {
        ToastUtils.show(this, "event_bus return: " + event.str)
    }

    override fun showLoading() {}

    override fun dismissLoading() {}

    override fun showError(errorMsg: String) {
        ToastUtils.show(this,errorMsg)
    }

    override fun showBanners(banners: MutableList<Banner>) {
    }

}
