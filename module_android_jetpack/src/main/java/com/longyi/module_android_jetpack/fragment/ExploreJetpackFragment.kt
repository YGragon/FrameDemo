package com.longyi.module_android_jetpack.fragment


import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.RouterPath
import com.example.uitestdemo.viewmodel.CommonLivaData
import com.example.uitestdemo.viewmodel.CommonViewModel

import com.longyi.module_android_jetpack.R
import kotlinx.android.synthetic.main.fragment_explore_jetpack.*

/**
 * jetpack 发现页面
 */
class ExploreJetpackFragment : BaseFragment() {
    private val TAG = ExploreJetpackFragment::class.java.simpleName
    private var mCommonViewModel: CommonViewModel? = null


    override fun getLayoutId(): Int {
        return R.layout.fragment_explore_jetpack
    }

    override fun initData() {

        mCommonViewModel?.getCommonLivaData()?.observe(this, Observer<CommonLivaData>{
            //注册观察者,观察数据的变化
            Log.e(TAG, "onChanged: 数据有更新---->"+it.getTag1())
        })
    }

    override fun initView() {
        mCommonViewModel = activity?.let { ViewModelProviders.of(it).get(CommonViewModel::class.java) }
        btn_post_data.setOnClickListener {
            mCommonViewModel?.getCommonLivaData()?.setTag1(123)
            ARouter.getInstance().build(RouterPath.AndroidJetPack.JETPACK_HOME_DEMO).navigation()
        }
    }

    override fun setTvTitleBackgroundColor() {
    }

    override fun fragmentShowToUser() {
    }

    override fun fragmentHideToUser() {
    }

}
