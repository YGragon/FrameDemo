package com.longyi.module_android_jetpack.fragment


import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.lib_common.base.BaseFragment
import com.example.uitestdemo.viewmodel.CommonLivaData
import com.example.uitestdemo.viewmodel.CommonViewModel
import com.longyi.module_android_jetpack.R
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * test fragment
 */
class MainFragment : BaseFragment() {

    private val TAG = MainFragment::class.java.simpleName
    private var mCommonViewModel: CommonViewModel? = null


    override fun getLayoutId(): Int {
        return R.layout.fragment_main
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
            Log.e(TAG, "onChanged: click---->")
            mCommonViewModel?.getCommonLivaData()?.setTag1(1234566)
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
