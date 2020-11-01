package com.longyi.module_usercenter.ui.collect

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lib_common.model.Collect
import com.longyi.module_usercenter.R

/**
 * 收藏 item
 */
class CollectAdapter(collects:List<Collect>) : BaseQuickAdapter<Collect,BaseViewHolder>(R.layout.item_collect,collects) {
    override fun convert(helper: BaseViewHolder?, item: Collect) {
        helper?.setText(R.id.tv_title,item.title)
        if (item.author == null || item.author?.isEmpty()!!){
            helper?.setGone(R.id.tv_author,false)
        }else{
            helper?.setGone(R.id.tv_author,true)
            helper?.setText(R.id.tv_author,"作者: ${item.author}")

        }
        helper?.setText(R.id.tv_nice_date,item.niceDate)
        helper?.setText(R.id.tv_super_chapter_name,item.chapterName)

        helper?.addOnClickListener(R.id.layout_card)
    }
}