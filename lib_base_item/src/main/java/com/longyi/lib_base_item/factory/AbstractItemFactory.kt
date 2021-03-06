package com.longyi.lib_base_item.factory

import android.content.Context
import com.longyi.lib_base_item.config.ConfigAttrs
import com.longyi.lib_base_item.config.Mode
import com.longyi.lib_base_item.item.AbstractItem

/**
 * Created by Aller on 2020/10/28.
 */
abstract class AbstractItemFactory(val mContext: Context) {

    abstract fun createItem(mode: Mode, attrs: ConfigAttrs): AbstractItem
}