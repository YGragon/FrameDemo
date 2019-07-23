package com.example.lib_common.model

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
data class User(
    val chapterTops:MutableList<String>,
    val collectIds:MutableList<Int>,
    val email:String,
    val icon:String,
    val id:Int,
    val password:String,
    val token:String,
    val type:Int,
    val username:String)