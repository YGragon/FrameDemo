package com.example.lib_common.http.response

/**
 * 基本的服务器返回
 */
class BaseResponse<T>(val errorCode :Int,
                       val errorMsg:String,
                       val data:T)