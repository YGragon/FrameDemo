package com.example.lib_common.service.gank

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * Created by Aller on 2020/10/26.
 */
interface IGankService:IProvider {
    fun getHeaderPhoto(iGankPhotoCallBack: IGankPhotoCallBack)
}

interface IGankPhotoCallBack {
    fun success(imageUrl:String)
    fun fail(msg:String)
}