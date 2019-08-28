package com.example.lib_common.model

/**
 * TODO列表对象
 */
data class TodoBean(
    val `data`: Todo,
    val errorCode: Int,
    val errorMsg: String
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
)