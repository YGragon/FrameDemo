package com.longyi.module_usercenter.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lib_common.base.BaseFragment
import com.longyi.module_usercenter.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AboutMeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutMeFragment : BaseFragment() {


    override fun getLayoutId(): Int {
        return R.layout.fragment_about_me
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
        fun newInstance() = AboutMeFragment()
    }
}