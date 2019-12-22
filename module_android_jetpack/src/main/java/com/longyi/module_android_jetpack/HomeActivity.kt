package com.longyi.module_android_jetpack

import com.example.lib_common.base.BaseActivity
import com.longyi.module_android_jetpack.widget.custom_bottom_tab.CustomTabView
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.View
import androidx.navigation.Navigation.findNavController
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.constant.RouterPath
import com.longyi.module_android_jetpack.widget.custom_bottom_tab.Tab
import com.longyi.module_android_jetpack.fragment.ExploreJetpackFragment
import com.longyi.module_android_jetpack.fragment.HomeJetpackFragment


@Route(path = RouterPath.AndroidJetPack.JETPACK_HOME,name = "AndroidJetPack 首页")
class HomeActivity : BaseActivity(), CustomTabView.OnTabCheckListener {

    private var mCustomTabView = CustomTabView(BaseApplication.context)
    private val mFragments = mutableListOf<Fragment>()

    override fun getLayoutId(): Int {
        return R.layout.activity_home

    }

    override fun initView() {


        mCustomTabView = findViewById(R.id.custom_tab_container)
        val tabHome = Tab.Builder().setText("首页")
            .setColor(resources.getColor(android.R.color.darker_gray))
            .setCheckedColor(resources.getColor(android.R.color.holo_blue_light))
            .setNormalIcon(R.mipmap.home_select)
            .setPressedIcon(R.mipmap.home_un_select)
        mCustomTabView.addTab(tabHome.build())

        val tabExplore = Tab.Builder().setText("发现")
            .setColor(resources.getColor(android.R.color.darker_gray))
            .setCheckedColor(resources.getColor(android.R.color.holo_blue_light))
            .setNormalIcon(R.mipmap.course_select)
            .setPressedIcon(R.mipmap.course_un_select)
        mCustomTabView.addTab(tabExplore.build())


    }

    override fun initData() {
        mFragments.add(HomeJetpackFragment())
        mFragments.add(ExploreJetpackFragment())
        mCustomTabView.setOnTabCheckListener(this)
        mCustomTabView.setCurrentItem(0)

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
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.home_container, fragment).commit()
        }
    }
}
