package com.longyi.module_android_jetpack.activity

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.longyi.module_android_jetpack.adapter.JetpackStudentAdapter
import com.longyi.module_android_jetpack.data.local.Student
import kotlinx.android.synthetic.main.activity_wechat.*
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.constant.RouterPath
import android.app.ActivityManager
import android.content.Context
import com.longyi.module_android_jetpack.R


@Route(path = RouterPath.AndroidJetPack.WECHAT, name = "测试朋友圈效果")
class WechatActivity : BaseActivity() {

    private val TAG = WechatActivity::class.java.simpleName

    private var list = mutableListOf<Student>()
    val adapter = JetpackStudentAdapter(list)

    override fun getLayoutId(): Int {
        return R.layout.activity_wechat
    }

    override fun initView() {
        for (i in 0..100){
            val student = Student(i, i.toString())
            list.add(student)
        }

        val layoutManager = LinearLayoutManager(this)
        rv_wechat_list.layoutManager = layoutManager
        rv_wechat_list.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun initData() {}

    override fun isSupportSwipeBack(): Boolean {
        // TODO 侧滑返回目前还有问题，感觉 activity 的栈没处理好，所以这里先不处理侧滑返回
        return false
    }


    override fun finish() {
        moveTaskToBack(true)
        val manager = (getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager)!!
        val taskInfoList = manager.getRunningTasks(Int.MAX_VALUE)
        for (task in taskInfoList) {
            if (task.topActivity.packageName == packageName && task.id !== taskId) {
                Log.e(TAG,"finish 返回上一个栈,否则会直接回到手机桌面")
                manager.moveTaskToFront(task.id, 0)
                break
            }
        }
    }
}
