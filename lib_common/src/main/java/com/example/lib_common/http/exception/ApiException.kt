package com.example.lib_common.http.exception

/**
 * 错误异常
 */
class ApiException:RuntimeException {

    private var code: Int? = null


    constructor(throwable: Throwable, code: Int) : super(throwable) {
        this.code = code
    }

    constructor(message: String) : super(Throwable(message))
}