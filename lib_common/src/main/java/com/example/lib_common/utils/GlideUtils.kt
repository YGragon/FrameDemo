package com.example.lib_common.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.lib_common.R

/**
 * Glide 加载工具类
 */
object GlideUtils {
    /**
     * 显示图片
     */

    fun showImageView(context: Context, mImageView: ImageView, url: String) {
        showImageView(context, mImageView, url, R.drawable.placeholder)
    }

    /**
     * 显示图片-placeholder 自定义占位图
     */
    fun showImageView(context: Context, mImageView: ImageView, url: String,placeholder:Int) {
        showImageView(
            context,
            mImageView,
            url,
            placeholder,
            R.drawable.placeholder
        )
    }
    /**
     * 显示图片-placeholder 自定义占位图 -error自定义异常占位图
     */
    fun showImageView(context: Context, mImageView: ImageView, url: String,placeholder:Int,error:Int) {
        val options = RequestOptions()
            .placeholder(placeholder)
            .error(error)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        /*
        DiskCacheStrategy.NONE： 表示不缓存任何内容。
        DiskCacheStrategy.DATA： 表示只缓存原始图片。
        DiskCacheStrategy.RESOURCE： 表示只缓存转换过后的图片。
        DiskCacheStrategy.ALL ： 表示既缓存原始图片，也缓存转换过后的图片。
        DiskCacheStrategy.AUTOMATIC： 表示让Glide根据图片资源智能地选择使用哪一种缓存策略（默认选项）。
         */
        Glide.with(context).load(url).apply(options).into(mImageView)
    }


    /**
     * 显示圆形图片
     */

    fun showCircleImage(context: Context , mImageView: ImageView, url: String) {
        showCircleImage(context, mImageView, url, R.drawable.placeholder)
    }

    /**
     * 显示圆形图片-placeholder 自定义占位图
     */
    fun showCircleImage(context: Context, mImageView: ImageView, url: String,placeholder:Int) {
        showCircleImage(
            context,
            mImageView,
            url,
            placeholder,
            R.drawable.placeholder
        )
    }
    /**
     * 显示圆形图片-placeholder 自定义占位图 -error自定义异常占位图
     */
    fun showCircleImage(context: Context, mImageView: ImageView, url: String, placeholder:Int, error:Int) {
        val options = RequestOptions()
            .placeholder(placeholder)
            .error(error)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .circleCrop()
        /*
        DiskCacheStrategy.NONE： 表示不缓存任何内容。
        DiskCacheStrategy.DATA： 表示只缓存原始图片。
        DiskCacheStrategy.RESOURCE： 表示只缓存转换过后的图片。
        DiskCacheStrategy.ALL ： 表示既缓存原始图片，也缓存转换过后的图片。
        DiskCacheStrategy.AUTOMATIC： 表示让Glide根据图片资源智能地选择使用哪一种缓存策略（默认选项）。
         */
        Glide.with(context).load(url).apply(options).into(mImageView)
    }
}