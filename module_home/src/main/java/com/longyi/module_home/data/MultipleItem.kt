package com.longyi.module_home.data

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.lib_common.model.Article
import com.example.lib_common.model.ImageData

/**
 * Created by Aller on 2020/11/18.
 */
class MultipleItem(itemType:Int, val article: Article, val imageData: ImageData): MultiItemEntity {
    private var mItemType = 0

    companion object{
        val TEXT = 1
        val IMG = 2
    }

    init {
        this.mItemType = itemType
    }

    override fun getItemType(): Int {
        return mItemType
    }

}