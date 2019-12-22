package com.example.lib_common.model

/**
 * 干货图片
 */

data class GankPhoto(
    val _id: String,
    val createdAt: String,
    val desc: String,
    val publishedAt: String,
    val source: String,
    val type: String,
    val url: String,
    val used: Boolean,
    val who: String
)