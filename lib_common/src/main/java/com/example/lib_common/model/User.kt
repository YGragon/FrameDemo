package com.example.lib_common.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.lib_common.db.IntegerConverter
import com.example.lib_common.db.StringTypeConverter

/**
 * chapterTops : []
 * collectIds : []
 * email :
 * icon :
 * id : 20685
 * password :
 * token :
 * type : 0
 * username : xing2019
 */
@Entity(tableName = "user")
@TypeConverters(StringTypeConverter::class, IntegerConverter::class)
data class User(
    val chapterTops:MutableList<String>?,
    val collectIds:MutableList<Int>?,
    val email:String,
    val icon:String,
    @PrimaryKey
    val id:Int,
    val password:String,
    val token:String,
    val type:Int,
    val username:String)