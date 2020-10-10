package com.longyi.module_gank.event

import com.example.lib_common.model.ImageData

/**
 * Created by Aller on 2020/10/10.
 */

data class ImageEvent(val position:Int, val page:Int, val count:Int, val list:MutableList<ImageData>)