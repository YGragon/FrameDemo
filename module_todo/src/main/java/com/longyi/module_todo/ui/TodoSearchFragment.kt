package com.longyi.module_todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lib_common.base.BaseFragment
import com.longyi.module_todo.R

class TodoSearchFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo_search, container, false)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_todo_search
    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun setTvTitleBackgroundColor() {
    }

    override fun fragmentShowToUser() {
    }

    override fun fragmentHideToUser() {
    }

    companion object {
        @JvmStatic
        fun newInstance() = TodoSearchFragment()
    }
}