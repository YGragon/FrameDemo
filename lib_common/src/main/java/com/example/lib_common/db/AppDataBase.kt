package com.example.lib_common.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lib_common.base.BaseApplication
import com.example.lib_common.db.dao.HotKeyDao
import com.example.lib_common.db.dao.SearchHistoryDao
import com.example.lib_common.model.Hotkey
import com.example.lib_common.model.SearchHistory

/**
 * 数据库示例
 */
@Database(entities = [SearchHistory::class, Hotkey::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getSearchHistoryDao(): SearchHistoryDao
    abstract fun getHotKeyDao(): HotKeyDao

    companion object {
        val DB_NAME = "FrameDemo.db"

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun instance(context: Context): AppDataBase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    DB_NAME
                ).allowMainThreadQueries().build()
            }
            return INSTANCE as AppDataBase
        }
    }


}