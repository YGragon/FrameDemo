package com.longyi.lib_base_item.item

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.view.ViewGroup
import android.widget.Switch
import com.longyi.lib_base_item.R
import com.longyi.lib_base_item.utils.dip2px
import com.longyi.lib_base_item.SwitchImageView


/**
 * Created by Aller on 2020/10/28.
 */
class NormalItem:AbstractItem {

    constructor(context: Context):super(context){}
    constructor(context: Context, attributeSet: AttributeSet):super(context,attributeSet){}
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int):super(context, attributeSet, defStyleAttr){}

    override fun createWidget() {
    }

    override fun createWidgetLayoutParams() {

    }


    override fun addWidget() {
        super.addWidget()
    }
}