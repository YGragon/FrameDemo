package com.example.lib_common.utils.imageloader

import android.content.Context
import android.widget.ImageView
import com.example.lib_common.utils.GlideUtils
import com.youth.banner.loader.ImageLoader

/**
 * Glide 图片加载器
 */
class GlideImageLoader : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        //Glide 加载图片简单用法
        GlideUtils.showImageView(context!!,imageView!!,path!!.toString())
    }

//    //提供createImageView 方法，如果不用可以不重写这个方法，主要是方便自定义ImageView的创建
//    override fun createImageView(context: Context): ImageView {
//        //使用fresco，需要创建它提供的ImageView，当然你也可以用自己自定义的具有图片加载功能的ImageView
//        return ImageView(context)
//    }
}