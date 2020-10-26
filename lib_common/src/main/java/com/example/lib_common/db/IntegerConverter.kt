package com.example.lib_common.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Room List<Integer> 转换
 */
class IntegerConverter {
    private var gson = Gson()

    @TypeConverter
    fun integerToSomeObjectList(data: String?): List<Int>? {
        if (data == null) {
            return emptyList()
        }

        val listType = object : TypeToken<List<Int>>() {}.type

        return gson.fromJson(data.toString(), listType)
    }

    @TypeConverter
    fun someIntegerListToString(someObjects: List<Int>): String? {
        return gson.toJson(someObjects)
    }
}