package com.longyi.module_expandablelist

import com.chad.library.adapter.base.entity.AbstractExpandableItem
import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * Created by Aller on 2019/10/16.
 */
data class Level1Item(var title: String, var subTitle: String) : AbstractExpandableItem<Person>(), MultiItemEntity {

    override fun getItemType(): Int {
        return ExpandableItemAdapter.TYPE_LEVEL_1
    }

    override fun getLevel(): Int {
        return 1
    }
}