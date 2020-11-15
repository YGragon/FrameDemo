package com.longyi.module_usercenter.ui.func

import android.content.Context
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.longyi.module_usercenter.R
import razerdp.basepopup.BasePopupWindow

/**
 * 展示所有 service 的弹窗
 */
class AllServicePopup(var context: Context,var list: MutableList<String>): BasePopupWindow(context) {

    init {
        val rvService = findViewById<RecyclerView>(R.id.rv_all_service_dialog)
        rvService.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = AllServiceAdapter(list)
        }
    }

    override fun onCreateContentView(): View {
        return createPopupById(R.layout.popup_all_service)
    }

}