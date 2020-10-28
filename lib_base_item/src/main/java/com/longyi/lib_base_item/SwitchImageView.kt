package com.longyi.lib_base_item

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView

/**
 * Created by Aller on 2020/10/28.
 */
class SwitchImageView: ImageView {


    private var isCheck: Boolean = false

    constructor(context:Context):super(context){}
    constructor(context:Context,attributeSet: AttributeSet):super(context,attributeSet){}
    constructor(context:Context, attributeSet: AttributeSet, defStyleAttr: Int):super(context, attributeSet, defStyleAttr){

        setOnClickListener {
            isCheck = !isCheck

            onSwitchClickListener?.onClick(isCheck)
        }
    }

    fun isCheck(): Boolean {
        return isCheck
    }

    private var onSwitchClickListener: OnSwitchClickListener? = null

    fun setOnSwitchClickListener(onSwitchClickListener: OnSwitchClickListener) {
        this.onSwitchClickListener = onSwitchClickListener
    }

    interface OnSwitchClickListener {

        fun onClick(isCheck: Boolean)
    }
}
