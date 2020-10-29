package com.longyi.lib_base_item.factory

import android.content.Context
import android.util.Log
import com.longyi.lib_base_item.item.RedTextItem
import com.longyi.lib_base_item.item.TextItem
import com.longyi.lib_base_item.item.ButtonItem
import com.longyi.lib_base_item.item.ArrowItem
import com.longyi.lib_base_item.item.NormalItem
import com.longyi.lib_base_item.item.AbstractItem
import com.longyi.lib_base_item.config.ConfigAttrs
import com.longyi.lib_base_item.config.Mode


/**
 * Created by Aller on 2020/10/28.
 */
class ItemFactory(val context: Context): AbstractItemFactory(context) {
    /**
     * 创建出ItemView
     * @param mode  通过传入 不同mode 来创建出不同类型的itemview
     * @param attrs
     * @return
    </T> */
    override fun createItem(mode: Mode, attrs: ConfigAttrs): AbstractItem {
        Log.e("mode", mode.name)


        var item: AbstractItem? = null

        try {
            when {
                mode === Mode.NORMAL -> {
                    Log.e("mode", "Mode.NORMALMode.NORMALMode.NORMAL")

                    item = NormalItem(context)
                }
                mode === Mode.ARROW -> item = ArrowItem(context)
                mode === Mode.BOTTON -> item = ButtonItem(context)
                mode === Mode.TEXT -> item = TextItem(context)
                mode === Mode.RED_TEXT -> item = RedTextItem(context)
            }


            item?.create(attrs)
        } catch (e: Exception) {
            throw RuntimeException(e.message)
        }


        return item!!
    }
}