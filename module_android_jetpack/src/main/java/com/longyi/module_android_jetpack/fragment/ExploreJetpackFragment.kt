package com.longyi.module_android_jetpack.fragment


import android.app.ActivityManager
import android.content.Context
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.utils.PreferenceUtils
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
        return com.longyi.module_android_jetpack.R.layout.fragment_explore_jetpack
    }

    override fun initData() {

        mCommonViewModel?.getCommonLivaData()?.observe(this, Observer<CommonLivaData>{
            //注册观察者,观察数据的变化
            Log.e(TAG, "onChanged: 数据有更新---->"+it.getTag1())
        })
    }

    override fun initView() {
        mCommonViewModel = activity?.let { ViewModelProviders.of(it).get(CommonViewModel::class.java) }
        btn_jump_to_wechat_moments.setOnClickListener {
            ARouter.getInstance().build(RouterPath.WechatMoments.MOMENTS).withTransition(R.anim.slide_right_in, R.anim.slide_right_out).navigation(activity)
        }
    }

    override fun setTvTitleBackgroundColor() {
    }

    override fun fragmentShowToUser() {
    }

    override fun fragmentHideToUser() {
    }

}
