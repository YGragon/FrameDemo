package com.longyi.module_android_jetpack.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lib_common.utils.GlideUtils
import com.longyi.module_android_jetpack.R
import com.longyi.module_android_jetpack.data.Student

/**
 * 学生列表
 */
class JetpackStudentAdapter(list:List<Student>): BaseQuickAdapter<Student, BaseViewHolder>(R.layout.student_item,list) {

    override fun convert(helper: BaseViewHolder?, item: Student?) {
        helper?.setText(R.id.tv_name,item?.name)
    }

}