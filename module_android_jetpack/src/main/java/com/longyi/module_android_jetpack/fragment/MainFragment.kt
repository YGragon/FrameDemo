package com.longyi.module_android_jetpack.fragment


import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.lib_common.base.BaseFragment
import com.longyi.module_android_jetpack.R
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * test fragment
 */
class MainFragment : BaseFragment() {

    private val TAG = MainFragment::class.java.simpleName


    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun initData() {
    }

    override fun initView() {
        btn_jump_to_wechat_moments.setOnClickListener {
            Log.e(TAG, "onChanged: click---->")
            Navigation.findNavController(it).navigate(R.id.action_view_model)
        }
    }

    override fun setTvTitleBackgroundColor() {
    }

    override fun fragmentShowToUser() {
    }

    override fun fragmentHideToUser() {
    }

}
