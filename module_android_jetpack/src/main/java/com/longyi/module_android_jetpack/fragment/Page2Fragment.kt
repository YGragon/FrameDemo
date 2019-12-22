package com.longyi.module_android_jetpack.fragment


import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.lib_common.base.BaseFragment
import com.example.uitestdemo.viewmodel.CommonLivaData
import com.example.uitestdemo.viewmodel.CommonViewModel

import com.longyi.module_android_jetpack.R
import kotlinx.android.synthetic.main.fragment_page2.*

/**
 * A simple [Fragment] subclass.
 */
class Page2Fragment : BaseFragment() {
    private val TAG = Page2Fragment::class.java.simpleName
    private var mCommonViewModel: CommonViewModel? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_page2
    }

    override fun initData() {
        mCommonViewModel?.getCommonLivaData()?.observe(this, Observer<CommonLivaData>{
            //注册观察者,观察数据的变化
            Log.e(TAG, "onChanged: 数据有更新---->"+it.getTag1())
        })
    }

    override fun initView() {
        mCommonViewModel = activity?.let { ViewModelProviders.of(it).get(CommonViewModel::class.java) }
        btn_back_data.setOnClickListener {
            mCommonViewModel?.getCommonLivaData()?.setTag1(456)
            Navigation.findNavController(it).navigateUp()
        }
        btn_to_destination.setOnClickListener {
            mCommonViewModel?.getCommonLivaData()?.setTag1(789)
            Navigation.findNavController(it).navigate(R.id.action_page1)
        }
    }

    override fun setTvTitleBackgroundColor() {
    }

    override fun fragmentShowToUser() {
    }

    override fun fragmentHideToUser() {
    }


}
