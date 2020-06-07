package com.longyi.module_android_jetpack.fragment


import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.RouterPath
import com.longyi.module_android_jetpack.R

import kotlinx.android.synthetic.main.fragment_explore_jetpack.*

/**
 * jetpack 发现页面
 */
class ExploreJetpackFragment : BaseFragment() {
    private val TAG = ExploreJetpackFragment::class.java.simpleName


    override fun getLayoutId(): Int {
        return R.layout.fragment_explore_jetpack
    }

    override fun initData() {


    }

    override fun initView() {
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
