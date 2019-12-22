package com.longyi.module_gank

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lib_common.model.GankPhoto
import com.example.lib_common.utils.GlideUtils

/**
 * 干货图片 item
 */
class GankPhotoAdapter(collects:List<GankPhoto>) : BaseQuickAdapter<GankPhoto,BaseViewHolder>(R.layout.item_gank_photo,collects) {
    override fun convert(helper: BaseViewHolder?, item: GankPhoto?) {
        GlideUtils.showImageView(mContext,helper?.getView(R.id.iv_gank_photo)!!,item?.url!!)
    }
}