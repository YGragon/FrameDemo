package com.longyi.module_android_jetpack.activity

import android.os.Bundle
import com.longyi.module_android_jetpack.widget.custom_bottom_tab.CustomTabView
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.RouterPath
import com.longyi.module_android_jetpack.R
import com.longyi.module_android_jetpack.widget.custom_bottom_tab.Tab
import com.longyi.module_android_jetpack.fragment.explore.ExploreFragment
import com.longyi.module_android_jetpack.fragment.home.HomeJetpackFragment
import com.longyi.module_android_jetpack.fragment.mine.MineFragment


@Route(path = RouterPath.AndroidJetPack.CUSTOM_TAB,name = "CustomTabView 首页")
class CustomTabViewHomeActivity : AppCompatActivity(), CustomTabView.OnTabCheckListener {


    private val TAG = CustomTabViewHomeActivity::class.java.simpleName
    private var mCustomTabView = CustomTabView(BaseApplication.context)
    private val mFragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mCustomTabView = findViewById(R.id.custom_tab_container)
        val tabHome = Tab.Builder().setText("首页")
            .setColor(resources.getColor(android.R.color.darker_gray))
            .setCheckedColor(resources.getColor(android.R.color.holo_blue_light))
            .setNormalIcon(R.mipmap.home_un_select)
            .setPressedIcon(R.mipmap.home_select)
        mCustomTabView.addTab(tabHome.build())

        val tabExplore = Tab.Builder().setText("发现")
            .setColor(resources.getColor(android.R.color.darker_gray))
            .setCheckedColor(resources.getColor(android.R.color.holo_blue_light))
            .setNormalIcon(R.mipmap.course_un_select)
            .setPressedIcon(R.mipmap.course_select)
        mCustomTabView.addTab(tabExplore.build())

        val tabMine = Tab.Builder().setText("我的")
            .setColor(resources.getColor(android.R.color.darker_gray))
            .setCheckedColor(resources.getColor(android.R.color.holo_blue_light))
            .setNormalIcon(R.mipmap.course_un_select)
            .setPressedIcon(R.mipmap.course_select)
        mCustomTabView.addTab(tabMine.build())

        mFragments.add(HomeJetpackFragment())
        mFragments.add(ExploreFragment())
        mFragments.add(MineFragment.newInstance())
        mCustomTabView.setOnTabCheckListener(this)
        mCustomTabView.setCurrentItem(0)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.home_container).navigateUp()
    }

    override fun onTabSelected(v: View, position: Int) {
        onTabItemSelected(v,position)
    }

    private fun onTabItemSelected(v:View, position: Int) {
        //点击跳转发现
        var fragment: Fragment? = null
        when (position) {
            0 ->{
                fragment = mFragments[0]
                mCustomTabView.updateState(0)
            }
            1 -> {
                fragment = mFragments[1]
                mCustomTabView.updateState(1)
            }
            2 -> {
                fragment = mFragments[2]
                mCustomTabView.updateState(2)
            }
        }
        if (fragment != null) {

            supportFragmentManager.beginTransaction().replace(R.id.home_container, fragment).commit()
        }
    }


}
