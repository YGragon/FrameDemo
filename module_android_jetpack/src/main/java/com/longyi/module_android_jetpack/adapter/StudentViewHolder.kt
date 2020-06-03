package com.longyi.module_android_jetpack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.longyi.module_android_jetpack.R
import com.longyi.module_android_jetpack.data.local.Student

/**
 * Created by Aller on 2019/12/22.
 */
class StudentViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)) {

    private val nameView = itemView.findViewById<TextView>(R.id.tv_name)
    var student: Student? = null

    fun bindTo(student: Student?) {
        this.student = student
        nameView.text = student?.name
    }
}