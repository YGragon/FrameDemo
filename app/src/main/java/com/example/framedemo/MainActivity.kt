package com.example.framedemo

import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.utils.LogUtils
import com.example.lib_common.utils.ToastUtils
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.event.LoginEvent
import com.example.lib_common.http.RetrofitManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        ToastUtils.show(this, "你好")

        btn_to_user_center.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Main.TO_USER_CENTER).navigation()
        }

        btn_get_banner.setOnClickListener {
            RetrofitManager.service.getBanners()
                .subscribeOn(Schedulers.io())//将被观察者切换到io线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ res ->
                    LogUtils.ee("222", "返回的结果：" + res.data)
                }, { throwable ->
                    LogUtils.ee("222", "message：" + throwable.message)
                })
        }

    }

    override fun initData() {
        LogUtils.ee("tag", "==tag==")
    }

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
}
