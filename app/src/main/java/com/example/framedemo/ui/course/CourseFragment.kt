package com.example.framedemo.ui.course


import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.example.framedemo.R
import com.example.framedemo.ui.FragmentAdapter
import com.example.lib_common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_course.*
import com.google.android.material.tabs.TabLayout

/**
 * 各个库使用例子
 *
 */
class CourseFragment : BaseFragment() {

    private var mFragments = mutableListOf<Fragment>()
    private var mTitles = mutableListOf<String>()
    private lateinit var mAdapter:FragmentAdapter
    companion object {
        fun newInstance() = CourseFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_course
    }

    override fun initData() {
    }

    override fun initView() {

        val finishFragment = FinishFragment()
        val unFinishFragment = UnFinishFragment()
        mFragments.add(finishFragment)
        mFragments.add(unFinishFragment)
        mTitles.add("已完成")
        mTitles.add("未完成")
        mAdapter = FragmentAdapter(childFragmentManager, mFragments, mTitles)
        view_pager_course.adapter = mAdapter
        tabLayout.setupWithViewPager(view_pager_course)
        initTabLayoutListener()

    }
    override fun setTvTitleBackgroundColor() {
        tv_title.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        fake_status_bar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
    }


    private fun initTabLayoutListener() {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                //选中某个tab
                view_pager_course.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    override fun fragmentShowToUser() {}

    override fun fragmentHideToUser() {}

}
