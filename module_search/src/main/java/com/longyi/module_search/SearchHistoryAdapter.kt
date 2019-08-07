package com.longyi.module_search

import android.text.Html
import android.text.Html.FROM_HTML_MODE_COMPACT
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lib_common.model.SearchHistory

/**
 * 搜索历史列表
 */
class SearchHistoryAdapter(list:MutableList<SearchHistory>)
    :BaseQuickAdapter<SearchHistory,BaseViewHolder>(R.layout.item_search_history,list) {

    override fun convert(helper: BaseViewHolder?, item: SearchHistory?) {

        helper?.setText(R.id.tv_search_history_title, item?.keyWord)
        helper?.addOnClickListener(R.id.iv_search_history_del)

    }
}