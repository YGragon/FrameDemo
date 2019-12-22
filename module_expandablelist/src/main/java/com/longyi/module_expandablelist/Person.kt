package com.longyi.module_expandablelist

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * Created by Aller on 2019/10/16.
 */
data class Person(var name: String, var age: Int) : MultiItemEntity {

    override fun getItemType(): Int {
        return ExpandableItemAdapter.TYPE_PERSON
    }
}