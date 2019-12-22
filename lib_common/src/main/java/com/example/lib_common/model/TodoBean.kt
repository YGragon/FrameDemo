package com.example.lib_common.model

import java.io.Serializable

/**
 * TODO列表对象
 */
data class TodoBean(
    val `data`: TodoList,
    val errorCode: Int,
    val errorMsg: String

)

data class TodoList(
    val curPage: Int,
    val datas: MutableList<Todo>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)


data class Todo(
    val completeDate: Any,
    val completeDateStr: String,
    val content: String,
    val date: Long,
    val dateStr: String,
    val id: Int,
    val priority: Int,
    val status: Int,
    val title: String,
    val type: Int,
    val userId: Int
) : Serializable