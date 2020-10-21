package com.longyi.module_home


import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lib_common.model.Article

/**
 * 首页 adapter
 */
class HomeAdapter(list:MutableList<Article>)
    : BaseQuickAdapter<Article,BaseViewHolder>(R.layout.item_article,list) {
    override fun convert(helper: BaseViewHolder?, item: Article?) {
        helper?.setText(R.id.tv_title,item?.title)
        helper?.setText(R.id.tv_author,item?.shareUser)
        helper?.setText(R.id.tv_nice_date,item?.niceDate)

    }
}