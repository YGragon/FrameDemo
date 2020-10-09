package com.longyi.module_android_jetpack.fragment.mine

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider
import com.example.lib_common.http.runRxLambdaViewModel
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by Aller on 2020/6/3.
 */
class MinePresenter(val view:MineContract.View):MineContract.Presenter {
    override fun onStart(owner: LifecycleOwner) {
        Log.e("222","MinePresenter onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.e("222","MinePresenter onResume")
    }

    override fun getData() {
        Log.e("222","MinePresenter getData")
        runRxLambdaViewModel(AndroidLifecycleScopeProvider.from(view.getOwnerView()),
            Observable.intervalRange(0,100,1,1, TimeUnit.SECONDS),{
                Log.e("222","time:$it")
                view.refreshUI()
            }
        )
    }

    override fun attachView(mRootView: MineContract.View) {
    }

    override fun detachView() {
    }
}
