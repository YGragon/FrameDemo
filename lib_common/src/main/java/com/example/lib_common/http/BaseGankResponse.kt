package com.example.lib_common.http

/**
 * 基本 Gank 服务器返回
 */
class BaseGankResponse<T>(val error :Boolean,
                          val results:T)