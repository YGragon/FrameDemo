package com.example.lib_common.constant

/**
 * 参数常量
 */
object ParameterConstant {

    object Login{
        // 检测是否登录
        const val isCheckLoginParameter = "unLogin"
        const val isCheckLogin = true
    }

    object Web{
        const val webUrl = "web_url"
        const val webID= "web_id"
        const val webPosition= "web_position"
        const val webCollected= "web_collected"
    }

    object GankPhoto{
        const val count = "count"
        const val page = "page"
        const val position = "position"
        const val imageUrl = "imageUrl"
    }

    object ToDo{
        const val todoBean = "todo_bean"

    }
}