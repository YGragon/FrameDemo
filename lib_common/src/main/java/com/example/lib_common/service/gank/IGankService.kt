package com.example.lib_common.service.gank

import com.alibaba.android.arouter.facade.template.IProvider
import com.example.lib_common.model.GankPhoto
import com.example.lib_common.model.ImageData

/**
 * Created by Aller on 2020/10/26.
 */
interface IGankService:IProvider {
    fun getHeaderPhoto(iGankPhotoCallBack: IGankPhotoCallBack)
}

interface IGankPhotoCallBack {
    fun successByList(images: MutableList<ImageData>)
    fun fail(msg:String)
}