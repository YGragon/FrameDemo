package com.example.lib_common.db.dao

import androidx.room.*
import com.example.lib_common.model.Hotkey
import com.example.lib_common.model.SearchHistory

/**
 * 搜索历史
 */
@Dao
interface HotKeyDao: BaseDao<Hotkey> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(element:Hotkey)


    @Query("select * from hotkey")
    fun getAllHotKey():MutableList<Hotkey>

}