package com.example.lib_common.utils.rxbus.lifecycle

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.IllegalStateException

/**
 * 无界面的 Fragment 管理生命周期
 */
class HolderLifeFragment:Fragment() {
    private val sTAG = "RxBus-HolderLifeFragment"
    // 1. 管理 activity，fragment 的生命周期
    private val sHolderFragmentManager = HolderFragmentManager()

    // 2. 管理 dispose
    private val compositeDisposable = CompositeDisposable()

    // 3. 提供给外部 activity fragment 调用
    fun holderFragmentFor(activity: FragmentActivity?): HolderLifeFragment? {
        Log.e("222", "activity:$activity")
        return if (activity == null) {
            HolderLifeFragment()
        } else {
            sHolderFragmentManager.holderFragmentFor(activity)
        }
    }


    fun holderFragmentFor(fragment: Fragment?): HolderLifeFragment? {
        return if (fragment == null) {
            HolderLifeFragment()
        } else {
            sHolderFragmentManager.holderFragmentFor(fragment)
        }
    }


    companion object{
        private const val HOLDER_TAG = "com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment.tag"

        // 生命周期管理
        class HolderFragmentManager{
            private val sTAG = "RxBus-HolderFragmentManager"
            private val mNotCommittedActivityHolders = HashMap<Activity, HolderLifeFragment?>()
            private val mNotCommittedFragmentHolders = HashMap<Fragment, HolderLifeFragment?>()

            private var mActivityCallbacksIsAdded = false


            // activity
            private val mActivityCallbacks = object : EmptyActivityLifecycleCallbacks() {
                override fun onActivityDestroyed(activity: Activity?) {
                    super.onActivityDestroyed(activity)
                    val fragment = mNotCommittedActivityHolders.remove(activity)
                    if (fragment != null) {
                        Log.e(sTAG, "Failed to save a ViewModel for $activity")
                    }
                }
            }

            // fragment
            private val mParentDestroyedCallback = object : FragmentManager.FragmentLifecycleCallbacks(){
                override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {
                    super.onFragmentDestroyed(fm, f)
                    val fragment = mNotCommittedFragmentHolders.remove(f)
                    if (fragment != null) {
                        Log.e(sTAG, "Failed to save a ViewModel for $f")
                    }
                }
            }

            // 创建并注册生命周期
            fun holderFragmentCreated(holderFragment:Fragment){

                val parentFragment = holderFragment.parentFragment
                if (parentFragment != null){
                    mNotCommittedFragmentHolders.remove(parentFragment)
                    parentFragment.parentFragmentManager.unregisterFragmentLifecycleCallbacks(mParentDestroyedCallback)
                }else{
                    mNotCommittedActivityHolders.remove(holderFragment.requireActivity())
                }
            }

            // 在 activity  使用 无界面 fragment 管理生命周期
            fun holderFragmentFor(activity: FragmentActivity): HolderLifeFragment {
                val fm = activity.supportFragmentManager
                var holder = findHolderFragment(fm)
                if (holder != null) {
                    return holder as HolderLifeFragment
                }

                holder = mNotCommittedActivityHolders[activity]
                if (holder != null) {
                    return holder
                }

                // 是否注册过
                if (!mActivityCallbacksIsAdded) {
                    mActivityCallbacksIsAdded = true
                    activity.application.registerActivityLifecycleCallbacks(mActivityCallbacks)
                }
                holder = createHolderFragment(fm)
                mNotCommittedActivityHolders[activity] = holder
                return holder
            }

            // 在 fragment 使用 无界面 fragment 管理生命周期
            fun holderFragmentFor(parentFragment: Fragment): HolderLifeFragment {
                val fm = parentFragment.childFragmentManager
                var holder = findHolderFragment(fm)
                if (holder != null) {
                    return holder as HolderLifeFragment
                }
                holder = mNotCommittedFragmentHolders[parentFragment]
                if (holder != null) {
                    return holder
                }

                parentFragment.parentFragmentManager.registerFragmentLifecycleCallbacks(mParentDestroyedCallback, false)
                holder = createHolderFragment(fm)
                mNotCommittedFragmentHolders[parentFragment] = holder
                return holder
            }

            // 查找 fragment，没找到则返回 null
            private fun findHolderFragment(manager:FragmentManager):Any?{

                check(!manager.isDestroyed) { "Can't access ViewModels from onDestroy" }

                val fragmentByTag = manager.findFragmentByTag(HOLDER_TAG)

                check(!(fragmentByTag != null && fragmentByTag !is HolderLifeFragment)) { "Unexpected " + "fragment instance was returned by HOLDER_TAG" }
                return fragmentByTag
            }

            // 创建
            private fun createHolderFragment(fragmentManager:FragmentManager):HolderLifeFragment{
                val holder = HolderLifeFragment()
                fragmentManager.beginTransaction().add(holder, HOLDER_TAG).commitAllowingStateLoss()
                return holder
            }
        }
    }

   init {
        retainInstance = true
   }

    // 在 onCreate 注册
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sHolderFragmentManager.holderFragmentCreated(this)

    }

    // 在 onDestroy 关闭 dispose
    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()

    }

    fun setDispose(dispose: Disposable) {
        compositeDisposable.add(dispose)
    }
}