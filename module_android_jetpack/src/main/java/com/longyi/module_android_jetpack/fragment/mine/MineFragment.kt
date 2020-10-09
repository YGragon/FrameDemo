package com.longyi.module_android_jetpack.fragment.mine

import android.util.Log
import androidx.lifecycle.Observer
import com.example.lib_common.base.BaseFragment
import kotlinx.android.synthetic.main.mine_fragment.*
import android.os.Handler
import android.os.Message
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider

class MineFragment : BaseFragment(),MineContract.View{



    companion object {
        private val TAG = MineFragment::class.java.simpleName
        fun newInstance() = MineFragment()

        private class MyHandler:Handler(){
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    0 -> {
                        Log.e(TAG,"Thread.sleep(5000) before")
                        Thread.sleep(5000)
                        Log.e(TAG,"Thread.sleep(5000) after")
                    }
                    1 -> {
                    }
                    else -> {
                    }
                }
            }
        }
    }
    private  var viewModel = MineViewModel(this)
    private val minePresenter = MinePresenter(this)

    override fun getLayoutId(): Int {
        return com.longyi.module_android_jetpack.R.layout.mine_fragment
    }

    override fun initData() {
        viewModel.currentName.observe(this, Observer<String> { newName ->
            tv_name.text = newName
        })

        viewModel.countDownTime.observe(this, Observer<Long> { aLong ->
            Log.e(TAG,"time = $aLong")
            tv_name.text = "time = $aLong"
        })
    }
    override fun initView() {
        // 订阅事件
//        lifecycle.addObserver(minePresenter)
        btn_get_data.setOnClickListener {
            viewModel.getTime()

//            minePresenter.getData()
//            Observable.interval(1, TimeUnit.SECONDS)
//                .doOnDispose { Log.i(TAG, "Disposing subscription from onViewCreated()") }
//                .autoDispose(AndroidLifecycleScopeProvider.from(viewLifecycleOwner))
//                .subscribe {
//                    Log.e("222","time:$it")
//                }

        }

        AndroidLifecycleScopeProvider.from(this)

    }
    override fun onStart() {
        super.onStart()
        Log.e(TAG,"MineFragment onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG,"MineFragment onResume ")
    }

    override fun getOwnerView():Fragment {
        return this

    }
    override fun refreshUI() {

    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun setTvTitleBackgroundColor() {}

    override fun fragmentShowToUser() {}

    override fun fragmentHideToUser() {}

    override fun onDestroyView() {
        Log.e(TAG,"onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.e(TAG,"onDestroy")
        super.onDestroy()
    }

}
