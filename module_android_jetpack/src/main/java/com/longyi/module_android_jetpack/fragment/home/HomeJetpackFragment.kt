package com.longyi.module_android_jetpack.fragment.home


import android.app.Application
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.base.BaseFragment

import com.longyi.module_android_jetpack.R
import com.longyi.module_android_jetpack.adapter.StudentAdapter
import kotlinx.android.synthetic.main.fragment_home_jetpack.*

/**
 * jetpack 首页
 */
class HomeJetpackFragment : BaseFragment() {
    private val TAG = HomeJetpackFragment::class.java.simpleName

    private val viewModel  = HomeViewModel(BaseApplication.context as Application)

    override fun getLayoutId(): Int {
        return R.layout.fragment_home_jetpack
    }



    override fun initView() {

        val adapter = StudentAdapter()
        val layoutManager = LinearLayoutManager(activity)
        rv_fragment_home_list.layoutManager = layoutManager
        rv_fragment_home_list.adapter = adapter
        // 将数据的变化反映到UI上
        viewModel.allStudents.observe(this, Observer {
            adapter.submitList(it)
        })
    }
    override fun initData() {}

    override fun setTvTitleBackgroundColor() {}

    override fun fragmentShowToUser() {}

    override fun fragmentHideToUser() {}



}
