package com.example.framedemo.ui.course


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.framedemo.R
import com.example.lib_common.base.BaseFragment

/**
 * 各个库使用例子
 *
 */
class CourseFragment : BaseFragment() {

    companion object{
        fun newInstance() = CourseFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_course
    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun fragmentShowToUser() {
    }

    override fun fragmentHideToUser() {
    }

}
