package com.longyi.module_android_jetpack.fragment.mine

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.example.lib_common.base.IBaseView
import com.example.lib_common.base.IPresenter

/**
 * Created by Aller on 2020/6/3.
 */
interface MineContract {
    interface View:IBaseView{
        // 显示刷新后的 UI
        fun refreshUI()
    }

    interface Presenter:IPresenter<View>, LifecycleObserver {
        // 获取数据
        fun getData()

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onStart(owner: LifecycleOwner)

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun onResume(owner: LifecycleOwner)
    }
}