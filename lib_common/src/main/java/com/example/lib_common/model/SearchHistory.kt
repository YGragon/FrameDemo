package com.example.lib_common.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * 历史搜索
 */
@Entity(tableName = "shistory")
data class SearchHistory(
    @PrimaryKey val sId: Long?,
    @ColumnInfo(name = "key_word") val keyWord: String?
)