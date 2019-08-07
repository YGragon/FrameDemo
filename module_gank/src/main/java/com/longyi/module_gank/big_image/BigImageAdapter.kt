package com.longyi.module_gank.big_image

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lib_common.model.GankPhoto
import com.example.lib_common.utils.GlideUtils
import com.longyi.module_gank.R

/**
 * 干货图片 item
 */
class BigImageAdapter(collects:List<GankPhoto>) : BaseQuickAdapter<GankPhoto,BaseViewHolder>(R.layout.item_gank_photo_detail,collects) {
    override fun convert(helper: BaseViewHolder?, item: GankPhoto?) {
        GlideUtils.showImageView(mContext,helper?.getView(R.id.photo_view)!!,item?.url!!)
    }
}