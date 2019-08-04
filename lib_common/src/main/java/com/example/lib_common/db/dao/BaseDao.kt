package com.example.lib_common.db.dao

import androidx.room.*

/**
 * 数据 Dao 基类
 */
@Dao
interface BaseDao<T> {
    /**
     * 插入全部
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: MutableList<T>)

    /**
     * 删除一个元素
     */
    @Delete
    fun delete(element: T)

    /**
     * 珊瑚列表
     */
    @Delete
    fun deleteList(elements:MutableList<T>)

    /**
     * 删除一些元素
     */
    @Delete
    fun deleteSome(vararg elements:T)

    /**
     * 更新
     */
    @Update
    fun update(element: T)
}