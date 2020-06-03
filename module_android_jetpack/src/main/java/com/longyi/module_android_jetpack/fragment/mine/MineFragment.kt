package com.longyi.module_android_jetpack.fragment.mine

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lib_common.base.BaseFragment
import com.just.agentweb.LogUtils

import com.longyi.module_android_jetpack.R
import kotlinx.android.synthetic.main.mine_fragment.*

class MineFragment : BaseFragment(),MineContract.View {

    companion object {
        fun newInstance() = MineFragment()
    }
    private val minePresenter = MinePresenter(this)
    //    private lateinit var viewModel: MineViewModel

    override fun getLayoutId(): Int {
        return R.layout.mine_fragment
    }

    override fun initData() {
        // viewModel = ViewModelProviders.of(this).get(MineViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun initView() {
        // 订阅事件
        lifecycle.addObserver(minePresenter)
        btn_get_data.setOnClickListener {
            minePresenter.getData()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.e("222","MineFragment onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("222","MineFragment onResume ")
    }

    override fun refreshUI() {
        Log.e("222","refreshUI")
    }

    override fun setTvTitleBackgroundColor() {}

    override fun fragmentShowToUser() {}

    override fun fragmentHideToUser() {}

    override fun showLoading() {}

    override fun hideLoading() {}

}
