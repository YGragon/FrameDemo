package com.longyi.module_expandablelist

import com.chad.library.adapter.base.entity.AbstractExpandableItem
import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * Created by Aller on 2019/10/16.
 */
data class Level0Item(var title: String, var subTitle: String) : AbstractExpandableItem<Level1Item>(), MultiItemEntity {

    override fun getItemType(): Int {
        return ExpandableItemAdapter.TYPE_LEVEL_0
    }

    override fun getLevel(): Int {
        return 0
    }
}