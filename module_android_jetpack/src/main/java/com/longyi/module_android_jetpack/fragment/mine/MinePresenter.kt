package com.longyi.module_android_jetpack.fragment.mine

import android.util.Log
import androidx.lifecycle.LifecycleOwner

/**
 * Created by Aller on 2020/6/3.
 */
class MinePresenter(view:MineContract.View):MineContract.Presenter {
    override fun onStart(owner: LifecycleOwner) {
        Log.e("222","MinePresenter onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.e("222","MinePresenter onResume")
    }

    private val mView = view
    override fun getData() {
        Log.e("222","MinePresenter getData")
        mView.refreshUI()
    }

    override fun attachView(mRootView: MineContract.View) {
    }

    override fun detachView() {
    }
}