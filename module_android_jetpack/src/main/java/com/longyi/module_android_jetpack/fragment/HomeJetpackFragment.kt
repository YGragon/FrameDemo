package com.longyi.module_android_jetpack.fragment


import android.app.Application
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment
import com.example.uitestdemo.viewmodel.CommonLivaData
import com.example.uitestdemo.viewmodel.CommonViewModel
import com.example.uitestdemo.viewmodel.MainViewModel

import com.longyi.module_android_jetpack.R
import com.longyi.module_android_jetpack.adapter.StudentAdapter
import kotlinx.android.synthetic.main.fragment_home_jetpack.*

/**
 * jetpack 首页
 */
class HomeJetpackFragment : BaseFragment() {
    private val TAG = HomeJetpackFragment::class.java.simpleName
    private var mCommonViewModel: CommonViewModel? = null

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainViewModel(
                BaseApplication.context as Application
            ) as T
        }).get(MainViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home_jetpack
    }



    override fun initView() {

        val adapter = StudentAdapter()
        val layoutManager = LinearLayoutManager(activity)
        rv_list.layoutManager = layoutManager
        rv_list.adapter = adapter
        // 将数据的变化反映到UI上
        viewModel.allStudents.observe(this, Observer {
            adapter.submitList(it)
        })
    }
    override fun initData() {
        mCommonViewModel = activity?.let { ViewModelProviders.of(it).get(CommonViewModel::class.java) }
        mCommonViewModel?.getCommonLivaData()?.observe(this, Observer<CommonLivaData>{
            //注册观察者,观察数据的变化
            Log.e(TAG, "onChanged: 数据有更新---->"+it.getTag1())
        })
    }

    override fun setTvTitleBackgroundColor() {
    }

    override fun fragmentShowToUser() {
    }

    override fun fragmentHideToUser() {
    }



}
