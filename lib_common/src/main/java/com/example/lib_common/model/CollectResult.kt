package com.example.lib_common.model

/**
 * 收藏对象
 */
data class CollectResult(
    val data: CollectBean,
    val errorCode: Int,
    val errorMsg: String
)

data class CollectBean(
    val curPage: Int,
    val datas: MutableList<Collect>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)

data class Collect(
    val author: String?,
    val chapterId: Int,
    val chapterName: String,
    val courseId: Int,
    val desc: String,
    val envelopePic: String,
    val id: Int,
    val link: String,
    val niceDate: String,
    val origin: String,
    val originId: Int,
    val publishTime: Long,
    val title: String,
    val userId: Int,
    val visible: Int,
    val zan: Int
)