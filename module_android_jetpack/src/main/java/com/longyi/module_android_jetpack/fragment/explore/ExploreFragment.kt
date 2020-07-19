package com.longyi.module_android_jetpack.fragment.explore


import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.RouterPath
import com.longyi.module_android_jetpack.R
import com.longyi.module_android_jetpack.utils.ButtonDelayUtil
import kotlinx.android.synthetic.main.fragment_explore.*


/**
 * jetpack 发现页面
 */
class ExploreFragment : BaseFragment() {
    private val TAG = ExploreFragment::class.java.simpleName


    override fun getLayoutId(): Int {
        return R.layout.fragment_explore
    }

    override fun initData() {


    }

    override fun initView() {
        btn_to_wechat.setOnClickListener {
            ARouter.getInstance().build(RouterPath.AndroidJetPack.WECHAT).navigation()
        }
        btn_to_coin_rank.setOnClickListener {
            if (ButtonDelayUtil.isFastClick()) {
                val bundle = Bundle()
                bundle.putString("name", "SouthernBox")
//                NavHostFragment
//                    .findNavController(it)
//                    .navigate(R.id.action_exploreFragment_to_coinRankFragment,bundle)
                val navController = NavHostFragment.findNavController(this)
                if (navController.currentDestination?.id == R.id.exploreFragment) {
                    navController.navigate(R.id.action2)
                }else{
                    Log.e("222","============")
                }
                //Type safe passing data

//            ARouter.getInstance().build(RouterPath.WechatMoments.MOMENTS).withTransition(R.anim.slide_right_in, R.anim.slide_right_out).navigation(activity)
            }

        }
    }

    override fun setTvTitleBackgroundColor() {
    }

    override fun fragmentShowToUser() {
    }

    override fun fragmentHideToUser() {
    }

}
