package com.example.framedemo.data

import com.example.framedemo.data.bean.MineItemBean

/**
 * 数据中心
 */
object DataSource {


    fun getFunData():MutableList<MineItemBean>{
        val list = mutableListOf<MineItemBean>()
        list.add(MineItemBean(0,"点击下载Apk",""))
        list.add(MineItemBean(1,"点击下载文件",""))
        list.add(MineItemBean(2,"点击上传文件",""))
        list.add(MineItemBean(3,"跳转分享组件",""))
        list.add(MineItemBean(4,"跳转地图组件",""))
        list.add(MineItemBean(5,"跳转干货组件",""))
        list.add(MineItemBean(6,"Android JetPack & 微信朋友圈效果",""))
        return list
    }
}