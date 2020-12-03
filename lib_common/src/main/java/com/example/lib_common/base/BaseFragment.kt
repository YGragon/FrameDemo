package com.example.lib_common.base


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


/**
 *  Fragment 基类
 *
 */
abstract class BaseFragment : Fragment() {

    // 界面是否已创建完成
    private var mIsViewCreated: Boolean = false
    // 是否对用户可见
    private var mIsVisibleToUser: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayoutId(), container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setTvTitleBackgroundColor()
        initData()
    }

    abstract fun getLayoutId(): Int

    abstract fun initData()

    abstract fun initView()
    abstract fun setTvTitleBackgroundColor()

    abstract fun fragmentShowToUser()

    abstract fun fragmentHideToUser()

    /**
     * 使用ViewPager嵌套fragment时，切换ViewPager回调该方法
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        mIsVisibleToUser = isVisibleToUser

        Log.e("333","setUserVisibleHint:$mIsVisibleToUser")
        if (isVisibleToUser) fragmentShowToUser() else fragmentHideToUser()
    }

    /**
     * fragment 显示、隐藏时回调该方法
     */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        mIsVisibleToUser = hidden
        Log.e("333","onHiddenChanged:$mIsVisibleToUser")
        if (hidden) fragmentHideToUser() else fragmentShowToUser()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mIsViewCreated = true
        mIsVisibleToUser = true
    }

    override fun onDestroy() {
        mIsViewCreated = false
        mIsVisibleToUser = false
        super.onDestroy()
    }

}
