package com.longyi.module_usercenter.data

import com.example.framedemo.data.bean.MineItemBean
import com.longyi.module_usercenter.R

/**
 * 数据中心
 */
object DataSource {
    const val DOWN_LOAD_APK = 0
    const val DOWN_LOAD_FILE = 1
    const val DOWN_UPLOAD_FILE = 2
    const val TO_SHARE_MODULE = 3
    const val TO_MAP_MODULE = 4
    const val TO_GANK_MODULE = 5
    const val TO_JETPACK_MODULE = 6
    const val GET_ALL_SERVICE = 7
    const val GET_COLLECT = 8
    const val LOG_OUT = 9
    const val ABOUT = 10
    const val NEW_FUNC = 11


    fun getUnLoginFunData():MutableList<MineItemBean>{
        val list = mutableListOf<MineItemBean>()
//        list.add(MineItemBean(DOWN_LOAD_FILE,"点击下载文件",""))
//        list.add(MineItemBean(DOWN_UPLOAD_FILE,"点击上传文件",""))
//        list.add(MineItemBean(TO_SHARE_MODULE,"跳转分享组件",""))
//        list.add(MineItemBean(TO_MAP_MODULE,"跳转地图组件",""))
//        list.add(MineItemBean(TO_GANK_MODULE,"跳转干货组件",""))
//        list.add(MineItemBean(TO_JETPACK_MODULE,"Android JetPack & 微信朋友圈效果",""))
        list.add(MineItemBean(NEW_FUNC,"探索新世界", R.mipmap.icon_game.toString()))
//        list.add(MineItemBean(GET_ALL_SERVICE,"获取所有后台服务",""))
        list.add(MineItemBean(GET_COLLECT,"收藏中心",R.mipmap.icon_carrot.toString()))
        list.add(MineItemBean(ABOUT,"关于中心",R.mipmap.icon_milk.toString()))
        list.add(MineItemBean(DOWN_LOAD_APK,"检查版本",R.mipmap.icon_orange.toString()))

        return list
    }

    fun getLoginFunData():MutableList<MineItemBean>{
        val list = mutableListOf<MineItemBean>()
        list.add(MineItemBean(NEW_FUNC,"探索新世界", R.mipmap.icon_game.toString()))
//        list.add(MineItemBean(GET_ALL_SERVICE,"获取所有后台服务",""))
        list.add(MineItemBean(GET_COLLECT,"收藏中心",R.mipmap.icon_carrot.toString()))
        list.add(MineItemBean(ABOUT,"关于中心",R.mipmap.icon_milk.toString()))
        list.add(MineItemBean(DOWN_LOAD_APK,"检查版本",R.mipmap.icon_orange.toString()))
        list.add(MineItemBean(LOG_OUT,"退出登录",R.mipmap.icon_sun.toString()))
        return list
    }
}