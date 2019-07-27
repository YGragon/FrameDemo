package com.longyi.module_usercenter.ui.collect

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lib_common.model.Collect
import com.longyi.module_usercenter.R

/**
 * 收藏 item
 */
class CollectAdapter(collects:List<Collect>) : BaseQuickAdapter<Collect,BaseViewHolder>(R.layout.item_collect,collects) {
    override fun convert(helper: BaseViewHolder?, item: Collect?) {
        helper?.setText(R.id.tv_title,item?.title)
        helper?.setText(R.id.tv_author,item?.author)
        helper?.setText(R.id.tv_nice_date,item?.niceDate)
    }
}