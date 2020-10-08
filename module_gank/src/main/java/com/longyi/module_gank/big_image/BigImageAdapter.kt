package com.longyi.module_gank.big_image

import android.media.Image
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lib_common.model.GankPhoto
import com.example.lib_common.model.ImageData
import com.example.lib_common.utils.GlideUtils
import com.longyi.module_gank.R

/**
 * 干货图片 item
 */
class BigImageAdapter(collects:List<ImageData>) : BaseQuickAdapter<ImageData,BaseViewHolder>(R.layout.item_gank_photo_detail,collects) {
    override fun convert(helper: BaseViewHolder?, item: ImageData?) {
        GlideUtils.showImageView(mContext,helper?.getView(R.id.photo_view)!!,item?.url!!)
    }
}