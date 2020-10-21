package com.longyi.module_course.course


import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

import com.longyi.module_course.FragmentAdapter
import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.RouterPath
import kotlinx.android.synthetic.main.fragment_course.*
import com.google.android.material.tabs.TabLayout
import com.longyi.module_course.R

/**
 * TODO列表功能
 */
@Route(path =  RouterPath.Course.COURSE,name = "TODO列表")
class CourseFragment : BaseFragment() {

    private var mFragments = mutableListOf<Fragment>()
    private var mTitles = mutableListOf<String>()

    private lateinit var mAdapter: FragmentAdapter
    private var isShowToUser = true

    companion object {
        fun newInstance() = CourseFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_course
    }

    override fun initData() {}

    override fun initView() {}

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

        floatActionButton.setOnClickListener {
            ARouter.getInstance().build(RouterPath.Todo.TODO_PUBLISH).navigation()
        }
    }

    override fun fragmentShowToUser() {
        if (isShowToUser){
            val unFinishFragment = UnFinishFragment()
            val finishFragment = FinishFragment()
            mFragments.add(unFinishFragment)
            mFragments.add(finishFragment)
            mTitles.add("未完成")
            mTitles.add("已完成")
            mAdapter = FragmentAdapter(childFragmentManager, mFragments, mTitles)
            view_pager_course.adapter = mAdapter
            tabLayout.setupWithViewPager(view_pager_course)
            initTabLayoutListener()
            isShowToUser = false
        }

    }

    override fun fragmentHideToUser() {}

}
