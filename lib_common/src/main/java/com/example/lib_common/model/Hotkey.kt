package com.example.lib_common.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * 搜索热词
 */
@Entity(tableName = "hotkey")
data class Hotkey(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "link")
    val link: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "order")
    val order: Int,
    @ColumnInfo(name = "visible")
    val visible: Int
)