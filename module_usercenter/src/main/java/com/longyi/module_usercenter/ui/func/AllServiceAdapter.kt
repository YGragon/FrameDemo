package com.longyi.module_usercenter.ui.func

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.framedemo.data.bean.MineItemBean
import com.example.lib_common.model.Collect
import com.longyi.module_usercenter.R

/**
 * service list
 */
class AllServiceAdapter(serviceList:MutableList<String>):BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_all_service,serviceList) {
    override fun convert(helper: BaseViewHolder?, item: String) {

        helper?.setText(R.id.tv_service_name,helper.adapterPosition.toString()+":"+item)

    }
}