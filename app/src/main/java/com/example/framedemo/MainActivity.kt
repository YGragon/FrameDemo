package com.example.framedemo

import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.lib_common.utils.ToastUtils
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.event.LoginEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.example.framedemo.ui.course.CourseFragment
import com.example.framedemo.ui.home.HomeFragment
import com.example.framedemo.ui.mine.MineFragment
import androidx.fragment.app.FragmentPagerAdapter
import com.jaeger.library.StatusBarUtil

/**
 * 首页
 */
class MainActivity : BaseActivity() {
    private val mFragmentList = ArrayList<Fragment>()
    private var mHomeFragment =  HomeFragment.newInstance()
    private var mCourseFragment = CourseFragment.newInstance()
    private var mMineFragment = MineFragment.newInstance()


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        mFragmentList.add(mHomeFragment)
        mFragmentList.add(mCourseFragment)
        mFragmentList.add(mMineFragment)

        bottom_navigation_bar
            .addItem(BottomNavigationItem(R.mipmap.home_select, "Home"))
            .addItem(BottomNavigationItem(R.mipmap.course_select, "Course"))
            .addItem(BottomNavigationItem(R.mipmap.mine_select, "Mine"))
            .setFirstSelectedPosition(0)
            .initialise()

        bottom_navigation_bar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabSelected(position: Int) {
                vp_home.currentItem = position
            }
            override fun onTabUnselected(position: Int) {}
            override fun onTabReselected(position: Int) {}
        })

        vp_home.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                bottom_navigation_bar.selectTab(position)
            }

        })
        vp_home.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return mFragmentList[position]
            }

            override fun getCount(): Int {
                return mFragmentList.size
            }
        }
    }

     override fun setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(this, null)
    }

    override fun initData() {}


    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onMessageEvent(event: LoginEvent) {
        ToastUtils.show(this, "event_bus return: " + event.str)
    }

}
