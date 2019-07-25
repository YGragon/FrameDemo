package com.longyi.module_share

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * 分享列表
 */
class ShareBottomAdapter(list:MutableList<String>)
    :BaseQuickAdapter<String,BaseViewHolder>(R.layout.support_simple_spinner_dropdown_item,list) {
    override fun convert(helper: BaseViewHolder?, item: String?) {

        helper?.setText(android.R.id.text1,item)
    }
}