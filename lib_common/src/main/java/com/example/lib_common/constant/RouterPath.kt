package com.example.lib_common.constant

/**
 * 路由中心
 */
object RouterPath {
    object UserCenter{
        const val LOGIN = "/user_center/login"
        const val REGISTER = "/user_center/register"
        const val COLLECT = "/user_center/collect"
    }

    object Share{
        const val SHARE_APP = "/share/app"
        const val SHARE_NATIVE = "/share/native"
    }

    object Map{
        const val MAP_APP = "/map/app"
    }

    object Gank{
        const val GANK_PHOTO = "/gank/photo"
        const val GANK_PHOTO_DETAIL = "/gank/photo_detail"
    }

    object Todo{
        const val TODO_PUBLISH = "/todo/publish"
        const val TODO_DETAIL = "/todo/detail"
    }

    object Expand{
        const val EXPAND_HOME = "/expand/home"
    }

    object Web{
        const val WEB_DETAIL = "/web/detail"
    }

    object Search{
        const val SEARCH_HOME = "/search/home"
    }

    object AndroidJetPack{
        const val JETPACK_HOME = "/jetpack/home"
    }
}