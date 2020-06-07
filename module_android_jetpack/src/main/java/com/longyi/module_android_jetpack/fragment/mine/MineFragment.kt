package com.longyi.module_android_jetpack.fragment.mine

import androidx.lifecycle.ViewModelProviders
import android.util.Log
import androidx.lifecycle.Observer
import com.example.lib_common.base.BaseFragment
import com.longyi.module_android_jetpack.R
import kotlinx.android.synthetic.main.mine_fragment.*

class MineFragment : BaseFragment(),MineContract.View {

    companion object {
        fun newInstance() = MineFragment()
    }
    private val minePresenter = MinePresenter(this)
    private lateinit var viewModel: MineViewModel

    override fun getLayoutId(): Int {
        return R.layout.mine_fragment
    }

    override fun initData() {
        viewModel = ViewModelProviders.of(this).get(MineViewModel::class.java)

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.currentName.observe(this, Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            tv_name.text = newName
        })

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.countDownTime.observe(this, Observer<Long> { aLong ->
            //Update UI
            tv_name.text = "time = " + aLong!!
        })
    }
    override fun initView() {
        // 订阅事件
        lifecycle.addObserver(minePresenter)
        btn_get_data.setOnClickListener {
//            minePresenter.getData()
//            val anotherName = "John Doe"
//            viewModel.currentName.setValue(anotherName)

            viewModel.getTime()
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
