package com.longyi.module_todo.ui

import android.graphics.Color
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lib_common.constant.BaseConstant
import com.example.lib_common.model.Todo
import com.example.lib_common.utils.DateUtils
import com.longyi.module_todo.R

/**
 * TODO列表 adapter
 */
class TodoAdapter(list:MutableList<Todo>) : BaseQuickAdapter<Todo,BaseViewHolder>(R.layout.item_todo,list) {
    override fun convert(helper: BaseViewHolder?, item: Todo?) {

        helper?.setText(R.id.tv_date, "开始时间："+item?.dateStr)
        helper?.setText(R.id.tv_title, "标题：\r\n"+item?.title)
        helper?.setText(R.id.tv_content, "内容：\r\n"+item?.content)

        when (item?.type) {
            BaseConstant.TODO_TYPE_WORK -> helper?.setText(R.id.tv_type, "类型：工作")
            BaseConstant.TODO_TYPE_LIFE -> helper?.setText(R.id.tv_type, "类型：生活")
            BaseConstant.TODO_TYPE_FUN -> helper?.setText(R.id.tv_type, "类型：娱乐")
            else -> helper?.setText(R.id.tv_type, "类型：未知（${item?.type}）")
        }

        when (item?.priority) {
            1 -> {
                helper?.setText(R.id.tv_priority, "重要程度：重要")
                helper?.setTextColor(R.id.tv_priority, Color.RED)
            }
            2 -> {
                helper?.setText(R.id.tv_priority, "重要程度：一般")
                helper?.setTextColor(R.id.tv_priority, Color.BLUE)
            }
            else -> {
                helper?.setText(R.id.tv_priority, "重要程度：很普通")
                helper?.setTextColor(R.id.tv_priority, Color.GREEN)
            }
        }

        if (item?.completeDate != null){
            helper?.setGone(R.id.tv_end_date, true)
            val endDate = item.completeDateStr
            helper?.setText(R.id.tv_end_date, "完成时间：$endDate")
        }else{
            helper?.setGone(R.id.tv_end_date, false)
        }

        val currentSystemTime = DateUtils.getCurrentSystemTime()

        if(currentSystemTime > item?.date!!){
            helper?.setBackgroundColor(R.id.item_layout,mContext.resources.getColor(R.color.color_30000000))
        }else{
            helper?.setBackgroundColor(R.id.item_layout,mContext.resources.getColor(R.color.white))
        }
    }
}