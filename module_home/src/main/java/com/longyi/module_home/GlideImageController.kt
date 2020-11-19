package com.longyi.module_home

import android.content.Context
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import per.wsj.lib.controller.BaseImageController

/**
 * Created by Aller on 2020/11/18.
 */
class GlideImageController(val context: Context, val imageUrl:String): BaseImageController() {
    override fun loadImage(viewWidth: Int) {
        if (imageUrl.isEmpty()) {
            return
        }

        // 利用Glide获取drawable

        // 利用Glide获取drawable
        Glide.with(context).load(imageUrl).into(object : SimpleTarget<Drawable?>() {

            override fun onResourceReady(
                resource: Drawable,
                transition: Transition<in Drawable?>?
            ) {
                // 处理drawable
                handleDrawable(viewWidth, resource)
            }
        })
    }
}