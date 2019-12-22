package com.example.lib_common.db.dao

import androidx.room.*
import com.example.lib_common.model.SearchHistory

/**
 * 搜索历史
 */
@Dao
interface SearchHistoryDao: BaseDao<SearchHistory> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(element:SearchHistory)

    @Query("select * from shistory")
    fun getAllSearchHistory():MutableList<SearchHistory>

    @Query("delete from shistory where key_word = :key_word")
    fun deleteSearchHistory(key_word:String)

    @Query("delete from shistory")
    fun deleteAll()
}