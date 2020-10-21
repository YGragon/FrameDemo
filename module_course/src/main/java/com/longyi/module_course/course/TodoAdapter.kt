package com.longyi.module_course.course

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lib_common.model.Todo
import com.longyi.module_course.R

/**
 * TODO列表 adapter
 */
class TodoAdapter(list:MutableList<Todo>) : BaseQuickAdapter<Todo,BaseViewHolder>(R.layout.item_todo,list) {
    override fun convert(helper: BaseViewHolder?, item: Todo?) {

        helper?.setText(R.id.tv_date, item?.dateStr)
        helper?.setText(R.id.tv_title, item?.title)
        helper?.setText(R.id.tv_content, item?.content)

        helper?.addOnClickListener(R.id.iv_more)
    }
}