package com.longyi.module_todo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * fragment adapter
 */
class FragmentAdapter(fm: FragmentManager, fragmentList: MutableList<Fragment>, titleList: MutableList<String>):FragmentPagerAdapter(fm) {

    private var mFragments:MutableList<Fragment> = fragmentList
    private var mTitleList:MutableList<String> = titleList

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitleList[position]
    }
}