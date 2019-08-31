package com.example.framedemo.ui.course

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.framedemo.R
import com.example.lib_common.model.Todo

/**
 * TODO列表 adapter
 */
class TodoAdapter(list:MutableList<Todo>) : BaseQuickAdapter<Todo,BaseViewHolder>(R.layout.item_todo,list) {
    override fun convert(helper: BaseViewHolder?, item: Todo?) {

        helper?.setText(R.id.tv_date, item?.dateStr)
        helper?.setText(R.id.tv_title, item?.title)
        helper?.setText(R.id.tv_content, item?.content)
    }
}