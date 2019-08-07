package com.longyi.module_search

import android.text.Html
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lib_common.model.SearchBean
import com.example.lib_common.utils.GlideUtils
import com.tencent.bugly.proguard.p

/**
 * 搜索结果
 */
class SearchMainAdapter(list:MutableList<SearchBean>)
    :BaseQuickAdapter<SearchBean,BaseViewHolder>(R.layout.item_search,list) {

    override fun convert(helper: BaseViewHolder?, item: SearchBean?) {

        helper?.setText(R.id.tv_search_author,item?.author)
        helper?.setText(R.id.tv_search_time,item?.niceDate)
        helper?.setText(R.id.tv_search_title, Html.fromHtml(item?.title))
        helper?.setText(R.id.tv_search_desc,item?.desc)


    }
}