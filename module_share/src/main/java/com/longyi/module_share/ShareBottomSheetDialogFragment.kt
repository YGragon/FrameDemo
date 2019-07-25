package com.longyi.module_share

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * 分享底部弹窗
 */
class ShareBottomSheetDialogFragment : BaseBottomSheetDialogFragment() {
    override fun getLayoutRes(): Int {
        return R.layout.dialog_bottom_sheet
    }

    override fun initData(savedInstanceState: Bundle?) {
        val recyclerView = mRootView.findViewById<RecyclerView>(R.id.rv_dialog_sheet)
        val adapter =  ShareBottomAdapter(getData())
        recyclerView.layoutManager =  LinearLayoutManager(context)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration( DividerItemDecoration(context, LinearLayoutManager.VERTICAL))

    }

    private fun getData():MutableList<String>{
       val list = arrayListOf<String>()
        for (i in 0..20){
            list.add("分享内容 "+i)
        }
        return list
    }
}