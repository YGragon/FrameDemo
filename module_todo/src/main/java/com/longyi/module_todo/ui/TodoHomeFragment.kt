package com.longyi.module_todo.ui


import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

import com.example.lib_common.base.BaseFragment
import com.example.lib_common.constant.RouterPath
import com.example.lib_common.widget.ViewpagerHeader
import com.google.android.material.tabs.TabLayout
import com.longyi.module_todo.FragmentAdapter
import com.longyi.module_todo.R
import kotlinx.android.synthetic.main.fragment_todo_home.*

/**
 * TODO列表功能
 */
@Route(path =  RouterPath.Todo.TODO_LIST,name = "TODO列表")
class TodoHomeFragment : BaseFragment() {

    private var mFragments = mutableListOf<Fragment>()
    private var mTitles = mutableListOf<String>()

    private lateinit var mAdapter: FragmentAdapter
    private var isShowToUser = true

    companion object {
        fun newInstance() = TodoHomeFragment()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_todo_home
    }

    override fun initData() {}

    override fun initView() {}

    override fun setTvTitleBackgroundColor() {
//        tv_title.setBackgroundColor(resources.getColor(R.color.colorPrimary))
//        fake_status_bar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
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
            val unFinishFragment = UnFinishFragment.newInstance()
            val finishFragment = FinishFragment.newInstance()
            val searchFragment = TodoSearchFragment.newInstance()
            mFragments.add(unFinishFragment)
            mFragments.add(finishFragment)
            mFragments.add(searchFragment)
            mTitles.add("未完成")
            mTitles.add("已完成")
            mTitles.add("ToDo 筛选")
            mAdapter = FragmentAdapter(childFragmentManager, mFragments, mTitles)
            view_pager_course.adapter = mAdapter

            // 滑动监听
            val viewPagerHeader = requireActivity().findViewById<ViewpagerHeader>(R.id.viewPagerMotionLayout)
            if (viewPagerHeader != null) {
                view_pager_course.addOnPageChangeListener(viewPagerHeader)
            }

            tabLayout.setupWithViewPager(view_pager_course)
            initTabLayoutListener()
            isShowToUser = false
        }

    }

    override fun fragmentHideToUser() {}

}
