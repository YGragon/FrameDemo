package com.longyi.module_expandablelist

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.lib_common.base.BaseActivity
import com.example.lib_common.constant.RouterPath
import java.util.*
import kotlin.collections.ArrayList

@Route(path = RouterPath.Expand.EXPAND_HOME, name = "树形菜单")
class MainActivity :  BaseActivity(){
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var adapter: ExpandableItemAdapter
    private lateinit var list: ArrayList<MultiItemEntity>

    override fun getLayoutId(): Int {
        return R.layout.activity_main

    }

    override fun initView() {
        mRecyclerView = findViewById(R.id.rv)

        list = generateData()
        adapter = ExpandableItemAdapter(list)
        val manager = LinearLayoutManager(this)


        mRecyclerView.adapter = adapter
        // important! setLayoutManager should be called after setAdapter
        mRecyclerView.layoutManager = manager
        adapter.expandAll()
    }

    override fun initData() {
    }
    private fun generateData(): ArrayList<MultiItemEntity> {
        val lv0Count = 9
        val lv1Count = 3
        val personCount = 5

        val nameList = arrayOf("Bob", "Andy", "Lily", "Brown", "Bruce")
        val random = Random()

        val res = ArrayList<MultiItemEntity>()
        for (i in 0 until lv0Count) {
            val lv0 = Level0Item("This is " + i + "th item in Level 0", "subtitle of " + i)
            for (j in 0 until lv1Count) {
                val lv1 = Level1Item("Level 1 item: " + j, "(no animation)")
                for (k in 0 until personCount) {
                    lv1.addSubItem(Person(nameList[k], random.nextInt(40)))
                }
                lv0.addSubItem(lv1)
            }
            res.add(lv0)
        }
        return res
    }
}
