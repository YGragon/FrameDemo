package com.example.framedemo

import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.lib_common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import androidx.fragment.app.FragmentPagerAdapter
import com.jaeger.library.StatusBarUtil
import com.alibaba.android.arouter.launcher.ARouter
import com.example.lib_common.constant.RouterPath

/**
 * 首页
 */
class MainActivity : BaseActivity() {
    private val mFragmentList = ArrayList<Fragment>()

    private val mPagerAdapter = object : FragmentPagerAdapter(supportFragmentManager) {
        override fun getItem(position: Int): Fragment { return mFragmentList[position] }
        override fun getCount(): Int { return mFragmentList.size }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {


        bottom_navigation_bar
            .addItem(BottomNavigationItem(R.mipmap.home_select, "Home"))
            .addItem(BottomNavigationItem(R.mipmap.course_select, "Course"))
            .addItem(BottomNavigationItem(R.mipmap.mine_select, "Mine"))
            .setFirstSelectedPosition(0)
            .initialise()

        initListener()


    }

    override fun initData() {
        val mHomeFragment = ARouter.getInstance().build(RouterPath.Home.HOME).navigation() as Fragment
        val mMineFragment = ARouter.getInstance().build(RouterPath.UserCenter.MINE).navigation() as Fragment
        val mCourseFragment = ARouter.getInstance().build(RouterPath.Course.COURSE).navigation() as Fragment
        mFragmentList.add(mHomeFragment)
        mFragmentList.add(mCourseFragment)
        mFragmentList.add(mMineFragment)

        vp_home.adapter = mPagerAdapter

    }

    private fun initListener(){
        bottom_navigation_bar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabSelected(position: Int) { vp_home.currentItem = position }
            override fun onTabUnselected(position: Int) {}
            override fun onTabReselected(position: Int) {}
        })

        vp_home.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) { bottom_navigation_bar.selectTab(position) }

        })
    }

    override fun setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, null)
    }

}
