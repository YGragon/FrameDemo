package com.example.lib_common.db.dao

import androidx.room.*
import com.example.lib_common.model.Hotkey
import com.example.lib_common.model.SearchHistory
import com.example.lib_common.model.User

/**
 * User 数据 Dao
 */
@Dao
interface UserDao: BaseDao<User> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(element:User)


    @Query("select * from user where username=:name")
    fun findUserByName(name:String):User

}