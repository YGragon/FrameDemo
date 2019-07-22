package com.example.framedemo

import com.example.framedemo.ui.home.contract.HomeContract
import com.example.framedemo.ui.home.presenter.HomePresenter
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


/**
 * 首页
 */
class MainActivity : BaseActivity() {

    private var mHomeFragment : HomeFragment ?= null
    private var mCourseFragment : CourseFragment ?= null
    private var mMineFragment : MineFragment ?= null


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        setDefaultFragment()
        bottom_navigation_bar
            .addItem(BottomNavigationItem(R.mipmap.home_select, "Home"))
            .addItem(BottomNavigationItem(R.mipmap.course_select, "Course"))
            .addItem(BottomNavigationItem(R.mipmap.mine_select, "Mine"))
            .setFirstSelectedPosition(0)
            .initialise()

        bottom_navigation_bar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabSelected(position: Int) {
                onBottomTabSelect(position)
            }
            override fun onTabUnselected(position: Int) {}
            override fun onTabReselected(position: Int) {}
        })

    }

    override fun initData() {}


    /**
     * 底部导航栏切换
     */
    private fun onBottomTabSelect(position: Int) {
        hideFragment()
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        when (position) {
            0 -> {
                if (null == mHomeFragment) {
                    mHomeFragment = HomeFragment.newInstance()
                    transaction.add(R.id.fragment_container, mHomeFragment!!)
                } else {
                    transaction.show(mHomeFragment!!)
                }
            }
            1 -> {
                if (null == mCourseFragment) {
                    mCourseFragment = CourseFragment.newInstance()
                    transaction.add(R.id.fragment_container, mCourseFragment!!)
                } else {
                    transaction.show(mCourseFragment!!)
                }
            }
            2 -> {
                if (null == mMineFragment) {
                    mMineFragment = MineFragment.newInstance()
                    transaction.add(R.id.fragment_container, mMineFragment!!)
                } else {
                    transaction.show(mMineFragment!!)
                }
            }
        }
        // 事务提交
        transaction.commit()
    }

    /**
     * 设置默认的
     */
    private fun setDefaultFragment() {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        mHomeFragment = HomeFragment.newInstance()
        transaction.add(R.id.fragment_container, mHomeFragment!!)
        transaction.commit()
    }
    /**
     * 隐藏 fragment
     */
    private fun hideFragment() {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        if (mHomeFragment != null){
            transaction.hide(mHomeFragment!!)
        }
        if (mCourseFragment != null){
            transaction.hide(mCourseFragment!!)
        }
        if (mMineFragment != null){
            transaction.hide(mMineFragment!!)
        }
        transaction.commit()
    }


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
